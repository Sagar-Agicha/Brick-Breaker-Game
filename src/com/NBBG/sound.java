package com.NBBG;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class sound {

    public Clip clip;

    void play_music(String musicLocation){

        try{
            File music_path = new File(musicLocation);

            if(music_path.exists()){
                AudioInputStream audio_input = AudioSystem.getAudioInputStream(music_path);
                clip = AudioSystem.getClip();
                clip.open(audio_input);
                clip.start();
            }
            else{
                System.out.println("Cant find file");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
