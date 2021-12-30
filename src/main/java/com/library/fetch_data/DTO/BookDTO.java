package com.library.fetch_data.DTO;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.library.fetch_data.InsertRequest;
import com.library.fetch_data.Model.Book;
import com.library.fetch_data.Model.Catagories;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class BookDTO {

    // Properties
    private Integer id;

    @NotBlank(groups = InsertRequest.class)
    private String name;

    List<Long> add_bookDetail;

    List<Long> remove_bookDetail;

    // Getter and Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getAdd_bookDetail() {
        return add_bookDetail;
    }

    public void setAdd_bookDetail(List<Long> add_bookDetail) {
        this.add_bookDetail = add_bookDetail;
    }

    public List<Long> getRemove_bookDetail() {
        return remove_bookDetail;
    }

    public void setRemove_bookDetail(List<Long> remove_bookDetail) {
        this.remove_bookDetail = remove_bookDetail;
    }

    public Book getDuplicateObjects(){
        Book book = new Book();
        book.setId(this.id);
        book.setName(this.name);
        return book;
    }

    public void setbook(Book book){
        this.id = book.getId();
        this.name = book.getName();
    }

    public Book getUpdatedValues(Book book){
        if (null != name){
            book.setName(this.name);
        }
        return book;
    }

    public void addDetail(Long id){
        if (null != this.add_bookDetail){
            this.add_bookDetail= new ArrayList<>();
        }
        this.add_bookDetail.add(id);
    }

    public static JsonArray getResponseJson(List<Book> b) {
        JsonArray jsonArray = new JsonArray();
        for (Book books : b){
            JsonObject jObj = getResponseJson1(books);
            jsonArray.add(jObj);
        }
        return jsonArray;
    }

    public static JsonObject getResponseJson1(Book book) {
        JsonObject jObj = new JsonObject();
        jObj.addProperty("id", book.getId());
        jObj.addProperty("name", book.getName());
        //        jObj.addProperty("enabled", brand.getEnabled());
        //        jObj.addProperty("shortKey", brand.getShortKey());
        return jObj;
    }

    public static JsonArray getResponseJson2(List<Catagories> b) {
        JsonArray jsonArray = new JsonArray();
        for (Catagories books : b) {
            JsonObject jObj = getResponseJson3(books);
            jsonArray.add(jObj);
        }
        return jsonArray;
    }

    public static JsonObject getResponseJson3(Catagories books) {
        JsonObject jObj = new JsonObject();

        jObj.addProperty("id" , books.getId());
        jObj.addProperty("book_id" , books.getBook_id());
        jObj.addProperty("customer_id" , books.getCustomer_id());
        jObj.addProperty("author-name" , books.getAuthor_name());
        jObj.addProperty("pages" , books.getPages());
        jObj.addProperty("publish_date" , books.getPublish_date());

        return jObj;
    }

}
