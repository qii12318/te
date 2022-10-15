package factory;


import inutil.InputInterface;
import manageutil.ManageInterface;
import oututil.OutputInterface;

public interface AbstractFactory {
    public void setType(String type);
    public void help();
    public InputInterface getInputInterface();
    public ManageInterface getManageInterface();
    public OutputInterface getOutputInterface();
}
