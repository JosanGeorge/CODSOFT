import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ChatClient {

    public static void main(String[] args) {
        try {
            // Connect to the server
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connected to server: " + socket);

            // Create input and output streams for communication
            InputStream serverInput = socket.getInputStream();
            OutputStream serverOutput = socket.getOutputStream();

            // Create a thread for receiving messages from the server
            Thread receiveThread = new Thread(() -> {
                try {
                    while (true) {
                        byte[] buffer = new byte[1024];
                        int bytesRead = serverInput.read(buffer);
                        if (bytesRead == -1) {
                            break; // Connection closed by the server
                        }

                        String receivedMessage = new String(buffer, 0, bytesRead);
                        System.out.println("Server: " + receivedMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiveThread.start();

            // Create a thread for sending messages to the server
            Thread sendThread = new Thread(() -> {
                try {
                    while (true) {
                        // Read a message from the console
                        String message = System.console().readLine();

                        // Send the message to the server
                        serverOutput.write(message.getBytes());
                        serverOutput.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            sendThread.start();

            // Wait for both threads to finish
            receiveThread.join();
            sendThread.join();

            // Close the socket
            socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
