package ktp_lab2;

public class Point3d extends Point2d {
	
	double zCoord;
	
	public Point3d(double x, double y, double z) {
		zCoord = z;
	}
	
	public Point3d() {
		this(0.0, 0.0, 0.0);
	}
	
	public void setZ(double z) {
		zCoord = z;
	}
	
	public double getZ() {
		return zCoord;
	}
	
	public boolean equals(Point3d point) {
		return (this.xCoord == point.xCoord && this.yCoord == point.yCoord && this.zCoord == point.zCoord);
	}
	
	public double distanceTo(Point3d point) {
		double t = Math.sqrt((point.xCoord - this.xCoord)*(point.xCoord - this.xCoord) + (point.yCoord - this.yCoord)*(point.yCoord - this.yCoord) + (point.zCoord - this.zCoord)*(point.zCoord - this.zCoord));
		return Math.floor(t*100)/100;
	}
}
