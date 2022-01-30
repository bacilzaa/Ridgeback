package game.io;

import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	Clip clip;
	URL soundURL[] = new URL[30];

	public Sound() {

		soundURL[0] = getClass().getResource("/sound/Bark.wav");
		soundURL[1] = getClass().getResource("/sound/bgs.wav");
		soundURL[2] = getClass().getResource("/sound/sinkinwater.wav");
		soundURL[3] = getClass().getResource("/sound/heal.wav");
		soundURL[4] = getClass().getResource("/sound/gameover.wav");

	}

	public void setUp(Integer number) {
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(this.soundURL[number]));
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

	}

	public void play() {
		clip.start();
	}

	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stop() {
		clip.stop();
	}

}
