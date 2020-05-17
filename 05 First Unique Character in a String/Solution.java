/*
Problem : 
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(1)
*/

class Solution {
    public int firstUniqChar(String s) {
        int[] charCount = new int[26];
        for(char c : s.toCharArray())
            charCount[c-'a']++;
        
        for(int i=0; i<s.length();i++){
            if(charCount[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}

/**
 class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i=0; i<s.length();i++){
            if(charCount.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
 */