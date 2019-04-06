/**
 * Created by benzali on 3/31/2019.
 */
import ObserverPackage.Subject;

import java.awt.*;
import java.util.Random;

public class Model extends Subject {

    private Robot myRobot;
    private boolean mousePosSwitch = true;

    public Model() throws Exception{
        myRobot = new Robot();

        mousePos();
    }

    public void addAction(int x, int y){
        myRobot.mouseMove(x, y);
    }

    public void mousePos(){
        double x, y;

        x = MouseInfo.getPointerInfo().getLocation().getX();
        y = MouseInfo.getPointerInfo().getLocation().getY();

        updateMousePos(x, y);

    }

}
