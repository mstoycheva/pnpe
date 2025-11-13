import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> commands = new LinkedList<>();
        while (true) {
            System.out.println("Enter command: ");
            String action = sc.nextLine();

            if (action.equals("end")) {
                System.out.println("Exit");
                break;
            }
            if (commands.size() == 3) {
                commands.poll();
            }

            commands.offer(action);

            System.out.println("Current commands: " + commands);
        }

    }
}
