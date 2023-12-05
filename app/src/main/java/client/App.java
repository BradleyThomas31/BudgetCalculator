package client;

import src.*;
import javax.swing.*;

//This class runs the Budget Application
public class App extends JFrame  {
    public App() {
        setTitle("Budget Application");
        setSize(500, 500);

        //shared model which stores data
        NodeModel nodeModel = new NodeModel();

        //creates the pages
        BasePage homePage = new HomePage(nodeModel);
        BasePage rentPage = new RentPage(nodeModel);
        BasePage foodPage = new FoodPage(nodeModel);
        BasePage transitPage = new TransitPage(nodeModel);
        BasePage funPage = new FunPage(nodeModel);
        BasePage otherPage = new OtherPage(nodeModel);
        BasePage resultPage = new ResultPage(nodeModel);

        //sets up the chain
        homePage.setNext(rentPage); 
        rentPage.setNext(transitPage);    
        transitPage.setNext(foodPage);
        foodPage.setNext(funPage);
        funPage.setNext(otherPage);
        otherPage.setNext(resultPage);

        //starts the chain
        homePage.handle();

        //ends the program
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
}

