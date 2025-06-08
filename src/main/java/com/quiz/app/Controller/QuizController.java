package com.quiz.app.Controller;

import com.quiz.app.Entity.Questions;
import com.quiz.app.Entity.QuestionsWrapper;
import com.quiz.app.Entity.Quiz;
import com.quiz.app.Entity.Response;
import com.quiz.app.Respository.QuizRepo;
import com.quiz.app.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quizmono")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("createQuiz")
    private List<Questions> createQuiz(@RequestParam String category){
       return quizService.createQuiz(category);
    }

    @GetMapping("getQuiz/{id}")
    private List<QuestionsWrapper> getQuiz(@PathVariable  Integer id){
        return quizService.getQuiz(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }


}
