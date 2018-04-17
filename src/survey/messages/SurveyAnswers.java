package survey.messages;

public class SurveyAnswers extends Message {
    public int answer1;
    public int answer2;
    public int answer3;
    public int answer4;


    public SurveyAnswers(String name, int answer1, int answer2, int answer3, int answer4) {
        super.name = name;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }

    @Override
    public String toString() {
        return super.toString() + ", Answer1: " + answer1 + ", Answer2: " + answer2 + ", Answer3: " + answer3 + ", Answer4: " + answer4;
    }
}
