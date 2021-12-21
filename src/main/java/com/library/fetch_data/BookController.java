package com.library.fetch_data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    @RequestMapping(value = UrlConstants.BOOKS , method = RequestMethod.GET)
    public ResponseEntity<String> getAllData() {
        List<book> books = this.bookService.getAlldata();
        return ResponceManager.sendSuccessResponse(BookDTO.getResponseJson(books));
    }

    @RequestMapping(value = UrlConstants.BOOK_ID , method = RequestMethod.GET)
    public ResponseEntity<String> getByID(@PathVariable Integer book_id){
        logger.info("getBookById request [book_id: " + book_id + "]");
        book book =  this.bookService.getBookById(book_id);
        return ResponceManager.sendSuccessResponse(BookDTO.getResponseJson1(book));
    }

    @RequestMapping(value = UrlConstants.BOOK_NAME , method = RequestMethod.GET)
    public ResponseEntity<String> getByName(@PathVariable String book_name){
        logger.info("getBookById request [book_name: " + book_name + "]");
        book book =  this.bookService.getBookByName(book_name);
        return ResponceManager.sendSuccessResponse(BookDTO.getResponseJson1(book));
    }

    @RequestMapping(value = UrlConstants.BOOKS_DETAIL , method = RequestMethod.GET)
    public ResponseEntity<String> getBookDetail(){
        List<catagories> detail = this.bookService.getBookDetail();
        return ResponceManager.sendSuccessResponse(BookDTO.getResponseJson2(detail));
    }

    @RequestMapping(value = UrlConstants.BOOK_DETAIL_BY_ID , method = RequestMethod.GET)
    public ResponseEntity<String> getBookDetailById(@PathVariable Integer book_id){
        logger.info("getBookById request [Book_id: " + book_id + "]");
        catagories bookDetail =  this.bookService.getBookDetailById(book_id);
        return ResponceManager.sendSuccessResponse(BookDTO.getResponseJson3(bookDetail));
    }

}
