package com.egocorp;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class task present task in system. Created 17.05.2016 by mKurbatov
 */
public class Task implements Serializable {
    final private int id;
    private Date deadLine;
    private String author;
    private String description;
    private boolean done;
    private static ArrayList<Task> tasks = new ArrayList<>();

    public int getId() {
        return id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isOverdue()
    {
        Date date = new Date();
        return deadLine.compareTo(date) < 0;
    }

    public boolean isInDanger()
    {
        Date date = new Date();
        return (date.getTime() - deadLine.getTime()) < 86400000;
    }

    public Task(int id, Date deadLine, String author, String description)
    {
        this.id = id;
        this.deadLine = deadLine;
        this.author = author;
        this.description = description;
    }

    @Override
    public String toString() {
        return deadLine + " [" + author + "]: " + description;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadLine()
    {
        return deadLine;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getDescription()
    {
        return description;
    }
}
