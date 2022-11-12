package ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import factory.*;
import inutil.InputInterface;
import oututil.OutputInterface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class OutputFrame extends JFrame{
    ArrayList<String> sentences=null;
    public OutputFrame(ArrayList<String> sentence){
        super("输出：");
        sentences=sentence;
        setSize(300,150);
        setLocation(350,250);
        setLayout(new GridLayout(3, 1,5,4));
        JLabel title=new JLabel("请选择输方式:   ",JLabel.CENTER);
        JButton jb1=new JButton("输出到UI");jb1.addActionListener(new CListener());
        JButton jb2=new JButton("文件导出");jb2.addActionListener(new FileListener());
        JButton jb3=new JButton("数据库导出");jb3.addActionListener(new DbListener());
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
            OutputFrame.this.dispose();
        }
    }
    class FileListener implements ActionListener{
        JTextField jtf;
        @Override
        public void actionPerformed(ActionEvent e) {
            OutputFrame.this.dispose();
            JFrame jf=new JFrame("从文件导出数据");
            jf.setSize(250,140);
            jf.setLocation(350,250);
            jf.setLayout(new GridLayout(3, 1,5,4));
            JLabel title=new JLabel("请输入文件名",JLabel.CENTER);
            JPanel dmid=new JPanel();
            JPanel dbot=new JPanel();
            JButton jb0=new JButton("确认");jb0.addActionListener(new ConfirmListener());
            jtf=new JTextField(20);
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
                AbstractFactory factory=new OutputFactory();
                factory.setType("f");
                OutputInterface outputUtil=factory.getOutputInterface();
                String outcome=outputUtil.setOutput(sentences,filename);
                Message me=new Message(outcome);
            }
        }
    }
    class CListener implements ActionListener{
        JFrame bigframe;
        public void actionPerformed(ActionEvent e) {
            bigframe=new JFrame("文本框");
            bigframe.setSize(400,300);
            bigframe.setLocation(300,200);
            bigframe.setLayout(new BorderLayout());
            bigframe.add(new JLabel("输出的句子：",JLabel.CENTER),BorderLayout.NORTH);
            int height;
            if(sentences.size()<10)
                height=10;
            else
                height=sentences.size();
            JTextArea pa=new JTextArea(height,26);
            pa.setEditable(false);
            JScrollPane jsp=new JScrollPane(pa);
            JPanel sou=new JPanel();
            bigframe.getContentPane().add(jsp,BorderLayout.CENTER);
            JButton confirm=new JButton("确认");confirm.addActionListener(new ConfirmListener());
            sou.add(confirm);
            bigframe.add(sou,BorderLayout.SOUTH);
            OutputFrame.this.dispose();
            AbstractFactory factory=new OutputFactory();
            factory.setType("c");
            OutputInterface outputUtil= factory.getOutputInterface();
            pa.setText(outputUtil.setOutput(sentences, ""));
            bigframe.setVisible(true);
        }
        class ConfirmListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                bigframe.dispose();
            }
        }
    }
    class DbListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            AbstractFactory factory=new OutputFactory();
            factory.setType("d");
            OutputInterface outputUtil=factory.getOutputInterface();
            String outcome=outputUtil.setOutput(sentences,"");
            Message msg=new Message(outcome);
        }
    }
}
