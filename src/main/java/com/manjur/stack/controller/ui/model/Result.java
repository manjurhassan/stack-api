package com.manjur.stack.controller.ui.model;

public class Result {

    int value;
    boolean success;
    boolean isEmpty;

    public Result() {
        value = 0;
        success = false;
        isEmpty = false;
    }

    public Result(int value, boolean success) {
        this.value = value;
        this.success = success;
        isEmpty = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
