package com.flashcard.demo.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity // indicates this annotated class should be mapped to a database table
public class Question {

    @Id // these two annotations indicate that an annotated field should be mapped to a primary key column in the database and the value for this field should be generated, instead of being explicitly entered
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String question;
    @NonNull
    private String answer;
}
