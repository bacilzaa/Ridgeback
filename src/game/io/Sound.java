package game.io;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import game.Main;

public class Sound {

	Clip clip;

	public void setUp(String path) {
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Main.class.getResource(path + ".wav")));
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

	public void backgroundMusic(String path) {

		setUp(path);

		if (clip != null) {
			play();
			loop();
		}

	}

	public void effect(String path) {
		setUp(path);

		if (clip != null) {
			play();
		}
	}

}
