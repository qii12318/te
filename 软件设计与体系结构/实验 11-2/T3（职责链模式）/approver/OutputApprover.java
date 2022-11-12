package approver;

import java.util.ArrayList;

import oututil.OutputDB;
import oututil.OutputFile;
import oututil.OutputRead;

public class OutputApprover extends Approver{
    public OutputApprover(){
        this.nextApprover=new InputApprover();
    }
    @Override
    public
    String processRequest(ArrayList<String> sentences,String type,String message) {
        if(type.split(" ")[0].equals("output")){
            switch(type.split(" ")[1]){
                case "f":return new OutputFile().setOutput(sentences, message);
                case "d":return new OutputDB().setOutput(sentences, message);
                case "c":return new OutputRead().setOutput(sentences, message);
                default :return null;
            }
        }
        else
        return nextApprover.processRequest(sentences, type, message);
    }
}
