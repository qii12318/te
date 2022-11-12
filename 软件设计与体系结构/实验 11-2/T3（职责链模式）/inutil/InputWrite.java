package inutil;

import java.util.ArrayList;

public class InputWrite implements InputInterface{
    public String setInput(ArrayList<String> sentences,String message){
        String []tempsen=message.split("\n");
        if(message.equals(""))
            return "请输入句子";
        for(int i=0;i<tempsen.length;i++){
            if(!InputFile.isEnglish(tempsen[i]))
                return "请输入纯英文句子";
        }
        for(int i=0;i<tempsen.length;i++){
            sentences.add(tempsen[i]);
        }
        return "添加"+tempsen.length+"个句子";
    }
}