/**
 * Created by lenskart on 21/02/2017.
 */

class Node {
    Node next;
    int data;

    Node(int value) {
        this.data = value;
    }
}

public class AddLinkedList {
    private Node first;
    private Node second;
    private Node result;

    public AddLinkedList(Node first, Node second) {
        this.first = first;
        this.second = second;
    }

    public void add() {
        this.result = addRecursive(this.first, this.second, 0);
    }

    private Node addRecursive(Node l1, Node l2, int carry) {

        if (l1 == null && l2 == null && carry == 0)
            return null;

        int value = carry;

        if (l1 != null)
            value += l1.data;

        if (l2 != null)
            value += l2.data;

        int data = value % 10;
        carry = value / 10;

        Node result = new Node(data);

        if (l1 != null && l2 != null)
            result.next = addRecursive(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);

        return result;

    }


    public void printResult() {
        if (this.result == null)
            System.out.println("please add link list");
        Node current = this.result;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }


    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(2);
        first.next.next = new Node(3);
        Node second = new Node(1);
        second.next = new Node(2);
        second.next.next = new Node(2);
        AddLinkedList addLinkedList = new AddLinkedList(first, second);
        addLinkedList.add();
        addLinkedList.printResult();
    }

}
