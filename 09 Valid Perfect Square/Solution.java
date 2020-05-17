/*
Problem : 
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false

*/

/*
Analysis ::
Time Complexity :: O(log n)
Space Complexity :: O(1)
*/

// Binary Search Approach
class Solution {
    public boolean isPerfectSquare(int num) {
        long lo = 1, hi = num;
        while(lo<=hi){
            long mid = lo + (hi-lo)/2;
            if(mid*mid == num)
                return true;
            else if(mid*mid < num)
                lo = mid+1;
            else
                hi = mid-1;
        }
        return false;
    }
}


/**  property of perfect square : It can be expressed as a sum of odd numbers **/
/** class Solution {
    public boolean isPerfectSquare(int num) {
        int i=1;
        while(num>0){
            num -= i;
            i += 2;
        }
        return num == 0;
    }
} **/