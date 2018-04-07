/**
 * Created by gyaneshwar on 21/02/2017.
 */
public class DeleteNodeInSinglyLinkList {

    private static class Node {
        Node next;
        int data;

        Node(int value) {
            this.data = value;
        }
    }

    public static boolean removeNode(Node n){
        if(n==null || n.next==null)
            return false;
       Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    public static void printLinkList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        removeNode(head.next.next);
        printLinkList(head);
    }
}
