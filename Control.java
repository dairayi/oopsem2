package assignment1;

import java.io.FileNotFoundException;

public class Control {
    public static void main(String[] args) throws FileNotFoundException {

        Class1 r = new Class1("MLdata.csv");
        System.out.println(r.calc_probs());

        //r.addnewdata();
        
    }
}
