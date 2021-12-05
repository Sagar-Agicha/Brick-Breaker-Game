package com.NBBG;

import java.awt.*;

public class contact_us {

Frame fa;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9;

contact_us(){

    fa = new Frame("Contact Us");
    fa.setLayout(null);
    fa.setVisible(true);
    fa.setSize(250,300);
    fa.setBackground(Color.GREEN);

    l6 = new Label("***CONTACT US***");
    l6.setBounds(35,42,1000,25);
    l6.setFont(new Font("Verdana", Font.PLAIN,20));
    fa.add(l6);

    l8 = new Label("***THANK YOU***");
    l8.setBounds(40,255,1000,25);
    l8.setFont(new Font("Verdana", Font.PLAIN,20));
    fa.add(l8);

    l5 = new Label("-----------------------------------------------------------------");
    l5.setBounds(0,65,1000,15);
    l5.setFont(new Font("Verdana", Font.PLAIN, 30));
    fa.add(l5);

    l1 = new Label("EMAIL US");
    l1.setBounds(85,95,75,20);
    l1.setFont(new Font("gill",Font.ITALIC,15));
    fa.add(l1);

    l9 = new Label("NarutoBBG@gmail.com");
    l9.setBounds(40,120,1000,20);
    l9.setFont(new Font("Verdana", Font.PLAIN, 15));
    fa.add(l9);

    l2 = new Label("CALL US");
    l2.setBounds(85,160,75,20);
    l2.setFont(new Font("gill",Font.ITALIC,15));
    fa.add(l2);

    l3 = new Label("1) 7977587352");
    l3.setBounds(70,190,120,20);
    l3.setFont(new Font("gill", Font.PLAIN,15));
    fa.add(l3);


    l4 = new Label("2) 9867345675");
    l4.setBounds(70,210,120,20);
    l4.setFont(new Font("gill",Font.PLAIN,15));
    fa.add(l4);

    l7 = new Label("-----------------------------------------------------------------");
    l7.setBounds(0,235,1000,15);
    l7.setFont(new Font("Verdana", Font.PLAIN, 30));
    fa.add(l7);

}
}
