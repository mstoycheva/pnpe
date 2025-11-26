import java.sql.SQLOutput;

public class MyThread implements Runnable{
    int count = 0;
    public MyThread(int count){
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println("My thread is running");
        while(count < 1000){
            count++;
        }
        System.out.println(count);
    }
}
