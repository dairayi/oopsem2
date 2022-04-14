package assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Class2 extends JFrame implements ActionListener{

    public String gender;
    public String parent;
    public String part_time;
    public String urban_rural;
    public String business;
    public String entrepreneur;

    JLabel label1,label2,label3,label4,label5;
    JButton button1, button2,button3,button4;
    JPanel panel1,panel2,panel3;
    Choice list1,list2,list3,list4,list5;
    JTextField tf1,tf2,tf3;

    public String filename;

    public int percentage;
    // constructor - sets up the screen as it first appears when you
    // open it



    Class2 (String title)
    {

        super(title);
        setSize(400,400);
        setLayout(new FlowLayout()); // sets the layout to a flowlayout

        tf1 = new JTextField("MLdata.csv",20);
        tf2 = new JTextField(20);
        tf3 = new JTextField(20);

        tf1.setToolTipText("enter file name to gather data");
        tf2.setToolTipText("enter percentage for training");
        tf3.setEditable(false);


        label1 = new JLabel("gender");
        label2 = new JLabel("did your parents start a business");
        label3 = new JLabel("do you have a part time job");
        label4 = new JLabel("rural or urban");
        label5 = new JLabel("do you study business");

        button1 = new JButton("submit");
        button2 = new JButton("train");
        button3 = new JButton("test");
        button4 = new JButton("run");

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
        panel2.add(button4);

        panel3.add(panel1);
        panel3.add(panel2);
        panel3.add(tf1);
        panel3.add(tf2);
        panel3.add(tf3);

        add(panel1);
        add(panel2);
        add(panel3);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        tf1.addActionListener(this);
        tf2.addActionListener(this);
        tf3.addActionListener(this);

        setVisible(true);

    }

    public void list_select(){
        if(Objects.equals(list1.getItem(list1.getSelectedIndex()), "Female")){
            gender = list1.getItem(list1.getSelectedIndex());
        }
        else if(Objects.equals(list1.getItem(list1.getSelectedIndex()), "Male")){
            gender = list1.getItem(list1.getSelectedIndex());
        }

        if(Objects.equals(list2.getItem(list2.getSelectedIndex()), "Yes")){
            parent = list2.getItem(list2.getSelectedIndex());
        }
        else if(Objects.equals(list2.getItem(list2.getSelectedIndex()), "No")){
            parent = list2.getItem(list2.getSelectedIndex());
        }

        if(Objects.equals(list3.getItem(list3.getSelectedIndex()), "Yes")){
            part_time = list3.getItem(list3.getSelectedIndex());
        }
        else if(Objects.equals(list3.getItem(list3.getSelectedIndex()), "No")){
            part_time = list3.getItem(list3.getSelectedIndex());
        }

        if(Objects.equals(list4.getItem(list4.getSelectedIndex()), "Urban")){
            urban_rural = list4.getItem(list4.getSelectedIndex());
        }
        else if(Objects.equals(list4.getItem(list4.getSelectedIndex()), "Rural")){
            urban_rural = list4.getItem(list4.getSelectedIndex());
        }

        if(Objects.equals(list5.getItem(list5.getSelectedIndex()), "Yes")){
            entrepreneur = list5.getItem(list5.getSelectedIndex());
        }
        else if(Objects.equals(list5.getItem(list5.getSelectedIndex()), "No")){
            entrepreneur = list5.getItem(list5.getSelectedIndex());
        }
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        String chance;
        String train;
        float percentage;

        if(event.getSource() == button1){
            filename = tf1.getText();
            Class1.gathering_data(filename);
            JOptionPane.showMessageDialog(this,"data gathered");

        }

        else if(event.getSource() == button2){

            //JOptionPane.showMessageDialog(this, Class1.count());
            this.percentage = Integer.parseInt(tf2.getText());
            percentage = (float) this.percentage/100;
            Class1.train(percentage);

            //JOptionPane.showMessageDialog(this,"train" + sum);

        }

        else if(event.getSource() == button3){

            list_select();

            train = Class1.test(gender,parent,part_time,urban_rural,business);

            tf3.setText(train);
        }

        else if(event.getSource() == button4){

            list_select();

            chance = Class1.run(gender,parent,part_time,urban_rural,business);

            tf3.setText(chance);
        }

    }
}
