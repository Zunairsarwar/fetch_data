package com.library.fetch_data;

import antlr.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("books")
    List<book> getData(){
        System.out.println("This on one handler");
       //        return bookService.getAlldata();
       
    }

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

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public List<book> getById(@PathVariable("id") Integer id){
        return bookService.getAlldataById(id);
    }

    @RequestMapping(value = "/book/cat", method = RequestMethod.GET)
    public List<book> getByJoins(){
        return bookService.getAllByJoins();
    }

}
