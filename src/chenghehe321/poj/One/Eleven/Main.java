package chenghehe321.poj.One.Eleven;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * 网上1011的代码，从此认识到Scanner和InputStreamReader对于ACM输入的区别！！！！！！
 * 
 * @author Not Carl
 * 
 *         2014-11-23
 */
public class Main {

	static boolean[] used;
	static int len;
	static int[] s;
	static int sum;
	static int max;
	static int parts;

	public static void main(String[] args) throws Exception {
		long a = System.currentTimeMillis();
		s = new int[] { 40, 40, 30, 35, 35, 26, 15, 40, 40, 40, 40, 40, 40, 40,
				40, 40, 40, 40, 40, 40, 40, 40, 40, 43, 42, 42, 41, 10, 4, 40,
				40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 25, 39, 46,
				40, 10, 4, 40, 40, 37, 18, 17, 16, 15, 40, 40, 40, 40, 40, 40,
				40, 40 };
		sum = 0;
		len = s.length;
		used = new boolean[len];
		for (int i = 0; i < len; i++) {
			sum += s[i];
		}
		Arrays.sort(s);
		max = s[len - 1];
		for (; max <= sum; max++) {
			if (sum % max == 0) {
				parts = sum / max;
				if (search(0, len - 1, 0)) {
					System.out.println(max);
					break;
				}
			}
		}
		long b = System.currentTimeMillis();
		System.out.println((b - a) + "ms");
	}

	public static boolean search(int res, int next, int cpl) {
		if (res == max) {
			res = 0;
			next = len - 2;
			cpl++;
		}
		if (cpl == parts) {
			return true;
		}
		while (next >= 0) {
			if (used[next] == false) {
				if (res + s[next] <= max) {
					used[next] = true;
					if (search(res + s[next], next - 1, cpl)) {
						return true;
					}
					used[next] = false;
					if (res == 0) {
						break;
					}
					if (res + s[next] == max) {
						break;
					}
				}
				int i = next - 1;
				while (i >= 0 && s[i] == s[next]) {
					i--;
				}
				next = i;
				int l_s = 0;
				for (int j = next; j >= 0; j--) {
					if (!used[j]) {
						l_s += s[j];
					}
				}
				if (l_s < max - res) {
					break;
				}
				continue;
			}
			next--;
		}
		return false;
	}
}