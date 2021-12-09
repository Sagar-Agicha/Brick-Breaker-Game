package com.NBBG;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Result {

    Frame fa;
    TextArea ta;
    String ss;

    Result() throws IOException {

        fa = new Frame("RESULT");
        fa.setLayout(null);
        fa.setVisible(true);
        fa.setSize(250, 250);

        ta = new TextArea();
        ta.setBounds(20, 40,150,200);
        fa.add(ta);

        File file = new File("Data/Java.txt");
        try{
            Scanner input = new Scanner(file);
            while(input.hasNext()){
                ss = input.nextLine();
                ta.append(ss);
                ta.append("\n");
                System.out.println(ss);
            }
        }catch (FileNotFoundException fx){
            System.out.println("FileNotFoundException");
        }


    }
}
