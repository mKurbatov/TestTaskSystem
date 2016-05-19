package com.egocorp;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * Created by FormsDeveloper on 5/18/16.
 */
public class TaskDataTable extends DataTable {

    public TaskDataTable(String id, List list, IDataProvider dataProvider, long rowsPerPage) {
        super(id, list, dataProvider, rowsPerPage);
    }

    @Override
    protected Item newRowItem(String id, int index, IModel model) {
        Item row = super.newRowItem(id, index, model);
        Task tempTask = (Task) row.getModelObject();
        String cssClass = null;

        if(tempTask.isDone())
        {
            cssClass = "success";
        }
        else if(tempTask.isOverdue())
        {
            if (tempTask.isInDanger())
            {
                cssClass = "warning";
            }
            else
            {
                cssClass = "danger";
            }
        }

        row.add(new AttributeAppender("class", cssClass));

        return row;
    }
}
