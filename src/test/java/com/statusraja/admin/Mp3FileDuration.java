package com.statusraja.admin;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.tritonus.share.sampled.file.TAudioFileFormat;

import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;

public class Mp3FileDuration {

	public static void main(String[] args) throws Exception {
		File file = new File("D:\\test_songs\\Kalimba.mp3");
		AudioFileFormat baseFileFormat = new MpegAudioFileReader().getAudioFileFormat(file);
		Map properties = baseFileFormat.properties();
		Long duration = (Long) properties.get("duration");
		int samples = (int) (duration / 1000 / 1000) * 44100;
		System.out.println(samples);
		// getDurationsWithMp3(file);
		getDurationWithMp3Spi(file);
		testMp3();
		
		float dur=getDuration(file);
		System.out.println(dur);
	}

	private static void getDurationWithMp3Spi(File file) throws UnsupportedAudioFileException, IOException {

		AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
		if (fileFormat instanceof TAudioFileFormat) {
			Map<?, ?> properties = ((TAudioFileFormat) fileFormat).properties();
			String key = "duration";
			Long microseconds = (Long) properties.get(key);
			int mili = (int) (microseconds / 1000);
			int sec = (mili / 1000) % 60;
			int min = (mili / 1000) / 60;
			System.out.println("time = " + min + ":" + sec);
		} else {
			throw new UnsupportedAudioFileException();
		}
	}

	public static void testMp3() {
		try (BufferedInputStream in = new BufferedInputStream(new URL("http://localhost:9001/webdav/100/cradles_medium-92.mp3").openStream());
				FileOutputStream fileOutputStream = new FileOutputStream("D://test_songs//new//xyz.mp3")) {
			byte dataBuffer[] = new byte[1024];
			int bytesRead;
			while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
				fileOutputStream.write(dataBuffer, 0, bytesRead);
			}
		} catch (IOException e) {
			// handle exception
		}
	}
	
	private static float getDuration(File file) throws Exception {
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
		AudioFormat format = audioInputStream.getFormat();
		long audioFileLength = file.length();
		int frameSize = format.getFrameSize();
		float frameRate = format.getFrameRate();
		float durationInSeconds = (audioFileLength / (frameSize * frameRate));
		return (durationInSeconds);
	}

}
