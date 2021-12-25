package tetris;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class ImageLoader {
	public static BufferedImage loadImage(String path){
		try {
			return ImageIO.read(ImageLoader.class.getClassLoader().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
		
	}
	
	/*
	public static Clip LoadSound(String direction){
		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(ImageLoader.class.getResource(direction)));
			return clip;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	*/
	
	public static Clip LoadSound(String direction) {
		try {
	        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(ImageLoader.class.getClassLoader().getResource(direction).getPath()));
	        DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
	        Clip clip = (Clip)AudioSystem.getLine(info);
	        clip.open(inputStream);
			return clip;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
