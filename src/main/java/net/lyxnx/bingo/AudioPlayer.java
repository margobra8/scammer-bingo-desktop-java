package net.lyxnx.bingo;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class AudioPlayer implements LineListener {

    private boolean completed;

    @Override
    public void update(LineEvent event) {
        if(event.getType() == LineEvent.Type.STOP) {
            completed = true;
        }
    }

    void play(URL url) {
        try(
                AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                Clip clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, ais.getFormat()))
        ) {
            clip.addLineListener(this);

            clip.open(ais);
            clip.start();

            while (!completed) {
                Thread.sleep(1000);
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}