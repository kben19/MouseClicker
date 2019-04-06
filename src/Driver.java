/**
 * Created by benzali on 3/31/2019.
 */
public class Driver {

    public Driver(){
        try {
            View myView = new View();
            Model myModel = new Model();

            Controller myController = new Controller();
            myController.addModel(myModel);
            myController.addView(myView);

            myView.addController(myController);

            myModel.attach(myView);
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}
