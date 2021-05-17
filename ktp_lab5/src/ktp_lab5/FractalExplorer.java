package ktp_lab5;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public final class FractalExplorer extends JFrame {
	
	private static final int WHITE = 16777215;
	
	private JImageDisplay image;
	private JComboBox fbox;
	private int isize;
	private FractalGenerator fbase;
	private Rectangle2D.Double display;
	
	public FractalExplorer(int size) {
		isize = size;
		display = new Rectangle2D.Double();
	}
	
	public FractalExplorer() {
		this(JImageDisplay.DEFAULT_SIZE);
	}
	
	public void createAndShowGui() {
		this.setTitle("Fractal Explorer");;
		GuiListener listener = new GuiListener();
		image = new JImageDisplay(isize, isize);
		image.addMouseListener(new ImageListener());
		JButton reset = new JButton("Сбросить");
		reset.setName("reset");
		JButton save = new JButton("Сохранить");
		save.setName("save");
		fbox = new JComboBox();
		fbox.addItem(new Mandelbrot());
		fbox.addItem(new Tricorn());
		fbox.addItem(new BurningShip());
		JPanel paneln = new JPanel();
		paneln.add(new JLabel("Фрактал:"));
		paneln.add(fbox);
		JPanel panels = new JPanel();
		panels.add(save);
		panels.add(reset);
		fbase = (FractalGenerator)fbox.getItemAt(0);
		fbase.getInitialRange(display);
		reset.addActionListener(listener);
		save.addActionListener(listener);
		fbox.addActionListener(listener);
		this.add(paneln, BorderLayout.NORTH);
		this.add(panels, BorderLayout.SOUTH);
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
			Object caller = e.getSource();
			if (caller.getClass() == JButton.class) {
				JButton button = (JButton)caller;
				if (button.getName() == "reset") {
					fbase.getInitialRange(display);
					drawFractal();
				}
				if (button.getName() == "save") {
					JFileChooser chooser = new JFileChooser();
					FileFilter pngfilter = new FileNameExtensionFilter("PNG Images", "png");
					chooser.setFileFilter(pngfilter);
					chooser.setAcceptAllFileFilterUsed(false);
					int result = chooser.showSaveDialog(image);
					if (result == JFileChooser.APPROVE_OPTION) {
						try {
							ImageIO.write(image.getImage(), "png", chooser.getSelectedFile());
							
						} catch (IOException ex) {
							JOptionPane.showMessageDialog(chooser, ex.getLocalizedMessage(), "Save error", JOptionPane.ERROR_MESSAGE);
							ex.printStackTrace();
						}
					}
				}
			}
			if (caller.getClass() == JComboBox.class) {
				fbase = (FractalGenerator)fbox.getSelectedItem();
				fbase.getInitialRange(display);
				drawFractal();
			}
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
