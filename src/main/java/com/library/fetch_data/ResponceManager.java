package com.library.fetch_data;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponceManager {

    public static ResponseEntity<String> sendSuccessResponse(JsonElement o) {
        Gson gson = new Gson();
        JsonObject object = new JsonObject();
        object.addProperty("message", "Success");
        object.add("data", o);
        object.addProperty("status", "Ok");
        return new ResponseEntity<>(object.toString(), HttpStatus.OK);
    }
}
