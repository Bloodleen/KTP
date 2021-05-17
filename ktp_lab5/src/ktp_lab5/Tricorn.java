package ktp_lab5;

import java.awt.geom.Rectangle2D.Double;

public final class Tricorn extends FractalGenerator {
	
	public static final int MAX_ITER = 2000;

	public Tricorn() {
		super(MAX_ITER);
	}

	@Override
	public void getInitialRange(Double range) {
		range.x = -2;
		range.y = -2;
		range.width = 4;
		range.height = 4;
	}

	@Override
	public int numIterations(double x, double y) {
		Complex z = new Complex();
		Complex c = new Complex(x, y);
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			z = z.conjugate();
			z = z.mul(z).add(c);
			if (z.absSqr() > 4) { return i; }
		}
		return -1;
	}
	
	@Override
	public String toString() {
		return "Трикорн";
	}

}
