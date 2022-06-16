package com.flashcard.demo.domain.repo;

import com.flashcard.demo.domain.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // indicates that the interface is intended to provide you with the access and manipulation of data for a database
// it also indicates to Spring during the component scan that this instance should be created as a bean that will be available for use and injection into other beans in the application
public interface QuestionRepo extends CrudRepository<Question, Long> {
    // the CRUDRepo interface defines the basic common methods to create, read, update, and delete data from a repo
}
