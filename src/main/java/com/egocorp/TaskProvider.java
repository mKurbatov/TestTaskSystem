package com.egocorp;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilterStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import java.io.Serializable;
import java.util.*;

/**
 * Created by FormsDeveloper on 5/17/16.
 */
public class TaskProvider extends SortableDataProvider implements IFilterStateLocator<TaskFilter> {
    @Override
    public TaskFilter getFilterState() {
        return taskFilter;
    }

    @Override
    public void setFilterState(TaskFilter taskFilter) {
        this.taskFilter = taskFilter;
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

    private List<Task> list = Task.getTasks();
    private SortableDataProviderComparator comparator = new SortableDataProviderComparator();
    private TaskFilter taskFilter = new TaskFilter();

    public TaskProvider() {
        // The default sorting
        setSort("deadLine", SortOrder.ASCENDING);
    }

    public Iterator<Task> iterator(final int first, final int count) {
        // In this example the whole list gets copied, sorted and sliced; in real applications typically your database would deliver a sorted and limited list


        // Get the data
        List<Task> newList = new ArrayList<>(list);

        //Filter the data
        newList = (List<Task>) filterList(newList).subList(first, (first + count)).iterator();

        // Sort the data
        Collections.sort(newList, comparator);

        // Return the data for the current page - this can be determined only after sorting
        return newList.subList(first, first + count).iterator();
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

    @Override
    public Iterator iterator(long l, long l1) {
        return iterator((int) l, (int) l1);
    }

    @Override
    public long size() {
        return list.size();
    }
}
