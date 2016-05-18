package com.egocorp;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import sun.text.normalizer.CharTrie;

/**
 * Created by FormsDeveloper on 5/18/16.
 */
public class MyPropertyColumn extends PropertyColumn {

    public MyPropertyColumn(IModel displayModel, Object sortProperty, String propertyExpression) {
        super(displayModel, sortProperty, propertyExpression);
    }

    public MyPropertyColumn(IModel displayModel, String propertyExpression) {
        super(displayModel, propertyExpression);
    }

    @Override
    public void populateItem(Item item, String componentId, IModel rowModel) {
        IModel model = this.getDataModel(rowModel);
        item.add(new Component[]{new PLabel(componentId)});

    }

    private class PLabel extends Panel
    {

        public PLabel(String id) {
            super(id);
            Label label1 = new Label(id + "1");
            Label label2 = new Label(id + "2");
            add(label1);
            add(label2);
        }

        public PLabel(String id, IModel<?> model) {
            super(id, model);
            Label label1 = new Label(id + "1");
            Label label2 = new Label(id + "2");
            add(label1);
            add(label2);
        }
    }
}
