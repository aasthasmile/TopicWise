package sdeskills;

public class DefectiveNode {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left.left = new TreeNode(4);
        node1.left.left.right = new TreeNode(5);
        node1.right.left = new TreeNode(6);

        int count = 0;
        count = countDefectiveNode(node1, count);
        System.out.println("Defective nodes:" + 7);
    }

    private static int countDefectiveNode(TreeNode node1, int count) {
        if (node1 == null)
            return 0;

        if (node1.left.data < node1.data)
            count++;
        else if (node1.data < node1.right.data)
            count++;

        countDefectiveNode(node1.left, count);
        countDefectiveNode(node1.right, count);

        return count;

    }


}
