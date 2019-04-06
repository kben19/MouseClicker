package ObserverPackage;

import java.util.Vector;

/**
 * Created by benzali on 4/6/2019.
 */
public interface Observer {
    void update(Vector<String> anObject);
    void updateMousePos(double x, double y);
}
