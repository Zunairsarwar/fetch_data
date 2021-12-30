package com.library.fetch_data;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public class ResponceManager {

    public static ResponseEntity<String> sendSuccessResponse(JsonElement o) {
        Gson gson = new Gson();
        JsonObject object = new JsonObject();
        object.addProperty("message", "Success");
        object.add("data", o);
        object.addProperty("status", "Ok");
        return new ResponseEntity<>(object.toString(), HttpStatus.OK);
    }

    public static ResponseEntity<String> sendErrorResponse(String exception, HttpStatus status) {
        JsonObject object = new JsonObject();
        object.addProperty("timestamp", new Date().toString());
        object.addProperty("status", status.value());
        object.addProperty("error", String.valueOf(status));
        object.addProperty("message", exception);
        return new ResponseEntity<>(object.toString(), status);
    }

    public static ResponseEntity<String> sendSuccessResponse1(Object o) {
        Gson gson = new Gson();
        JsonObject object = new JsonObject();
        object.addProperty("message", "Success");
        object.add("data", gson.toJsonTree(o));
        return new ResponseEntity<>(object.toString(), HttpStatus.OK);
    }
}
