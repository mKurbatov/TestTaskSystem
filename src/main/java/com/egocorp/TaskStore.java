package com.egocorp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FormsDeveloper on 5/20/16.
 */
public class TaskStore {
    private static List<Task> list = new ArrayList<>();

    public TaskStore()
    {}

    static {
        try {
            list.add(new Task(1, new SimpleDateFormat("dd.MM.yyyy").parse("13.05.2016"), "Курбатов Максим Сергеевич", "Приехать на встречу"));
            list.add(new Task(2, new SimpleDateFormat("dd.MM.yyyy").parse("14.05.2016"), "Курбатов Максим Сергеевич", "Просто задача, чтобы показать как выглядит статус \"Просроченная\""));
            list.add(new Task(3, new SimpleDateFormat("dd.MM.yyyy").parse("15.05.2016"), "Курбатов Максим Сергеевич", "Нарисовать дизайн главной страницы"));
            list.add(new Task(4, new SimpleDateFormat("dd.MM.yyyy").parse("16.05.2016"), "Курбатов Максим Сергеевич", "Реализовать дизайн главной страницы"));
            list.add(new Task(5, new SimpleDateFormat("dd.MM.yyyy").parse("17.05.2016"), "Курбатов Максим Сергеевич", "Реализовать вторую часть тествого задания"));
            list.add(new Task(6, new SimpleDateFormat("dd.MM.yyyy").parse("18.05.2016"), "Курбатов Максим Сергеевич", "Сдать тестовое задание в срок"));
            list.add(new Task(7, new SimpleDateFormat("dd.MM.yyyy").parse("19.05.2016"), "Курбатов Максим Сергеевич", "Поздравить жену с годовщиной"));
            list.add(new Task(8, new SimpleDateFormat("dd.MM.yyyy").parse("20.05.2016"), "Курбатов Максим Сергеевич", "Купить кошке еды"));
            list.add(new Task(9, new SimpleDateFormat("dd.MM.yyyy").parse("21.05.2016"), "Курбатов Максим Сергеевич", "Помочь отцу с ремонтом"));
            list.add(new Task(10, new SimpleDateFormat("dd.MM.yyyy").parse("22.05.2016"), "Курбатова Елена Александровна", "Дочитать книгу"));
            list.get(3).setDone(true);
            list.get(4).setDone(true);
            list.get(8).setDone(true);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static List<Task> getList() {
        return list;
    }
}
