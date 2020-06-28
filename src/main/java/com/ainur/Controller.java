package com.ainur;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import com.ainur.model.Data;
import com.ainur.model.Response;

import java.io.IOException;

@RestController
@CrossOrigin(origins = {"*"})
public class Controller {
    @Autowired
    Calc calc;

    @RequestMapping("/get-limit")
    @GetMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity getLimit(HttpServletRequest request) {
        Gson gson = new Gson();

        try {
            Data data = gson.fromJson(request.getReader(), Data.class);
            Response response = new Response();

            if (data.getaIncSP() < 0 ) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }

            response.setLimit(calc.getLimit(data));
            return new ResponseEntity(gson.toJson(response, Response.class), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
