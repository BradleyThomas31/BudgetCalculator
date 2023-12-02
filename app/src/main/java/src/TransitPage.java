package src;

public class TransitPage extends BasePage {

    public TransitPage(NodeModel nodeModel) {
        super(
            nodeModel,
            "Transit",
            "What is your total transportation cost, including rideshare services? (Ex. 87.00)",
            "/transit.jpg");
    }
}
