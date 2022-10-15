package factory;
import inutil.InputInterface;
import manageutil.ManageInterface;
import oututil.OutputDB;
import oututil.OutputFile;
import oututil.OutputInterface;
import oututil.OutputRead;
public class OutputFactory implements AbstractFactory {
    private String outputType=null;
    public void setType(String type){
        outputType=type;
    }
    @Override
    public InputInterface getInputInterface() {
        return null;
    }
    @Override
    public ManageInterface getManageInterface() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public OutputInterface getOutputInterface() {
        switch(outputType){
            case "f":return new OutputFile(); 
            case "c":return new OutputRead();
            case "d":return new OutputDB();
            default:return null;
       }
    }
    @Override
    public void help() {
        System.out.println();
    }
}
