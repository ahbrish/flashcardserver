package com.flashcard.demo.domain.controller;

import com.flashcard.demo.domain.exception.QuestionCreationException;
import com.flashcard.demo.domain.exception.QuestionNotFoundException;
import com.flashcard.demo.domain.model.Question;
import com.flashcard.demo.domain.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@Slf4j
public class QuestionController {

    private QuestionService service;

    @Autowired
    public QuestionController(QuestionService questionService){
        this.service = questionService;
    }

    @PostMapping("")
    public ResponseEntity<Question> create(@RequestBody Question question) throws QuestionCreationException{
        question = service.createQuestion(question);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> requestQuestionById(@PathVariable Long id) throws QuestionNotFoundException{
        Question response = service.findById(id);
        log.info(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions() throws QuestionNotFoundException {
        List<Question> allQuestions = service.getAllQuestions();
        return new ResponseEntity<>(allQuestions, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) throws QuestionNotFoundException {
        question = service.updateQuestion(question);
        return new ResponseEntity<>(question, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Question> deleteQuestion(@PathVariable Long id) throws QuestionNotFoundException {
            service.deleteQuestion(id);
            return ResponseEntity.ok().body(null);
    }

}
