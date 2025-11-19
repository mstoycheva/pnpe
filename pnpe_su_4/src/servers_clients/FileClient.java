package servers_clients;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class FileClient {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 7000;
        String outputFile = "received.bin";

        if (args.length >= 1) host = args[0];
        if (args.length >= 2) port = Integer.parseInt(args[1]);
        if (args.length >= 3) outputFile = args[2];

        try (Socket socket = new Socket(host, port);
             DataInputStream in = new DataInputStream(socket.getInputStream());
             BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream(outputFile))) {
            System.out.println("Server connected " + host + " - " + port);

            long expectedLength = in.readLong();
            System.out.println("Expected length " + expectedLength);

            byte[] buffer = new byte[4096];
            long totalRead = 0;
            int bytesRead;

            while (totalRead < expectedLength &&
                    (bytesRead = in.read(buffer, 0, (int)Math.min(buffer.length, expectedLength - totalRead))) != -1) {
                fileOut.write(buffer, 0, bytesRead);
                totalRead += bytesRead;
            }

            fileOut.flush();

            System.out.println("Bytes: " + totalRead);
            System.out.println("Expected Length: " + expectedLength);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
