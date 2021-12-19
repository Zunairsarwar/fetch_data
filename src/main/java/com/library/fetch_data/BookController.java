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

    /*

    @GetMapping("/book/name")
    public List<book> getDataByName() {
        return bookService.getDataByName();
    }



    @RequestMapping(value = "/book/id/{id}", method = RequestMethod.GET)
    public List<book> getById(@PathVariable("id") Integer id){
        return bookService.getDataById(id);
    }
    @RequestMapping(value = "/book/name/{name}", method = RequestMethod.GET)
    public List<book> getByNames(@PathVariable("name") String name){
        return bookService.getDataByName(name);
    }

    @RequestMapping(value = "/book/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<book> getByNames(@RequestParam("name") String name){
        return bookService.getDataByName(name);
    }

    @RequestMapping(value = "/hi/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void hello(@PathParam("id") Integer id){
        System.out.println(bookService.getDataById(id));
    }

     */

//    @RequestMapping(value = "/books", method = RequestMethod.GET)
//    public List<book> getAllData(){
//        return bookService.getAllDatafrom();
//    }

//    @GetMapping(value = "/book/{id}")
//    public List<book> getById(@PathVariable("id") Integer id){
//        return bookService.getAlldataById(id);
//    }

//    @RequestMapping(value = URLConstants.BRAND_BY_ID, method = RequestMethod.GET)
//    public ResponseEntity<String> getBrandById(@PathVariable long brand_id) {
//        logger.info("getBrandById request [brandId: " + brand_id + "]");
//        Brand brand = this.brandService.getBrandById(brand_id);
//        return ResponseManager.sendSuccessResponse(BrandDTO.getResponseJson(brand));
//    }

    @RequestMapping(value = "/bb" , method = RequestMethod.GET)
    List<book> getData(){
        return bookService.getAlldata();
    }

    @RequestMapping(value = "/books" , method = RequestMethod.GET)
    public ResponseEntity<String> getAllData() {
        //        logger.info("getBookById request [book_id: " + book_id + "]");
        List<book> books = this.bookService.getAlldata();
        return ResponceManager.sendSuccessResponse(BookDTO.getResponseJson(books));
    }



    @RequestMapping(value = "/id/{book_id}" , method = RequestMethod.GET)
    public ResponseEntity<String> getByID(@PathVariable Integer book_id){
        logger.info("getBookById request [book_id: " + book_id + "]");
        book book =  this.bookService.getBookById(book_id);
        return ResponceManager.sendSuccessResponse(BookDTO.getResponseJson1(book));
    }

    @RequestMapping(value = "/name/{bookName}" , method = RequestMethod.GET)
    public ResponseEntity<String> getByName(@PathVariable String bookName){
        logger.info("getBookById request [bookName: " + bookName + "]");
        book book =  this.bookService.getBookByName(bookName);
        return ResponceManager.sendSuccessResponse(BookDTO.getResponseJson1(book));
    }

    @RequestMapping(value = "/book/detail" , method = RequestMethod.GET)
    public ResponseEntity<String> getBookDetail(){
//        logger.info("getBookById request [BookId: " + bookId + "]");
        List<catagories> detail = this.bookService.getBookDetail();
        return ResponceManager.sendSuccessResponse(BookDTO.getResponseJson2(detail));
    }

    @RequestMapping(value = "/book/id/{bookId}" , method = RequestMethod.GET)
    public ResponseEntity<String> getBookDetailById(@PathVariable Integer bookId){
        logger.info("getBookById request [BookId: " + bookId + "]");
        catagories bookDetail =  this.bookService.getBookDetailById(bookId);
        return ResponceManager.sendSuccessResponse(BookDTO.getResponseJson3(bookDetail));
    }

//    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
//    public List<book> getById(@PathVariable("id") Integer id){
//        return bookService.getAlldataById(id);
//    }

//    @RequestMapping(value = "/book/cat", method = RequestMethod.GET)
//    public List<book> getByJoins(){
//        return bookService.getAllByJoins();
//    }

}
