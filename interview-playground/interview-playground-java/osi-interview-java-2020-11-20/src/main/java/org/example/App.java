package org.example;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * public class RootToLeafPathSum {
 *
 *     public static boolean hasPathSum(TreeNode node, int sum) {
 *
 * 	    //TODO for implementation
 *     }
 * }
 * Examples:
 *                 10
 *               /    \
 *             8       2
 *            / \      /
 *           3   5   2
 * RootToLeafPathSum.hasPathSum(testNode, 23) should return true;
 * RootToLeafPathSum.hasPathSum(testNode, 21) should return true;
 * RootToLeafPathSum.hasPathSum(testNode, 14) should return true;
 * RootToLeafPathSum.hasPathSum(testNode, 333) should return false;
 * RootToLeafPathSum.hasPathSum(testNode, 10) should return false;
 */
public class App {
    public static void main(String[] args) {

        TreeNode tr3 = new TreeNode();
        tr3.data = 3;

        TreeNode tr2 = new TreeNode();
        tr2.data = 8;
        tr2.leftChild = tr3;

        TreeNode tr1 = new TreeNode();
        tr1.data = 10;
        tr1.leftChild = tr2;


        System.out.println(hasPathSum(tr1, 21));


    }

    public static boolean hasPathSum(TreeNode node, int sum) {
        if(node == null) {
            return false;
        }

        if(node.rightChild == null && node.leftChild == null && sum == 0) {
            return true;
        } else if(node.rightChild == null && node.leftChild == null && sum < 0) {
            return false;
        }

        return hasPathSum(node.leftChild, sum-=node.data) || hasPathSum(node.rightChild, sum-=node.data);
    }

}

class TreeNode {

    int data = 0;
    TreeNode leftChild;
    TreeNode rightChild;
}
