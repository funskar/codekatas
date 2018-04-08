import java.util.*;

public class PairHashing {
	public static void main(String[] args) {
		new PairHashing().solve();
	}

	public void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = {47, 47, 47, 63, 65, 86, 63};
		int m = 4, k = 3;
		TreeSet<Pair> q = new TreeSet<>(new PairComp());
		HashMap<Integer, Integer> m1 = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (m1.containsKey(arr[i])) {
				m1.put(arr[i], m1.get(arr[i])+1);
			} else {
				m1.put(arr[i], 1);
			}
		}
		for (Integer i : m1.keySet()) {
			q.add(new Pair(i, m1.get(i)));
		}
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += q.pollFirst().b;
		}
		System.out.println(sum);
	}
}

class Pair {
	int a, b;
	public Pair(int a, int b) {
		// TODO Auto-generated constructor stub
		this.a = a;
		this.b = b;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Integer.parseInt(""+a+b);
	}

	@Override
	public boolean equals(Object obj) {
		Pair o = (Pair)obj;
		if (this.a == o.a)
			return true;
		else 
			return false;
	}
	
}

class PairComp implements Comparator<Pair> {
	@Override
	public int compare(Pair o1, Pair o2) {
		if (o1.b < o2.b) 
			return 1;
		else if (o1.b > o2.b)
			return -1;
		return 0;
	}
}
