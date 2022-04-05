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

    }

    public void count(){

        //countMap holds the count details of each element
        Map<String, String> countgender = new HashMap<String, String>();
        for (String key : gender) {
            if (countgender.containsKey(key)) {
                int count = Integer.parseInt(countgender.get(key));
                count++;
                countgender.put(key, String.valueOf(count));
            } else {
                countgender.put(key, String.valueOf(1));
            }
        }

        System.out.println(countgender);


        Map<String, String> countparent = new HashMap<String, String>();
        for (String key : parent) {
            if (countparent.containsKey(key)) {
                int count = Integer.parseInt(countparent.get(key));
                count++;
                countparent.put(key, String.valueOf(count));
            } else {
                countparent.put(key, String.valueOf(1));
            }
        }

        System.out.println(countparent);


        Map<String, String> countpart_time = new HashMap<String, String>();
        for (String key : part_time) {
            if (countpart_time.containsKey(key)) {
                int count = Integer.parseInt(countpart_time.get(key));
                count++;
                countpart_time.put(key, String.valueOf(count));
            } else {
                countpart_time.put(key, String.valueOf(1));
            }
        }

        System.out.println(countpart_time.get("Yes"));
    }

    public void calc_probs(){



    }


    public void run(String gender,String parent,String parttime,String living,String business) {

        float y;

        int x = 0;

        float y1;
        float y2;
        float y3;
        float y4;
        float y5;

        float x1;
        float x2;
        float x3;
        float x4;
        float x5;

        int count = 0;
        if (Objects.equals(gender, "female")) {

        }
        /*
        else{
            x1=a2/a11;
            y1=a2/gender_total;
        }

        if(Objects.equals(parent, "yes")){
            x2=a3/a11;
            y2=a3/parent_total;
        }
        else{
            x2=a4/a11;
            y2=a4/parent_total;
        }

        if(Objects.equals(parttime, "yes")){
            x3=a5/a11;
            y3=a5/parttime_total;
        }
        else{
            x3=a6/a11;
            y3=a6/parttime_total;
        }

        if(Objects.equals(living, "rural")){
            x4=a7/a11;
            y4=a7/urbanrural_total;
        }
        else{
            x4=a8/a11;
            y4=a8/urbanrural_total;
        }

        if(Objects.equals(business, "yes")){
            x5=a9/a11;
            y5=a9/business_total;
        }
        else{
            x5=a10/a11;
            y5=a10/business_total;
        }

         */

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

