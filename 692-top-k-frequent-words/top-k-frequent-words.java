class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>(); 
        String[] sol = new String[k]; 
        for (String x : words) {
            map.put(x, map.getOrDefault(x, 0) + 1); 
        }
        PriorityQueue<String> pq =new PriorityQueue<>((a,b)->map.get(b)!= map.get(a) ? map.get(b)-map.get(a) : a.compareTo(b));      
        pq.addAll(map.keySet());
        List<String> ans=new ArrayList<>();
        for(int i=0; i<k; i++){
            ans.add(pq.poll());
        }
        return ans;
    }
}