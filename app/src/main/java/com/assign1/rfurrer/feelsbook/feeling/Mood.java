package com.assign1.rfurrer.feelsbook.feeling;


import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.assign1.rfurrer.feelsbook.exceptions.CommentTooLongException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


//TODO credit http://www.vogella.com/tutorials/AndroidParcelable/article.html
public abstract class Mood implements Comparable<Mood>, Parcelable {
    static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",
            Locale.getDefault());
    static final SimpleDateFormat dF = new SimpleDateFormat("yyyy-MM-dd",
            Locale.getDefault());
    static final SimpleDateFormat dT = new SimpleDateFormat("HH:mm:ss",
            Locale.getDefault());
    private static final Integer MAX_CHARS = 100;
    private Date date;
    private String comment;

    public Mood() {
        this.date = new Date();
        comment = "";
    }

    public Mood(String message) throws CommentTooLongException {
        this.date = new Date();
        Log.d(message.length()+"", "Mood: " + message);
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

    public void setDate(String dateText) {
        Log.d(dateText, "setDate: ");
        try {
            this.date = dateFormat.parse(dateText);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) throws CommentTooLongException {
        Log.d(comment.length()+"", "Mood: " + comment);
        if (comment.length() <= this.MAX_CHARS ) {
            this.comment = comment;
        } else {
            throw new CommentTooLongException();
        }
    }

    public Date getDate() {
        return date;
    }

    public String getDateAsString() {
        return dF.format(date);
    }

    public String getTimeAsString() {
        return dT.format(date);
    }

    @Override
    public String toString(){
        return dateFormat.format(date);
    }

    @Override
    public int compareTo(Mood mood) {
        return - this.getDate().compareTo(mood.getDate());
    }
}