package Questions;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        PriorityQueue<Integer> pmax = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pmin = new PriorityQueue<>();
        int k = 0;
        for (int i = 0; i < n; i++) {
            k = a[i];
            //heapify
            if (pmax.size() > 0) {
                if (k > pmax.peek()) {
                    pmin.add(k);
                    if (pmin.size() > pmax.size()) {
                        int t = pmin.poll();
                        pmax.add(t);
                    }
                } else {
                    pmax.add(k);
                    if (pmin.size() + 1 < pmax.size()) {
                        int t = pmax.poll();
                        pmin.add(t);
                    }
                }
            } else {
                pmax.add(k);
            }

            //find the median from heaps
            if (i % 2 == 0) {
                System.out.printf("%.1f \n", (float) pmax.peek());
            } else {
                float l = pmax.peek();
                float b = pmin.peek();
                float c = (l + b) / 2;
                System.out.printf("%.1f \n", c);
            }
        }
    }
}
