package factory;

import inutil.InputDB;
import inutil.InputFile;
import inutil.InputInterface;
import inutil.InputWrite;
import manageutil.ManageInterface;
import oututil.OutputInterface;

public class InputFactory implements AbstractFactory {//具体输入工厂类
    private String inputType=null;
    public void setType(String type){               //简单工厂：输入方式
        inputType=type;
    }
    @Override
    public InputInterface getInputInterface() {
        switch (inputType){
            case "f":return new InputFile();//通过文件输入
            case "c":return new InputWrite();//通过ui输入
            case "d":return new InputDB();//通过数据库输入
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
