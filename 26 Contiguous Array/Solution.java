/*
Problem : 
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, -1);
        int maxLen=0, count=0;
        for(int i=0; i<nums.length; i++){
            count = count  + (nums[i] == 0 ? -1 : 1);
            if(countMap.containsKey(count)){
                maxLen = Math.max(maxLen, i-countMap.get(count));
            }else{
                countMap.put(count, i);
            }
        }
        return maxLen;
    }
}