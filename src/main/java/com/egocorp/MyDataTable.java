package com.egocorp;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;

import java.util.Date;
import java.util.List;

/**
 * Created by FormsDeveloper on 5/18/16.
 */
public class MyDataTable extends DataTable {
    @Override
    protected Item newRowItem(String id, int index, IModel model) {
        Item row = super.newRowItem(id, index, model);
        Task tempTask = (Task) row.getModelObject();
        Date currentDate = new Date();
        if(tempTask.getDeadLine().compareTo(currentDate) < 0)
        {
            if ((currentDate.getTime() - tempTask.getDeadLine().getTime()) < 86400000) // Проверка разницы на соответствие 24 часам
            {
                row.add(new AttributeAppender("class", "warning"));
            }
            else
            {
                row.add(new AttributeAppender("class", "danger"));
            }
        }
        return row;
    }

    @Override
    protected Item<IColumn> newCellItem(String id, int index, IModel model) {
        return super.newCellItem(id, index, model);
    }

    public MyDataTable(String id, List list, IDataProvider dataProvider, long rowsPerPage) {
        super(id, list, dataProvider, rowsPerPage);
    }
}
