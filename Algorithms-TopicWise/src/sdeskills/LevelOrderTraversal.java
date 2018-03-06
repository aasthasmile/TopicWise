package sdeskills;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find level order traversal of a  binary tree , make sure to print elements in the next line as per the level.
 */
public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left.left = new TreeNode(4);
        node1.left.left.right = new TreeNode(5);
        node1.right.left = new TreeNode(6);

        levelOrder(node1);

    }

    private static void levelOrder(TreeNode node1) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node1);

        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);

                System.out.print(node.data);
                count--;
            }
            System.out.println();
        }

    }
}
