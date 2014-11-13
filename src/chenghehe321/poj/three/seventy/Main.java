package chenghehe321.poj.three.seventy;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * Problem 3070:<br>
 * 使用二维数组【1，1，1，0】完成时间复杂度为O(logn)的Fibonacci数列第n项的计算<br>
 * <br>
 * 主要思路:<br>
 * 1，采用分治的方法将时间复杂度变为logn<br>
 * 2，在计算矩阵时，仅需要计算矩阵第一行<br>
 * <br>
 * Source:<br>
 * Stanford Local 2006
 * 
 * @author Carl
 * 
 *         2014-11-12
 */
public class Main {

	public List<Integer> testData = new ArrayList<Integer>();

	public int[][] matrix = { { 1, 1 }, { 1, 0 } };
	public int[][] unit = { { 1, 0 }, { 0, 1 } };

	public List<Integer> get() {
		Scanner cin = new Scanner(new BufferedInputStream(System.in));
		try {
			int a;
			while ((a = cin.nextInt()) != -1) {
				testData.add(a);
			}
		} finally {
			cin.close();
		}
		return testData;
	}

	private int[][] multiple(int[][] a, int[][] b) {
		int[][] result = new int[2][2];
		result[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % 10000;
		result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % 10000;
		result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % 10000;
		result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % 10000;
		return result;
	}

	public int[][] fibonacci(int n) {
		if (n <= 2) {
			return new int[][] { { n == 2 ? 1 : n, 1 }, { 1, 0 } };
		}
		return multi(matrix, n - 1);
	}

	private int[][] multi(int[][] a, int n) {
		if (n <= 1) {
			return matrix;
		}
		if ((n & 1) == 1) {
			a = multi(a, (n - 1) / 2);
			a = multiple(a, a);
			a = multiple(a, matrix);
		} else {
			a = multi(a, n / 2);
			a = multiple(a, a);
		}
		return a;
	}

	public static void main(String[] args) {
		Main m = new Main();
		List<Integer> input = m.get();
		for (int i = 0; i < input.size(); i++) {
			System.out.println(m.fibonacci(input.get(i))[0][0] % 10000);
		}
	}

}