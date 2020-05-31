/*
Problem : 
We write the integers of A and B (in the order they are given) on two separate horizontal lines.

Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:

A[i] == B[j];
The line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.

Return the maximum number of connecting lines we can draw in this way.

Example 1:
Input: A = [1,4,2], B = [1,2,4]
Output: 2

Example 2:
Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
Output: 3

*/

/*
Analysis ::
Time Complexity :: O(mn)
Space Complexity :: O(mn)
*/


class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        if(A == null || B == null || A.length == 0 || B.length == 0)
            return 0;
        int dp[][] = new int[A.length+1][B.length+1];
        for(int i=1; i<=A.length; i++){
            for(int j=1; j<=B.length; j++){
                if(A[i-1] == B[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[A.length][B.length];
    }
}