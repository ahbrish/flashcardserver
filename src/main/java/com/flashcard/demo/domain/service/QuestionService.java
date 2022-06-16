package com.flashcard.demo.domain.service;

import com.flashcard.demo.domain.exception.QuestionCreationException;
import com.flashcard.demo.domain.exception.QuestionNotFoundException;
import com.flashcard.demo.domain.model.Question;

import java.util.List;

public interface QuestionService {

    Question createQuestion(Question question) throws QuestionCreationException;
    Question findById(Long id) throws QuestionNotFoundException;
    List<Question> getAllQuestions() throws QuestionNotFoundException;
    Question updateQuestion(Question question) throws QuestionNotFoundException;
    void deleteQuestion(Long id) throws QuestionNotFoundException;

}
