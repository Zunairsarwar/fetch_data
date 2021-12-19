package com.library.fetch_data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDetailRepo extends CrudRepository<catagories, Long> {

    @Query(value = "select * from catagories", nativeQuery = true)
    List<catagories> findAll();

    // joins
    @Query(value = "select * from book inner join catagories on book.id = catagories.book_id where book.id = :bookId", nativeQuery = true)
    catagories getAllById(@Param("bookId") Integer bookId);

}
