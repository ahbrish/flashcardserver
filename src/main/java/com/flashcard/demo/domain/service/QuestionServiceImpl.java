package com.flashcard.demo.domain.service;

import com.flashcard.demo.domain.exception.QuestionCreationException;
import com.flashcard.demo.domain.exception.QuestionNotFoundException;
import com.flashcard.demo.domain.model.Question;
import com.flashcard.demo.domain.repo.QuestionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // this is a specialization of the @Component annotation, and it fulfills the idea of a service layer
@Slf4j
public class QuestionServiceImpl implements QuestionService{

    private QuestionRepo repo;

    @Autowired
    public QuestionServiceImpl(QuestionRepo questionRepo){
        this.repo = questionRepo;
    }

    @Override
    public Question createQuestion(Question question) throws QuestionCreationException {
        return repo.save(question);
    }

    @Override
    public Question findById(Long id) throws QuestionNotFoundException {
        return findQuestionById(id);
    }

    @Override
    public List<Question> getAllQuestions() throws QuestionNotFoundException {
        return (List) repo.findAll();
    }

    @Override
    public Question updateQuestion(Question question) throws QuestionNotFoundException {
        findQuestionById(question.getId());
        return repo.save(question);
    }

    @Override
    public void deleteQuestion(Long id) throws QuestionNotFoundException {
        Question questionToRemove = findQuestionById(id);
        repo.delete(questionToRemove);
    }

    private Question findQuestionById(Long id) throws QuestionNotFoundException {
        Optional<Question> questionOptional = repo.findById(id);

        if (questionOptional.isEmpty())
            throw new QuestionNotFoundException("Question not found");
        return questionOptional.get();
    }
}
