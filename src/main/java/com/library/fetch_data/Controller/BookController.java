package com.library.fetch_data.Controller;

import com.library.fetch_data.DTO.BookDTO;
import com.library.fetch_data.InsertRequest;
import com.library.fetch_data.Model.Book;
import com.library.fetch_data.Model.Catagories;
import com.library.fetch_data.ResponceManager;
import com.library.fetch_data.Service.BookService;
import com.library.fetch_data.UrlConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    @RequestMapping(value = UrlConstants.BOOKS , method = RequestMethod.GET)
    public ResponseEntity<String> getAllData() {
        List<Book> books = this.bookService.getAlldata();
        return ResponceManager.sendSuccessResponse(BookDTO.getResponseJson(books));
    }

    @RequestMapping(value = UrlConstants.BOOK_ID , method = RequestMethod.GET)
    public ResponseEntity<String> getByID(@PathVariable Integer book_id){
        logger.info("getBookById request [book_id: " + book_id + "]");
        Book book =  this.bookService.getBookById(book_id);
        return ResponceManager.sendSuccessResponse(BookDTO.getResponseJson1(book));
    }

    @RequestMapping(value = UrlConstants.BOOK_NAME , method = RequestMethod.GET)
    public ResponseEntity<String> getByName(@PathVariable String book_name){
        logger.info("getBookById request [book_name: " + book_name + "]");
        Book book =  this.bookService.getBookByName(book_name);
        return ResponceManager.sendSuccessResponse(BookDTO.getResponseJson1(book));
    }

    @RequestMapping(value = UrlConstants.BOOKS_DETAIL , method = RequestMethod.GET)
    public ResponseEntity<String> getBookDetail(){
        List<Catagories> detail = this.bookService.getBookDetail();
        return ResponceManager.sendSuccessResponse(BookDTO.getResponseJson2(detail));
    }

    @RequestMapping(value = UrlConstants.BOOK_DETAIL_BY_ID , method = RequestMethod.GET)
    public ResponseEntity<String> getBookDetailById(@PathVariable Integer book_id){
        logger.info("getBookById request [Book_id: " + book_id + "]");
        Catagories bookDetail =  this.bookService.getBookDetailById(book_id);
        return ResponceManager.sendSuccessResponse(BookDTO.getResponseJson3(bookDetail));
    }

    @RequestMapping(value = UrlConstants.BOOKS , method = RequestMethod.POST)
    public ResponseEntity<String> addBooks(HttpServletRequest httprequest,
                                            @Validated(InsertRequest.class) @RequestBody BookDTO request) {
        logger.info("Add new book request received from bookName: " + request.getName() + " [ " + request.toString() + " ] ");
        BookDTO res = this.bookService.addBookAndDetail(request);
        if (null == res) {
            logger.info("Error: Book not added");
            return ResponceManager.sendErrorResponse("Error: User not added", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (null == res.getId()) {
            logger.info("Error: Book Already exist");
            return ResponceManager.sendErrorResponse("Error: Already exist", HttpStatus.NOT_ACCEPTABLE);
        }
        logger.info("Book Add Request Completed for bookName: " + res);
        //        Thread thread = new Thread(() -> {
        //            String username = HeaderParser.getUserFromRequest(httpRequest);
        //            this.userActionsService.createActionsForAddBrandUsers(username, request, res);
        //        });
        //        thread.start();
        return ResponceManager.sendSuccessResponse1(res);
    }
}
