package assignment1;

import java.io.*;
import java.util.*;

public class Class1 {
    public String[] gender = {};
    public String[] parent = {};
    public String[] part_time = {};
    public String[] urban_rural = {};
    public String[] business = {};
    public String[] entrepreneur = {};

    public String filename;

    public float train_prob;
    public float train2_prob;
    public int z=0;

    public Class1(String filename) throws FileNotFoundException {
        this.filename=filename;
    }

    public void gathering_data(){
        int y = 0;

        String line;

        //parsing a CSV file into Scanner class constructor

        String delimiter = ",";

        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList(gender));
            ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList(parent));
            ArrayList<String> arrayList3 = new ArrayList<>(Arrays.asList(part_time));
            ArrayList<String> arrayList4 = new ArrayList<>(Arrays.asList(urban_rural));
            ArrayList<String> arrayList5 = new ArrayList<>(Arrays.asList(business));
            ArrayList<String> arrayList6 = new ArrayList<>(Arrays.asList(entrepreneur));


            String[] tempArr;
            while((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                for(String tempStr : tempArr) {
                    //System.out.print(tempStr + " ");

                    //gender
                    if(Objects.equals(tempStr, "Female")||Objects.equals(tempStr, "Male") && y==0){

                        arrayList1.add(tempStr);
                        gender = arrayList1.toArray(gender);

                        y=y+1;
                    }
                    else if(y==1) {

                        arrayList2.add(tempStr);
                        parent = arrayList2.toArray(parent);

                        y=y+1;
                    }
                    else if(y==2){

                        arrayList3.add(tempStr);
                        part_time = arrayList3.toArray(part_time);

                        y=y+1;
                    }
                    //urban or rural
                    else if(y==3){

                        arrayList4.add(tempStr);
                        urban_rural = arrayList4.toArray(urban_rural);

                        y=y+1;
                    }
                    //studies business
                    else if(y==4){

                        arrayList5.add(tempStr);
                        business = arrayList5.toArray(business);

                        y=y+1;
                    }
                    else if(y==5){

                        arrayList6.add(tempStr);
                        entrepreneur = arrayList6.toArray(entrepreneur);

                        y=0;
                    }
                }
            }
            br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println(Arrays.toString(gender));
        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(part_time));
        System.out.println(Arrays.toString(urban_rural));
        System.out.println(Arrays.toString(business));
        System.out.println(Arrays.toString(entrepreneur));
        System.out.println(gender[5]);

    }

    public void calc_probs(){
        


    }


    public void run(String gender,String parent,String parttime,String living,String business){


    }
/*
    public void train(int train_perc){
        String[] train_gender = {};

        train_perc = gender.length;

        Random r = new Random();



    }


/*

    public void test(){
        System.out.println(Float.compare(train_prob, train2_prob));
    }
*/
}


