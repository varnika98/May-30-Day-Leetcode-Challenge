/*
Problem : 
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(1)
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0)
            return res;

        int[] charCount = new int[26];

        for (char c : p.toCharArray())
            charCount[c - 'a']++;

        int start = 0;
        int count = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (--charCount[ch - 'a'] >= 0)
                count++;

            if (count == p.length())
                res.add(start);

            if (end - start + 1 == p.length() && charCount[s.charAt(start++) - 'a']++ >= 0)
                count--;
        }
        return res;
    }
}