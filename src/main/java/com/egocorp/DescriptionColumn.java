package com.egocorp;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

/**
 * Created by maxim on 5/20/16.
 */
public class DescriptionColumn extends PropertyColumn {

    public DescriptionColumn(IModel displayModel, String propertyExpression) {
        super(displayModel, propertyExpression);
    }

    @Override
    public void populateItem(Item item, String componentId, IModel rowModel) {
        IModel model = this.getDataModel(rowModel);
        Task task = (Task) rowModel.getObject();
        Component[] components = new Component[1];
        if(!task.isDone()) {
            components[0] = new CellDataButtonPanel(componentId, model, task);
        }
        else {
            components[0] = new CellDataPanel(componentId, model, task.isDone());
        }
        item.add(components);
    }
}
