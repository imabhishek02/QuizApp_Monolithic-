package com.quiz.app.Controller;

import com.quiz.app.Entity.Questions;
import com.quiz.app.Service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionsService questionsService;

    @PostMapping("create")
    public Questions createQuestion(@RequestBody Questions questions){
        return questionsService.createQuestion(questions);
    }

    @GetMapping("getAllQuestion")
    public List<Questions> getQuestion(){
        return questionsService.getQuestions();

    }
}
