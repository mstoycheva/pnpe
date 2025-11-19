package files;

import java.io.*;

public class FilterCopy {
    public static void main(String[] args) {
        File inputFile = new File("C:\\Users\\User\\IdeaProjects\\pnpe\\input.txt");
        File outputFile = new File("C:\\Users\\User\\IdeaProjects\\pnpe\\output.txt");

        if (!inputFile.exists()) {
            System.out.println("File does not exist");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile)); BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("Filtered file");
            writer.newLine();

            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                writer.write(line);
                writer.newLine();
            }

            System.out.println("File filtered");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
