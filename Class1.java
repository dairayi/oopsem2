package assignment1;

import java.io.*;
import java.util.Objects;

public class Class1 {
    public String filename;
    public float a1 = 0;//gender//female
    public float a2 = 0;//gender//male
    public float gender_total;
    public float a3 = 0;//parent business//yes
    public float a4 = 0;//parent business//no
    public float parent_total;
    public float a5 = 0;//part-time job//yes
    public float a6 = 0;//part-time job//no
    public float parttime_total;
    public float a7 = 0;//urban
    public float a8 = 0;//rural
    public float urbanrural_total;
    public float a9 = 0;//studies business//yes
    public float a10 =0;//studies business//no
    public float business_total;
    public float a11 =0;//become an entrepreneur//yes
    public float a12 =0;//become an entrepreneur//no
    public float entrepreneur_total;

    public Class1(String filename) throws FileNotFoundException {
        this.filename=filename;

        int y = 0;

        String line;

        //parsing a CSV file into Scanner class constructor

        String delimiter = ",";

            try {
                File file = new File(filename);
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                //String line = "";
                String[] tempArr;
                while((line = br.readLine()) != null) {
                    tempArr = line.split(delimiter);
                    for(String tempStr : tempArr) {
                        //System.out.print(tempStr + " ");

                        //gender
                        if(Objects.equals(tempStr, "Female")||Objects.equals(tempStr, "Male") && y==0){

                            if(Objects.equals(tempStr, "Female")){
                                a1=a1+1;
                            }
                            else {
                                a2=a2+1;
                            }
                            y=y+1;
                        }
                        else if(y==1) {

                            if(Objects.equals(tempStr, "Yes")){
                                a3=a3+1;
                            }
                            else {
                                a4=a4+1;
                            }
                            y=y+1;
                        }
                        else if(y==2){
                            if(Objects.equals(tempStr, "Yes")){
                                a5=a5+1;
                            }
                            else {
                                a6=a6+1;
                            }
                            y=y+1;
                        }
                        //urban or rural
                        else if(y==3){

                            if(Objects.equals(tempStr, "Rural")){
                                a7=a7+1;
                            }
                            else {
                                a8=a8+1;
                            }

                            y=y+1;
                        }
                        //studies business
                        else if(y==4){
                            if(Objects.equals(tempStr, "Yes")){
                                a9=a9+1;
                            }
                            else {
                                a10=a10+1;
                            }
                            y=y+1;
                        }
                        else if(y==5){
                            if(Objects.equals(tempStr, "Yes")){
                                a11=a11+1;
                            }
                            else {
                                a12=a12+1;
                            }
                            y=0;
                        }
                    }
                    //System.out.println();
                }
                br.close();
            } catch(IOException ioe) {
                ioe.printStackTrace();
            }

        System.out.println("gender\nfemale = "+a1+"\nmale = " +a2);
            gender_total=a1+a2;
        System.out.println("parent owned business\nyes = "+a3+"\nno = " +a4);
            parent_total=a3+a4;
        System.out.println("part-time job\nyes = "+a5+"\nno = " +a6);
            parttime_total=a5+a6;
        System.out.println("living\nrural = "+a7+"\nurban = " +a8);
            urbanrural_total=a7+a8;
        System.out.println("studies business\nyes = "+a9+"\nno = " +a10);
            business_total=a9+a10;
        System.out.println("entrepreneur\nyes = "+a11+"\nno = " +a12);
            entrepreneur_total=a11+a12;
    }


    public void calc_probs(){
        float p_gender_f;//female probability
        float p_gender_m;//male probability
        //prior probabilities
        //gender
        //female
        p_gender_f = a1/gender_total;
        //male
        p_gender_m = a2/gender_total;

        float p_parent;//parent owned a business
        p_parent=a3/parent_total;

        float p_parttime;//student had a part time job probability
        p_parttime=a5/parttime_total;

        float p_urban;//urban living probability
        float p_rural;//rural living probability
        //urban
        p_urban=a8/urbanrural_total;
        //rural
        p_rural=a7/urbanrural_total;

        float p_business;//studies business
        p_business=a9/business_total;

        float p_entrepreneur;//
        p_entrepreneur=a11/entrepreneur_total;

    }

}
