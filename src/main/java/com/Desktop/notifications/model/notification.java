package com.Desktop.notifications.model;

public class notification {


    public notification()
    {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String message;
    public String title;

    public notification(String message, String title) {
        this.message = message;
        this.title = title;
    }
}
