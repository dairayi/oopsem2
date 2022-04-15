/*

Dairayi Mabika c20304181
15 April

class for creating and displaying a gui for user input and output
 */

package assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MyGUI extends JFrame implements ActionListener{

    public String gender;
    public String parent;
    public String partTime;
    public String urbanRural;
    public String business;
    public String entrepreneur;

    JLabel label1,label2,label3,label4,label5;
    JButton button1, button2,button3,button4;
    JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8,panel9,panel0;
    Choice list1,list2,list3,list4,list5;
    JTextField tf1,tf2,tf3;

    public String filename;

    public int percentage;
    // constructor - sets up the screen as it first appears when you
    // open it

    MyGUI (String title)
    {

        super(title);
        setSize(350,450);
        setLayout(new FlowLayout());
        setBackground(Color.CYAN);

        //text fields
        tf1 = new JTextField("MLdata.csv",20);
        tf2 = new JTextField(20);
        tf3 = new JTextField(20);

        tf3.setHorizontalAlignment(0);

        tf1.setToolTipText("enter file name to gather data");
        tf2.setToolTipText("enter percentage for training");
        tf3.setToolTipText("machine output");
        tf3.setEditable(false);


        //labels
        label1 = new JLabel("gender");
        label2 = new JLabel("parents");
        label3 = new JLabel("part time job");
        label4 = new JLabel("rural or urban");
        label5 = new JLabel("study business");

        label1.setToolTipText("are you male or female");
        label2.setToolTipText("do your parents own a business");
        label3.setToolTipText("do you have a part time job");
        label4.setToolTipText("do you live in a rural or urban area");
        label5.setToolTipText("do you study business");

        //buttons
        button1 = new JButton("submit");
        button2 = new JButton("train");
        button3 = new JButton("test");
        button4 = new JButton("run");

        //button1.setSize(100,50);
        //button colours
        button1.setBounds(100,110,90,25);
        button1.setForeground(Color.CYAN);
        button1.setBackground(Color.BLACK);
        button2.setBounds(100,110,90,25);
        button2.setForeground(Color.CYAN);
        button2.setBackground(Color.BLACK);
        button3.setBounds(100,110,90,25);
        button3.setForeground(Color.CYAN);
        button3.setBackground(Color.BLACK);
        button4.setBounds(100,110,90,25);
        button4.setForeground(Color.CYAN);
        button4.setBackground(Color.BLACK);

        //lists
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

        button1.setToolTipText("submit file name and gather data");
        button2.setToolTipText("train machine at specified percentage");
        button3.setToolTipText("test the machine at specified percentage");
        button4.setToolTipText("run machine");


        //panels for layout
        panel1 = new JPanel(new GridLayout(6,1,10,3));
        panel2 = new JPanel(new GridLayout(2,1,3,3));
        panel3 = new JPanel(new GridLayout(1,1,3,3));
        panel4 = new JPanel(new GridLayout(1,2,3,3));
        panel5 = new JPanel(new GridLayout(2,1,3,3));
        panel6 = new JPanel(new GridLayout(2,1,3,3));
        panel7 = new JPanel(new GridLayout(4,1,3,3));
        panel8 = new JPanel(new GridLayout(6,1,3,3));
        panel9 = new JPanel(new GridLayout(1,2,3,3));
        panel0 = new JPanel(new GridLayout(6,1,3,3));

        panel1.add(label1);
        panel8.add(list1);
        panel1.add(label2);
        panel8.add(list2);
        panel1.add(label3);
        panel8.add(list3);
        panel1.add(label4);
        panel8.add(list4);
        panel1.add(label5);
        panel8.add(list5);

        panel9.add(panel1);
        panel9.add(panel0);
        panel9.add(panel8);

        panel2.add(tf1);
        panel2.add(button1);

        panel3.add(tf2);

        panel4.add(button2);
        panel4.add(button3);

        panel5.add(panel3);
        panel5.add(panel4);

        panel6.add(button4);
        panel6.add(tf3);

        panel9.add(panel1);
        panel9.add(panel8);

        panel7.add(panel9);
        panel7.add(panel2);
        panel7.add(panel5);
        panel7.add(panel6);

        add(panel0);
        add(panel1);
        add(panel9);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        add(panel6);
        add(panel7);

        //action listeners
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        tf1.addActionListener(this);
        tf2.addActionListener(this);
        tf3.addActionListener(this);

        setVisible(true);

    }

    //method for collecting info from the list
    public void listSelect(){

        /*
        consists of if...else if statements
        an if...else if pair for each of the five questions
         */
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
            partTime = list3.getItem(list3.getSelectedIndex());
        }
        else if(Objects.equals(list3.getItem(list3.getSelectedIndex()), "No")){
            partTime = list3.getItem(list3.getSelectedIndex());
        }

        if(Objects.equals(list4.getItem(list4.getSelectedIndex()), "Urban")){
            urbanRural = list4.getItem(list4.getSelectedIndex());
        }
        else if(Objects.equals(list4.getItem(list4.getSelectedIndex()), "Rural")){
            urbanRural = list4.getItem(list4.getSelectedIndex());
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
        String chance;//chance of starting a business based on user chosen parameters
        String train;//the accuracy of the machine training at chosen percentage
        float percentage;

        //selecting a file and gathering data
        if(event.getSource() == button1){
            filename = tf1.getText();
            NaiveBayes.gatheringData(filename);
            JOptionPane.showMessageDialog(this,"data gathered");

        }

        //training machine
        else if(event.getSource() == button2){

            this.percentage = Integer.parseInt(tf2.getText());
            percentage = (float) this.percentage/100;
            NaiveBayes.train(percentage);
        }

        //testing machine
        else if(event.getSource() == button3){

            listSelect();

            train = NaiveBayes.test(gender,parent,partTime,urbanRural,business);

            tf3.setText(train);
        }

        //running the machine
        else if(event.getSource() == button4){

            listSelect();

            chance = NaiveBayes.run(gender,parent,partTime,urbanRural,business);

            tf3.setText(chance);
        }

    }
}

