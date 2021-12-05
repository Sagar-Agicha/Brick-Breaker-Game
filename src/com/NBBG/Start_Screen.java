package com.NBBG;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class Start_Screen extends JPanel implements ActionListener, KeyListener {

    public Clip clip;
    String filepath = "Sound/Naruto.wav";
    JLabel bg;

    public Start_Screen() {

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        bg = new JLabel(new ImageIcon("Image/intro.jpg"));
        add(bg);

        try {
            File music_path = new File(filepath);

            if (music_path.exists()) {
                AudioInputStream audio_input = AudioSystem.getAudioInputStream(music_path);
                clip = AudioSystem.getClip();
                clip.open(audio_input);
                clip.start();
            } else {
                System.out.println("Cant find file");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e){}
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
    public void keyPressed(KeyEvent e){

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            clip.stop();
            new Main_Menu();
        }
    }
}