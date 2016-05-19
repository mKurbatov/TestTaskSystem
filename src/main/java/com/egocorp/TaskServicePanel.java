package com.egocorp;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * Created by FormsDeveloper on 5/18/16.
 */
public class TaskServicePanel extends Panel {

    public TaskServicePanel(String id, IModel model, final Task task) {
        super(id, model);
        Label label1 = new Label("desc", model);
        add(label1);

        Form form = new Form("doTask"){
            @Override
            protected void onSubmit() {
                task.setDone(true);
            }
        };

        add(form);
    }
}
