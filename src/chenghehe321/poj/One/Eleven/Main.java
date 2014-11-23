package chenghehe321.poj.One.Eleven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Carl
 * 
 *         2014-11-17
 */
public class Main {
	List<Sticks> testData = new ArrayList<Sticks>();
	List<Integer> expectedResult = new ArrayList<Integer>();

	public static int count = 0;

	/**
	 * Scanner�����ˣ���������������������������������������
	 */
	public void get() throws NumberFormatException, IOException {
		int a;
		BufferedReader read = new BufferedReader(new InputStreamReader(
				System.in));
		while ((a = Integer.parseInt(read.readLine())) != 0) {
			int[] lens = new int[a];
			StringTokenizer take = new StringTokenizer(read.readLine());
			int index = 0, sum = 0;
			while (take.hasMoreTokens()) {
				lens[index] = Integer.parseInt(take.nextToken());
				sum += lens[index++];
			}
			testData.add(new Sticks(a, lens, sum));
		}
		// testData();
		// specialData();
	}

	void specialData() {
		testData.add(new Sticks(64, new int[] { 40, 40, 30, 35, 35, 26, 15, 40,
				40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 43,
				42, 42, 41, 10, 4, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40,
				40, 40, 40, 25, 39, 46, 40, 10, 4, 40, 40, 37, 18, 17, 16, 15,
				40, 40, 40, 40, 40, 40, 40, 40 }, 2270));
		expectedResult.add(454);
	}

	void testData() {
		testData.add(new Sticks(9, new int[] { 15, 3, 2, 11, 4, 1, 8, 8, 8 },
				60));
		expectedResult.add(20);

		testData.add(new Sticks(6, new int[] { 6, 2, 2, 4, 8, 8 }, 30));
		expectedResult.add(10);

		testData.add(new Sticks(5, new int[] { 1, 1, 1, 1, 1 }, 5));
		expectedResult.add(1);

		testData.add(new Sticks(2, new int[] { 1, 1 }, 2));
		expectedResult.add(1);

		testData.add(new Sticks(4, new int[] { 2, 2, 9, 9 }, 22));
		expectedResult.add(11);

		testData.add(new Sticks(3, new int[] { 1, 2, 3 }, 6));
		expectedResult.add(3);

		testData.add(new Sticks(7, new int[] { 49, 48, 47, 46, 45, 44, 43 },
				322));
		expectedResult.add(322);

		testData.add(new Sticks(7, new int[] { 3, 4, 5, 5, 5, 5, 13 }, 40));
		expectedResult.add(20);

		testData.add(new Sticks(7, new int[] { 2, 7, 7, 7, 7, 10, 20 }, 60));
		expectedResult.add(30);

		testData.add(new Sticks(6, new int[] { 1, 2, 3, 11, 11, 20 }, 48));
		expectedResult.add(24);

		testData.add(new Sticks(7, new int[] { 63, 2, 44, 12, 60, 35, 60 }, 276));
		expectedResult.add(276);

		testData.add(new Sticks(9, new int[] { 5, 2, 1, 5, 2, 1, 5, 2, 1 }, 24));
		expectedResult.add(6);

		testData.add(new Sticks(4, new int[] { 1, 2, 3, 4 }, 10));
		expectedResult.add(5);

		testData.add(new Sticks(45, new int[] { 15, 3, 2, 4, 11, 1, 8, 8, 8,
				15, 3, 2, 4, 11, 1, 8, 8, 8, 15, 3, 2, 4, 11, 1, 8, 8, 8, 15,
				3, 2, 4, 11, 1, 8, 8, 8, 15, 3, 2, 4, 11, 1, 8, 8, 8 }, 300));
		expectedResult.add(20);

		testData.add(new Sticks(64, new int[] { 40, 40, 40, 40, 40, 40, 40, 40,
				40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 43,
				42, 42, 41, 10, 4, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40,
				40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40,
				40, 40, 40, 40, 40, 40, 40, 40 }, 2502));
		expectedResult.add(1251);

		testData.add(new Sticks(64, new int[] { 32, 32, 32, 32, 32, 32, 32, 32,
				32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
				32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
				32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
				32, 32, 32, 32, 33, 33, 31, 31 }, 2048));
		expectedResult.add(64);
	}

	public int search(Sticks stick) {
		int[] lens = sort(stick.lens);// ��֦1���Ӵ�С���򣬿��Ծ����ڽӽ����ĵط����ֲ�����
		int num = stick.num, sum = stick.sum;
		System.out.println("����" + num + "��ľ����ȫ���ܳ�Ϊ" + sum);
		List<Integer> candidates = new LinkedList<Integer>();
		int index = 1, end = (int) (Math.sqrt(sum) + 1), left = 0;
		while (index < end) {
			int other = (int) sum / index;
			if (sum % index == 0) {
				candidates.add(left++, other);
				candidates.add(left, index);
			}
			index++;
		}
		for (int i = 0; i < candidates.size(); i++) {
			int groups = candidates.get(i);
			int average = (int) sum / groups;
			if (groups > num || average < lens[0]) {// ��֦2��������������ľ��������ȥ��ÿ���ܺ�С���ľ����ȥ
				continue;
			}
			if (groups == 1) {
				return average;
			}
			System.out.println("����" + groups + "�����飬ÿ���ܺ�Ϊ" + average);
			boolean cal = sum(stick, 0, average, average, true);
			if (cal) {
				return average;
			}
		}
		return -1;
	}

	private boolean sum(Sticks sticks, int start, int sum, int left,
			boolean isGoOn) {
		count++;
		int num = sticks.num;
		boolean result = false;
		if (left == 0) {
			int first = sticks.firstUnpick();
			if (first == -1) {// ����ƥ�����
				result = true;
			} else {// ƥ��һ�γɹ�
				result = sum(sticks, first, sum, sum, true);// �ӵ�һ��δƥ��Ŀ�ʼ����ƥ��
			}
			return result;
		}
		for (int i = start; i < num; i++) {
			if (sticks.isPicked(i)) {
				continue;
			}
			if (sticks.get(i) > left) {// ��֦3��������ת�����ʵ����ľ��
				continue;
			}
			if (!isSubsumEnough(sticks, i, left)) {// ��֦4��������ʣ�����е�ľ��������������ʱֱ�ӷ���
				break;
			}
			left -= sticks.pick(i);
			if (sum(sticks, i + 1, sum, left, false)) {
				return true;
			}
			left += sticks.unpick(i);
			if (isGoOn) {// ��֦5����һ��ľ��δ�ҵ����ʵ�ƥ�䣬ֱ�ӷ���
				break;
			}
			if (sticks.get(i) == left) {// ��֦6����ĳ��ľ���պ�����һ��ԭľ�����������ƥ�����겻��ʱֱ�ӷ���
				break;
			}
			while (i < num - 1 && sticks.get(i) == sticks.get(i + 1)) {// ��֦7��ĳ��ľ�������ֲ�����ʱ��������ͬľ���϶�Ҳ������
				i++;
			}
		}
		return result;
	}

	private boolean isSubsumEnough(Sticks sticks, int start, int left) {
		int sum = 0, num = sticks.num;
		int[] nums = sticks.lens;
		for (; start < num; start++) {
			if (sticks.isPicked(start)) {
				continue;
			}
			sum += nums[start];
			if (sum >= left) {
				return true;
			}
		}
		return false;
	}

	private int[] swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
		return nums;
	}

	/**
	 * shell sort, O(n^(3/2))
	 */
	public int[] sort(int[] a) {
		int h = 1, len = a.length;
		while (h < len / 3)
			h = h * 3 + 1;
		for (; h >= 1; h /= 3)
			for (int i = h; i < len; i++)
				for (int j = i; j >= h && a[j] > a[j - h]; j -= h)
					swap(a, j, j - h);
		return a;
	}

	private boolean assertEquals(int a, int b) {
		return a == b;
	}

	private class Sticks {
		int num;
		int[] lens;
		int sum;
		boolean[] isPicked;

		public Sticks(int num, int[] lens, int sum) {
			this.num = num;
			this.lens = lens;
			this.sum = sum;
			isPicked = new boolean[lens.length];// Ĭ�ϳ�ʼ��Ϊfalse
		}

		public int get(int index) {
			return lens[index];
		}

		public int pick(int index) {
			isPicked[index] = true;
			return lens[index];
		}

		public int unpick(int index) {
			isPicked[index] = false;
			return lens[index];
		}

		public int firstUnpick() {
			for (int i = 0; i < num; i++) {
				if (!isPicked[i]) {
					return i;
				}
			}
			return -1;
		}

		public boolean isPicked(int index) {
			return isPicked[index];
		}
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		long s = System.currentTimeMillis();
		Main m = new Main();
		m.get();
		for (int i = 0; i < m.testData.size(); i++) {
			int a = m.search(m.testData.get(i));
			// System.out.println(a);
			System.out.println("--------------" + a + ":"
					+ m.assertEquals(a, m.expectedResult.get(i))
					+ "--------------");
		}
		long e = System.currentTimeMillis();
		System.out.println("�ݹ���" + count + "��");
		System.out.println((e - s) + "ms");
	}

}