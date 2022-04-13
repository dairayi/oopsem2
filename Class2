package assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Class2 extends JFrame implements ActionListener{
    JLabel label1,label2,label3,label4,label5;
    JButton button1, button2,button3;
    JPanel panel1,panel2,panel3;
    Choice list1,list2,list3,list4,list5;
    JTextField tf1,tf2;

    String filename;

    float percentage;
    // constructor - sets up the screen as it first appears when you
    // open it



    Class2 (String title)
    {

        super(title);
        setSize(300,300);
        setLayout(new FlowLayout()); // sets the layout to a flowlayout

        tf1 = new JTextField(20);
        tf2 = new JTextField(20);

        label1 = new JLabel("gender");
        label2 = new JLabel("did your parents start a business");
        label3 = new JLabel("do you have a part time job");
        label4 = new JLabel("rural or urban");
        label5 = new JLabel("do you study business");

        button1 = new JButton("run");
        button2 = new JButton("train");
        button3 = new JButton("test");

        list1 = new Choice();
        list1.add("Female");
        list1.add("Male");

        list2 = new Choice();
        list2.add("Yes");
        list2.add("No");

        list3 = new Choice();
        list3.add("Yes");
        list3.add("No");

        list4 = new Choice();
        list4.add("Urban");
        list4.add("Rural");

        list5 = new Choice();
        list5.add("Yes");
        list5.add("No");

        button1.setToolTipText("This is the first button, and show a message when clicked");
        button2.setToolTipText("This is the second button, and show a message when clicked");


        panel1 = new JPanel(new GridLayout(5,1));
        panel2 = new JPanel(new GridLayout(1,3));
        panel3 = new JPanel(new GridLayout(3,1));
        //panel2.setBackground(Color.red);

        panel1.add(label1);
        panel1.add(list1);
        panel1.add(label2);
        panel1.add(list2);
        panel1.add(label3);
        panel1.add(list3);
        panel1.add(label4);
        panel1.add(list4);
        panel1.add(label5);
        panel1.add(list5);

        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);

        panel3.add(panel1);
        panel3.add(panel2);
        panel3.add(tf1);
        panel3.add(tf2);

        add(panel1);
        add(panel2);
        add(panel3);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        tf1.addActionListener(this);
        tf2.addActionListener(this);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        percentage = Float.parseFloat(tf1.getText());
        filename = tf2.getText();
        //Class1.train(Float.parseFloat(percentage));
        List sum;

        if(event.getSource() == button1){
            JOptionPane.showMessageDialog(this,"run");
        }

        else if(event.getSource() == button2){

            //JOptionPane.showMessageDialog(this, Class1.count());
            Class1.gathering_data(filename);
            sum = Class1.train(percentage);

            JOptionPane.showMessageDialog(this,"train" + sum);


        }

    }
}
