import java.util.Arrays;
import java.util.List;

public class Binarysearch {

	public static void main(String[] args) {
		int[] ip = {0, 5, 7, 9, 9, 9, 10, 21};
        Integer[] ip1 = {9, 10, 21, 0, 5, 7, 8};

        int key = 9;
//		int[] ip = {1, 1};
		Arrays.sort(ip);
		for (int i : ip) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
//		System.out.println("\n"  + bs(ip, 8));
//		System.out.println("\n"  + lwbs(ip, 8));
//		System.out.println("\n"  + upbs(ip, 8));
//		System.out.println("Lower Bound : " + binarySearchLowerBound(ip, key));
//		System.out.println("Upper Bound : " + binarySearchUpperBound(ip, key));
//      System.out.println("Search : " + findMin(Arrays.asList(ip1)));
    }

	/*
	Lower Bound : The lowest point from which the predicate(abstract function) returns a true value.
	Upper Bound : The highest point until which the predicate(abstract function) returns a true value.

	NOTE : The mid in upper bound is always ceiling function -> (low + high + 1) / 2
	For reason take the corner case of (F, T); we want mid to be floor in Lower bound and ceil in Upper bound
	 */

	// 1 2 3 4 4 4 4 5 6
	// F F F T T T T T T
	//lower bound : 3
	//return the index of the first element in Array equal to or greater than the target value
	//returns the first element which matches the key or the next element greater than the key
	public static int binarySearchLowerBound(int[] ip, int key) {
		int low = 0;
		int high = ip.length - 1;
		int mid;
		while(low < high) {
			mid = (low + high)/2;
			if (ip[mid] >= key) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	// 1 2 3 4 4 4 4 5 6
	// T T T T T T T F F
	//upper bound : 6
	public static int binarySearchUpperBound(int[] ip, int key) {
		int low = 0;
		int high = ip.length - 1;
		int mid;
		while(low < high) {
			mid = (low + high + 1)/2;
			if (ip[mid] <= key) {
				low = mid;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}

	public static int bs(int[] ip, int key) {
		int l=0, h=ip.length-1, m;
		while(l <= h) {
			m = ( l+ h)/2;
			if (ip[m] == key) {
				return m;
			} else if (ip[m] < key) {
				l = m+1;
			} else {
				h = m-1;
			}
		}
		return -1;
	}
	
	public static int upbs(int[] ip, int key) {
		int low = 0, high = ip.length-1, mid = -1;
		while(low <= high) {
			mid = (low+high)/2;
			if (ip[mid] == key && (mid == high || ip[mid+1] > key)) {
				return mid;
			} else if (ip[mid] <= key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return mid;
	}

	public static int lwbs(int[] ip, int key) {
		int low = 0, high = ip.length-1, mid = -1;
		while(low <= high) {
			mid = (low+high)/2;
			if (ip[mid] == key && (mid == low || ip[mid-1] < key)) {
				return mid;
			} else if (ip[mid] >= key) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return mid;
	}

	//SQRT is an upper-bound function
	public int sqrt(int a) {
		long low = 0, high = a, mid = 0, ans = 0;
		while (low < high) {
			mid = (low + high + 1) / 2;
			if (mid * mid <= a) {
				low = mid;
			} else {
				high = mid - 1;
			}
		}
		return (int)low;
	}

	public static int findMin(final List<Integer> a) {
        int low = 0, high = a.size() - 1, mid = 0, ans = a.get(low);
        while (low < high) {
            mid = (low + high) / 2;
            if (a.get(mid) >= a.get(low)) {
                if (a.get(mid) >= a.get(high)) {
                    low = mid + 1;
                } else {
                    high = low;
                }
            } else {
                high = mid;
            }
        }
        return a.get(low);
	}

}

