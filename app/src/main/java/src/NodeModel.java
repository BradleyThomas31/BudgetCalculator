package src;

public class NodeModel {

    private Node[] dataList;
    private int index;

    public NodeModel() {
       dataList = new Node[10];
      index = 0;
   }    

    public void add(Node node) {
        if (index == dataList.length) {
           Node[] newList = new Node[dataList.length * 2];
           System.arraycopy(dataList, 0, newList, 0, dataList.length);
           dataList = newList;
        }
        dataList[index] = node;
        index++;
    }

    public Node[] getDataList() {
        return dataList;
    }

    public void setDataList(Node[] dataList) {
        this.dataList = dataList;
    }

    public int getIndex() {
        return index;
    }

    public Node getIndex(int i) {
        return dataList[i];
    }

    public void setIndex(int index) {
        this.index = index;
    }


}
