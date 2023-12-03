package src;

public class Node {

    private String name;
    private double amount;
    private int importance;
    private Node next;

    public Node(String name, double amount, int importance) {
        this.name = name;
        this.amount = amount;
        this.importance = importance;
        next = null;
    }

   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
