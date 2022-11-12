package ui;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import factory.AbstractFactory;
import factory.ManageFactory;
import manageutil.ManageInterface;

public class MainFrame extends JFrame {
    ArrayList<String> sentences=null;
    public MainFrame(ArrayList<String> sentence){
        super("	KWIC 软件系统");
        sentences=sentence;
        setSize(300,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(300,200);
        setLayout(new GridLayout(3, 1,5,4));
        JLabel title=new JLabel("请选择功能:   ",JLabel.CENTER);
        add(title);
        JPanel mid=new JPanel();
        //mid.setLayout(new GridLayout(1,4,5,5));
        JButton jb1=new JButton("输入");jb1.addActionListener(new InputListener());
        JButton jb2=new JButton("移位");jb2.addActionListener(new MoveListener());
        JButton jb3=new JButton("排序");jb3.addActionListener(new SortListener());
        JButton jb4=new JButton("输出");jb4.addActionListener(new OutputListener());
        JButton jb5=new JButton("关闭");jb5.addActionListener(new CloseListener());
        JButton jb6=new JButton("帮助");
        mid.add(jb1);mid.add(jb2);mid.add(jb3);mid.add(jb4);
        JPanel bot=new JPanel();
        bot.add(jb5);bot.add(jb6);
        add(mid);
        add(bot);
        setVisible(true);
    }
    class CloseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            MainFrame.this.dispose();
        }
    }
    class InputListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            InputFrame inf=new InputFrame(sentences);
        }
    }
    class OutputListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            OutputFrame ouf=new OutputFrame(sentences);
        }
    }
    class SortListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            AbstractFactory factory=new ManageFactory();
            factory.setType("s");
            ManageInterface manageUtil=factory.getManageInterface();
            manageUtil.setManage(sentences, 0, 0);
            Message msg=new Message("排序完成");
        }
    }
    class MoveListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            MoveFrame mf=new MoveFrame(sentences);
        }
    }
}
