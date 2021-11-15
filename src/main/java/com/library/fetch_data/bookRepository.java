package com.library.fetch_data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface bookRepository extends CrudRepository<book, Long> {

    List<book> findAll();
//
//    List<book> findAllById(Integer id);
//
//    List<book> findAllByName(String n);

//    @Query(value = "select * from book", nativeQuery = true)
//    List<book>  getAllById();

    @Query(value = "select * from book where book.id= :id", nativeQuery = true)
    List<book> getAllById(Integer id);

    @Query(value = "select * from catagories inner join catagories on book.id = catagories.book_id", nativeQuery = true)
    List<book> getAllById();


}
