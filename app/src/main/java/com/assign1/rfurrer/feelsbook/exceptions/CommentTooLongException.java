/*
Custom exception class for too long comment handling.
 */

package com.assign1.rfurrer.feelsbook.exceptions;

public class CommentTooLongException extends Exception {

    public CommentTooLongException() {
        super("Comment is too long!");
    }
}