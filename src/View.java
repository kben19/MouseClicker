/**
 * Created by benzali on 3/31/2019.
 */
import ObserverPackage.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

public class View implements Observer {
    private TextField xTextField, yTextField;
    private JLabel xLabel, yLabel;
    private Button submitButton, showPosButton;

    public View(){
        Frame frame = new Frame("Mouse Clicker");
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());

        xTextField = new TextField("0");
        yTextField = new TextField("0");
        xLabel = new JLabel("0");
        yLabel = new JLabel("0");

        submitButton = new Button("Submit");
        showPosButton = new Button("Show");

        panel1.add(new Label("X:"));
        panel1.add(xTextField);
        panel1.add(new Label("Y:"));
        panel1.add(yTextField);
        panel1.add(submitButton);

        panel2.add(showPosButton);
        panel2.add(xLabel);
        panel2.add(yLabel);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.addWindowListener(new CloseListener());
        frame.setSize(400, 200);
        frame.setLocation(100, 100);
        frame.setVisible(true);

    }

    public String getXTextField(){  return xTextField.getText();    }

    public String getYTextField(){  return yTextField.getText();    }

    public void addController(ActionListener controller){
        submitButton.addActionListener(controller);
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
