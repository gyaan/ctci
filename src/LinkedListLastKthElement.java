/**
 * Created by lenskart on 20/02/2017.
 */
public class LinkedListLastKthElement {

    private static class Node {
        Node next;
        int data;

        Node(int value) {
            this.data = value;
        }
    }

    public static int lastKthElement(Node head, int kth) {
        if (head == null)
            return 0;
        Node current = head;
        Node slow = head;
        int count = 1;
        while (current != null) {
            if (count > kth) {
                slow = slow.next;
            }
            count++;
            current = current.next;
        }
        return slow.data;
    }

    public static int recursiveKthElement(Node head, int k) {
        if (head == null)
            return 0;
        int i = recursiveKthElement(head.next, k) + 1;
        if (i == k)
            System.out.println(head.data);
        return i;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        System.out.println(LinkedListLastKthElement.lastKthElement(head, 1));
        LinkedListLastKthElement.recursiveKthElement(head,1);
    }

}
