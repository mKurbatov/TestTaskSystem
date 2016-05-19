package com.egocorp;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilterStateLocator;
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
public class TaskProvider extends SortableDataProvider implements IFilterStateLocator<TaskFilter> {

    private static List<Task> list = new ArrayList<>();
    private SortableDataProviderComparator comparator = new SortableDataProviderComparator();
    private TaskFilter taskFilter = new TaskFilter();

    public TaskProvider() {
        // The default sorting
        setSort("deadLine", SortOrder.ASCENDING);
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

    class SortableDataProviderComparator implements Comparator<Task>, Serializable {
        public int compare(final Task o1, final Task o2) {

            PropertyModel<Comparable> model1 = new PropertyModel<>(o1, String.valueOf(getSort().getProperty()));
            PropertyModel<Comparable> model2 = new PropertyModel<>(o2, String.valueOf(getSort().getProperty()));

            int result = model1.getObject().compareTo(model2.getObject());

            if (!getSort().isAscending()) {
                result = -result;
            }

            return result;
        }

    }

    public Iterator<Task> iterator(final int first, final int count) {
        // In this example the whole list gets copied, sorted and sliced; in real applications typically your database would deliver a sorted and limited list


        // Get the data
        List<Task> newList = new ArrayList<>(list);

        //Filter the data
        newList = filterList(newList);
        int newCount = count > newList.size() ? newList.size() : count;

        // Sort the data
        Collections.sort(newList, comparator);

        // Return the data for the current page - this can be determined only after sorting
        return newList.subList(first, first + newCount).iterator();
    }

    private List<Task> filterList(List<Task> l)
    {
        List<Task> result = new ArrayList<>();
        for(Task t : l) {
            if (taskFilter.getDateFrom() != null && t.getDeadLine().before(taskFilter.getDateFrom())) {
                continue;
            }

            if (taskFilter.getDateTo() != null && t.getDeadLine().after(taskFilter.getDateTo()))
            {
                continue;
            }

            if(!taskFilter.isShowDone() && t.isDone())
            {
                continue;
            }

            if(taskFilter.getAuthorName() != null && !t.getAuthor().toLowerCase().contains(taskFilter.getAuthorName().toLowerCase()))
            {
                continue;
            }

            if(taskFilter.getDescription() != null && !t.getDescription().toLowerCase().contains(taskFilter.getDescription().toLowerCase()))
            {
                continue;
            }

            result.add(t);
        }
        return result;
    }

    public IModel<Task> model(final Object object) {
        return new AbstractReadOnlyModel<Task>() {
            @Override
            public Task getObject() {
                return (Task) object;
            }
        };
    }

    public static List<Task> getList()
    {
        return list;
    }

    @Override
    public Iterator iterator(long l, long l1) {
        return iterator((int) l, (int) l1);
    }

    @Override
    public long size() {
        return list.size();
    }

    @Override
    public TaskFilter getFilterState() {
        return taskFilter;
    }

    @Override
    public void setFilterState(TaskFilter taskFilter) {
        this.taskFilter = taskFilter;
    }
}
