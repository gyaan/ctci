import java.util.HashMap;
import java.util.Map;

/**
 * Created by gyaneshwar on 18/02/2017.
 * Learning: don't keep node itself in the map
 * keep previous pointer and current pointer
 * run loop till current is not null
 * make previous only if no duplicate node
 * in no buffer we will check runner next element data and
 * will execute till the runner next is not null
 */
public class LikedListRemoveDuplicate {

    private static class Node {
        int data;
        Node next;

        Node(int value) {
            this.data = value;
        }
    }

    /**
     * @param head
     * @return time complexity o(n)
     */
    public static Node removeDuplicateFromLinkedList(Node head) {
        Map<Integer, Boolean> nodeBooleanHashMap = new HashMap<Integer, Boolean>();
        //don't do anything
        if (head == null)
            return head;
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (nodeBooleanHashMap.containsKey(current.data)) {
                previous.next = current.next;
            } else {
                nodeBooleanHashMap.put(current.data, true);
                previous = current;
            }
            current = current.next;
        }
        return head;
    }

    /**
     * @param head
     * @return time complexity o(n^2)
     */
    public static Node removeDuplicateWithoutBuffer(Node head) {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (current.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        return head;
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
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        Node newNode = LikedListRemoveDuplicate.removeDuplicateFromLinkedList(head);
        Node newNode1 = LikedListRemoveDuplicate.removeDuplicateWithoutBuffer(head);
        LikedListRemoveDuplicate.printLinkList(newNode);
        LikedListRemoveDuplicate.printLinkList(newNode1);

    }
}
