package ObserverPackage;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by benzali on 4/6/2019.
 */
public class Subject {

    ArrayList<Observer> observers = new ArrayList<>();

    public Subject(){}

    public void attach(Observer o){this.observers.add(o);}

    public void notifyObservers(Vector<String> anObject){
        for(Observer o : observers){
            o.update(anObject);
        }
    }

    public void updateMousePos(double x, double y){
        for(Observer o : observers){
            o.updateMousePos(x, y);
        }
    }
}
