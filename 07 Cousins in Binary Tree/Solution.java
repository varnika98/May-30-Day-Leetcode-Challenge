/*
Problem : 
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int[] xinfo;
    int[] yinfo;
    public boolean isCousins(TreeNode root, int x, int y) {
        xinfo = new int[2];
        yinfo = new int[2];
        findNodesInfo(root, root.left, 1, x, y);
        findNodesInfo(root, root.right, 1, x, y);
        
        if(xinfo[0] != yinfo[0] && xinfo[1] == yinfo[1])
            return true;
        
        return false;
        
    }
    
    public void findNodesInfo(TreeNode parent, TreeNode node, int level, int x, int y){
        if(node == null)
            return;
        
        if(node.val == x){
            xinfo[0] = parent.val;
            xinfo[1] = level;
        }
        if(node.val == y){
            yinfo[0] = parent.val;
            yinfo[1] = level;
        }
        
        findNodesInfo(node, node.left, level+1, x, y);
        findNodesInfo(node, node.right, level+1, x, y);
        
    }
}