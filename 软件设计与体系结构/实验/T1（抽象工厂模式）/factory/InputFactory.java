package factory;

import inutil.InputDB;
import inutil.InputFile;
import inutil.InputInterface;
import inutil.InputWrite;
import manageutil.ManageInterface;
import oututil.OutputInterface;

public class InputFactory implements AbstractFactory {
    private String inputType=null;
    public void setType(String type){
        inputType=type;
    }
    @Override
    public InputInterface getInputInterface() {
        switch (inputType){
            case "f":return new InputFile();
            case "c":return new InputWrite();
            case "d":return new InputDB();
            default:return null;
        }
    }
    @Override
    public ManageInterface getManageInterface() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public OutputInterface getOutputInterface() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void help() {
        System.out.println("请输入句子来源  f：文件  i：键入    d：数据库");
    }
}
