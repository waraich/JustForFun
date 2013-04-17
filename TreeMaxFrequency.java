public class TreeMaxFrequency {

    /**
     * @param args
     */
    public static void main(String[] args) {

        TreeMaxFrequency tree = new TreeMaxFrequency();
        TreeMaxFrequency.Node node = tree.new Node(2);
        TreeMaxFrequency.Node node2 = tree.new Node(2);
        TreeMaxFrequency.Node node3 = tree.new Node(1);
        TreeMaxFrequency.Node node5 = tree.new Node(2);
        TreeMaxFrequency.Node node6 = tree.new Node(1);
        node3.setLeft(node5);
        node3.setRight(node6);
        node2.setLeft(node);
        node2.setRight(node3);
        tree.maxFrequency(node2);
        int fre = tree.current > tree.past ? tree.current : tree.past;
        System.out.println(fre);
        // System.out.println(sum(node2));

    }

    class Node {
        public Node(int data) {
            this.data = data;
        }

        private int data;
        private Node left;
        private Node right;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

    }

    public static int sum(Node node) {
        if (node == null)
            return 0;
        return sum(node.getLeft()) + node.getData() + sum(node.getRight());

    }

    private int past = 1;
    private int current = 1;
    private int currentData = 0;

    
    //Pre order.
    public void maxFrequency(Node node) {
        if (node == null)
            return;

        if (currentData != node.getData()) {
            currentData = node.getData();
            past = current > past ? current : past;
            current = 1;
        } else {
            current++;
        }
        maxFrequency(node.left);
        maxFrequency(node.right);
    }
}
