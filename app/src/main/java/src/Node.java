package src;

//Used in an array
//get values with get() methods
//set values with set() methods
public class Node {

    private String name; // name of a budget option
    private double amount; // dollar amount spent
    private int importance; //rank of how important it is
    private Node next; //next Node in the chain

   //creates a new Node with the values
    public Node(String name, double amount, int importance) {
        this.name = name;
        this.amount = amount;
        this.importance = importance;
        next = null;
    }
   
   //returns name
   public String getName() {
        return name;
    }

   //sets name
    public void setName(String name) {
       this.name = name;
    }

    //gets amount of the expense
    public double getAmount() {
        return amount;
    }
  
    //sets amount of the expense
    public void setAmount(double amount) {
        this.amount = amount;
    }


    //gets rank of importance of the budget item
    public int getImportance() {
        return importance;
    }
   
    //sets rank of importance of the budget item
    public void setImportance(int importance) {
        this.importance = importance;
    }

    //returns next node in the chain
    public Node getNext() {
        return next;
    }

    //sets the next node in the chain
    public void setNext(Node next) {
        this.next = next;
    }
}
