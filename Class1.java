package assignment1;

import java.io.*;
import java.util.*;

public class Class1 {

    public static String[] gender = {};
    public static String[] parent = {};
    public static String[] part_time = {};
    public static String[] urban_rural = {};
    public static String[] business = {};
    public static String[] entrepreneur = {};

    public static int[] train = {};


    public static float gender_female = 0;
    public static float gender_male = 0;
    public static float parent_yes = 0;
    public static float parent_no = 0;
    public static float parttime_yes = 0;
    public static float parttime_no = 0;
    public static float urbanrural_urban = 0;
    public static float urbanrural_rural = 0;
    public static float business_yes = 0;
    public static float business_no = 0;
    public static float entrepenuer_yes = 0;
    public static float entrepenuer_no = 0;


    public static float train_gender_female = 0;
    public static float train_gender_male = 0;
    public static float train_parent_yes = 0;
    public static float train_parent_no = 0;
    public static float train_parttime_yes = 0;
    public static float train_parttime_no = 0;
    public static float train_urbanrural_urban = 0;
    public static float train_urbanrural_rural = 0;
    public static float train_business_yes = 0;
    public static float train_business_no = 0;
    public static float train_entrepenuer_yes = 0;
    public static float train_entrepenuer_no = 0;

    public static float train2_gender_female = 0;
    public static float train2_gender_male = 0;
    public static float train2_parent_yes = 0;
    public static float train2_parent_no = 0;
    public static float train2_parttime_yes = 0;
    public static float train2_parttime_no = 0;
    public static float train2_urbanrural_urban = 0;
    public static float train2_urbanrural_rural = 0;
    public static float train2_business_yes = 0;
    public static float train2_business_no = 0;
    public static float train2_entrepenuer_yes = 0;
    public static float train2_entrepenuer_no = 0;

    static String[] train_gender = {};
    static String[] train_parent = {};
    static String[] train_parttime = {};
    static String[] train_urbanrural = {};
    static String[] train_business = {};
    static String[] train_entrepreneur = {};

    static String[] train2_gender = {};
    static String[] train2_parent = {};
    static String[] train2_parttime = {};
    static String[] train2_urbanrural = {};
    static String[] train2_business = {};
    static String[] train2_entrepreneur = {};

    public static String filename;

    public Class1(String filename) throws FileNotFoundException {
        filename="MLdata.csv";
        Class1.filename =filename;
    }

    public static void gathering_data(String filename){
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

    public static void test_count(){
        //System.out.println(Arrays.toString(gender));

        //if(Objects.equals(option, "gender")){
        for(String name : train_gender)
        {
            if(Objects.equals(name, "Female")){
                train_gender_female=train_gender_female+1;
            }
            else if(Objects.equals(name,"Male")){
                train_gender_male=train_gender_male+1;
            }
        }
        //}

        //else if(Objects.equals(option, "parent")){
        for(String name : train_parent)
        {
            if(Objects.equals(name, "Yes")){
                train_parent_yes=train_parent_yes+1;
            }
            else{
                train_parent_no=train_parent_no+1;
            }
        }
        //}

        //else if(Objects.equals(option, "parttime")){
        for(String name : train_parttime)
        {
            if(Objects.equals(name, "Yes")){
                train_parttime_yes=train_parttime_yes+1;
            }
            else{
                train_parttime_no=train_parttime_no+1;
            }
        }
        //}

        //else if(Objects.equals(option, "urbanrural")){
        for(String name : train_urbanrural)
        {
            if(Objects.equals(name, "Urban")){
                train_urbanrural_urban=train_urbanrural_urban+1;
            }
            else if(Objects.equals(name, "Rural")){
                train_urbanrural_rural=train_urbanrural_rural+1;
            }
        }
        //}

        //else if(Objects.equals(option, "business")){
        for(String name : train_business)
        {
            if(Objects.equals(name, "Yes")){
                train_business_yes=train_business_yes+1;
            }
            else{
                train_business_no=train_business_no+1;
            }
        }
        //}

        //else{
        for(String name : train_entrepreneur)
        {
            if(Objects.equals(name, "Yes")){
                train_entrepenuer_yes=train_entrepenuer_no+1;
            }
            else{
                train_entrepenuer_no=train_entrepenuer_no+1;
            }
        }
        //}


        for(String name : train2_gender)
        {
            if(Objects.equals(name, "Female")){
                train2_gender_female=train2_gender_female+1;
            }
            else if(Objects.equals(name,"Male")){
                train2_gender_male=train2_gender_male+1;
            }
        }
        //}

        //else if(Objects.equals(option, "parent")){
        for(String name : train2_parent)
        {
            if(Objects.equals(name, "Yes")){
                train2_parent_yes=train2_parent_yes+1;
            }
            else{
                train2_parent_no=train2_parent_no+1;
            }
        }
        //}

        //else if(Objects.equals(option, "parttime")){
        for(String name : train_parttime)
        {
            if(Objects.equals(name, "Yes")){
                train2_parttime_yes=train2_parttime_yes+1;
            }
            else{
                train2_parttime_no=train2_parttime_no+1;
            }
        }
        //}

        //else if(Objects.equals(option, "urbanrural")){
        for(String name : train2_urbanrural)
        {
            if(Objects.equals(name, "Urban")){
                train2_urbanrural_urban=train2_urbanrural_urban+1;
            }
            else if(Objects.equals(name, "Rural")){
                train2_urbanrural_rural=train2_urbanrural_rural+1;
            }
        }
        //}

        //else if(Objects.equals(option, "business")){
        for(String name : train2_business)
        {
            if(Objects.equals(name, "Yes")){
                train2_business_yes=train2_business_yes+1;
            }
            else{
                train2_business_no=train2_business_no+1;
            }
        }
        //}

        //else{
        for(String name : train2_entrepreneur)
        {
            if(Objects.equals(name, "Yes")){
                train2_entrepenuer_yes=train2_entrepenuer_no+1;
            }
            else{
                train2_entrepenuer_no=train2_entrepenuer_no+1;
            }
        }
        //}
    }

    public static void count(){
        //System.out.println(Arrays.toString(gender));

        //if(Objects.equals(option, "gender")){
            for(String name : gender)
            {
                if(Objects.equals(name, "Female")){
                    gender_female=gender_female+1;
                }
                else if(Objects.equals(name,"Male")){
                    gender_male=gender_male+1;
                }
            }
        //}

        //else if(Objects.equals(option, "parent")){
            for(String name : parent)
            {
                if(Objects.equals(name, "Yes")){
                    parent_yes=parent_yes+1;
                }
                else{
                    parent_no=parent_no+1;
                }
            }
        //}

        //else if(Objects.equals(option, "parttime")){
            for(String name : part_time)
            {
                if(Objects.equals(name, "Yes")){
                    parttime_yes=parttime_yes+1;
                }
                else{
                    parttime_no=parttime_no+1;
                }
            }
        //}

        //else if(Objects.equals(option, "urbanrural")){
            for(String name : urban_rural)
            {
                if(Objects.equals(name, "Urban")){
                    urbanrural_urban=urbanrural_urban+1;
                }
                else if(Objects.equals(name, "Rural")){
                    urbanrural_rural=urbanrural_rural+1;
                }
            }
        //}

        //else if(Objects.equals(option, "business")){
            for(String name : business)
            {
                if(Objects.equals(name, "Yes")){
                    business_yes=business_yes+1;
                }
                else{
                    business_no=business_no+1;
                }
            }
        //}

        //else{
            for(String name : entrepreneur)
            {
                if(Objects.equals(name, "Yes")){
                    entrepenuer_yes=entrepenuer_no+1;
                }
                else{
                    entrepenuer_no=entrepenuer_no+1;
                }
            }
        //}
    }

    public static List random_num(float percent){
        int maxRange;
        int size = gender.length;

        maxRange= (int) (size*(percent));
        Random random = new Random();

        return random.ints(0, size).distinct().limit(maxRange).sorted().boxed().toList();
    }

    public static void train(float percent){

        ArrayList <Integer> nums = new ArrayList<>(random_num(percent));
        ArrayList <Integer> nums2 = new ArrayList<>();

        ArrayList<String> gender_train = new ArrayList<>(Arrays.asList(train_gender));
        ArrayList<String> parent_train = new ArrayList<>(Arrays.asList(train_parent));
        ArrayList<String> parttime_train = new ArrayList<>(Arrays.asList(train_parttime));
        ArrayList<String> urbanrural_train = new ArrayList<>(Arrays.asList(train_urbanrural));
        ArrayList<String> business_train = new ArrayList<>(Arrays.asList(train_business));
        ArrayList<String> entrepreneur_train = new ArrayList<>(Arrays.asList(train_entrepreneur));

        ArrayList<String> gender_train2 = new ArrayList<>(Arrays.asList(train2_gender));
        ArrayList<String> parent_train2 = new ArrayList<>(Arrays.asList(train2_parent));
        ArrayList<String> parttime_train2 = new ArrayList<>(Arrays.asList(train2_parttime));
        ArrayList<String> urbanrural_train2 = new ArrayList<>(Arrays.asList(train2_urbanrural));
        ArrayList<String> business_train2 = new ArrayList<>(Arrays.asList(train2_business));
        ArrayList<String> entrepreneur_train2 = new ArrayList<>(Arrays.asList(train2_entrepreneur));


        //gets a percentage of the data
        for(Object name : nums){
            //System.out.println(gender[(int) name]);
            gender_train.add(gender[(int) name]);
            parent_train.add(parent[(int) name]);
            parttime_train.add(part_time[(int) name]);
            urbanrural_train.add(urban_rural[(int) name]);
            business_train.add(business[(int) name]);

            entrepreneur_train.add(entrepreneur[(int) name]);
        }

        train_gender = gender_train.toArray(String[]::new);
        train_parent = parent_train.toArray(String[]::new);
        train_parttime = parttime_train.toArray(String[]::new);
        train_urbanrural = urbanrural_train.toArray(String[]::new);
        train_business = business_train.toArray(String[]::new);
        train_entrepreneur = entrepreneur_train.toArray(String[]::new);




        for(int x = 0;x< gender.length; x++){
            nums2.add(x);
        }

        nums2.removeAll(nums);

        for(Object name : nums2){
            //System.out.println(gender[(int) name]);
            gender_train2.add(gender[(int) name]);
            parent_train2.add(parent[(int) name]);
            parttime_train2.add(part_time[(int) name]);
            urbanrural_train2.add(urban_rural[(int) name]);
            business_train2.add(business[(int) name]);

            entrepreneur_train2.add(entrepreneur[(int) name]);
        }

        train2_gender = gender_train2.toArray(String[]::new);
        train2_parent = parent_train2.toArray(String[]::new);
        train2_parttime = parttime_train2.toArray(String[]::new);
        train2_urbanrural = urbanrural_train2.toArray(String[]::new);
        train2_business = business_train2.toArray(String[]::new);
        train2_entrepreneur = entrepreneur_train2.toArray(String[]::new);

        //System.out.println(gender_train+"\n"+gender_train2);

    }

    public static String test(String usrgender, String usrparent, String usrparttime, String usrurbanrural, String usrbusiness) {

        train_gender_female = 0;
        train_gender_male = 0;
        train_parent_yes = 0;
        train_parent_no = 0;
        train_parttime_yes = 0;
        train_parttime_no = 0;
        train_urbanrural_urban = 0;
        train_urbanrural_rural = 0;
        train_business_yes = 0;
        train_business_no = 0;
        train_entrepenuer_yes = 0;
        train_entrepenuer_no = 0;

        train2_gender_female = 0;
        train2_gender_male = 0;
        train2_parent_yes = 0;
        train2_parent_no = 0;
        train2_parttime_yes = 0;
        train2_parttime_no = 0;
        train2_urbanrural_urban = 0;
        train2_urbanrural_rural = 0;
        train2_business_yes = 0;
        train2_business_no = 0;
        train2_entrepenuer_yes = 0;
        train2_entrepenuer_no = 0;


        float x1 = 0;
        float x2 = 0;
        float x3 = 0;
        float x4 = 0;
        float x5 = 0;

        float z1 = 0;
        float z2 = 0;
        float z3 = 0;
        float z4 = 0;
        float z5 = 0;

        float y1 = 0;
        float y2 = 0;

        float chance1 = 0;
        float chance2 = 0;

        test_count();

        y1 = train_entrepenuer_yes/(train_entrepenuer_yes+train_entrepenuer_no);
        y2 = train2_entrepenuer_yes/(train2_entrepenuer_yes+train2_entrepenuer_no);

        if(Objects.equals(usrgender, "Female")){
            x1 = train_gender_female/train_entrepenuer_yes;
        }
        else{
            x1 = train_gender_male/train_entrepenuer_yes;
        }

        if(Objects.equals(usrparent, "Yes")){
            x2 = train_parent_yes/train_entrepenuer_yes;
        }
        else{
            x2 = train_parent_no/train_entrepenuer_yes;
        }

        if(Objects.equals(usrparttime, "Yes")){
            x3 = train_parttime_yes/train_entrepenuer_yes;
        }
        else{
            x3 = train_parttime_no/train_entrepenuer_yes;
        }

        if(Objects.equals(usrurbanrural, "Urban")){
            x4 = train_urbanrural_urban/train_entrepenuer_yes;
        }
        else if(Objects.equals(usrurbanrural, "Rural")){
            x4 = train_urbanrural_rural/train_entrepenuer_yes;
        }

        if(Objects.equals(usrbusiness, "Yes")){
            x5 = train_business_yes/train_entrepenuer_yes;
        }
        else{
            x5 = train_business_no/train_entrepenuer_yes;
        }

        if(Objects.equals(usrgender, "Female")){
            z1 = train2_gender_female/train2_entrepenuer_yes;
        }
        else{
            z1 = train2_gender_male/train2_entrepenuer_yes;
        }

        if(Objects.equals(usrparent, "Yes")){
            z2 = train2_parent_yes/train2_entrepenuer_yes;
        }
        else{
            z2 = train2_parent_no/train2_entrepenuer_yes;
        }

        if(Objects.equals(usrparttime, "Yes")){
            z3 = train2_parttime_yes/train2_entrepenuer_yes;
        }
        else{
            z3 = train2_parttime_no/train2_entrepenuer_yes;
        }

        if(Objects.equals(usrurbanrural, "Urban")){
            z4 = train2_urbanrural_urban/train2_entrepenuer_yes;
        }
        else if(Objects.equals(usrurbanrural, "Rural")){
            z4 = train2_urbanrural_rural/train2_entrepenuer_yes;
        }

        if(Objects.equals(usrbusiness, "Yes")){
            z5 = train2_business_yes/train2_entrepenuer_yes;
        }
        else{
            z5 = train2_business_no/train2_entrepenuer_yes;
        }


        chance1 = (x1*x2*x3*x4*x5)*y1;
        chance2 = (z1*z2*z3*z4*z5)*y2;

        return ((chance1*100)+ "%\n" + (chance2*100)+"%");

    }


    public static String run(String usrgender, String usrparent, String usrparttime, String usrurbanrural, String usrbusiness) {

        gender_female = 0;
        gender_male = 0;
        parent_yes = 0;
        parent_no = 0;
        parttime_yes = 0;
        parttime_no = 0;
        urbanrural_urban = 0;
        urbanrural_rural = 0;
        business_yes = 0;
        business_no = 0;
        entrepenuer_yes = 0;
        entrepenuer_no = 0;


        float x1 = 0;
        float x2 = 0;
        float x3 = 0;
        float x4 = 0;
        float x5 = 0;

        float y = 0;

        float chance = 0;

        count();

        y = entrepenuer_yes/entrepreneur.length;

        if(Objects.equals(usrgender, "Female")){
            x1 = gender_female/entrepenuer_yes;
        }
        else{
            x1 = gender_male/entrepenuer_yes;
        }

        if(Objects.equals(usrparent, "Yes")){
            x2 = parent_yes/entrepenuer_yes;
        }
        else{
            x2 = parent_no/entrepenuer_yes;
        }

        if(Objects.equals(usrparttime, "Yes")){
            x3 = parttime_yes/entrepenuer_yes;
        }
        else{
            x3 = parttime_no/entrepenuer_yes;
        }

        if(Objects.equals(usrurbanrural, "Urban")){
            x4 = urbanrural_urban/entrepenuer_yes;
        }
        else if(Objects.equals(usrurbanrural, "Rural")){
            x4 = urbanrural_rural/entrepenuer_yes;
        }

        if(Objects.equals(usrbusiness, "Yes")){
            x5 = business_yes/entrepenuer_yes;
        }
        else{
            x5 = business_no/entrepenuer_yes;
        }


        chance = (x1*x2*x3*x4*x5)*y;

        return ("chance = "+chance*100+"%");

    }
}
