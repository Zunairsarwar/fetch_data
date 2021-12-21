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

    public List<book> getAlldata(){
        return this.bookRepository.findAll();
    }

    public book getBookById(Integer book_id) {
        return this.bookRepository.getAllById(book_id);
    }

    public book getBookByName(String book_name) {
        return this.bookRepository.getAllByName(book_name);
    }

    public List<catagories> getBookDetail() { return this.bookDetailRepo.findAll(); }

    public catagories getBookDetailById(Integer book_id) {
        return this.bookDetailRepo.getAllById(book_id);
    }

}
