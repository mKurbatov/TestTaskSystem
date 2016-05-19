package com.egocorp;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.Date;

/**
 * Created by FormsDeveloper on 5/18/16.
 */
public class TextLabelPanel extends Panel
{
    public TextLabelPanel(String id, IModel<?> model, boolean done) {
        super(id, model);
        Label text = new Label("text", model);
        String statusText = null;
        String statusCssClass = null;

        if(model.getObject() instanceof Date) {
            Date taskDate = (Date) model.getObject();
            Date currentDate = new Date();

            if(done)
            {
                statusText = "Выполненная";
                statusCssClass = "label label-success";
            }
            else if (taskDate.compareTo(currentDate) < 0) {
                if ((currentDate.getTime() - taskDate.getTime()) < 86400000) {
                    statusText = "Срочная";
                    statusCssClass = "label label-warning";
                } else {
                    statusText = "Просроченная";
                    statusCssClass = "label label-danger";
                }
            }
        }

        Label status = new Label("status", new Model(statusText));
        status.add(new AttributeAppender("class", statusCssClass));

        add(text);
        add(status);
    }
}