package com.sand.SpringWebApplication.service;

import com.sand.SpringWebApplication.dao.QuestionDao;
import com.sand.SpringWebApplication.objectRelationalMapping.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Questions>> getAllQuestions() {
        return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
    }

    public List<Questions> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public List<Questions> getQuestionsByLevel(String level) {
        return questionDao.findByDifficultylevel(level);
    }

    public String addQuestion(Questions questions) {
        questionDao.save(questions);
        return "success";
    }

    public String deleteQuestion(Integer id) {
        questionDao.deleteById(id);
        return "success";
    }
}
