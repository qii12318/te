package facade;

import java.util.ArrayList;

import inutil.*;
import manageutil.*;
import oututil.*;

public class Facade {
    public String inputByWrite(ArrayList<String> sentences,String message){
        return new InputWrite().setInput(sentences, message);
    }
    public String inputByFile(ArrayList<String> sentences,String message){
        return new InputFile().setInput(sentences, message);
    }
    public String inputByDB(ArrayList<String> sentences){
        return new InputDB().setInput(sentences,"");
    }
    public String manageBySort(ArrayList<String> sentences){
        return new ManageSort().setManage(sentences, 0, 0);
    }
    public String manageByMove(ArrayList<String> sentences,int num,int pos){
        return new ManageMove().setManage(sentences, num, pos);
    }
    public String outputByRead(ArrayList<String> sentences){
        return new OutputRead().setOutput(sentences, "");
    }
    public String outputByFile(ArrayList<String> sentences,String message){
        return new OutputFile().setOutput(sentences, message);
    }
    public String outputByDB(ArrayList<String> sentences){
        return new OutputDB().setOutput(sentences,"");
    }
}
