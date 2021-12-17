package com.NBBG;
import javax.swing.*;
public class Main {

    public static void main(String[] args) {

        Start_Screen ss = new Start_Screen();
        JFrame ff = new JFrame("Press Enter To Start");
        ff.setSize(550,700);
        ff.setVisible(true);
        ff.add(ss);
    }
}