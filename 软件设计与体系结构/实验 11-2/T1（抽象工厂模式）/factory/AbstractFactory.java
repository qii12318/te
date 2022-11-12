package factory;


import inutil.InputInterface;
import manageutil.ManageInterface;
import oututil.OutputInterface;

public interface AbstractFactory {//抽象工厂类
    public void setType(String type);
    public void help();     
    public InputInterface getInputInterface();  //输入工厂
    public ManageInterface getManageInterface();//调整工厂
    public OutputInterface getOutputInterface();//输出工厂
}
