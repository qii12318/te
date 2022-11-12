package ui;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import manageutil.ManageInterface;
import oututil.OutputInterface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import approver.Approver;
import approver.OutputApprover;

public class MoveFrame extends JFrame{
    ArrayList<String> sentences;
    JTextField jf1=new JTextField(5);
    JTextField jf2=new JTextField(5);
    OutputInterface outputUtil;
    JTextArea pa;
    Approver approver=new OutputApprover();
    MoveFrame(ArrayList<String> sentence){
        super("循环移位");
        sentences=sentence;
        setSize(400,300);
        setLocation(300,200);
        setLayout(new BorderLayout());
        add(new JLabel("选择要移位的句子和次数，左正右负",JLabel.CENTER),BorderLayout.NORTH);
        int height;
            if(sentences.size()<10)
                height=10;
            else
                height=sentences.size();
            pa=new JTextArea(height,26);
            pa.setEditable(false);
            JScrollPane jsp=new JScrollPane(pa);
            JPanel sou=new JPanel();
            this.getContentPane().add(jsp,BorderLayout.CENTER);
            JButton confirm=new JButton("移位");confirm.addActionListener(new ConfirmListener());
            
            sou.add(new JLabel("句子"));sou.add(jf1);
            sou.add(new JLabel("次数"));sou.add(jf2);
            sou.add(confirm);
            this.add(sou,BorderLayout.SOUTH);
            String outcome= approver.processRequest(sentence,"output c", "");
            pa.setText(outcome);
        setVisible(true);
    }
    class ConfirmListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String outcome;
            try{
                int num=Integer.parseInt(jf1.getText()); 
                int pos=Integer.parseInt(jf2.getText());
                outcome=approver.processRequest(sentences, "manage m",num+" "+pos);
                Message msg=new Message(outcome);
                pa.setText(approver.processRequest(sentences,"output c", ""));
                jf1.setText("");jf2.setText("");
            }catch(Exception e0){
                Message msg=new Message("请输入有效的数字");
                e0.printStackTrace();
            }
        }
    }
}
