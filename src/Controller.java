import Model.Model;

/**
 * Created by benzali on 3/31/2019.
 */
public class Controller implements java.awt.event.ActionListener {
    Model aModel;
    View aView;

    public Controller(){

    }

    public void actionPerformed(java.awt.event.ActionEvent e){
        if(e.getActionCommand().equals("Submit")){
            aModel.addMove(aView.getNameField(), aView.getXTextField(), aView.getYTextField(), aView.getDelayField(), aView.getDataType());
        }
        else if(e.getActionCommand().equals("Show")){
            aModel.mousePos();
        }
    }

    public void addModel(Model model){
        aModel = model;
    }

    public void addView(View view){
        aView = view;
    }


}
