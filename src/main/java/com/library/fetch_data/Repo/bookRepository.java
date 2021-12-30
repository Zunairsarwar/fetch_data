package com.library.fetch_data.Repo;

import com.library.fetch_data.Model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface bookRepository extends CrudRepository<Book, Long> {

    @Query(value = "select * from book", nativeQuery = true)
    List<Book> findAll();

    @Query(value="select * from book where book.id=:book_id", nativeQuery=true) Book getAllById(@Param("book_id") Integer book_id);

    @Query(value="select * from book where book.name=:book_name", nativeQuery=true)
    Book getAllByName(@Param("book_name") String book_name);

}
