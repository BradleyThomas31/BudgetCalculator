package src;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultPage extends BasePage {

    String values[];
    String ranks[];
    String names[];
    String[] cols;
    Object[][] tableData;
    DefaultPieDataset pieData;

    public ResultPage(NodeModel nodeModel) {

        this.nodeModel = nodeModel;
    }

    @Override
    public JPanel handle() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Result Page"));
        initData();
        createTable();
        createChart();

//make this go home
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
        DefaultTableModel model = new DefaultTableModel(tableData, cols);
        JTable table = new JTable(model);
        panel.add(table);
    }

    public void createChart() {
        JFreeChart chart = ChartFactory.createPieChart(
                "Your Budget",
                pieData,
                true,  
                true,
                false);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(25060, 250));
        panel.add(chartPanel);
        panel.revalidate(); 
    }

    public void initData() {
        this.values = new String[nodeModel.index];
        this.ranks = new String[nodeModel.index];
        this.names = new String[nodeModel.index];
        this.cols = new String[]{"Name", "Value", "Importance"};
        this.tableData = new Object[nodeModel.index][3];
        pieData = new DefaultPieDataset();
        for (int i = 0; i < nodeModel.index; i++) {
            names[i] = nodeModel.dataList[i].name;
            ranks[i] = Double.toString(nodeModel.dataList[i].importance);
            values[i] = Double.toString(nodeModel.dataList[i].amount);
        }
        for (int i = 0; i < nodeModel.index; i++) {
            tableData[i][0] = names[i];
            tableData[i][1] = values[i];
            tableData[i][2] = ranks[i];
        }
        for (int i = 0; i < names.length; i++) {
            pieData.setValue(names[i], Double.parseDouble(values[i]));
        }
    }
}
