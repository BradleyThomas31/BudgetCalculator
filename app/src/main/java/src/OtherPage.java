package src;

//Budget page for other expenses
public class OtherPage extends BasePage {

    //creates the page and gives BasePage its data
    public OtherPage(NodeModel nodeModel) {
        super(
            nodeModel,
            "Other",
            "Do you have any other expenses?? (Ex. 187.00)",
            "/other.jpg");
    }
}
