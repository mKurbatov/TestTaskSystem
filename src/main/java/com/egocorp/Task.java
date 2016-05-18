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
    private Date deadLine;
    private String author;
    private String description;
    private boolean done;
    private static ArrayList<Task> tasks = new ArrayList<>();

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static int getTasksNum()
    {
        return tasks.size();
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

    static {
        try {
            tasks.add(new Task(new SimpleDateFormat("dd.MM.yyyy").parse("13.05.2016"), "Курбатов Максим Сергеевич", "Приехать на встречу"));
            tasks.add(new Task(new SimpleDateFormat("dd.MM.yyyy").parse("14.05.2016"), "Курбатов Максим Сергеевич", "Просто задача, чтобы показать как выглядит статус \"Просроченная\""));
            tasks.add(new Task(new SimpleDateFormat("dd.MM.yyyy").parse("15.05.2016"), "Курбатов Максим Сергеевич", "Нарисовать дизайн главной страницы", true));
            tasks.add(new Task(new SimpleDateFormat("dd.MM.yyyy").parse("16.05.2016"), "Курбатов Максим Сергеевич", "Реализовать дизайн главной страницы", true));
            tasks.add(new Task(new SimpleDateFormat("dd.MM.yyyy").parse("17.05.2016"), "Курбатов Максим Сергеевич", "Реализовать вторую часть тествого задания"));
            tasks.add(new Task(new SimpleDateFormat("dd.MM.yyyy").parse("18.05.2016"), "Курбатов Максим Сергеевич", "Сдать тестовое задание в срок"));
            tasks.add(new Task(new SimpleDateFormat("dd.MM.yyyy").parse("19.05.2016"), "Курбатов Максим Сергеевич", "Поздравить жену с годовщиной"));
            tasks.add(new Task(new SimpleDateFormat("dd.MM.yyyy").parse("20.05.2016"), "Курбатов Максим Сергеевич", "Купить кошке еды", true));
            tasks.add(new Task(new SimpleDateFormat("dd.MM.yyyy").parse("21.05.2016"), "Курбатов Максим Сергеевич", "Помочь отцу с ремонтом"));
            tasks.add(new Task(new SimpleDateFormat("dd.MM.yyyy").parse("22.05.2016"), "Курбатова Елена Александровна", "Дочитать книгу"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Task(Date deadLine, String author, String description)
    {
        this.deadLine = deadLine;
        this.author = author;
        this.description = description;
    }

    public Task(Date deadLine, String author, String description, boolean done)
    {
        this.deadLine = deadLine;
        this.author = author;
        this.description = description;
        this.done = done;
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
