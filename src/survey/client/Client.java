package survey.client;

import survey.messages.ClientWelcome;
import survey.messages.Message;
import survey.messages.SurveyQuestions;
import survey.messages.SurveyAnswers;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public Client(String host, int port) throws Exception {
        //Próba połączenia z serwerem
        socket = new Socket("localhost", 1234);
        //inputStream = new ObjectInputStream(socket.getInputStream());
        outputStream = new ObjectOutputStream(socket.getOutputStream());
    }

    public SurveyQuestions getSurveyQuestions() throws IOException, ClassNotFoundException {
        Message message = new ClientWelcome("Damian");
        sendMessage(message);
          //Sprawdzenie, czy serwer odpowiedział.
        inputStream = new ObjectInputStream(socket.getInputStream());
        SurveyQuestions surveyQuestions = (SurveyQuestions) inputStream.readObject();
        System.out.println("Received message: [" + surveyQuestions + "]");
        return surveyQuestions;
    }


    public void sendSurveyResponse(SurveyAnswers response) throws IOException {
        sendMessage(response);
    }

    private void sendMessage(Message message) throws IOException {
        outputStream.writeObject(message);
        System.out.println("Sent message: [" + message + "]");

    }
}