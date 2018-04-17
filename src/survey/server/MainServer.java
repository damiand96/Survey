package survey.server;

import java.io.FileNotFoundException;

public class MainServer {

    public static void main(String[] args) throws FileNotFoundException {

        Server server = new Server(1234);
        server.start();
    }

}
