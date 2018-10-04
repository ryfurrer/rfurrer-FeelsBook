package com.assign1.rfurrer.feelsbook.comments;

public class CommentTooLongException extends Exception {

    public CommentTooLongException() {
        super("Comment is too long!");
    }
}