/*
Problem : 
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructTree(0, preorder.length - 1, preorder);
    }

    public TreeNode constructTree(int start, int end, int[] preorder) {
        if (start > end)
            return null;

        TreeNode root = new TreeNode(preorder[start]);
        int leftIndex = start + 1;
        while (leftIndex <= end && preorder[leftIndex] < preorder[start])
            leftIndex++;
        root.left = constructTree(start + 1, leftIndex - 1, preorder);
        root.right = constructTree(leftIndex, end, preorder);
        return root;
    }
}