package ktp_lab4;

import java.awt.geom.Rectangle2D.Double;

public final class Mandelbrot extends FractalGenerator {
	
	public static final int MAND_ITER = 2000;
	
	public Mandelbrot() {
		super(MAND_ITER);
	}

	@Override
	public void getInitialRange(Double range) {
		range.x = -2;
		range.y = -1.5;
		range.height = 3;
		range.width = 3;
	}

	@Override
	public int numIterations(double x, double y) {
		Complex z = new Complex();
		Complex c = new Complex(x, y);
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			z = z.mul(z).add(c);
			if (z.absSqr() > 4) { return i; }
		}
		return -1;
	}

}
