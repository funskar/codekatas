package DataStructures;

import java.util.Scanner;

public class LinkedListProblems {
    static int n;
    static LLUtils llu;
    static LLNode head, head1;
    static LLNode tail, temp;
    long a;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        llu = new LLUtils();
        while (t-- > 0) {
            n = in.nextInt();
            head = null;
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    head = LLUtils.createLL(in.nextInt());
                } else {
                    int val = in.nextInt();
                    LLUtils.addNode(val, head);
                }
            }
            LLUtils.printLL(head);
            //for (tail = head; tail.next != null; tail = tail.next);
            //DataStructures.LLPair p = DataStructures.LLUtils.reverseLL(head, tail);
            //DataStructures.LLUtils.printLL(p.head);
            n = in.nextInt();
            head1 = null;
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    head1 = LLUtils.createLL(in.nextInt());
                } else {
                    int val = in.nextInt();
                    LLUtils.addNode(val, head1);
                }
            }
            //DataStructures.LLUtils.printLL(head1);
            //temp = DataStructures.LLUtils.mergeList(head, head1);
            temp = LLUtils.mergeMaxList(head, head1);
            LLUtils.printLL(temp);
        }
    }
}

class LLUtils {

    public static LLNode temp;
    //public static DataStructures.LLNode head;

    public static LLNode createLL(int value) {
        temp = new LLNode();
        temp.value = value;
        temp.next = null;
        return temp;
    }

    public static void addNode(int value, LLNode head) {
        temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new LLNode();
        temp.next.value = value;
        temp.next.next = null;
    }

    public static LLPair reverseLL(LLNode head, LLNode tail) {
        LLNode newTail = head;
        if (head == tail) {
            return new LLPair(tail, newTail);
        } else {
            LLPair newLL = reverseLL(head.next, tail);
            newLL.tail.next = newTail;
            newTail.next = null;
            return new LLPair(newLL.head, newTail);
        }
    }

    public static void printLL(LLNode lln) {
        while (lln != null) {
            System.out.print(lln.value + " ");
            lln = lln.next;
        }
    }

    public static LLNode addLink(int value, LLNode head) {
        if (head == null) {
            head = new LLNode();
            head.value = value;
            head.next = null;
        } else {
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new LLNode();
            temp.next.value = value;
            temp.next.next = null;
        }
        return head;
    }

    public static LLNode mergeList(LLNode h1, LLNode h2) {
        LLPair lp = new LLPair(null, null);
        if (h1 != null && h2 != null) {
            if (h1.value <= h2.value) {
                lp.head = h1;
                lp.tail = h1;
                h1 = h1.next;
            } else {
                lp.head = h2;
                lp.tail = h2;
                h2 = h2.next;
            }
        }
        while (h1 != null && h2 != null) {
            if (h1.value <= h2.value) {
                lp.tail.next = h1;
                h1 = h1.next;
            } else {
                lp.tail.next = h2;
                h2 = h2.next;
            }
            lp.tail = lp.tail.next;
        }
        if (h1 != null) {
            if (lp.head == null) {
                lp.head = h1;
            } else {
                lp.tail.next = h1;
            }
        }
        if (h2 != null) {
            if (lp.head == null) {
                lp.head = h2;
            } else {
                lp.tail.next = h2;
            }
        }
        return lp.head;
    }

    public static LLNode mergeMaxList(LLNode h1, LLNode h2) {
        LLNode head = null, head1 = h1, head2 = h2, tail = null;
        int sum1 = 0, sum2 = 0;

        while (h1 != null && h2 != null) {
            if (h1.value < h2.value) {
                sum1 += h1.value;
                h1 = h1.next;
            } else if (h1.value > h2.value) {
                sum2 += h2.value;
                h2 = h2.next;
            } else {
                if (sum1 >= sum2) {
                    if (head == null) {
                        head = head1;
                        tail = h1;
                    } else {
                        tail.next = head1;
                        tail = h1;
                    }
                } else {
                    if (head == null) {
                        head = head2;
                        tail = h2;
                    } else {
                        tail.next = head2;
                        tail = h2;
                    }
                }
                sum1 = 0;
                sum2 = 0;
                h1 = h1.next;
                head1 = h1;
                h2 = h2.next;
                head2 = h2;
            }
        }
        while (h1 != null) {
            sum1 += h1.value;
            h1 = h1.next;
        }
        while (h2 != null) {
            sum2 += h2.value;
            h2 = h2.next;
        }
        if (sum1 >= sum2) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }
        return head;
    }
}

class LLNode {
    public int value;
    public LLNode next = null;
}

class LLPair {
    public LLNode head;
    public LLNode tail;

    public LLPair(LLNode h, LLNode t) {
        this.head = h;
        this.tail = t;
    }

    public LLPair() {
    }
}
