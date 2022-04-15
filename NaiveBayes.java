/*
Dairayi Mabika c20304181
15 April
class that gathers data from csv file and using naive bayes outputs the probability of a student becoming an entrepreneur
based on their attributes.

 */

package assignment1;

import java.io.*;
import java.util.*;

public class NaiveBayes {

    //strings of all data from csv file
    public static String[] gender = {};
    public static String[] parent = {};
    public static String[] partTime = {};
    public static String[] urbanRural = {};
    public static String[] business = {};
    public static String[] entrepreneur = {};

    //csv data split at user chosen percentage for training and testing
    static String[] trainGender = {};
    static String[] trainParent = {};
    static String[] trainPartTime = {};
    static String[] trainUrbanRural = {};
    static String[] trainBusiness = {};
    static String[] trainEntrepreneur = {};

    static String[] train2Gender = {};
    static String[] train2Parent = {};
    static String[] train2PartTime = {};
    static String[] train2UrbanRural = {};
    static String[] train2Business = {};
    static String[] train2Entrepreneur = {};

    public static float trainPercent = 0;//percent used for training machine

    //counts for all options
    public static float genderFemale = 0;
    public static float genderMale = 0;
    public static float parentYes = 0;
    public static float parentNo = 0;
    public static float parttimeYes = 0;
    public static float parttimeNo = 0;
    public static float urbanruralUrban = 0;
    public static float urbanruralRural = 0;
    public static float businessYes = 0;
    public static float businessNo = 0;
    public static float entrepenuerYes = 0;
    public static float entrepenuerNo = 0;

    public static float trainGenderFemale = 0;
    public static float trainGenderMale = 0;
    public static float trainParentYes = 0;
    public static float trainParentNo = 0;
    public static float trainPartTimeYes = 0;
    public static float trainPartTimeNo = 0;
    public static float trainUrbanRuralUrban = 0;
    public static float trainUrbanRuralRural = 0;
    public static float trainBusinessYes = 0;
    public static float trainBusinessNo = 0;
    public static float trainEntreprenuerYes = 0;
    public static float trainEntreprenuerNo = 0;

    public static float train2GenderFemale = 0;
    public static float train2GenderMale = 0;
    public static float train2ParentYes = 0;
    public static float train2ParentNo = 0;
    public static float train2PartTimeYes = 0;
    public static float train2PartTimeNo = 0;
    public static float train2UrbanRuralUrban = 0;
    public static float train2UrbanRuralRural = 0;
    public static float train2BusinessYes = 0;
    public static float train2BusinessNo = 0;
    public static float train2EntreprenuerYes = 0;
    public static float train2EntreprenuerNo = 0;

    //filename of current file in use
    public static String filename;

    public NaiveBayes(String filename) {
        filename="MLdata.csv";
        NaiveBayes.filename =filename;
    }

    //method for gathering data from file
    public static void gatheringData(String filename){
        int y = 0;

        String line;

        String delimiter = ",";

        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            //creating lists version of the arrays
            ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList(gender));
            ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList(parent));
            ArrayList<String> arrayList3 = new ArrayList<>(Arrays.asList(partTime));
            ArrayList<String> arrayList4 = new ArrayList<>(Arrays.asList(urbanRural));
            ArrayList<String> arrayList5 = new ArrayList<>(Arrays.asList(business));
            ArrayList<String> arrayList6 = new ArrayList<>(Arrays.asList(entrepreneur));


            String[] tempArr;
            //looping through file adding each item to the correct array and list
            while((line = br.readLine()) != null) {

                tempArr = line.split(delimiter);

                for(String tempStr : tempArr) {

                    //Gender
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
                        partTime = arrayList3.toArray(partTime);

                        y=y+1;
                    }
                    //urban or rural
                    else if(y==3){

                        arrayList4.add(tempStr);
                        urbanRural = arrayList4.toArray(urbanRural);

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
                    else{
                        System.out.println("error");
                    }
                }
            }//end while

            br.close();//close file

        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

    }

    //method for counting the elements of the array
    public static void count(){

        for(String name : gender)
        {
            if(Objects.equals(name, "Female")){
                genderFemale=genderFemale+1;
            }
            else if(Objects.equals(name,"Male")){
                genderMale=genderMale+1;
            }
        }

        for(String name : parent)
        {
            if(Objects.equals(name, "Yes")){
                parentYes=parentYes+1;
            }
            else{
                parentNo=parentNo+1;
            }
        }

        for(String name : partTime)
        {
            if(Objects.equals(name, "Yes")){
                parttimeYes=parttimeYes+1;
            }
            else{
                parttimeNo=parttimeNo+1;
            }
        }

        for(String name : urbanRural)
        {
            if(Objects.equals(name, "Rural")){
                urbanruralRural=urbanruralRural+1;
            }
            else{
                urbanruralUrban=urbanruralUrban+1;
            }
        }

        for(String name : business)
        {
            if(Objects.equals(name, "Yes")){
                businessYes=businessYes+1;
            }
            else{
                businessNo=businessNo+1;
            }
        }

        for(String name : entrepreneur)
        {
            if(Objects.equals(name, "Yes")){
                entrepenuerYes=entrepenuerNo+1;
            }
            else{
                entrepenuerNo=entrepenuerNo+1;
            }
        }
    }

    //counting the elements of the training arrays
    public static void testCount(){

        for(String name : trainGender)
        {
            if(Objects.equals(name, "Female")){
                trainGenderFemale=trainGenderFemale+1;
            }
            else if(Objects.equals(name,"Male")){
                trainGenderMale=trainGenderMale+1;
            }
        }

        for(String name : trainParent)
        {
            if(Objects.equals(name, "Yes")){
                trainParentYes=trainParentYes+1;
            }
            else{
                trainParentNo=trainParentNo+1;
            }
        }

        for(String name : trainPartTime)
        {
            if(Objects.equals(name, "Yes")){
                trainPartTimeYes=trainPartTimeYes+1;
            }
            else{
                trainPartTimeNo=trainPartTimeNo+1;
            }
        }

        for(String name : trainUrbanRural)
        {
            if(Objects.equals(name, "Urban")){
                trainUrbanRuralUrban=trainUrbanRuralUrban+1;
            }
            else if(Objects.equals(name, "Rural")){
                trainUrbanRuralRural=trainUrbanRuralRural+1;
            }
        }

        for(String name : trainBusiness)
        {
            if(Objects.equals(name, "Yes")){
                trainBusinessYes=trainBusinessYes+1;
            }
            else{
                trainBusinessNo=trainBusinessNo+1;
            }
        }

        for(String name : trainEntrepreneur)
        {
            if(Objects.equals(name, "Yes")){
                trainEntreprenuerYes=trainEntreprenuerNo+1;
            }
            else{
                trainEntreprenuerNo=trainEntreprenuerNo+1;
            }
        }

        for(String name : train2Gender)
        {
            if(Objects.equals(name, "Female")){
                train2GenderFemale=train2GenderFemale+1;
            }
            else if(Objects.equals(name,"Male")){
                train2GenderMale=train2GenderMale+1;
            }
        }

        for(String name : train2Parent)
        {
            if(Objects.equals(name, "Yes")){
                train2ParentYes=train2ParentYes+1;
            }
            else{
                train2ParentNo=train2ParentNo+1;
            }
        }

        for(String name : trainPartTime)
        {
            if(Objects.equals(name, "Yes")){
                train2PartTimeYes=train2PartTimeYes+1;
            }
            else{
                train2PartTimeNo=train2PartTimeNo+1;
            }
        }

        for(String name : train2UrbanRural)
        {
            if(Objects.equals(name, "Urban")){
                train2UrbanRuralUrban=train2UrbanRuralUrban+1;
            }
            else if(Objects.equals(name, "Rural")){
                train2UrbanRuralRural=train2UrbanRuralRural+1;
            }
        }

        for(String name : train2Business)
        {
            if(Objects.equals(name, "Yes")){
                train2BusinessYes=train2BusinessYes+1;
            }
            else{
                train2BusinessNo=train2BusinessNo+1;
            }
        }

        for(String name : train2Entrepreneur)
        {
            if(Objects.equals(name, "Yes")){
                train2EntreprenuerYes=train2EntreprenuerYes+1;
            }
            else{
                train2EntreprenuerNo=train2EntreprenuerNo+1;
            }
        }
    }


    //method for getting a random selection of list indexes at the chosen percentage
    public static List randomNum(float percent){
        int maxRange;
        int size = gender.length;

        maxRange= (int) (size*(percent));
        Random random = new Random();

        return random.ints(0, size).distinct().limit(maxRange).sorted().boxed().toList();
    }

    //method for training machine at chosen percentage
    public static void train(float percent){

        trainPercent = percent;

        ArrayList <Integer> nums = new ArrayList<>(randomNum(percent));
        ArrayList <Integer> nums2 = new ArrayList<>();


        //creating list versions of training arrays
        ArrayList<String> Gender_train = new ArrayList<>(Arrays.asList(trainGender));
        ArrayList<String> Parent_train = new ArrayList<>(Arrays.asList(trainParent));
        ArrayList<String> parttime_train = new ArrayList<>(Arrays.asList(trainPartTime));
        ArrayList<String> urbanrural_train = new ArrayList<>(Arrays.asList(trainUrbanRural));
        ArrayList<String> business_train = new ArrayList<>(Arrays.asList(trainBusiness));
        ArrayList<String> entrepreneur_train = new ArrayList<>(Arrays.asList(trainEntrepreneur));

        ArrayList<String> Gender_train2 = new ArrayList<>(Arrays.asList(train2Gender));
        ArrayList<String> Parent_train2 = new ArrayList<>(Arrays.asList(train2Parent));
        ArrayList<String> parttime_train2 = new ArrayList<>(Arrays.asList(train2PartTime));
        ArrayList<String> urbanrural_train2 = new ArrayList<>(Arrays.asList(train2UrbanRural));
        ArrayList<String> business_train2 = new ArrayList<>(Arrays.asList(train2Business));
        ArrayList<String> entrepreneur_train2 = new ArrayList<>(Arrays.asList(train2Entrepreneur));


        //gets a chosen percentage of the data
        for(Object name : nums){
            Gender_train.add(gender[(int) name]);
            Parent_train.add(parent[(int) name]);
            parttime_train.add(partTime[(int) name]);
            urbanrural_train.add(urbanRural[(int) name]);
            business_train.add(business[(int) name]);

            entrepreneur_train.add(entrepreneur[(int) name]);
        }

        //adding list data to arrays
        trainGender = Gender_train.toArray(String[]::new);
        trainParent = Parent_train.toArray(String[]::new);
        trainPartTime = parttime_train.toArray(String[]::new);
        trainUrbanRural = urbanrural_train.toArray(String[]::new);
        trainBusiness = business_train.toArray(String[]::new);
        trainEntrepreneur = entrepreneur_train.toArray(String[]::new);



        //removing all elements not used in the above to be used when comparing the accuracy of the machine
        for(int x = 0;x< gender.length; x++){
            nums2.add(x);
        }

        nums2.removeAll(nums);

        for(Object name : nums2){
            Gender_train2.add(gender[(int) name]);
            Parent_train2.add(parent[(int) name]);
            parttime_train2.add(partTime[(int) name]);
            urbanrural_train2.add(urbanRural[(int) name]);
            business_train2.add(business[(int) name]);

            entrepreneur_train2.add(entrepreneur[(int) name]);
        }

        train2Gender = Gender_train2.toArray(String[]::new);
        train2Parent = Parent_train2.toArray(String[]::new);
        train2PartTime = parttime_train2.toArray(String[]::new);
        train2UrbanRural = urbanrural_train2.toArray(String[]::new);
        train2Business = business_train2.toArray(String[]::new);
        train2Entrepreneur = entrepreneur_train2.toArray(String[]::new);
    }

    //method to test the machines accuracy using the naive bayes algorithm
    public static String test(String usrGender, String usrParent, String usrparttime, String usrurbanrural, String usrbusiness) {

        //resetting the count values to allow multiple use of the machine without restarting it
        trainGenderFemale = 0;
        trainGenderMale = 0;
        trainParentYes = 0;
        trainParentNo = 0;
        trainPartTimeYes = 0;
        trainPartTimeNo = 0;
        trainUrbanRuralUrban = 0;
        trainUrbanRuralRural = 0;
        trainBusinessYes = 0;
        trainBusinessNo = 0;
        trainEntreprenuerYes = 0;
        trainEntreprenuerNo = 0;

        train2GenderFemale = 0;
        train2GenderMale = 0;
        train2ParentYes = 0;
        train2ParentNo = 0;
        train2PartTimeYes = 0;
        train2PartTimeNo = 0;
        train2UrbanRuralUrban = 0;
        train2UrbanRuralRural = 0;
        train2BusinessYes = 0;
        train2BusinessNo = 0;
        train2EntreprenuerYes = 0;
        train2EntreprenuerNo = 0;

        //prior probabilities
        float y1 = 0;
        float y2 = 0;

        //numerator values
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

        //denominator values
        float a1 = 0;
        float a2 = 0;
        float a3 = 0;
        float a4 = 0;
        float a5 = 0;

        float b1 = 0;
        float b2 = 0;
        float b3 = 0;
        float b4 = 0;
        float b5 = 0;

        float chance1 = 0;//probability at chosen percentage
        float chance2 = 0;//probability at 100% less chosen percentage

        testCount();

        y1 = trainEntreprenuerYes/(trainEntreprenuerYes+trainEntreprenuerNo);
        y2 = train2EntreprenuerYes/(train2EntreprenuerYes+train2EntreprenuerNo);


        if(Objects.equals(usrGender, "Female")){
            x1 = trainGenderFemale/trainEntreprenuerYes;
            a1 = trainGenderFemale/(trainEntreprenuerYes+trainEntreprenuerNo);
        }
        else{
            x1 = trainGenderMale/trainEntreprenuerYes;
            a1 = trainGenderMale/(trainEntreprenuerYes+trainEntreprenuerNo);
        }

        if(Objects.equals(usrParent, "Yes")){
            x2 = trainParentYes/trainEntreprenuerYes;
            a2 = trainParentYes/(trainEntreprenuerYes+trainEntreprenuerNo);
        }
        else{
            x2 = trainParentNo/trainEntreprenuerYes;
            a2 = trainParentNo/(trainEntreprenuerYes+trainEntreprenuerNo);
        }

        if(Objects.equals(usrparttime, "Yes")){
            x3 = trainPartTimeYes/trainEntreprenuerYes;
            a3 = trainPartTimeYes/(trainEntreprenuerYes+trainEntreprenuerNo);
        }
        else{
            x3 = trainPartTimeNo/trainEntreprenuerYes;
            a3 = trainPartTimeNo/(trainEntreprenuerYes+trainEntreprenuerNo);
        }

        if(Objects.equals(usrurbanrural, "Urban")){
            x4 = trainUrbanRuralUrban/trainEntreprenuerYes;
            a4 = trainUrbanRuralUrban/(trainEntreprenuerYes+trainEntreprenuerNo);
        }
        else if(Objects.equals(usrurbanrural, "Rural")){
            x4 = trainUrbanRuralRural/trainEntreprenuerYes;
            a4 = trainUrbanRuralRural/(trainEntreprenuerYes+trainEntreprenuerNo);
        }

        if(Objects.equals(usrbusiness, "Yes")){
            x5 = trainBusinessYes/trainEntreprenuerYes;
            a5 = trainBusinessYes/(trainEntreprenuerYes+trainEntreprenuerNo);
        }
        else{
            x5 = trainBusinessNo/trainEntreprenuerYes;
            a5 = trainBusinessNo/(trainEntreprenuerYes+trainEntreprenuerNo);
        }


        //getting values for 100% less specified percentage
        if(Objects.equals(usrGender, "Female")){
            z1 = train2GenderFemale/train2EntreprenuerYes;
            b1 = train2GenderFemale/(train2EntreprenuerYes+train2EntreprenuerNo);
        }
        else{
            z1 = train2GenderMale/train2EntreprenuerYes;
            b1 = train2GenderMale/(train2EntreprenuerYes+train2EntreprenuerNo);
        }

        if(Objects.equals(usrParent, "Yes")){
            z2 = train2ParentYes/train2EntreprenuerYes;
            b2 = train2ParentYes/(train2EntreprenuerYes+train2EntreprenuerNo);
        }
        else{
            z2 = train2ParentNo/train2EntreprenuerYes;
            b2 = train2ParentNo/(train2EntreprenuerYes+train2EntreprenuerNo);
        }

        if(Objects.equals(usrparttime, "Yes")){
            z3 = train2PartTimeYes/train2EntreprenuerYes;
            b3 = train2PartTimeYes/(train2EntreprenuerYes+train2EntreprenuerNo);
        }
        else{
            z3 = train2PartTimeNo/train2EntreprenuerYes;
            b3 = train2PartTimeNo/(train2EntreprenuerYes+train2EntreprenuerNo);
        }

        if(Objects.equals(usrurbanrural, "Urban")){
            z4 = train2UrbanRuralUrban/train2EntreprenuerYes;
            b4 = train2UrbanRuralUrban/(train2EntreprenuerYes+train2EntreprenuerNo);
        }
        else if(Objects.equals(usrurbanrural, "Rural")){
            z4 = train2UrbanRuralRural/train2EntreprenuerYes;
            b4 = train2UrbanRuralRural/(train2EntreprenuerYes+train2EntreprenuerNo);
        }

        if(Objects.equals(usrbusiness, "Yes")){
            z5 = train2BusinessYes/train2EntreprenuerYes;
            b5 = train2BusinessYes/(train2EntreprenuerYes+train2EntreprenuerNo);
        }
        else{
            z5 = train2BusinessNo/train2EntreprenuerYes;
            b5 = train2BusinessNo/(train2EntreprenuerYes+train2EntreprenuerNo);
        }


        float evidence1 = a1*a2*a3*a4*a5;
        float evidence2 = b1*b2*b3*b4*b5;

        chance1 = ((x1*x2*x3*x4*x5)*y1)/evidence1;
        chance2 = ((z1*z2*z3*z4*z5)*y2)/evidence2;

        float diff = chance1 - chance2;

        return ("difference is " + diff + "%");

    }

    //method for using the naive bayes algorithm to calulate the probability
    public static String run(String usrGender, String usrParent, String usrparttime, String usrurbanrural, String usrbusiness) {

        //resetting the count values to allow multiple use of the machine without restarting it
        genderFemale = 0;
        genderMale = 0;
        parentYes = 0;
        parentNo = 0;
        parttimeYes = 0;
        parttimeNo = 0;
        urbanruralUrban = 0;
        urbanruralRural = 0;
        businessYes = 0;
        businessNo = 0;
        entrepenuerYes = 0;
        entrepenuerNo = 0;

        float y = 0;//prior probabilities

        //numerator values
        float x1 = 0;
        float x2 = 0;
        float x3 = 0;
        float x4 = 0;
        float x5 = 0;

        //denominator values
        float a1 = 0;
        float a2 = 0;
        float a3 = 0;
        float a4 = 0;
        float a5 = 0;

        float chance = 0;//final probability

        count();

        y = entrepenuerYes/entrepreneur.length;

        if(Objects.equals(usrGender, "Female")){
            x1 = genderFemale/entrepenuerYes;
            a1 = genderFemale/entrepreneur.length;
        }
        else{
            x1 = genderMale/entrepenuerYes;
            a1 = genderMale/entrepreneur.length;
        }

        if(Objects.equals(usrParent, "Yes")){
            x2 = parentYes/entrepenuerYes;
            a2 = parentYes/entrepreneur.length;
        }
        else{
            x2 = parentNo/entrepenuerYes;
            a2 = parentNo/entrepreneur.length;
        }

        if(Objects.equals(usrparttime, "Yes")){
            x3 = parttimeYes/entrepenuerYes;
            a3 = parttimeYes/entrepreneur.length;
        }
        else{
            x3 = parttimeNo/entrepenuerYes;
            a3 = parttimeNo/entrepreneur.length;
        }

        if(Objects.equals(usrurbanrural, "Urban")){
            x4 = urbanruralUrban/entrepenuerYes;
            a4 = urbanruralUrban/entrepreneur.length;
        }
        else if(Objects.equals(usrurbanrural, "Rural")){
            x4 = urbanruralRural/entrepenuerYes;
            a4 = urbanruralRural/entrepreneur.length;
        }

        if(Objects.equals(usrbusiness, "Yes")){
            x5 = businessYes/entrepenuerYes;
            a5 = businessYes/entrepreneur.length;
        }
        else{
            x5 = businessNo/entrepenuerYes;
            a5 = businessNo/entrepreneur.length;
        }

        float evidence = a1*a2*a3*a4*a5;

        chance = ((x1*x2*x3*x4*x5)*y)/evidence;

        return ("chance = "+chance+"%");

    }
}
