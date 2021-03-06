package ktp_lab2;

public class Lab2 {

	public static void main(String[] args) {
		Point3d[] points = new Point3d[3];
		for (int i = 0; i<3; i++) {
			points[i] = new Point3d(Double.parseDouble(args[i*3]), Double.parseDouble(args[i*3 + 1]), Double.parseDouble(args[i*3 + 2]));
		}
		if (points[0].equals(points[1])||(points[1].equals(points[2])||points[0].equals(points[2]))) {
			System.out.println("Присутствуют одинаковые точки");
			return;
		}
		System.out.println(computeArea(points[0], points[1], points[2]));
	}
	
	public static double computeArea(Point3d p1, Point3d p2, Point3d p3) {
		double a = p1.distanceTo(p2);
		double b = p2.distanceTo(p3);
		double c = p1.distanceTo(p3);
		double p = (a + b + c)/2.0;
		return Math.sqrt(p*(p - a)*(p - b)*(p - c));
	}
}
