/**
 * Created by benzali on 3/31/2019.
 */
import javax.swing.*;
import java.awt.*;

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

    }

}
