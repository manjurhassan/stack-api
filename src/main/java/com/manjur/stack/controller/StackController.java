package com.manjur.stack.controller;

import com.manjur.stack.controller.ui.model.Result;
import com.manjur.stack.service.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StackController {

    @Autowired
    private StackService stackService;

    @PostMapping(path = "/stack/push/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> pushValue(@PathVariable int value) {
        boolean success = stackService.pushValue(value);
        Result result = new Result(value, success);
        if (success) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(path = "/stack/pop", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> popValue() {
        int value = stackService.popValue();
        boolean success = value != -1;
        Result result = new Result(value, success);
        if (success) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/stack/peek", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> peekValue() {
        int value = stackService.peek();
        boolean success = value != -1;
        Result result = new Result(value, success);
        if (success) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/stack/isEmpty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> isEmpty() {
        boolean isEmpty = stackService.isEmpty();
        Result result = new Result();
        result.setSuccess(true);
        result.setEmpty(isEmpty);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/stack/size", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> getSize() {
        int size = stackService.size();
        Result result = new Result(size, true);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(path = "/stack/resize/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> resize(@PathVariable int value) {
        boolean success = stackService.resizeStack(value);
        Result result = new Result(value, success);
        if (success) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
