import java.util.List;
public class Exam {
    private List<MCQ> questions;
    private int currentQuestion = 0;
    public Exam(List<MCQ> questions) {
        this.questions = questions;
    }
    public MCQ getNextQuestion() {
        if (currentQuestion < questions.size()) {
            return questions.get(currentQuestion++);
        }
        return null;
    }
}
