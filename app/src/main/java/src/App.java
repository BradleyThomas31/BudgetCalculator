package src;

import javax.swing.*;

public class App extends JFrame  {
    public App() {
        setTitle("Budget Calculatr");
        setSize(500, 500);

        NodeModel nodeModel = new NodeModel();

        BasePage homePage = new HomePage(nodeModel);
        BasePage rentPage = new RentPage(nodeModel,
                            "Rent", 
                             "How much do you currently pay in rent?", 
                             "/housing.jpg");
        BasePage foodPage = new FoodPage(nodeModel);
        BasePage transitPage = new TransitPage(nodeModel);
        BasePage funPage = new FunPage(nodeModel);
        BasePage otherPage = new OtherPage(nodeModel);
        BasePage resultPage = new ResultPage(nodeModel);

        homePage.setNext(rentPage); 
        rentPage.setNext(transitPage);    
        transitPage.setNext(foodPage);
        foodPage.setNext(funPage);
        funPage.setNext(otherPage);
        otherPage.setNext(resultPage);

        homePage.handle();

        JPanel finalPanel = homePage.handle();
        if (finalPanel != null) {
        this.setContentPane(finalPanel);
        } 
        else {
            System.err.println("End");
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }

    public String getGreeting() {
        return "Hello World!";
    }
}

