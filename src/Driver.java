/**
 * Created by benzali on 3/31/2019.
 */
public class Driver {

    public Driver(){
        try {
            Model myModel = new Model();
            View myView = new View();

            Controller myController = new Controller();
            myController.addModel(myModel);
            myController.addView(myView);

            myView.addController(myController);
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}
