import java.lang.reflect.Array;
import java.util.ArrayList;

public class main1 {
    public class queue {
        ArrayList a = new ArrayList();
        int max;
        int num;

        public queue(int max) {
            this.max = max;
            this.num = 0;
        }

        public void put(int v) {
            a.add(v);
            num++;
        }

        public void delete() {
            a.remove(0);
            num--;
        }
    }

    queue q = new queue(10);
    boolean flag;

    public class resorce {

    }

    public class t1 extends Thread {
        resorce s;

        public t1(resorce s) {
            this.s = s;
        }

        public void run(queue q, int v) {
            while (!flag) {
                synchronized (s) {
                    while (q.num < q.max) {
                        q.put(1);
                        s.notify();
                    }
                    if (q.num == q.max) {
                        s.notify();
                        flag = true;
                    }
                }

            }

        }


    }

    public class t2 extends Thread {
        resorce s;

        public t2(resorce s) {
            this.s = s;
        }

        public void run() {
            while (flag) {
                synchronized (s) {
                    while (q.num > 0) {
                        q.delete();
                    }
                    if (q.num == 0) {
                        s.notify();
                        flag = false;
                    }
                }

            }

        }
    }
}

