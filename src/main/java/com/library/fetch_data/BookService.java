package com.library.fetch_data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class BookService {

    @Autowired
    bookRepository bookRepository;

    List<book> getAlldata(){
        return bookRepository.findAll();
    }
//
//    List<book> getDataById(Integer id){
//        return bookRepository.findAllById(id);
//    }
//
//    List<book> getDataByName(String name){
//        return bookRepository.findAllByName(name);
//    }

//    List<book> getAllDatafrom(){
//        return bookRepository.getAllById();
//    }



    List<book> getAlldataById(Integer id){
        return bookRepository.getAllById(id);
    }

    List<book> getAllByJoins(){
        return bookRepository.getAllById();
    }

}
