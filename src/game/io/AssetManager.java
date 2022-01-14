package game.io;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import game.Main;
import game.entity.Player;

public class AssetManager {
	
	public static ArrayList<BufferedImage> setSpriteSheet(String path, int tilesize) {

		ArrayList<BufferedImage> spriteSheet = new ArrayList<BufferedImage>();

		try {

			BufferedImage image = ImageIO.read(Main.class.getResourceAsStream(path + ".png"));

			int col = 0;
			int row = 0;

			int x = 0;
			int y = 0;

			int maxCol = image.getHeight() / tilesize;
			int maxRow = image.getWidth() / tilesize;

			while (col < maxCol && row < maxRow) {
				spriteSheet.add(image.getSubimage(x, y, tilesize, tilesize));

				col++;
				x += tilesize;

				if (col == maxCol) {
					col = 0;
					x = 0;
					row++;
					y += tilesize;
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return spriteSheet;

	}
	
	public static BufferedImage setImage(String path) {

		BufferedImage image = null;

		try {

			image = ImageIO.read(Main.class.getResourceAsStream(path + ".png"));

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return image;

	}

}
