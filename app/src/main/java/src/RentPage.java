package src;

import javax.swing.*;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentPage extends BasePage {

    private NodeModel nodeModel;
    JPanel panel;
    JTextField value;
    JTextField ranking;

    public RentPage(NodeModel nodeModel) {
        this.nodeModel = nodeModel;
    }

    @Override
    public JPanel handle() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Rent Page"));
        firstQuestion();
        secondQuestion();
        addImage();
        return nextButton();
    }

    public void firstQuestion() {
        JTextArea question = new JTextArea(5, 20);
        question.setText("What is your current rent / mortgage? (Ex. 1200.00).\n");
        question.setEditable(false);
        panel.add(question);
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
        URL imageUrl = getClass().getResource("/housing.jpg");
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

//custom part    

   nodeModel.dataList[nodeModel.index] = new Node("Rent", Double.parseDouble(value.getText()), Integer.parseInt(ranking.getText()));
        nodeModel.index++;

//end custom part

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
