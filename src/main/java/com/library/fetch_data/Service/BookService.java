package com.library.fetch_data.Service;


import com.library.fetch_data.DTO.BookDTO;
import com.library.fetch_data.Model.Book;
import com.library.fetch_data.Model.Catagories;
import com.library.fetch_data.Repo.BookDetailRepo;
import com.library.fetch_data.Repo.bookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    bookRepository bookRepository;

    @Autowired
    BookDetailRepo bookDetailRepo;

    public List<Book> getAlldata(){
        return this.bookRepository.findAll();
    }

    public Book getBookById(Integer book_id) {
        return this.bookRepository.getAllById(book_id);
    }

    public Book getBookByName(String book_name) {
        return this.bookRepository.getAllByName(book_name);
    }

    public List<Catagories> getBookDetail() { return this.bookDetailRepo.findAll(); }

    public Catagories getBookDetailById(Integer book_id) {
        return this.bookDetailRepo.getAllById(book_id);
    }

    public Book addBook(BookDTO request){
        Book book;
        try {
            logger.info("Saving Book: " + request.getName());
            book = request.getDuplicateObjects();
            book = this.bookRepository.save(book);
        } catch (Exception e){
            logger.info("Error occured while trying to add book: " + request.getName());
            logger.info("Error message: " + e.getMessage());
            logger.debug("Exception occured:" + e);
            return null;
        }
        logger.info("Book saved Successfull with bookId: " + request.getId());
        return book;
    }

    @Transactional
    public BookDTO addBookAndDetail(BookDTO request){
        BookDTO res = new BookDTO();
        Book book;
        try{
            if (null != this.bookRepository.getAllByName(request.getName())){
                logger.info("Error: User Already exist, Aborting operation");
                return new BookDTO();
            } else {
                book = this.addBook(request);
                if (null == book){
                    logger.info("Operation Failed, Aborting");
                    return null;
                }
            }
        } catch (Exception e) {
            logger.info("Operation Failed, Aborting");
            return new BookDTO();
        }
        res.setbook(book);
        updateBookAccessControls(book , request , res , false , true);
        return res;
    }

    private void updateBookAccessControls(Book book, BookDTO request, BookDTO res, boolean remove, boolean add) {


        if (add){
            logger.info("Starting Add calls");

        }
        if (remove){
            logger.info("Starting Removing calls");
        }

    }

//    public List<catagories> addBookDetial(Long BookId, List<Long> id){
//        if (null == id || id.size() == 0){
//            return null;
//        }
//        List<catagories> bookDetail = new ArrayList<>();
//        try {
//            logger.info("");
//        } catch (Exception e){
//
//        }
//    }

}
