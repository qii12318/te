package manageutil;

import java.util.ArrayList;

public class ManageMove implements ManageInterface{
    @Override
    public String setManage(ArrayList<String> sentences, int num, int pos) {
        String sentence=sentences.get(num);
        sentence=sentence.substring(0,sentence.length()-1);
        String []words=sentence.split(" ");
        if(pos>0){
            for(int i=0;i<pos;i++){//循环左移
                String tempword=words[0];
                for(int j=1;j<words.length;j++){
                    words[j-1]=words[j];
                }
                words[words.length-1]=tempword;
            }
        }
        else{
            pos=-pos;
            for(int i=0;i<pos;i++){//循环右移
                String tempword=words[words.length-1];
                for(int j=words.length-1;j>0;j--){
                    words[j]=words[j-1];
                }
                words[0]=tempword;
            }
        }
        sentence="";
        for(int j=0;j<words.length;j++)
        {
            sentence+=words[j]+" ";
        }
        sentence=sentence.substring(0,sentence.length()-1);
        sentence+=".";
        sentences.set(num,sentence );
        return "移动成功";
    }
}