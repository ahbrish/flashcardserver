package com.flashcard.demo.domain.exception;

public class QuestionNotFoundException extends Exception {
    public QuestionNotFoundException(String msg){
        super(msg);
    }
}
