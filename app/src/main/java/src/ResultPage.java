package src;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultPage extends BasePage {

//    private NodeModel nodeModel;
 //   JPanel panel;

    public ResultPage(NodeModel nodeModel) {
        this.nodeModel = nodeModel;
    }

    @Override
    public JPanel handle() {
        panel = new JPanel();

        panel.add(new JLabel("Result Page"));
        createTable();


JTextField textField = new JTextField(String.valueOf(nodeModel.index));
//JTextField textField = new JTextField(String.valueOf(nodeModel.dataList.length));
//JTextField textField = new JTextField(String.valueOf(nodeModel.dataList[nodeModel.index - 1].importance));
panel.add(textField);

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

    void createTable() {
        String values[] = new String[nodeModel.index];
        String ranks[] = new String[nodeModel.index];
        String names[] = new String[nodeModel.index];
        for (int i = 0; i < nodeModel.index; i++) {
            names[i] = nodeModel.dataList[i].name;
            ranks[i] = Double.toString(nodeModel.dataList[i].importance);
            values[i] = Double.toString(nodeModel.dataList[i].amount);
        }
        String[] cols = {"Name", "Value", "Importance"};
       Object[][] data = new Object[nodeModel.index][3];
        for (int i = 0; i < nodeModel.index; i++) {
            data[i][0] = names[i];
            data[i][1] = values[i];
            data[i][2] = ranks[i];
        }
        DefaultTableModel model = new DefaultTableModel(data, cols);
        JTable table = new JTable(model);
        panel.add(table);
    }
}
