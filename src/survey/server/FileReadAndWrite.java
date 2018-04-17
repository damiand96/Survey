package survey.server;

import survey.messages.SurveyAnswers;
import survey.messages.SurveyQuestions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileReadAndWrite {

    public static SurveyQuestions ReadSurveyQuestionsFromFile() throws FileNotFoundException {
        String questionFile = "F:\\Repezytoria\\ankieta\\bazaPytan.txt";
        Scanner scanner = new Scanner(new File(questionFile));
        List<String> fileLines = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            fileLines.add(scanner.nextLine());
        }
        String[] question1answers = {fileLines.get(1), fileLines.get(2), fileLines.get(3), fileLines.get(4)};
        String[] question2answers = {fileLines.get(6), fileLines.get(7), fileLines.get(8), fileLines.get(9)};
        String[] question3answers = {fileLines.get(11), fileLines.get(12), fileLines.get(13), fileLines.get(14)};
        String[] question4answers = {fileLines.get(16), fileLines.get(17), fileLines.get(18), fileLines.get(19)};
        SurveyQuestions questions = new SurveyQuestions(fileLines.get(0), question1answers,
                fileLines.get(5), question2answers,
                fileLines.get(10), question3answers,
                fileLines.get(15), question4answers);

        return questions;
    }

    public static void WriteSurveyAnswersToFile(SurveyAnswers answers) throws IOException {
        String answersFile = "F:\\Repezytoria\\ankieta\\bazaOdpowiedzi.txt";

        List<String> lines = Arrays.asList("Imie: " + answers.name, "odpowiedz 1: " + answers.answer1,
                "odpowiedz 2: " + answers.answer2, "odpowiedz 3: " + answers.answer3, "odpowiedz 4: " + answers.answer4);

        Path file = Paths.get(answersFile);
        Files.write(file, lines, Charset.forName("UTF-8"));
    }

    static int q1a1Count = 0;
    static int q1a2Count = 0;
    static int q1a3Count = 0;
    static int q1a4Count = 0;
    static int q2a1Count = 0;
    static int q2a2Count = 0;
    static int q2a3Count = 0;
    static int q2a4Count = 0;
    static int q3a1Count = 0;
    static int q3a2Count = 0;
    static int q3a3Count = 0;
    static int q3a4Count = 0;
    static int q4a1Count = 0;
    static int q4a2Count = 0;
    static int q4a3Count = 0;
    static int q4a4Count = 0;

    public static void WriteSurveyStatisticsToFile(SurveyAnswers answers) throws IOException {
        ActualizeStatistics(answers);

        List<String> lines = Arrays.asList(
                "q1a1Count: " + q1a1Count,
                "q1a2Count: " + q1a2Count,
                "q1a3Count: " + q1a3Count,
                "q1a4Count: " + q1a4Count,
                "q2a1Count: " + q2a1Count,
                "q2a2Count: " + q2a2Count,
                "q2a3Count: " + q2a3Count,
                "q2a4Count: " + q2a4Count,
                "q3a1Count: " + q3a1Count,
                "q3a2Count: " + q3a2Count,
                "q3a3Count: " + q3a3Count,
                "q3a4Count: " + q3a4Count,
                "q4a1Count: " + q4a1Count,
                "q4a2Count: " + q4a2Count,
                "q4a3Count: " + q4a3Count,
                "q4a4Count: " + q4a4Count);

        String statisticsFile = "F:\\Repezytoria\\ankieta\\wyniki.txt";
        Path file = Paths.get(statisticsFile);
        Files.write(file, lines, Charset.forName("UTF-8"));
    }

    private static void ActualizeStatistics(SurveyAnswers answers) {
        switch (answers.answer1) {
            case 1:q1a1Count++; break;
            case 2:q1a2Count++; break;
            case 3:q1a3Count++; break;
            case 4:q1a4Count++; break;
        }
        switch (answers.answer2) {
            case 1:q2a1Count++; break;
            case 2:q2a2Count++; break;
            case 3:q2a3Count++; break;
            case 4:q2a4Count++; break;
        }
        switch (answers.answer3) {
            case 1:q3a1Count++; break;
            case 2:q3a2Count++; break;
            case 3:q3a3Count++; break;
            case 4:q3a4Count++; break;
        }
        switch (answers.answer4) {
            case 1:q4a1Count++; break;
            case 2:q4a2Count++; break;
            case 3:q4a3Count++; break;
            case 4:q4a4Count++; break;
        }
    }
}
