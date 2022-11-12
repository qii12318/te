package ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import inutil.InputDB;
import inutil.InputFile;
import inutil.InputWrite;

public class InputFrame extends JFrame{
    ArrayList<String> sentences=null;
    public InputFrame(ArrayList<String> sentence){
        super("输入：");
        sentences=sentence;
        setSize(300,150);
        setLocation(350,250);
        setLayout(new GridLayout(3, 1,5,4));
        JLabel title=new JLabel("请选择输入方式:   ",JLabel.CENTER);
        JButton jb1=new JButton("UI输入");jb1.addActionListener(new CListener());
        JButton jb2=new JButton("文件导入");jb2.addActionListener(new FileListener());
        JButton jb3=new JButton("数据库导入");jb3.addActionListener(new DbListener());
        JButton jb4=new JButton("取消");jb4.addActionListener(new CloseListener());
        add(title);
        JPanel mid=new JPanel();
        mid.add(jb1);mid.add(jb2);mid.add(jb3);
        JPanel bot=new JPanel();
        bot.add(jb4);
        add(mid); add(bot);
        setVisible(true);
    }
    class CloseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            InputFrame.this.dispose();
        }
    }
    class FileListener implements ActionListener{
        JTextField jtf;
        @Override
        public void actionPerformed(ActionEvent e) {
            InputFrame.this.dispose();
            JFrame jf=new JFrame("从文件导入数据");
            jf.setSize(250,140);
            jf.setLocation(350,250);
            jf.setLayout(new GridLayout(3, 1,5,4));
            JLabel title=new JLabel("请输入文件名",JLabel.CENTER);
            JPanel dmid=new JPanel();
            JPanel dbot=new JPanel();
            JButton jb0=new JButton("确认");jb0.addActionListener(new ConfirmListener());
            jtf=new JTextField(20);
            jtf.setText("sentences.txt");
            dmid.add(jtf);
            dbot.add(jb0);
            jf.add(title);
            jf.add(dmid);
            jf.add(dbot);
            jf.setVisible(true);
        }
        class ConfirmListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename=jtf.getText();
                String outcome=new InputFile().setInput(sentences, filename);
                Message me=new Message(outcome);
            }
        }
    }
    class CListener implements ActionListener{
        JTextArea pa;
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame bigframe=new JFrame("文本框");
            bigframe.setSize(400,300);
            bigframe.setLocation(300,200);
            bigframe.setLayout(new BorderLayout());
            bigframe.add(new JLabel("输入的句子：",JLabel.CENTER),BorderLayout.NORTH);
            pa=new JTextArea(20,26);
            pa.setEditable(true);
            JScrollPane jsp=new JScrollPane(pa);
            JPanel sou=new JPanel();
            bigframe.getContentPane().add(jsp,BorderLayout.CENTER);
            JButton confirm=new JButton("确认");confirm.addActionListener(new ConfirmListener());
            sou.add(confirm);
            bigframe.add(sou,BorderLayout.SOUTH);
            InputFrame.this.dispose();
            
            
            bigframe.setVisible(true);
        }
        class ConfirmListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                String in=pa.getText();
                String outcome=new InputWrite().setInput(sentences, in);
                Message message=new Message(outcome);
                if(!outcome.equals("请输入纯英文句子"))
                    pa.setText("");
            }
        }
    }
    class DbListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String outcome= new InputDB().setInput(sentences,"");
            Message msg=new Message(outcome);
        }
    }
}
