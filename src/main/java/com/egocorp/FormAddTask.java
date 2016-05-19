package com.egocorp;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by FormsDeveloper on 5/19/16.
 */
public class FormAddTask extends Form {

    private String author;
    private String deadLine;
    private String description;

    public FormAddTask(String id) {
        super(id);

        setDefaultModel(new CompoundPropertyModel(this));

        add(new TextField("author"));
        add(new TextField("deadLine"));
        add(new TextArea("description"));
    }

    @Override
    protected final void onSubmit() {
        List<Task> l = Task.getTasks();
        try {
            l.add(new Task(l.size(), new SimpleDateFormat("dd.MM.yyyy").parse(deadLine), author, description));
            deadLine = "";
            author = "";
            description = "";
        } catch (Exception ignore)
        {}
    }
}
