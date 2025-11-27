import java.sql.SQLOutput;

public class MyThread implements Runnable{
    int count;
    public MyThread(int count){
        this.count = count;
    }

    @Override
    synchronized public void run() {
        for (int i = 0; i < 1000; i++) {
            count += 1;
        }
        System.out.println(count);
    }
}
