package dev.appkr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class InOrderTraversal {

  public static void main(String[] args) {
    // in-order traversal
    // left -> root -> right
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(4);

    System.out.println(new Solution().inorderTraversal(root));
  }

  static class Solution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
      if (root == null) {
        return list;
      }

      inorderTraversal(root.left);
      list.add(root.val);
      inorderTraversal(root.right);

      return list;
    }
  }
}
