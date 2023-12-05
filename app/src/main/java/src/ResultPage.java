package src;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.*;

//the null end of the node chain
//displays data from the nodeModel
public class ResultPage extends BasePage {

    String values[]; //dollar amounts from budget items
    String ranks[]; //importance ranks from budget items
    String names[]; //names from budget items
    String[] cols; //columns in the table
    Object[][] tableData; //stores data from above arrays
    DefaultPieDataset pieData; //data for the pie chart

    //creates the page
    public ResultPage(NodeModel nodeModel) {
        this.nodeModel = nodeModel;
    }

    //creates the JPanel
    //sets up the data visualizations
    @Override
    public JPanel handle() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Result Page"));
        initData();
        createTable();
        createChart();
        return panel;
    }

    //creates the data table based on the nodeModel data
    //adds to the panel to add to the screen
    void createTable() {
        DefaultTableModel model = new DefaultTableModel(tableData, cols);
        JTable table = new JTable(model);
        panel.add(table);
    }

    //creates the pie chart from the nodeModel data
    //adds to the panel to send to the screen
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

    //inits the arrays and vars from nodeModel data
    public void initData() {
        //inits the arrays based on the size of the node array
        this.values = new String[nodeModel.getIndex()];
        this.ranks = new String[nodeModel.getIndex()];
        this.names = new String[nodeModel.getIndex()];

        //creates the columns 
        this.cols = new String[]{"Name", "Value", "Importance"};

        //creates the table data
        //3 columns, and index number of rows
        this.tableData = new Object[nodeModel.getIndex()][3];

        //standard init
        pieData = new DefaultPieDataset();

        //adds data to the arrays based on nodeModel fields
        for (int i = 0; i < nodeModel.getIndex(); i++) {
            names[i] = nodeModel.getIndex(i).getName();
            ranks[i] = Double.toString(nodeModel.getIndex(i).getImportance());
            values[i] = Double.toString(nodeModel.getIndex(i).getAmount());
        }

        //sets data for the 3 columns
        for (int i = 0; i < nodeModel.getIndex(); i++) {
            tableData[i][0] = names[i];
            tableData[i][1] = values[i];
            tableData[i][2] = ranks[i];
        }
     
        //sets pie chart data 
        for (int i = 0; i < names.length; i++) {
            pieData.setValue(names[i], Double.parseDouble(values[i]));
        }
    }
}
