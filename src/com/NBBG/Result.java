package com.NBBG;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Result {

    Frame fa;
    TextArea ta;
    String ss;
    Label l1;

    Result() {

        fa = new Frame("RESULT");
        fa.setLayout(null);
        fa.setVisible(true);
        fa.setBackground(Color.GREEN);
        fa.setSize(250, 250);

        l1 = new Label("Result");
        l1.setBounds(70, 45, 100, 35);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Verdana", Font.BOLD, 30));
        fa.add(l1);

        ta = new TextArea();
        ta.setBounds(20, 130, 210, 100);
        fa.add(ta);

        File file = new File("Data/Java.txt");
        try {
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                ss = input.nextLine();
                ta.append(ss);
                ta.append("\n");
            }
        } catch (FileNotFoundException fx) {
            System.out.println("FileNotFoundException");
        }

    }
}
