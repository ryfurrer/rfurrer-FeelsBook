package com.assign1.rfurrer.feelsbook.feeling;


import android.os.Parcel;
import android.os.Parcelable;

import com.assign1.rfurrer.feelsbook.exceptions.CommentTooLongException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


//TODO credit http://www.vogella.com/tutorials/AndroidParcelable/article.html
public abstract class Mood implements Comparable<Mood>, Parcelable {
    static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",
                                                                    Locale.getDefault());
    private static final Integer MAX_CHARS = 100;
    private Date date;
    private String comment;

    public Mood() {
        this.date = new Date();
    }

    public Mood(String message) throws CommentTooLongException {
        this.date = new Date();
        if (message.length() <= this.MAX_CHARS ) {
            this.comment = message;
        } else {
            throw new CommentTooLongException();
        }
    }

    public Mood(Parcel in) {
        try {
            this.comment = in.readString();
            this.date = dateFormat.parse(in.readString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.comment);
        dest.writeString(dateFormat.format(date));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) throws CommentTooLongException {
        if (comment.length() <= this.MAX_CHARS ) {
            this.date = new Date();
            this.comment = comment;
        } else {
            throw new CommentTooLongException();
        }
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