package factory;
import inutil.InputInterface;
import manageutil.ManageInterface;
import oututil.OutputDB;
import oututil.OutputFile;
import oututil.OutputInterface;
import oututil.OutputRead;
public class OutputFactory implements AbstractFactory {//具体输出工厂
    private String outputType=null;
    public void setType(String type){
        outputType=type;    //简单工厂 输出方式
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
            case "f":return new OutputFile(); //文件输出
            case "c":return new OutputRead();//ui输出
            case "d":return new OutputDB();//数据库输出
            default:return null;
       }
    }
    @Override
    public void help() {
        System.out.println();
    }
}
