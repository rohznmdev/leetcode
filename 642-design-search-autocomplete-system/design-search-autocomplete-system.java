class AutocompleteSystem {

    // TrieNode class to represent each node in the Trie
    private class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> sentenceFrequency;

        TrieNode() {
            children = new HashMap<>();
            sentenceFrequency = new HashMap<>();
        }
    }

    private TrieNode root;
    private StringBuilder currentInput;

    // Constructor to initialize the AutocompleteSystem with given sentences and times
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        currentInput = new StringBuilder();

        // Insert each sentence into the Trie with its frequency
        for (int i = 0; i < sentences.length; i++) {
            insertSentence(sentences[i], times[i]);
        }
    }

    // Method to insert a sentence into the Trie
    private void insertSentence(String sentence, int frequency) {
        TrieNode node = root;

        // Traverse the Trie and add nodes for each character in the sentence
        for (char c : sentence.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);

            // Update the frequency of the sentence at each node
            node.sentenceFrequency.put(sentence, node.sentenceFrequency.getOrDefault(sentence, 0) + frequency);
        }
    }

    // Method to process input character and return top 3 sentences with the current prefix
    public List<String> input(char c) {
        // If the input character is '#', finalize the current input as a sentence
        if (c == '#') {
            insertSentence(currentInput.toString(), 1);
            currentInput = new StringBuilder();
            return new ArrayList<>();
        }

        // Append the character to the current input
        currentInput.append(c);
        TrieNode node = root;

        // Traverse the Trie based on the current input
        for (char ch : currentInput.toString().toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return new ArrayList<>();
            }
            node = node.children.get(ch);
        }

        // Retrieve and sort sentences by frequency and lexicographical order
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
        );

        pq.addAll(node.sentenceFrequency.entrySet());

        List<String> result = new ArrayList<>();
        int count = 0;

        // Collect the top 3 sentences
        while (!pq.isEmpty() && count < 3) {
            result.add(pq.poll().getKey());
            count++;
        }

        return result;
    }
}
