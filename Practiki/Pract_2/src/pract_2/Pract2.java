package pract_2;

public class Pract2 {

	public static void main(String[] args) {
		System.out.println(oppositeHouse(1,3));
		System.out.println(oppositeHouse(2,3));
		System.out.println(oppositeHouse(3,5));
		System.out.println(oppositeHouse(5,46));
	}
	
	public static int oppositeHouse(int i, int n) {
		int x = (i/2)+(i%2);
		int y = n - x + 1;
		return 2*y-((i+1)%2);
	}

}
