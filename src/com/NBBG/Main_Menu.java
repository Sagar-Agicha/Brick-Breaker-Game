package com.NBBG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class Main_Menu implements ActionListener, KeyListener {

    Frame fa;
    Button b_easy,b_med,b_hard,b4,b5,b_m,b6;
    JComboBox<String> cb1;
    Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l0,l11,l12;
    String[] number = {"None","6","10","15","25","30"};
    Label la,lb,lc,ld,le,lf,lg,lh,li,lj,lk;
    public String a;
    public int b,c,d,g;
    String filepath = "Sound/Naruto2.wav";

    public sound music = new sound();

    Main_Menu() {

        music.play_music(filepath);

        fa = new Frame();
        fa.setSize(550, 700);
        fa.setVisible(true);
        fa.setLayout(null);
        fa.setFocusable(true);
        fa.setFocusTraversalKeysEnabled(false);
        fa.setBackground(Color.cyan);
        fa.addKeyListener(this);

        l1 = new Label("Naruto Brick Breaker Game");
        l1.setLocation(80, 42);
        l1.setSize(450, 35);
        l1.setFont(new Font("Verdana", Font.PLAIN, 30));
        fa.add(l1);

        l2 = new Label("****INSTRUCTIONS****");
        l2.setLocation(180, 100);
        l2.setSize(170, 20);
        l2.setFont(new Font("Verdana", Font.PLAIN, 15));
        fa.add(l2);

        l3 = new Label("1) The Paddle Move's Horizontally and is Controlled with the keywords.");
        l3.setLocation(10, 135);
        l3.setSize(1000, 20);
        l3.setFont(new Font("Verdana", Font.PLAIN, 15));
        fa.add(l3);

        l4 = new Label("(Left Arrow and Right Arrow).");
        l4.setLocation(25, 155);
        l4.setSize(800, 20);
        l4.setFont(new Font("Verdana", Font.PLAIN, 15));
        fa.add(l4);

        l0 = new Label("2) Player Will get 2 lives to Start,");
        l0.setLocation(10, 180);
        l0.setSize(800, 20);
        l0.setFont(new Font("Verdana", Font.PLAIN, 15));
        fa.add(l0);

        l11 = new Label("A Life is LOST if the ball hits the bottom of the screen");
        l11.setLocation(26, 200);
        l11.setSize(800, 20);
        l11.setFont(new Font("Verdana", Font.PLAIN, 15));
        fa.add(l11);

        l5 = new Label("3) Press Space to START the game after selecting the level you Want.");
        l5.setLocation(10, 225);
        l5.setSize(700, 20);
        l5.setFont(new Font("Verdana", Font.PLAIN, 15));
        fa.add(l5);

        l12 = new Label("4) To Stop The Music Press 'ESCAPE' Key.");
        l12.setLocation(10, 250);
        l12.setSize(700, 20);
        l12.setFont(new Font("Verdana", Font.PLAIN, 15));
        fa.add(l12);

        l6 = new Label("****LEVELS****");
        l6.setLocation(210, 300);
        l6.setSize(150, 20);
        l6.setFont(new Font("Verdana", Font.PLAIN, 15));
        fa.add(l6);

        lk = new Label("OR");
        lk.setLocation(250, 400);
        lk.setSize(150, 30);
        lk.setFont(new Font("Verdana", Font.PLAIN, 25));
        fa.add(lk);

        lj = new Label("Select By YourSelf");
        lj.setLocation(80,440);
        lj.setSize(210, 20);
        lj.setFont(new Font("Verdana", Font.PLAIN, 25));
        fa.add(lj);

        cb1 = new JComboBox<>(number);
        cb1.setLocation(295,440);
        cb1.setSize(60,25);
        fa.add(cb1);

        b_m = new Button("GO");
        b_m.setLocation(360,440);
        b_m.setSize(60, 25);
        b_m.addActionListener(this);
        b_m.setBackground(Color.red);
        fa.add(b_m);

        l9 = new Label("****Created BY****");
        l9.setLocation(175, 500);
        l9.setSize(170, 25);
        l9.setFont(new Font("Verdana", Font.PLAIN, 20));
        fa.add(l9);

        l8 = new Label("02.SAGAR AGICHA");
        l8.setLocation(175, 530);
        l8.setSize(150, 20);
        l8.setFont(new Font("Verdana", Font.PLAIN, 15));
        fa.add(l8);

        l7 = new Label("54.BHAVIN MOTWANI");
        l7.setLocation(175, 550);
        l7.setSize(165, 20);
        l7.setFont(new Font("Verdana", Font.PLAIN, 15));
        fa.add(l7);

        lc = new Label("-----------------------------------------------------------------");
        lc.setLocation(0, 27);
        lc.setSize(2200, 10);
        lc.setFont(new Font("Verdana", Font.PLAIN, 30));
        fa.add(lc);

        le = new Label("-----------------------------------------------------------------");
        le.setLocation(0, 485);
        le.setSize(2200, 10);
        le.setFont(new Font("Verdana", Font.PLAIN, 30));
        fa.add(le);

        lf = new Label("-----------------------------------------------------------------");
        lf.setLocation(0, 570);
        lf.setSize(2200, 10);
        lf.setFont(new Font("Verdana", Font.PLAIN, 30));
        fa.add(lf);

        ld = new Label("-----------------------------------------------------------------");
        ld.setLocation(0, 32);
        ld.setSize(2200, 10);
        ld.setFont(new Font("Verdana", Font.PLAIN, 30));
        fa.add(ld);

        la = new Label("-----------------------------------------------------------------");
        la.setLocation(0, 72);
        la.setSize(2200, 10);
        la.setFont(new Font("Verdana", Font.PLAIN, 30));
        fa.add(la);

        lb = new Label("-----------------------------------------------------------------");
        lb.setLocation(0, 77);
        lb.setSize(2200, 10);
        lb.setFont(new Font("Verdana", Font.PLAIN, 30));
        fa.add(lb);

        lg = new Label("-----------------------------------------------------------------");
        lg.setLocation(0, 280);
        lg.setSize(2200, 10);
        lg.setFont(new Font("Verdana", Font.PLAIN, 30));
        fa.add(lg);

        b_easy = new Button("Level 1");
        b_easy.setLocation(25, 350);
        b_easy.setSize(90, 40);
        b_easy.addActionListener(this);
        b_easy.setBackground(Color.red);
        fa.add(b_easy);

        b_med = new Button("Level 2");
        b_med.setLocation(125,350);
        b_med.setSize(90, 40);
        b_med.addActionListener(this);
        b_med.setBackground(Color.red);
        fa.add(b_med);

        b_hard = new Button("Level 3");
        b_hard.setLocation(225, 350);
        b_hard.setSize(90, 40);
        b_hard.addActionListener(this);
        b_hard.setBackground(Color.red);
        fa.add(b_hard);

        b4 = new Button("Level 4");
        b4.setLocation(325,350);
        b4.setSize(90,40);
        b4.addActionListener(this);
        b4.setBackground(Color.red);
        fa.add(b4);

        b5 = new Button("Level 5");
        b5.setLocation(425,350);
        b5.setSize(90,40);
        b5.addActionListener(this);
        b5.setBackground(Color.red);
        fa.add(b5);

        b6 = new Button("Contact Us");
        b6.setLocation(215,605);
        b6.setSize(90,40);
        b6.addActionListener(this);
        b6.setBackground(Color.red);
        fa.add(b6);

        lh = new Label("-----------------------------------------------------------------");
        lh.setLocation(0, 660);
        lh.setSize(2200, 10);
        lh.setFont(new Font("Verdana", Font.PLAIN, 30));
        fa.add(lh);

        li = new Label("-----------------------------------------------------------------");
        li.setLocation(0, 665);
        li.setSize(2200, 10);
        li.setFont(new Font("Verdana", Font.PLAIN, 30));
        fa.add(li);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b_easy) {

            Custom ca = new Custom(3,1,3,10,3, 0,1,"Image/bg.jpg","1","Sound/Fairy.wav");
            JFrame ff = new JFrame();
            ff.setSize(550,700);
            ff.setVisible(true);
            ff.add(ca);
            music.clip.stop();
        }

        if (e.getSource() == b_med) {

            Custom ca = new Custom(2,3,6,8,6,1,1,"Image/bg3.jpg","2","Sound/Naruto1.wav");
            JFrame ff = new JFrame();
            ff.setSize(550,700);
            ff.setVisible(true);
            ff.add(ca);
            music.clip.stop();
        }

        if (e.getSource() == b_hard) {

            Custom ca = new Custom(4,4,16,6,12,2,1,"Image/bg1.png","3","Sound/Naruto2.wav");
            JFrame ff = new JFrame();
            ff.setSize(550,700);
            ff.setVisible(true);
            ff.add(ca);
            music.clip.stop();
        }

        if (e.getSource() == b4) {

            Custom ca = new Custom(4,6,26,4,26,3,1,"Image/bg.jpg","4","Sound/Naruto2.wav");
            JFrame ff = new JFrame();
            ff.setSize(550,700);
            ff.setVisible(true);
            ff.add(ca);
            music.clip.stop();
        }

        if (e.getSource() == b5) {

            Custom ca = new Custom(5,7,35,2,35,4,1,"Image/bg1.png","5","Sound/Naruto2.wav");
            JFrame ff = new JFrame();
            ff.setSize(550,700);
            ff.setVisible(true);
            ff.add(ca);
            music.clip.stop();
        }

        if (e.getSource() == b6){
            new contact_us();
        }

        if (e.getSource() == b_m) {

            a = (String) cb1.getSelectedItem();
            if (Objects.equals(a,"6")){
                System.out.println("hi");
                b = 6;
                c = 2;
                d = 3;
                g = 6;

            } else if (Objects.equals(a, "10")) {
                System.out.println("hi1");
                b = 10;
                c = 2;
                d = 5;
                g = 10;

            } else if (Objects.equals(a, "15")) {
                System.out.println("hi2");
                b = 15;
                c = 3;
                d = 5;
                g = 15;

            } else if (Objects.equals(a, "25")) {
                System.out.println("hi3");
                b = 25;
                c = 5;
                d = 5;
                g = 25;

            } else if (Objects.equals(a, "30")) {
                System.out.println("hi4");
                b = 30;
                c = 5;
                d = 6;
                g = 30;
            }

            Custom ca = new Custom(c,d,g,7,d,5,2,"Image/bg3.jpg","Custom","Sound/Naruto2.wav");
            JFrame ff = new JFrame();
            ff.setSize(550,700);
            ff.setVisible(true);
            ff.add(ca);
            music.clip.stop();
        }
    }

    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            music.clip.stop();
        }
    }
    public void keyReleased(KeyEvent e) {}
}