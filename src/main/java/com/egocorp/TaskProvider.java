package com.egocorp;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import java.io.Serializable;
import java.util.*;

/**
 * Created by FormsDeveloper on 5/17/16.
 */
public class TaskProvider extends SortableDataProvider {
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

    public TaskProvider() {
        // The default sorting
        setSort("deadLine", SortOrder.ASCENDING);
    }

    public Iterator<Task> iterator(final int first, final int count) {
        // In this example the whole list gets copied, sorted and sliced; in real applications typically your database would deliver a sorted and limited list


        // Get the data
        List<Task> newList = new ArrayList<>(list);

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
        return iterator((int) l, (int) l1);
    }

    @Override
    public long size() {
        return list.size();
    }
}
