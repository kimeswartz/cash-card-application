package com.useo.cashcard;

//CrudRepository is an interface supplied by Spring Data

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

//By extending CrudRepository, Spring Boot and Spring Data work together automatically to generate CRUD methods to interact with the database.
interface CashCardRepository extends CrudRepository<CashCard, Long>,
        PagingAndSortingRepository<CashCard, Long> {

    //For security so users cannot see other users card information
    CashCard findByIdAndOwner(Long id, String owner);

    //We create a logic to check whether tje Cas Card IS exist in the DB
    boolean existsByIdAndOwner(Long id, String owner);

    Page<CashCard> findByOwner(String owner, PageRequest pageRequest);
}
