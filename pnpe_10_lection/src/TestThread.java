public class TestThread {
    public static void main(String[] args) {
        int counter = 0;
        MyThread thread = new MyThread(counter);
        Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread);
        t1.start();
        t2.start();
    }
}
