package trees;

public class TreeNodeImpl {

    public static void main(String[] args) {

        TreeNode node = dataInTreeNode();

        postOrderNonRecursive(node);

    }

    public static TreeNode dataInTreeNode() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(14);

		/*finding minimum depth*/
        /*root.left.left.right = new TreeNode(4);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(13);*/
        return root;
    }

    /**
     * Post Order Traversal with out using Recursion .
     */
    public static void postOrderNonRecursive(TreeNode node) {

        TreeNode temp = node;

        while (temp != null && temp.visited == false) {

            if (temp.left != null && temp.left.visited == false) {
                temp = temp.left;
            } else if (temp.right != null && temp.right.visited == false) {
                temp = temp.right;
            } else {
                System.out.print(temp.data + " ");
                temp.visited = true;
                temp = node;
            }
        }

    }


}
