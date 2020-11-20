package org.example;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p>
 * public class RootToLeafPathSum {
 * <p>
 * public static boolean hasPathSum(TreeNode node, int sum) {
 * <p>
 * //TODO for implementation
 * }
 * }
 * Examples:
 * 10
 * /    \
 * 8       2
 * / \      /
 * 3   5   2
 * RootToLeafPathSum.hasPathSum(testNode, 23) should return true;
 * RootToLeafPathSum.hasPathSum(testNode, 21) should return true;
 * RootToLeafPathSum.hasPathSum(testNode, 14) should return true;
 * RootToLeafPathSum.hasPathSum(testNode, 333) should return false;
 * RootToLeafPathSum.hasPathSum(testNode, 10) should return false;
 */
public class App {
    public static void main(String[] args) {
        TreeNode tr3 = new TreeNode(3);

        TreeNode tr2 = new TreeNode(8);
        tr2.left = tr3;

        TreeNode tr1 = new TreeNode(10);
        tr1.left = tr2;

        System.out.println(hasPathSum(tr1, 23));
    }

    public static boolean hasPathSum(TreeNode node, int sum) {
        if (node == null) {
//            return false;
            return sum == 0;
        }

//        if (node.right == null && node.left == null && sum == 0) {
//            return true;
//        } else if (node.right == null && node.left == null && sum < 0) {
//            return false;
//        }

//        sum -= node.data;
//        return hasPathSum(node.leftChild, sum-=node.data) || hasPathSum(node.rightChild, sum-=node.data);
        return hasPathSum(node.left, sum - node.data) || hasPathSum(node.right, sum - node.data);
    }

}

class TreeNode {
    int data = 0;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}
