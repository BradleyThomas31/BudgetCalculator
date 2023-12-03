package src;

//Budget page for entertainment expenses
public class FunPage extends BasePage {

    //creates the page by calling BasePage with data
    public FunPage(NodeModel nodeModel) {
        super(
            nodeModel,
            "Entertainment",
            "How much do you typically spend on entertainment? (Ex. 117.00)",
            "/fun.jpg");
    }
}
