package ktp_lab4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public final class FractalExplorer extends JFrame {
	
	private static final int WHITE = 16777215;
	
	private JImageDisplay image;
	private int isize;
	private FractalGenerator fbase;
	private Rectangle2D.Double display;
	
	public FractalExplorer(int size) {
		isize = size;
		fbase = new Mandelbrot();
		display = new Rectangle2D.Double();
		fbase.getInitialRange(display);
	}
	
	public FractalExplorer() {
		this(JImageDisplay.DEFAULT_SIZE);
	}
	
	public void createAndShowGui() {
		GuiListener listener = new GuiListener();
		image = new JImageDisplay(isize, isize);
		image.addMouseListener(new ImageListener());
		JButton button = new JButton("—бросить");
		button.addActionListener(listener);
		this.add(button, BorderLayout.SOUTH);
		this.add(image, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		drawFractal();
	}
	
	private int getColor(int iter) {
		int mxiter = fbase.getMaxIterations();
		int k = WHITE/mxiter;
		return WHITE*(iter + 1)*k;
	}
	
	private void drawFractal() {
		double fx, fy;
		int iter;
		for (int x = 0; x < isize; x++) {
			for (int y = 0; y < isize; y++) {
				fx = FractalGenerator.getCoord(display.x, display.x + display.width, isize, x);
				fy = FractalGenerator.getCoord(display.y, display.y + display.height, isize, y);
				iter = fbase.numIterations(fx, fy);
				image.drawPixel(x, y, getColor(iter));
			}
		}
		image.repaint();
	}

	private class GuiListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			fbase.getInitialRange(display);
			drawFractal();
		}
		
	}
	
	private class ImageListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			double x = FractalGenerator.getCoord(display.x, display.x + display.width, isize, e.getX());
			double y = FractalGenerator.getCoord(display.y, display.y + display.height, isize, e.getY());
			fbase.recenterAndZoomRange(display, x, y, 0.5);
			drawFractal();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
