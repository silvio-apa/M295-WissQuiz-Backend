package ch.wiss.quizbackend.service;

import  ch.wiss.quizbackend.model.Question;
import  org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final List<Question> questions =
          List.of(
                new Question(
                        "1",
                        "Welches Land hat die meisten FIFA-WMs gewonnen ? ",
                        "Sport",
                        "leicht",
                        List.of("Brasilien", "Italien", "Frankreich", "Deutschland"),
                        "Brasilien"


                ),
                new Question(
                        "2",
                        "Wie viele Beine hat eine Spinne",
                        "Natur",
                        "leicht",
                        List.of("4","2","8","6"),
                        "8"
                ),

                new Question(
                        "3",
                        "Wie viele Kontinente gibt es auf der Erde?",
                        "Geografie",
                        "leicht",
                        List.of("5", "6", "7", "8"),
                        "7"
                ),




                new Question(
                        "4",
                        "In welchem Jahr fiel die Berliner Mauer?",
                        "Geschichte",
                        "mittel",
                        List.of("1987", "1989", "1991", "1993"),
                        "1989"
                ),


                new Question(
                        "5",
                        "Was ist das Ergebnis von 12 mal 8?",
                        "Mathematik",
                        "mittel",
                        List.of("86", "94", "96", "108"),
                        "96"
                ),


                new Question(
                        "6",
                        "Welches Protokoll wird normalerweise für verschlüsselte Webseiten verwendet?",
                        "Informatik",
                        "schwer",
                        List.of("HTTP", "FTP", "HTTPS", "SMTP"),
                        "HTTPS"
                )



        );

        public List<Question> getAllQuestions() {
            return questions;
        }

        public Question getQuestionById(String id) {
            for (Question question : questions) {
                if (question.getId().equals(id)) {
                    return question;
                }
            }
            return null;
        }
    }