package chenghehe321.poj;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Phaser;
import java.util.concurrent.RecursiveTask;

/**
 * @author Carl
 * 
 *         2014-11-4
 */
public class Test extends B {

	public static String SOURCE_PATH = "D://java";
	public static String TARGET_PATH = "D://bak";
	public static String SOURCE_SUFFIX = ".java";
	public static String TARGET_SUFFIX = ".bak";

	public static void traversal(String path) {
		File root = new File(path);
		File[] files = root.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				traversal(file.getAbsolutePath());
				try {
					File dir = new File(TARGET_PATH + file.getCanonicalPath());
					dir.mkdir();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (file.isFile() && file.getName().endsWith(SOURCE_SUFFIX)) {
				String oldName = file.getName();
				String newName = oldName.substring(0,
						oldName.lastIndexOf('.') - 1) + TARGET_SUFFIX;
				try {
					copyFile(file,
							new File(TARGET_PATH + file.getCanonicalPath()
									+ newName));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void copyFile(File sourceFile, File targetFile)
			throws IOException {
		BufferedInputStream inBuff = null;
		BufferedOutputStream outBuff = null;
		try {
			inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
			outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1) {
				outBuff.write(b, 0, len);
			}
			outBuff.flush();
		} finally {
			if (inBuff != null)
				inBuff.close();
			if (outBuff != null)
				outBuff.close();
		}
	}

	public static void test(Integer i) {
		int a = i.intValue();
		a += 3;
		i = new Integer(a);
	}

	/**
	 * a^i,O(log(n))
	 */

	public static int multi(int a, int i, int result) {
		System.out.print(i + " ");
		if (i <= 1) {
			return a;
		}
		int half = 0;
		if ((i & 1) == 1) {
			half = multi(a, (i - 1) / 2, result);
			result = result * a * half * half;
		} else {
			half = multi(a, i / 2, result);
			result = result * half * half;
		}
		return result;
	}

	public static void main(String[] args) {
		Collections s;
		int a=1;
		assert a==2;
		System.out.println(3 & 1);
		System.out.println("\n" + multi(2, 11, 1));
	}
}

class B extends Exception {
	public B() {
		System.out.println("b");
	}
}

abstract class A {
	abstract void a();
}

interface C {
	void a();
}

class D extends A implements C {

	@Override
	public void a() {
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(10);
		RecursiveTask t;
		Phaser p;
	}

}