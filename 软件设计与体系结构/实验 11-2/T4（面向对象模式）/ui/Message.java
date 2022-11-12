package ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Message extends JFrame{
    Message(String s){
        super("警告");
        JLabel jl=new JLabel(s,JLabel.CENTER);
        JButton jb=new JButton("确认");jb.addActionListener(new ConfirmListener());
        setSize(170,100);
        setLayout(new GridLayout(2,1));
        JPanel jp=new JPanel();
        jp.add(jb);
        setLocation(330,250);
        add(jl);add(jp);
        setVisible(true);
    }
    class ConfirmListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Message.this.dispose();
        }
    }
}
