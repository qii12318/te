package factory;

import inutil.InputInterface;
import manageutil.ManageInterface;
import manageutil.ManageMove;
import manageutil.ManageSort;
import oututil.OutputInterface;

public class ManageFactory implements AbstractFactory {     //具体调整工厂
    private String manageType=null;
    public void setType(String type){   //简单工厂：调整方式
        manageType=type;
    }
    @Override
    public InputInterface getInputInterface() {
       return null;
    }
    @Override
    public ManageInterface getManageInterface() {
        switch(manageType){             
            case "m":return new ManageMove();//move
            case "s":return new ManageSort();//srot
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
