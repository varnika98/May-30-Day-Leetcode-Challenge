/*
Problem : 
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(1)
*/

// Different Type of Algo(Boyer-Moore Voting Algorithm)
class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int maj = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] == maj)
                count++;
            else
                count--;
            if(count == 0){
                count = 1;
                maj = nums[i];
            }
        }
        return maj;
    }
}