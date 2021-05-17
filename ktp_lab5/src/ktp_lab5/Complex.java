package ktp_lab5;

public class Complex {
	
	protected double real;
	protected double complex;
	
	public Complex(double real, double complex) {
		this.real = real;
		this.complex = complex;
	}
	
	public Complex() {
		this(0, 0);
	}
	
	public double getReal() {
		return real;
	}
	
	public void setReal(double real) {
		this.real = real;
	}
	
	public double getComplex() {
		return complex;
	}
	
	public void setComplex(double complex) {
		this.complex = complex;
	}
	
	public Complex add(Complex c) {
		return new Complex(this.real + c.real, this.complex + c.complex);
	}
	
	public Complex sub(Complex c) {
		return new Complex(this.real - c.real, this.complex - c.complex);
	}
	
	public Complex mul(Complex c) {
		return new Complex(this.real*c.real - this.complex*c.complex, this.real*c.complex + this.complex*c.real);
	}
	
	public Complex mul(double c) {
		return new Complex(this.real*c, this.complex*c);
	}
	
	public Complex conjugate() {
		return new Complex(this.real, -this.complex);
	}
	
	public double absSqr() {
		return this.real*this.real + this.complex*this.complex;
	}
	
	public double abs() {
		return Math.sqrt(this.absSqr());
	}
	
	public Complex reciprocal() {
		return this.conjugate().mul(1/this.absSqr());
	}
	
	public Complex div(Complex c) {
		return this.mul(c.reciprocal());
	}
}
