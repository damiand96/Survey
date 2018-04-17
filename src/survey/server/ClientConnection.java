package survey.server;

import survey.messages.ClientWelcome;
import survey.messages.Message;
import survey.messages.SurveyQuestions;
import survey.messages.SurveyAnswers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ClientConnection extends Thread {
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public ClientConnection(Socket socket) throws IOException {
        this.socket = socket;
        //Twrzenie streamow
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Error during handling client connection: " + e);
        }
    }
// Tworzenie nowego watku
    @Override
    public void run() {
        boolean keepRunning = true;
        while (keepRunning) {
            try {
                Message message = (Message) inputStream.readObject();
                handleReceivedMessage(message);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                keepRunning = false;
            }
        }

        close();
    }

    private void handleReceivedMessage(Message message) throws IOException {
        System.out.println("Received message: [" + message + "]");

        if (message instanceof ClientWelcome) {
            SurveyQuestions questions = FileReadAndWrite.ReadSurveyQuestionsFromFile();
            sendMessage(questions);
        }

        if (message instanceof SurveyAnswers) {
            SurveyAnswers answers = (SurveyAnswers) message;
            FileReadAndWrite.WriteSurveyAnswersToFile(answers);
            FileReadAndWrite.WriteSurveyStatisticsToFile(answers);
        } else {
            System.out.println("Not supported messages.");
        }
    }

    public void sendMessage(Message message) {
        if (!socket.isConnected()) {
            close();
            return;
        }
        try {
            outputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// Zamkniecie wszytkiego
    public void close() {
        try {
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
