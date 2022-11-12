package oututil;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputFile implements OutputInterface{
    public String setOutput(ArrayList<String>sentences,String message ){
        String outcome;
        String filename=message;
        try{
            FileWriter fw=new FileWriter(filename);
            for(int i=0;i<sentences.size();i++){
                fw.write(sentences.get(i)+"\n");
            }
            fw.close();
            outcome="已写入到文件中";
        }catch(IOException e){
            outcome="无效的文件名";
            e.printStackTrace();
        }
        return outcome;
    }
}
