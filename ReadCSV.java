package assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReadCSV {

    public String filename;
    public String[] newdata = {};
    public String[] newnewdata = {};
    public int x=0;
    public int y;

    ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(newdata));

    public ReadCSV(String filename){

        this.filename=filename;
        String[] strArray = null;

        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();

                arrayList.add(data);
                newdata = arrayList.toArray(newdata);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //System.out.println(Arrays.toString(newdata));

        strArray = (Arrays.toString(newdata)).split(",");

        //y = (Arrays.toString(newdata)).length();

        for (String s : strArray) {
            //System.out.println(s);

            newnewdata[x] = s;
            x=x+1;
        }

}

    public void addnewdata(){

        while(x > y){



            y=y+1;
        }
    }

}


