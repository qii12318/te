package inutil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputFile implements InputInterface{

    @Override
    public String setInput(ArrayList<String> sentences,String message) {
        String filename=message;
        
        String outcome;
        try{
            String line;
            ArrayList<String> tempSen=new ArrayList<>();
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            while((line=br.readLine())!=null){
                tempSen.add(line);
                System.out.println(line);
                if(!isEnglish(line))
                    return  "文件中只能包含纯英文";
            }
            br.close();
            for(int i=0;i<tempSen.size();i++)
                sentences.add(tempSen.get(i));
            outcome="读取完成,共"+sentences.size()+"条记录";
        }catch(IOException e){
                outcome="文件名错误";
            e.printStackTrace();
        }
        return outcome;
    }
    static boolean isEnglish(String s){
        boolean b=true;
        for(int i=0;i<s.length();i++){
            String eng=" QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm,.";
            if (!eng.contains(Character.toString(s.charAt(i))))
                b=false;
            if(s.charAt(s.length()-1)!='.')
                b=false;
            if(s.charAt(0)==' ')
                b=false;
        }
        return b;
    }
}
