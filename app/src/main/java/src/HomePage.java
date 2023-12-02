package src;

import javax.swing.*;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends BasePage {

    public HomePage(NodeModel nodeModel) {
        this.nodeModel = nodeModel;
    }

    @Override
    public JPanel handle() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Home Page"));
        firstText();
        addImage();
        return nextButton();
    }

    public void firstText() {
        JTextArea text = new JTextArea(5, 20);
        text.setText("This application helps users create a financial budget.\n\nYou will be presented with a few questions to help create your budet");
        text.setEditable(false);
        panel.add(text);
    }

    public void addImage() {
        URL imageUrl = getClass().getResource("/budget.jpg");
        ImageIcon imageIcon = new ImageIcon(imageUrl);
        JLabel imageLabel = new JLabel(imageIcon);
        panel.add(imageLabel);
        JTextArea text = new JTextArea();
        text.setText("\n\n");
        panel.add(text);
    }

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
