public class SumLists {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode ListNode1 = new ListNode(9);
        ListNode ListNode2 = new ListNode(9);
        ListNode ListNode3 = new ListNode(9);
        ListNode ListNode4 = new ListNode(9);
        ListNode ListNode5 = new ListNode(9);
        ListNode5.setNext(ListNode4);
        ListNode4.setNext(ListNode3);
        ListNode3.setNext(ListNode2);
        ListNode2.setNext(ListNode1);
        ListNode ListNode = sumEqual(ListNode5, ListNode5);

        while (ListNode != null) {
            if (carry != 0) {
                System.out.print(carry);
                carry = 0;
            }
            System.out.print(ListNode.getData());
            ListNode = ListNode.getNext();
        }

    }

    private static int carry = 0;

    public static ListNode sumEqual(ListNode head1, ListNode head2) {

        if (head1 == null)
            return null;
        ListNode newHead = new ListNode();
        newHead.setNext(sumEqual(head1.getNext(), head1.getNext()));
        int sum = head1.getData() + head2.getData() + carry;
        carry = sum / 10;
        sum = sum % 10;
        newHead.setData(sum);
        return newHead;

    }

    /*
     * public static ListNode sum(ListNode head1, ListNode head2) {
     * int len1 = 0;
     * int len2 = 0;
     * ListNode temhead1 = head1;
     * ListNode temhead2 = head2;
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
     * ListNode ListNode = null;
     * if (len1 == len2) {
     * ListNode = sum(head1, head2);
     * }
     * 
     * if (carry != 0) {
     * SumLists sumLists = new SumLists();
     * ListNode carryListNode = sumLists.new ListNode(carry);
     * carryListNode.setNext(ListNode);
     * ListNode = carryListNode;
     * }
     * 
     * return null;
     * }
     */

}
