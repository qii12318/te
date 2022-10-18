import java.util.ArrayList;

import javax.swing.JFrame;

import ui.MainFrame;

public class Main {
    
    public static void main(String []args){
        ArrayList<String> sentences=new ArrayList<String>();
        sentences.add("a have an apple.");sentences.add("I have an apple.");sentences.add("a have an apple.");
        sentences.add("B have an apple.");sentences.add("d have an apple.");sentences.add("c have an apple.");
        JFrame MF=new MainFrame(sentences);
        /*Scanner sc=new Scanner(System.in);
        AbstractFactory factory=new InputFactory();
        factory.help();
        String inType=sc.nextLine();
        factory.setType(inType);
        InputInterface inputUtil=factory.getInputInterface();
        inputUtil.setInput(sentences);
        */
    }
}
