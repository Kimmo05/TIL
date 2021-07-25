package algorithm_study;

import java.util.Scanner;

public class prac1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//두수 비교하기
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		if (a > b)
			System.out.println(">");
		if (a < b)
			System.out.println("<");
		if (a == b)
			System.out.println("==");
	}

}