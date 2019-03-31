/**
 * Created by benzali on 3/31/2019.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class View {
    private TextField xTextField, yTextField;
    private Button submitButton;

    public View(){
        Frame frame = new Frame("Mouse Clicker");
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        xTextField = new TextField();
        yTextField = new TextField();

        submitButton = new Button("Submit");

        panel1.add(new Label("X:"));
        panel1.add(xTextField);
        panel1.add(new Label("Y:"));
        panel1.add(yTextField);
        panel1.add(submitButton);

        frame.add(panel1);
        frame.addWindowListener(new CloseListener());
        frame.setSize(400, 200);
        frame.setLocation(100, 100);
        frame.setVisible(true);

    }

    public String getXTextField(){  return xTextField.getText();    }

    public String getYTextField(){  return yTextField.getText();    }

    public void addController(ActionListener controller){
        submitButton.addActionListener(controller);
    }

    public static class CloseListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            System.exit(0);
        } //windowClosing()
    } //CloseListener

}
