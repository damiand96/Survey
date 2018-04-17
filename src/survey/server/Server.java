package survey.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private ServerSocket serverSocket;
    private ArrayList<ClientConnection> clientConnections;
    private int port;
    private boolean isRun;

    // przekazanie portu z mainserver
    public Server(int port) {
        this.port = port;
        this.isRun = false;
        this.clientConnections = new ArrayList<>();
    }

    public void start() {
        isRun = true;
// Tworzenie gniazda naluchujacego
        try {
           serverSocket = new ServerSocket(port);

            while (isRun) {
                System.out.println("Server run on port " + port + " waiting for Clients.");
                Socket socket = serverSocket.accept();

                System.out.println("New client connected");
                ClientConnection clientConn = new ClientConnection(socket);
                clientConnections.add(clientConn);
                clientConn.start();
            }

            closeServer(serverSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        isRun = false;
    }

    private void closeServer(ServerSocket serverSocket) {
        try {
            serverSocket.close();
            for (ClientConnection clientConn : clientConnections) {
                clientConn.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
