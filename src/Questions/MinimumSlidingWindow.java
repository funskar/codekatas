package Questions;

import java.util.HashMap;
import java.util.Scanner;

public class MinimumSlidingWindow {
    public static void main(String[] args) {
        new MinimumSlidingWindow().solve();
    }

    public void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
    }

    public String minWindow(String s, String t) {
        int i = 0, j = 0;
        int[] m = new int[26];
        for (int l = 0; l < m.length; l++) {
            m[l] = 0;
        }
        for (int l = 0; l < t.length(); l++) {
            m[t.charAt(l) - 'A']++;
        }
        HashMap<Character, Integer> mp = new HashMap<>();
        int x = 0, y = 0;
        Character l = 0;
        int mx = 0, my = 0, len = 0, clen = 0;
        while (x < s.length()) {
            while (y < s.length() && (t.length() > clen)) {
                l = s.charAt(y);
                if (m[l - 'A'] > 0) {
                    addMap(l, mp);
                    clen++;
                    m[l - 'A']--;
                }
                y++;
            }
            if (t.length() == clen) {
                if ((y - x) < (my - mx))
                    mx = x;
                my = y;
            }

        }
        return "";
    }

    public void addMap(char a, HashMap<Character, Integer> mp) {
        if (mp.containsKey(a)) {
            mp.put(a, mp.get(a) + 1);
        } else {
            mp.put(a, 1);
        }
    }

    public void subMap(char a, HashMap<Character, Integer> mp) {
        if (mp.get(a) > 1)
            mp.put(a, mp.get(a) - 1);
        else
            mp.remove(a);
    }
}

