package src;

//Budget page for transportation
public class TransitPage extends BasePage {

    //creates the page by calling BasePage with data
    public TransitPage(NodeModel nodeModel) {
        super(
            nodeModel,
            "Transit",
            "What is your total transportation cost, including rideshare services? (Ex. 87.00)",
            "/transit.jpg");
    }
}
