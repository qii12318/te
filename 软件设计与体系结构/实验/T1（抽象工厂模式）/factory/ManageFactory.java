package factory;

import inutil.InputInterface;
import manageutil.ManageInterface;
import manageutil.ManageMove;
import manageutil.ManageSort;
import oututil.OutputInterface;

public class ManageFactory implements AbstractFactory {
    private String manageType=null;
    public void setType(String type){
        manageType=type;
    }
    @Override
    public InputInterface getInputInterface() {
       return null;
    }
    @Override
    public ManageInterface getManageInterface() {
        switch(manageType){
            case "m":return new ManageMove();
            case "s":return new ManageSort();
            default:return null; 
        }
    }
    @Override
    public OutputInterface getOutputInterface() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void help() {
        System.out.println();
    }
}
