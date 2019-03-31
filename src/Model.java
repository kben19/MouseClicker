/**
 * Created by benzali on 3/31/2019.
 */
import java.awt.Robot;
import java.util.Random;

public class Model {

    private Robot myRobot;

    public Model() throws Exception{
        myRobot = new Robot();
    }

    public void addAction(int x, int y){
        myRobot.mouseMove(x, y);
    }

}
