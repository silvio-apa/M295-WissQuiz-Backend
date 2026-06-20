package ch.wiss.quizbackend;

import ch.wiss.quizbackend.model.Question;
import ch.wiss.quizbackend.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {
    private final QuestionRepository questionRepository;

    public DataSeeder( QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;

    }

    @Override
    public void run(String... args) {
        if (questionRepository.count() == 0) {
            questionRepository.saveAll(getStartQuestions());
            System.out.println("DataSeeder: " + questionRepository.count() + "Fragen in die DB geschrieben. ");

        }else {
            System.out.println("DataSeeder: DB enthält bereits Daten, kein Seeding nötig. ");

        }
    }


    private List<Question> getStartQuestions() {

        return List.of(

                new Question(
                        "1",
                        "Was ist die Hauptstadt von Kanada?",
                        "Geografie",
                        "mittel",
                        List.of("Toronto", "Ottawa", "Vancouver", "Montreal"),
                        "Ottawa"
                ),

                new Question(
                        "2",
                        "Welches Tier ist das schnellste Landtier?",
                        "Natur",
                        "leicht",
                        List.of("Löwe", "Gepard", "Pferd", "Leopard"),
                        "Gepard"
                ),

                new Question(
                        "3",
                        "Wie lautet die Binärzahl für die Dezimalzahl 10?",
                        "Informatik",
                        "mittel",
                        List.of("1001", "1010", "1100", "1110"),
                        "1010"
                ),

                new Question(
                        "4",
                        "Wer erfand den modernen Buchdruck mit beweglichen Metalllettern in Europa?",
                        "Geschichte",
                        "schwer",
                        List.of(
                                "Isaac Newton",
                                "Johannes Gutenberg",
                                "Galileo Galilei",
                                "Leonardo da Vinci"
                        ),
                        "Johannes Gutenberg"
                ),

                new Question(
                        "5",
                        "Wie viel sind 15 Prozent von 200?",
                        "Mathematik",
                        "leicht",
                        List.of("20", "25", "30", "35"),
                        "30"
                ),

                new Question(
                        "6",
                        "Welcher Planet hat die kürzeste Umlaufzeit um die Sonne?",
                        "Astronomie",
                        "schwer",
                        List.of("Venus", "Mars", "Merkur", "Jupiter"),
                        "Merkur"
                )
        );
    }
}
