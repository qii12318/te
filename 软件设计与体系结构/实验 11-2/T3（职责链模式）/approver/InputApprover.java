package approver;

import java.util.ArrayList;

import inutil.InputDB;
import inutil.InputFile;
import inutil.InputWrite;
import oututil.OutputDB;
import oututil.OutputFile;
import oututil.OutputRead;

public class InputApprover extends Approver{
    public InputApprover(){
        this.nextApprover=new ManageApprover();
    }
    @Override
    public
        String processRequest(ArrayList<String> sentences,String type,String message){
            if(type.split(" ")[0].equals("input")){
                switch (type.split(" ")[1]){
                    case "f":return new InputFile().setInput(sentences, message);
                    case "d":return new InputDB().setInput(sentences, message);
                    case "c":return new InputWrite().setInput(sentences, message);
                    default:return null;
                }
            }  
            else
                return nextApprover.processRequest(sentences, type, message);
        }
}
