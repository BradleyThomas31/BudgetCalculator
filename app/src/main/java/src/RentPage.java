package src;

//Budget page for rent / mortgage
public class RentPage extends BasePage {

    //creates the page by giving  BasePage the data
    public RentPage(NodeModel nodeModel) {
        super(
            nodeModel,
            "Rent",
            "How much do you currently pay in rent?",
            "/housing.jpg");
    }
}
