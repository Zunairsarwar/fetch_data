package com.library.fetch_data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class BookDTO {

    public static JsonArray getResponseJson(List<book> b) {
        JsonArray jsonArray = new JsonArray();
        for (book books : b){
            JsonObject jObj = getResponseJson1(books);
            jsonArray.add(jObj);
        }
        return jsonArray;
    }

    public static JsonObject getResponseJson1(book book) {
        JsonObject jObj = new JsonObject();
        jObj.addProperty("id", book.getId());
        jObj.addProperty("name", book.getName());
        //        jObj.addProperty("enabled", brand.getEnabled());
        //        jObj.addProperty("shortKey", brand.getShortKey());
        return jObj;
    }

    public static JsonArray getResponseJson2(List<catagories> b) {
        JsonArray jsonArray = new JsonArray();
        for (catagories books : b) {
            JsonObject jObj = getResponseJson3(books);
            jsonArray.add(jObj);
        }
        return jsonArray;
    }

    public static JsonObject getResponseJson3(catagories books) {
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
