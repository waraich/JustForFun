public class TreeMaxFrequency {

    /**
     * @param args
     */
    public static void main(String[] args) {

        TreeMaxFrequency tree = new TreeMaxFrequency();
        TreeNode node = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(1);
        node3.setLeft(node5);
        node3.setRight(node6);
        node2.setLeft(node);
        node2.setRight(node3);
        tree.maxFrequency(node2);
        int fre = tree.current > tree.past ? tree.current : tree.past;
        System.out.println(fre);
        // System.out.println(sum(node2));

    }


    public static int sum(TreeNode node) {
        if (node == null)
            return 0;
        return sum(node.getLeft()) + node.getData() + sum(node.getRight());

    }

    private int past = 1;
    private int current = 1;
    private int currentData = 0;

    
    //Pre order.
    public void maxFrequency(TreeNode node) {
        if (node == null)
            return;

        if (currentData != node.getData()) {
            currentData = node.getData();
            past = current > past ? current : past;
            current = 1;
        } else {
            current++;
        }
        maxFrequency(node.getLeft());
        maxFrequency(node.getRight());
    }
}
