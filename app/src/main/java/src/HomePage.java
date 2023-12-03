package src;

import javax.swing.*;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

//the intro page to the budget app
public class HomePage extends BasePage {

    //creates the page from calling BasePage with data
    public HomePage(NodeModel nodeModel) {
        super(
            nodeModel,
            "Home",
            "This application helps users create a financial budget.\n\nYou will be presented with a few questions to help create your budet",
            "/budget.jpg");
    }

    //uses its own method so that it doessn't ask for a text response
    @Override
    public void firstQuestion() { 
        JTextArea frage = new JTextArea(5, 20);
        frage.setText(question + "\n");
        frage.setEditable(false);
        panel.add(frage);
    }

    //uses its own method so it doesnt give a second question
    @Override
    public void secondQuestion() { } 

    //uses its own method so it doesnt send data to the nodeModel
    @Override
    public JPanel nextButton() {
        JButton button = new JButton("Next");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
    }
}
