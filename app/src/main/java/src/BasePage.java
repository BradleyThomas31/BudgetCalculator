package src;

import javax.swing.*;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class BasePage implements GUIHandler {

    JPanel panel;
    BasePage next;
    NodeModel nodeModel;
    JTextField value;
    JTextField ranking;
    String name;
    String question;
    String imagePath;

    public BasePage() {
    }

    public BasePage(NodeModel nodeModel, String name, String question, String imagePath) {
        this.nodeModel = nodeModel;
        this.name = name;
        this.question = question;
        this.imagePath = imagePath;
    }

    public BasePage getNext() {
        return next;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setNext(BasePage nextHandler) {
        this.next = nextHandler;
    }

    public JPanel handle() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel(name + "Page"));
        firstQuestion();
        secondQuestion();
        addImage();
        return nextButton();
    }

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

    public void firstQuestion() {
        JTextArea frage = new JTextArea(5, 20);
        frage.setText(question + "\n");
        frage.setEditable(false);
        panel.add(frage);
        value = new JTextField();
        panel.add(value);
    }

    public void secondQuestion() {
        JTextArea question = new JTextArea(5, 20);
        question.setText("How important is this to you? (1 - 5).\n");
        question.setEditable(false);
        panel.add(question);
        ranking = new JTextField();
        panel.add(ranking);
    }

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

