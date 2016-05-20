package com.egocorp;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

/**
 * Created by FormsDeveloper on 5/18/16.
 */
public class DateColumn extends PropertyColumn {

    public DateColumn(IModel displayModel, Object sortProperty, String propertyExpression) {
        super(displayModel, sortProperty, propertyExpression);
    }

    @Override
    public void populateItem(Item item, String componentId, IModel rowModel) {
        IModel model = this.getDataModel(rowModel);
        Task task = (Task) rowModel.getObject();
        item.add(new Component[]{new CellDataPanel(componentId, model, task.isDone())});
    }
}
