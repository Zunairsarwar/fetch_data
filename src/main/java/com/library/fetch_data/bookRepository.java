package com.library.fetch_data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface bookRepository extends CrudRepository<book, Long> {

    @Query(value = "select * from book", nativeQuery = true)
    List<book> findAll();

    @Query(value="select * from book where book.id= :book_id", nativeQuery=true)
    book getAllById(@Param("book_id") Integer book_id);

    @Query(value="select * from book where book.name= :bookName", nativeQuery=true)
    book getAllByName(@Param("bookName") String bookName);

}
