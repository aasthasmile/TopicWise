package sdeskills;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}

public class AddTreeNodes {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left.left = new TreeNode(4);
        node1.left.left.right=new TreeNode(5);
        node1.right.left = new TreeNode(6);

        TreeNode newNode=generateMirrorImage(node1);

        TreeNode node2 = new TreeNode(2);
        node2.left = new TreeNode(7);
        node2.right = new TreeNode(8);
        node2.left.left = new TreeNode(5);
        node2.left.right = new TreeNode(5);
        node2.right.left = new TreeNode(4);
        node2.right.right = new TreeNode(3);

        TreeNode node3 = addTreeNodes(node1, node2);


    }

    private static TreeNode generateMirrorImage(TreeNode node1) {

        if (node1 == null)
            return null;

        TreeNode newNode = new TreeNode(node1.data);
        if (node1.left != null && node1.right != null) {
            newNode.left = node1.right;
            newNode.right = node1.left;
        } else if (node1.left != null || node1.right == null) {
            newNode.right = node1.left;
        } else if (node1.left == null || node1.right != null) {
            newNode.left = node1.right;
        } else if (node1.left == null && node1.right == null)
            return null;

        newNode.left=generateMirrorImage(node1.right);
        newNode.right=generateMirrorImage(node1.left);

        return newNode;
    }

    /**
     * no extra space
     *
     * @param node1
     * @param node2
     * @return
     */

    private static TreeNode addTreeNodes(TreeNode node1, TreeNode node2) {

        if (node1 != null && node2 != null) {
            node1.data = node1.data + node2.data;
        } else if (node2 != null || node1 == null) {
            return node2;
        } else if (node2 == null || node1 != null) {
            return node1;
        } else if (node1 == null && node2 == null)
            return null;

        node1.left = addTreeNodes(node1.left, node2.left);
        node1.right = addTreeNodes(node1.right, node2.right);

        return node1;
    }
}
