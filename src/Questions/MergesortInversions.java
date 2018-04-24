package Questions;

import java.util.Scanner;

public class MergesortInversions {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            long res = mergeSort(arr, 0, n - 1);
            System.out.println(res);
            /*for(int i=0; i < n; i++){
                System.out.print(arr[i] + " ");
            }*/
        }
    }

    private static long mergeSort(int[] arr, int i, int j) {
        if (j - i == 0)
            return 0;
        int m = (j + i) / 2;
        long a = mergeSort(arr, i, m);
        long b = mergeSort(arr, m + 1, j);
        long res = mergeCount(arr, i, m, j);
        return res + a + b;
    }

    private static long mergeCount(int[] arr, int i, int m, int j) {
        int p1 = i, p2 = m + 1, c = 0;
        long res = 0;
        int f[] = new int[j - i + 1];
        while (p1 <= m && p2 <= j) {
            if (arr[p1] <= arr[p2]) {
                f[c++] = arr[p1++];
            } else {
                res = res + (m - p1 + 1);
                f[c++] = arr[p2++];
            }
        }
        while (p1 <= m) {
            f[c++] = arr[p1++];
        }
        while (p2 <= j) {
            f[c++] = arr[p2++];
        }
        for (int k = i; k < i + c; k++) {
            arr[k] = f[k - i];
        }
        return res;
    }
}
