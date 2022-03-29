package assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileReaders {
    String filename1;
    String filename2;
    File myFile1;
    File myFile2;
    String line[];
    String lin2[];

    public void openFile(String filename1, String filename2) {
        this.filename1=filename1;
        myFile1 = new File(filename1);
        this.filename2=filename2;
        myFile2 = new File(filename2);
    }

    


    public void readLine()
    {
        char[] array = new char[100];


        try {
            // Creates a FileReader
            FileReader file = new FileReader(myFile1);
      
            // Creates a BufferedReader
            BufferedReader input = new BufferedReader(file);
      
            // Reads characters
            input.read(array);
            System.out.println("Data in the file: ");
            System.out.println(array);
      
            // Closes the reader
            input.close();
          }
      
          catch(Exception e) {
            e.getStackTrace();
          }

        try
        {
            Scanner myScanner = new Scanner(myFile2);
            while (myScanner.hasNextLine())
            {
                String line2 = myScanner.nextLine();
                System.out.println(line2);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("error caught "+ e.getMessage());
        }
    }
    

}