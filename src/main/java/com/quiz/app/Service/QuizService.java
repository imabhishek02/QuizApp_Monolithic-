package com.quiz.app.Service;


import com.quiz.app.Entity.Questions;
import com.quiz.app.Entity.QuestionsWrapper;
import com.quiz.app.Entity.Quiz;
import com.quiz.app.Entity.Response;
import com.quiz.app.Respository.QuestionsRepo;
import com.quiz.app.Respository.QuizRepo;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuestionsRepo questionsRepo;
    public  List<Questions> createQuiz(String category) {
        List<Questions>questions = questionsRepo.findQuestionsByCategory(category);

        System.out.println(questions);
        Quiz quiz = new Quiz();
        quiz.setQuestionsList(questions);
        quizRepo.save(quiz);
        return questions;
    }

    public List<QuestionsWrapper> getQuiz(Integer id) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Questions>questions = quiz.get().getQuestionsList();
        List<QuestionsWrapper>quizForUser = new ArrayList<>();
            for(Questions questions1 : questions) {
                QuestionsWrapper questionsWrapper = new QuestionsWrapper(questions1.getId(),questions1.getQuestion(), questions1.getOption1(),
                        questions1.getOption2(), questions1.getOption3(), questions1.getOption4());
                quizForUser.add(questionsWrapper);
            }
            System.out.println(quizForUser);
       return quizForUser;
    }
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Questions> questions = quiz.getQuestionsList();
        int right = 0;
        int i = 0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
