package com.quiz.app.Service;

import com.quiz.app.Entity.Questions;
import com.quiz.app.Respository.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService {
    @Autowired
    private QuestionsRepo questionsRepo;
    public Questions createQuestion(Questions questions) {
        return questionsRepo.save(questions);
    }

    public List<Questions> getQuestions() {
        return questionsRepo.findAll();
    }
}
