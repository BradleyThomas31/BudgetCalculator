package src;

//Budget page for groceries and restaurant expenses
public class FoodPage extends BasePage {

    //creates the page by calling BasePage with data
    public FoodPage(NodeModel nodeModel) {
        super(
            nodeModel,
            "Groceries & Restaurants",
            "What do you typically spend on groceries and restaurants? (Ex. 457.00)",
            "/food.jpg");
    }
}
