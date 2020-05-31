/*
Problem : 
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character

Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5

*/

/*
Analysis ::
Time Complexity :: O(n^2)
Space Complexity :: O(n^2)
*/

class Solution {
    public int minDistance(String word1, String word2) {
        if((word1 == null && word2 == null) || (word1.length() == 0 && word2.length() == 0))
            return 0;
        if(word1.length() == 0)
            return word2.length();
        
        if(word2.length() == 0)
            return word1.length();
        
        int l1 = word1.length();
        int l2 = word2.length();
        int dp[][] = new int[l2+1][l1+1];
        for(int i=0; i<=l1; i++)
            dp[0][i] = i;
        for(int j=0; j<=l2; j++)
            dp[j][0] = j;
        for(int i=1; i<=l2; i++){
            for(int j=1; j<=l1; j++){
                if(word2.charAt(i-1) == word1.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
            }
        }
        return dp[l2][l1];
    }
}