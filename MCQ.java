public class MCQ {
    private String question;
    private String[] options;
    private int correctAnswer;
    public MCQ(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
    public String getQuestion() {
        return question;
    }
    public String[] getOptions() {
        return options;
    }
    public boolean checkAnswer(int answer) {
        return answer == correctAnswer;
    }
}
