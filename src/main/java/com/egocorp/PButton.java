package com.egocorp;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * Created by FormsDeveloper on 5/18/16.
 */
public class PButton extends Panel {
    public PButton(String id, IModel model) {
        super(id, model);
        Label label1 = new Label(id + "1", model);
        add(label1);
    }
}
