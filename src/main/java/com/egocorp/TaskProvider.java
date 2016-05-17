package com.egocorp;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by FormsDeveloper on 5/17/16.
 */
public class TaskProvider extends SortableDataProvider {
    class SortableDataProviderComparator implements Comparator<Task>, Serializable {
        public int compare(final Task o1, final Task o2) {

            PropertyModel<Comparable> model1 = new PropertyModel<Comparable>(o1, String.valueOf(getSort().getProperty()));
            PropertyModel<Comparable> model2 = new PropertyModel<Comparable>(o2, String.valueOf(getSort().getProperty()));


            int result = model1.getObject().compareTo(model2.getObject());

            if (!getSort().isAscending()) {
                result = -result;
            }

            return result;
        }

    }

    private List<Task> list = new ArrayList<Task>();
    private SortableDataProviderComparator comparator = new SortableDataProviderComparator();

    public TaskProvider() {
        // The default sorting
        setSort("deadLine", SortOrder.ASCENDING);

        try {
            list.add(new Task(new SimpleDateFormat("dd.mm.yyyy").parse("13.05.2016"), "Курбатов Максим Сергеевич", "Приехать на встречу"));
            list.add(new Task(new SimpleDateFormat("dd.mm.yyyy").parse("14.05.2016"), "Курбатов Максим Сергеевич", "Просто задача, чтобы показать как выглядит статус \"Просроченная\""));
            list.add(new Task(new SimpleDateFormat("dd.mm.yyyy").parse("15.05.2016"), "Курбатов Максим Сергеевич", "Нарисовать дизайн главной страницы", true));
            list.add(new Task(new SimpleDateFormat("dd.mm.yyyy").parse("16.05.2016"), "Курбатов Максим Сергеевич", "Реализовать дизайн главной страницы", true));
            list.add(new Task(new SimpleDateFormat("dd.mm.yyyy").parse("17.05.2016"), "Курбатов Максим Сергеевич", "Реализовать вторую часть тествого задания"));
            list.add(new Task(new SimpleDateFormat("dd.mm.yyyy").parse("18.05.2016"), "Курбатов Максим Сергеевич", "Сдать тестовое задание в срок"));
            list.add(new Task(new SimpleDateFormat("dd.mm.yyyy").parse("19.05.2016"), "Курбатов Максим Сергеевич", "Поздравить жену с годовщиной"));
            list.add(new Task(new SimpleDateFormat("dd.mm.yyyy").parse("20.05.2016"), "Курбатов Максим Сергеевич", "Купить кошке еды", true));
            list.add(new Task(new SimpleDateFormat("dd.mm.yyyy").parse("21.05.2016"), "Курбатов Максим Сергеевич", "Помочь отцу с ремонтом"));
            list.add(new Task(new SimpleDateFormat("dd.mm.yyyy").parse("22.05.2016"), "Курбатов Максим Сергеевич", "Дочитать книгу"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Iterator<Task> iterator(final int first, final int count) {
        // In this example the whole list gets copied, sorted and sliced; in real applications typically your database would deliver a sorted and limited list

        // Get the data
        List<Task> newList = new ArrayList<Task>(list);

        // Sort the data
        Collections.sort(newList, comparator);

        // Return the data for the current page - this can be determined only after sorting
        return newList.subList(first, first + count).iterator();
    }

    public IModel<Task> model(final Object object) {
        return new AbstractReadOnlyModel<Task>() {
            @Override
            public Task getObject() {
                return (Task) object;
            }
        };
    }

    @Override
    public Iterator iterator(long l, long l1) {
        return list.iterator();
    }

    @Override
    public long size() {
        return list.size();
    }
}
