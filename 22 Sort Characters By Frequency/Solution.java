/*
Problem : 
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"
Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:

Input:
"Aabb"
Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(1)
*/

class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0)
            return "";
        int[] freq = new int[128];
        for (char c : s.toCharArray())
            freq[c]++;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int i = 0; i < 128; i++) {
            if (freq[i] != 0)
                heap.offer(new int[] { i, freq[i] });
        }
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            int[] ele = heap.poll();
            String str = String.valueOf((char) ele[0]);
            sb.append(str.repeat(ele[1]));
        }
        return sb.toString();
    }
}