package files;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class BinaryStats {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\User\\IdeaProjects\\pnpe\\numbers.dat";
        String outputFile = "C:\\Users\\User\\IdeaProjects\\pnpe\\stats.txt";

        long count = 0;
        long sum = 0;
        Integer min = null;
        Integer max = null;

        try (DataInputStream dis = new DataInputStream(new FileInputStream(inputFile))) {
            while (true) {
                try {
                    int value = dis.readInt();
                    count++;
                    sum += value;
                    if (min == null || value < min) min = value;
                    if (max == null || value > max) max = value;
                } catch (EOFException eof) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        double avg;

        if (count > 0) {
            avg = (double) sum / count;
        } else {
            avg = 0.0;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("Count: " + count);
            writer.newLine();
            writer.write("Sum: " + sum);
            writer.newLine();
            writer.write("Avg: " + avg);
            writer.newLine();
            writer.write("Min: " + min);
            writer.newLine();
            writer.write("Max: " + max);
            writer.newLine();

            System.out.println("Success in " + outputFile);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
