package DataStructures;

/**
 * Creates a data-structure to answer -
 * -- range queries in log(n)
 * -- point updates in log(n)
 * The BIT array has a size one greater than the original array
 * Applicable only for aggregate functions which have subtractive property
 * not for MAX, MIN
 */
public class BinaryIndexTree {
	private int[] B;
	private int size;

	public BinaryIndexTree(int size) {
		this.size = size + 1;
		B = new int[this.size];
	}

	public int find(int i) {
		i++;
		int sum = 0;
		while (i > 0) {
			sum += this.B[i];
			i -= (i & -i);
		}
		return sum;
	}

	public void update(int i, int key) {
		i++;
		while (i < this.size) {
			B[i] += key;
			i += (i & -i);
		}
	}
	
	public int aggregate(int res, int key) {
		return res + key;
	}

	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5};
		BinaryIndexTree bit = new BinaryIndexTree(A.length);
		for (int i = 0; i < A.length; i++) {
			bit.update(i, A[i]);
			System.out.println("Updated i : " + i);
		}
		System.out.println(bit.find(2));
	}
}
