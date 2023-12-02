package src;

import javax.swing.*;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class HomePage extends BasePage {

    public HomePage(NodeModel nodeModel) {
        super(
            nodeModel,
            "Home",
            "This application helps users create a financial budget.\n\nYou will be presented with a few questions to help create your budet",
            "/budget.jpg");
    }

    @Override
    public void firstQuestion() { 
        JTextArea frage = new JTextArea(5, 20);
        frage.setText(question + "\n");
        frage.setEditable(false);
        panel.add(frage);
    }

    @Override
    public void secondQuestion() { } 

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
