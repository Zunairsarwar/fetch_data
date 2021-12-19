package com.library.fetch_data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {

    @Autowired
    bookRepository bookRepository;

    @Autowired
    BookDetailRepo bookDetailRepo;
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

    public List<book> getAlldata(){
        return this.bookRepository.findAll();
    }

    public book getBookById(Integer book_id) {
        return this.bookRepository.getAllById(book_id);
    }

    public book getBookByName(String bookName) {
        return this.bookRepository.getAllByName(bookName);
    }

    public List<catagories> getBookDetail() { return this.bookDetailRepo.findAll(); }

    public catagories getBookDetailById(Integer bookId) {
        return this.bookDetailRepo.getAllById(bookId);
    }

}
