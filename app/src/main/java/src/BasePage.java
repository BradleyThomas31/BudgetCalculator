package src;

import javax.swing.*;
import java.net.URL;
import java.awt.event.*;
import java.awt.*;

//The Base page to be extended
public class BasePage implements GUIHandler {

    JPanel panel; //panel to be added to
    BasePage next; //the next page 
    NodeModel nodeModel; //universal nodeModel for all pages to add data to
    JTextField value; //field for user input
    JTextField ranking; //importance rank for budget items
    String name; //name for budget items
    String question; //question the user will answer
    String imagePath; //path to the page iamge

    //creates a base page
    public BasePage() {
    }

    //creates a base page and inits vars
    //these fields are later fed into the nodeModel
    public BasePage(NodeModel nodeModel, String name, String question, String imagePath) {
        this.nodeModel = nodeModel;
        this.name = name;
        this.question = question;
        this.imagePath = imagePath;
    }

    // returns next page
    public BasePage getNext() {
        return next;
    }

    //returns panel
    public JPanel getPanel() {
        return panel;
    }

    //sets the panel
    public void setPanel(JPanel panelParam) {
        panel = panelParam;
    }

    //returns ranking
    public JTextField getRanking() {
        return ranking;
    }

    //returns ranking
    public void setRanking(JTextField input) {
        ranking = input;
    }

    //returns value (ie. amount of the budget item)
    public JTextField getValue() {
        return value;
    }

    //returns the node model
    public NodeModel getNodeModel() {
        return nodeModel;
    }

    //returns the question
    public String getQuestion() {
        return question;
    }

    //returns name
    public String getName() {
        return name;
    }

    //sets the next page
    public void setNext(BasePage nextHandler) {
        this.next = nextHandler;
    }

    //adds output to the panel
    //calls all other methods to be used
    //returns the next page
    public JPanel handle() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel(name + "Page"));
        firstQuestion();
        secondQuestion();
        addImage();
        return nextButton();
    }

    //adds a button to the panel to go ot the next page
    //adds data to the nodeModel based on the user inpt and page data
    public JPanel nextButton() {
        JButton button = new JButton("Next");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Node newNode = new Node(
                               name, 
                               Double.parseDouble(value.getText()), 
                               Integer.parseInt(ranking.getText()));
                nodeModel.add(newNode);

                //if there is a next page, it clears the current output and calls the next page
                if (next != null) {
                    panel.removeAll();
                    JPanel nextPanel = next.handle();
                    panel.add(nextPanel);
                    panel.revalidate();
                }
            }
        });
        panel.add(button);
        panel.repaint();
        return panel;
        //this panel will then be added the output to the JFrame
    }

    //asks the user a question
    //gives a text box response
    public void firstQuestion() {
        JTextArea frage = new JTextArea(5, 20);
        frage.setText(question + "\n");
        frage.setEditable(false);
        panel.add(frage);
        value = new JTextField();
        panel.add(value);
    }

    //asks the user to rank the item's importance
    //gives a text box response
    public void secondQuestion() {
        JTextArea question = new JTextArea(5, 20);
        question.setText("How important is this to you? (1 - 5).\n");
        question.setEditable(false);
        panel.add(question);
        ranking = new JTextField();
        panel.add(ranking);
    }

    //adds an image to the page
    public void addImage() {
        URL imageUrl = getClass().getResource(imagePath);
        ImageIcon imageIcon = new ImageIcon(imageUrl);
        Image rawImage = imageIcon.getImage();
        Image sizedImage = rawImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(sizedImage);
        JLabel imageLabel = new JLabel(imageIcon);
        panel.add(imageLabel);
        JTextArea text = new JTextArea();
        text.setText("\n\n");
        panel.add(text);
    }
}

