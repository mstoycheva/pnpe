package task_1;

import java.util.Scanner;

public class MainTask1 {
    public static void main(String[] args) {
        System.out.println("Enter number of instruments:");
        int num = new Scanner(System.in).nextInt();
        Instrument[] instruments = new Instrument[num];
        for (int i = 0; i < num; i++) {
            instruments[i] = new Instrument();
        }
        for (int i = 0; i < num; i++) {
            instruments[i].play();
        }
    }
}
