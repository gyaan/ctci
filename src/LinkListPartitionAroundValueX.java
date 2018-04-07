/**
 * Created by gyaneshwar on 21/02/2017.
 */
public class LinkListPartitionAroundValueX {
    private static class Node {
        Node next;
        int data;

        Node(int value) {
            this.data = value;
        }
    }

    public static Node linkListPartition(Node head, int val) {
        Node listBefore = null;
        Node listAfter = null;
        Node current = head;
        while (current != null) {
            if (current.data >= val) {
                listAfter = addElementToLinkList(listAfter, current.data);
            } else {
                listBefore = addElementToLinkList(listBefore, current.data);
            }
            current = current.next;
        }

        //now combine the list
        Node currentOfListBefore = listBefore;
        while (currentOfListBefore.next != null)
            currentOfListBefore = currentOfListBefore.next;

        currentOfListBefore.next = listAfter;
        return listBefore;
    }

    public static Node addElementToLinkList(Node head, int value) {
        if (head == null) {
            head = new Node(value);
            return head;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value);
        return head;
    }

    public static void printLinkList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            current=current.next;
        }
    }

    public static void main(String[] args) {

        Node first = new Node(1);
        first.next = new Node(3);
        first.next.next = new Node(5);
        first.next.next.next = new Node(7);
        first.next.next.next.next = new Node(4);

        first=LinkListPartitionAroundValueX.linkListPartition(first, 5);
        LinkListPartitionAroundValueX.printLinkList(first);


    }


}
