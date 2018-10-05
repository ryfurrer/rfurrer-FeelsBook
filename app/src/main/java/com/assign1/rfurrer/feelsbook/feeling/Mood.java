package com.assign1.rfurrer.feelsbook.feeling;


import com.assign1.rfurrer.feelsbook.comments.Comment;
import com.assign1.rfurrer.feelsbook.comments.CommentTooLongException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public abstract class Mood implements Comparable<Mood> {
    static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
    private Date date;
    private Comment comment;

    public Mood() {
        this.date = new Date();
    }

    public Mood(String text) throws CommentTooLongException{
        this.date = new Date();
        comment = new Comment();
        comment.setMessage(text);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(String comment) throws CommentTooLongException {
        this.comment.setMessage(comment);
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString(){
        return dateFormat.format(date);
    }

    @Override
    public int compareTo(Mood mood) {
        return mood.getDate().compareTo(this.getDate());
    }
}