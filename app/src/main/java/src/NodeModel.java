package src;

//implements the model composite pattern
//stores and retrieves data for the Page classes
//each Page class shares the same nodeModel
public class NodeModel {

    private Node[] dataList; //each Node is the data for a budget item
    private int index; //position in the array

    //creates the model
    // only called once, so there is just 1 shared instance
    public NodeModel() {
       dataList = new Node[10]; // inits dataList
      index = 0; // inits index
   }    

    //adds a new node to the list, expands the list if necessary
    public void add(Node node) {
        if (index == dataList.length) {
           Node[] newList = new Node[dataList.length * 2];
           System.arraycopy(dataList, 0, newList, 0, dataList.length);
           dataList = newList;
        }
        dataList[index] = node;
        index++;
    }

    //returns the array of nodes
    public Node[] getDataList() {
        return dataList;
    }

    // sets the array list
    public void setDataList(Node[] dataList) {
        this.dataList = dataList;
    }

    //returns the place in teh array
    public int getIndex() {
        return index;
    }

    // returns a specific node in the array
    public Node getIndex(int i) {
        return dataList[i];
    }

    //sets a specific node in the array
    public void setIndex(int index) {
        this.index = index;
    }
}
