public class SumLists {

    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node() {

        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SumLists sumLists = new SumLists();
        Node Node1 = sumLists.new Node(9);
        Node Node2 = sumLists.new Node(9);
        Node Node3 = sumLists.new Node(9);
        Node Node4 = sumLists.new Node(9);
        Node Node5 = sumLists.new Node(9);
        Node5.setNext(Node4);
        Node4.setNext(Node3);
        Node3.setNext(Node2);
        Node2.setNext(Node1);
        Node node = sumEqual(Node5, Node5);

        while (node != null) {
            if (carry != 0) {
                System.out.print(carry);
                carry=0;
            }
            System.out.print(node.getData());
            node = node.getNext();
        }

    }

    private static int carry = 0;

    public static Node sumEqual(Node head1, Node head2) {

        if (head1 == null)
            return null;
        SumLists sumLists = new SumLists();
        Node newHead = sumLists.new Node();
        newHead.setNext(sumEqual(head1.getNext(), head1.getNext()));
        int sum = head1.getData() + head2.getData() + carry;
        carry = sum / 10;
        sum = sum % 10;
        newHead.setData(sum);
        return newHead;

    }

    /*
     * public static Node sum(Node head1, Node head2) {
     * int len1 = 0;
     * int len2 = 0;
     * Node temhead1 = head1;
     * Node temhead2 = head2;
     * 
     * while (temhead1 != null) {
     * len1++;
     * temhead1 = temhead1.getNext();
     * }
     * while (temhead2 != null) {
     * len2++;
     * temhead2 = temhead2.getNext();
     * }
     * 
     * Node node = null;
     * if (len1 == len2) {
     * node = sum(head1, head2);
     * }
     * 
     * if (carry != 0) {
     * SumLists sumLists = new SumLists();
     * Node carryNode = sumLists.new Node(carry);
     * carryNode.setNext(node);
     * node = carryNode;
     * }
     * 
     * return null;
     * }
     */

}
