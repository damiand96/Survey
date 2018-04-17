package survey.client;

import survey.messages.SurveyQuestions;
import survey.messages.SurveyAnswers;

import java.util.Scanner;

public class MainClient {

    //Tworzenie gniazda
    public static void main(String[] args) throws Exception {
        Client client = new Client("localhost", 1234);
        SurveyQuestions questions = client.getSurveyQuestions();
        SurveyAnswers response = showSurvay(questions);
        client.sendSurveyResponse(response);

        System.in.read();
    }
  // pytania i zczytywanie odpowiedzi
    private static SurveyAnswers showSurvay(SurveyQuestions questions) {
        System.out.println("pytanie 1: " + questions.question1);
        System.out.println("odpowiedzi (1,2,3,4): " + String.join(", ", questions.question1Answers));
        Scanner in = new Scanner(System.in);
        int answer1 = in.nextInt();

        System.out.println("pytanie 2: " + questions.question2);
        System.out.println("odpowiedzi (1,2,3,4): " + String.join(", ", questions.question2Answers));
        int answer2 = in.nextInt();

        System.out.println("pytanie 3: " + questions.question3);
        System.out.println("odpowiedzi (1,2,3,4): " + String.join(", ", questions.question3Answers));
        int answer3 = in.nextInt();

        System.out.println("pytanie 4: " + questions.question4);
        System.out.println("odpowiedzi (1,2,3,4): " + String.join(", ", questions.question4Answers));
        int answer4 = in.nextInt();

        return new SurveyAnswers("Damian",answer1,answer2,answer3,answer4);
    }
}
