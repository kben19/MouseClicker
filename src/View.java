/**
 * Created by benzali on 3/31/2019.
 */
import Model.DataType;
import ObserverPackage.Observer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

public class View implements Observer {
    private TextField nameField, xTextField, yTextField, delayField;
    private JLabel xLabel, yLabel;
    private Button submitButton, outerLoopButton, showPosButton;
    private JComboBox typeBox;
    private JTable table;

    public View(){
        Frame frame = new Frame("Mouse Clicker");
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());

        nameField = new TextField("");
        nameField.setColumns(7);
        xTextField = new TextField("0");
        yTextField = new TextField("0");
        delayField = new TextField("0");
        xLabel = new JLabel("0");
        yLabel = new JLabel("0");

        typeBox = new JComboBox(new String[] {"Action", "Loop"});
        typeBox.setSelectedIndex(0);

        submitButton = new Button("Submit");
        outerLoopButton = new Button("Outer Loop");
        showPosButton = new Button("Show");

        String[] columnNames = new String[] {"Name", "X", "Y", "Delay", "Type"};
        table = new JTable(new DefaultTableModel(columnNames, 0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        });
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    //allow only one selection at a time
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        table.setAutoCreateRowSorter(true);
        JScrollPane js = new JScrollPane(table);    // Enable the table to be scrollable
        js.setPreferredSize(new Dimension(frame.getWidth(), 250));
        js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        JPanel panelForm = new JPanel();
        panelForm.setLayout(new FlowLayout());
        panelForm.add(new Label("Name:"));
        panelForm.add(nameField);
        panelForm.add(new Label("X:"));
        panelForm.add(xTextField);
        panelForm.add(new Label("Y:"));
        panelForm.add(yTextField);
        panelForm.add(new Label("Delay:"));
        panelForm.add(delayField);
        panelForm.add(typeBox);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(submitButton);
        buttonPanel.add(outerLoopButton);

        panel1.add(panelForm, BorderLayout.NORTH);
        panel1.add(buttonPanel, BorderLayout.CENTER);

        panel2.add(table.getTableHeader(), BorderLayout.NORTH);
        panel2.add(js, BorderLayout.CENTER);

        panel3.add(showPosButton);
        panel3.add(xLabel);
        panel3.add(yLabel);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.SOUTH);
        frame.addWindowListener(new CloseListener());
        frame.setSize(700, 300);
        frame.setLocation(100, 100);
        frame.setVisible(true);

    }

    public String getXTextField(){  return xTextField.getText();    }

    public String getYTextField(){  return yTextField.getText();    }

    public String getNameField(){   return nameField.getText();     }

    public String getDelayField(){  return delayField.getText();    }

    public DataType getDataType(){
        if(typeBox.getSelectedIndex() == 0){
            return DataType.ACTION;
        }
        else{
            return DataType.LOOP;
        }
    }

    public void addController(ActionListener controller){
        submitButton.addActionListener(controller);
        outerLoopButton.addActionListener(controller);
        showPosButton.addActionListener(controller);
    }

    public static class CloseListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            System.exit(0);
        } //windowClosing()
    } //CloseListener

    @Override
    public void update(Vector<String> object){

    }

    @Override
    public void updateMousePos(double x, double y){
        xLabel.setText(Double.toString(x));
        yLabel.setText(Double.toString(y));
    }

}
