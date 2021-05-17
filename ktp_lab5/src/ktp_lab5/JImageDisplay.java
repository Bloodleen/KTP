package ktp_lab5;

import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Graphics;

public class JImageDisplay extends JComponent {
	
	public static final int DEFAULT_SIZE = 750;
	
	private static final long serialVersionUID = -4840077681692108149L;
	private BufferedImage img;
	private int width, height;

	public JImageDisplay(int w, int h) {
		img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		super.setPreferredSize(new Dimension(w, h));
		width = w;
		height = h;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, width, height, null);
	}
	
	public BufferedImage getImage() {
		return img;
	}
	
	public void clearImage() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				img.setRGB(i, j, 0);
			}
		}
	}
	
	public void drawPixel(int x, int y, int rgb) {
		img.setRGB(x, y, rgb);
	}
}
