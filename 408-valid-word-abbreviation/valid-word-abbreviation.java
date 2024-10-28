class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordCnt = 0; 
        int abbrCnt = 0; 
        if(abbr.length() > word.length()) return false; 
        while (wordCnt < word.length() && abbrCnt < abbr.length()) {
            if (Character.isLetter(abbr.charAt(abbrCnt))) {
                if (word.charAt(wordCnt) != abbr.charAt(abbrCnt)) return false; 
                wordCnt++; 
                abbrCnt++; 
            } else {
                if (abbr.charAt(abbrCnt) == '0') return false; 
                int num = 0; 
                while (abbrCnt < abbr.length() && Character.isDigit(abbr.charAt(abbrCnt))) {
                    num = num * 10 + (abbr.charAt(abbrCnt) - '0'); 
                    abbrCnt++; 
                }
                wordCnt += num; 
            }
        }
        return wordCnt == word.length() && abbrCnt == abbr.length(); 
    }
}