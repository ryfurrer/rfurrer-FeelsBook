package com.assign1.rfurrer.feelsbook.comments;


import java.util.Date;

public class Comment  {

    private Date date;
    private String message;
    private static final Integer MAX_CHARS = 100;

    public Comment() {
        this.date = new Date();
        this.message = "";
    }

    public Comment(String message) {
        this.date = new Date();
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.message;
    }

    public void setMessage(String message) throws CommentTooLongException {
        if (message.length() <= this.MAX_CHARS ) {
            this.date = new Date();
            this.message = message;
        } else {
            throw new CommentTooLongException();
        }
    }

    public Date getDate() { return this.date; }
}

