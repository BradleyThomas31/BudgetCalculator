package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunPage extends BasePage {

//    private NodeModel nodeModel;

    public FunPage(NodeModel nodeModel) {
        this.nodeModel = nodeModel;
    }

    @Override
    public JPanel handle() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Fun Page"));
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
