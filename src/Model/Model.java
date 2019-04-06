package Model; /**
 * Created by benzali on 3/31/2019.
 */
import ObserverPackage.Subject;

import java.awt.*;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.Vector;

public class Model extends Subject {

    private Robot myRobot;
    private boolean mousePosSwitch = true;
    private Vector<Vector<String>> tableContent;

    public Model() throws Exception{
        myRobot = new Robot();
        System.out.print(DataType.LOOP.toString());
        mousePos();
    }

    public void addMove(String name, String x, String y, String delay, DataType type){
        Vector<String> item = new Vector<>();
        item.add(name);
        item.add(x);
        item.add(y);
        item.add(delay);

    }

    public void mousePos(){
        double x, y;

        x = MouseInfo.getPointerInfo().getLocation().getX();
        y = MouseInfo.getPointerInfo().getLocation().getY();

        updateMousePos(x, y);

    }

}
