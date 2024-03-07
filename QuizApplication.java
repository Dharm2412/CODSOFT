import java.util.ArrayList;
import java.util.Scanner;

class QuizQuestion {
    private String question;
    private String[] options;
    private char correctAnswer;

    public QuizQuestion(String question, String[] options, char correctAnswer) {
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

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}

class Quiz {
    private ArrayList<QuizQuestion> questions;
    private int score;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.score = 0;
    }

    public void addQuestion(QuizQuestion question) {
        this.questions.add(question);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (QuizQuestion question : questions) {
            System.out.println(question.getQuestion());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((char)('A' + i) + ": " + options[i]);
            }
            
            System.out.println("Enter your answer (You have 30 seconds):");
            
            String answer = scanner.nextLine();

            if (answer.toUpperCase().charAt(0) == question.getCorrectAnswer()) {
                score++;
            }
        }

        System.out.println("Quiz finished! Your score: " + score + "/" + questions.size());
        scanner.close();
    }
}

public class QuizApplication {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        
        quiz.addQuestion(new QuizQuestion("What is the capital of France?", new String[]{"Lyon", "Paris", "Marseille", "Nice"}, 'B'));
        quiz.addQuestion(new QuizQuestion("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Venus"}, 'B'));
       

        quiz.start();
    }
}
