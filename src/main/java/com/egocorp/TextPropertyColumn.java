package com.egocorp;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

/**
 * Created by maxim on 5/19/16.
 */
public class TextPropertyColumn extends PropertyColumn {
    public TextPropertyColumn(IModel displayModel, Object sortProperty, String propertyExpression) {
        super(displayModel, sortProperty, propertyExpression);
    }

    public TextPropertyColumn(IModel displayModel, String propertyExpression) {
        super(displayModel, propertyExpression);
    }

    @Override
    public void populateItem(Item item, String componentId, IModel rowModel) {
        IModel model = this.getDataModel(rowModel);
        Task task = (Task) rowModel.getObject();
        if(!model.toString().contains("description")) {
            item.add(new Component[]{new PLabel(componentId, model, true)});
        }
        else
        {
            if(!task.isDone()) {
                item.add(new Component[]{new TaskServicePanel(componentId, model, task)});
            }
            else {
                item.add(new Component[]{new PLabel(componentId, model, task.isDone())});
            }
        }
    }
}
