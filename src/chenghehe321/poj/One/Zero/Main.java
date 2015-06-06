package chenghehe321.poj.One.Zero;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * POJ Java Test Problem
 * 
 * @author Carl
 * 
 *         2014-11-4
 */
public class Main {

	public static void main(String[] args) {
		Scanner cin = new Scanner(new BufferedInputStream(System.in));
		try {
			int a = cin.nextInt(), b = cin.nextInt();
			System.out.println(a + b);
		} finally {
			cin.close();
		}
	}

}
