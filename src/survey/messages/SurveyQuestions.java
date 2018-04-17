package survey.messages;

public class SurveyQuestions extends Message {
    public String question1;
    public String[] question1Answers;

    public String question2;
    public String[] question2Answers;

    public String question3;
    public String[] question3Answers;

    public String question4;
    public String[] question4Answers;

    public SurveyQuestions(String question1, String[] question1Answers,
                           String question2, String[] question2Answers,
                           String question3, String[] question3Answers,
                           String question4, String[] question4Answers) {
        super.name = "server";
        this.question1 = question1;
        this.question1Answers = question1Answers;
        this.question2 = question2;
        this.question2Answers = question2Answers;
        this.question3 = question3;
        this.question3Answers = question3Answers;
        this.question4 = question4;
        this.question4Answers = question4Answers;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", question1: " + question1 + ", question1Answers: [" + String.join(",", question1Answers) + "]" +
                ", question1: " + question2 + ", question1Answers: [" + String.join(",", question2Answers) + "]" +
                ", question1: " + question3 + ", question1Answers: [" + String.join(",", question3Answers) + "]" +
                ", question1: " + question4 + ", question1Answers: [" + String.join(",", question4Answers) + "]";
    }
}
