package bms;

public class Node {
    Bank account;
    Node next;

    public Node(Bank account) {
        this.account = account;
        this.next = null;
    }
}

