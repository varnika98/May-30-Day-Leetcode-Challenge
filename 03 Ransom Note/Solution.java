/*
Problem : 
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(1)
*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count =  new int[26];
        for(char c : magazine.toCharArray())
            count[c-'a']++;
        for(char c : ransomNote.toCharArray()){
            if(--count[c-'a']<0)
                return false;
        }
        return true;
    }
}