/*
Problem : 
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length())
            return false;
        
        int[] charCount = new int[26];
        for(char c: s1.toCharArray())
            charCount[c-'a']++;
        
        int start = 0;
        int count = 0;
        
        for(int end=0; end<s2.length(); end++){
            char c = s2.charAt(end);
            if(--charCount[c-'a'] >= 0)
                count++;
            if(count == s1.length())
                return true;
            if(end-start+1 == s1.length() && charCount[s2.charAt(start++)-'a']++ >= 0)
                count--;
        }
        return false;
    }
}