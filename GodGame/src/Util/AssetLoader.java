package Util;
//Kelvin's AssetLoader

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

public class AssetLoader {

	////////////////////////////////////////////////////
	// Variables
	////////////////////////////////////////////////////
	/**using hashmap to implements the map for the images */
	private static Map<String, BufferedImage> images = new HashMap<String, BufferedImage>();
	/**using hashmap to implements the map for the text fonts*/
	private static Map<String, Font> fonts = new HashMap<String, Font>();
	/**implementing hashmap for clips/audio*/
	private static HashMap<String, Clip> clips = new HashMap<String, Clip>();

	// //////////////////////////////////////////////////
	// Methods
	// //////////////////////////////////////////////////
	/**
	 * public methods that allow to load the music while the game is running
	 * @param key
	 */
	public static void loadMusic(String key) {
		File folder = new File("audio//clips");
		Clip clip;
		try {
			File content = new File(folder + "//" + key + ".wav");
			AudioInputStream input = AudioSystem.getAudioInputStream(content);
			clip = AudioSystem.getClip();
			clip.open(input);
			clips.put(key, clip);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Loads a single image. Used below in the loadAllImages method.
	 * 
	 * @param imgPath the path of the image, from the image folder.
	 * @return a single image as a BufferedImage.
	 */
	private static BufferedImage loadImage(String folder, String imgPath) {
		try {
			return ImageIO.read(new File(folder + "/" + imgPath));
		} catch (IOException ex) {
			System.out.println("No such image!");
			System.out.println("\n\n");
			System.out.println(ex);

		}
		return null;
	}

	
	/**
	 * public method that allow to load the text fonts
	 * @param folder - where the fonts is stored
	 * @param fontPath - 
	 * @param fontSize - the size of the font
	 * @return
	 */
	
	public static Font loadFont(String folder, String fontPath, int fontSize) {
		try {
			return Font.createFont(Font.TRUETYPE_FONT,
					new FileInputStream(new File(folder + "/" + fontPath)))
					.deriveFont(Font.PLAIN, fontSize);
		} catch (IOException ex) {
			System.out.println("No such font!");
			System.out.println("\n\n");
			System.out.println(ex);

		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Loads all the images within the "images" folder. CRASHES if there are
	 * subfolders in there, DO NOT EDIT THAT FOLDER.
	 * 
	 * Should be called once.
	 * 
	 */
	public static void loadAllImages() {
		File folder = new File("images");
		for (File content : folder.listFiles()) {

			images.put(
					content.getName().substring(0,
							content.getName().length() - 4),
					loadImage(folder.getName(), content.getName()));
		}
	}

	public static void loadAllFonts() {
		File folder = new File("fonts");
		for (File content : folder.listFiles()) {
			fonts.put(
					content.getName().substring(0,
							content.getName().length() - 4),
					loadFont(folder.getName(), content.getName(), 12));
		}

	}

	////////////////////////////////////////////////////
	// Getters
	////////////////////////////////////////////////////

	public static Map<String, Clip> getClips() {
		return clips;
	}

	/**
	 * Needed to get access to images. If you want to access it, simply use 
	 * AssetLoader.getImages().get(key), where key is the filename (without extensions).
	 * 
	 * @return the image map.
	 */
	public static Map<String, BufferedImage> getImages() {
		return images;
	}

	public static Map<String, Font> getFonts() {
		return fonts;
	}

	public static Image resizeImages(Image aImg, int newWidth, int newHeight) {
		Image img1 = aImg.getScaledInstance(newWidth, newHeight,
				Image.SCALE_SMOOTH);
		return img1;

	}

	public static ImageIcon resizeImages(ImageIcon icon, int newWidth, int newHeight) {
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(newWidth, newHeight,  Image.SCALE_FAST);
		ImageIcon newIcon = new ImageIcon(newimg);
		
		return newIcon;

	}

}
