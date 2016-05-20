package com.egocorp;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

/**
 * Created by maxim on 5/19/16.
 */
public class AuthorColumn extends PropertyColumn {
    public AuthorColumn(IModel displayModel, Object sortProperty, String propertyExpression) {
        super(displayModel, sortProperty, propertyExpression);
    }

    public AuthorColumn(IModel displayModel, String propertyExpression) {
        super(displayModel, propertyExpression);
    }

    @Override
    public void populateItem(Item item, String componentId, IModel rowModel) {
        IModel model = this.getDataModel(rowModel);
        item.add(new Component[]{new CellDataPanel(componentId, model, true)});
    }
}
