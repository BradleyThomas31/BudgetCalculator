package src;

public class Node {

    public String name;
    public double amount;
    public int importance;
    public Node next;

    public Node(String name, double amount, int importance) {
        this.name = name;
        this.amount = amount;
        this.importance = importance;
        next = null;
    }

}
