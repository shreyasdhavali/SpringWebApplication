package com.sand.SpringWebApplication.controller;

import com.sand.SpringWebApplication.objectRelationalMapping.Questions;
import com.sand.SpringWebApplication.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Questions> getByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("level/{level}")
    public List<Questions> getByLevel(@PathVariable String level) {
        return questionService.getQuestionsByLevel(level);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Questions questions) {
        return questionService.addQuestion(questions);
    }

    @DeleteMapping("delete/{id}")
    public String deleteQuestion(@PathVariable Integer id) {
        return questionService.deleteQuestion(id);
    }
}
