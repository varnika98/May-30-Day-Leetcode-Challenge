/*
Problem : 
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

Follow up: Your solution should run in O(log n) time and O(1) space.

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10

*/

/*
Analysis ::
Time Complexity :: O(log n)
Space Complexity :: O(1)
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int start=0, end = n-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(mid%2 == 1)
                mid--;
            if(nums[mid] != nums[mid+1])
                end=mid;
            else
                start = mid+2;
        }
        return nums[start];
    }
}