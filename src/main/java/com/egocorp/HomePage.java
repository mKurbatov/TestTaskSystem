package com.egocorp;

import org.apache.wicket.extensions.markup.html.repeater.data.table.*;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.*;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		//add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

		// TODO Add your page's components here
		//add(new Label("version2", "Just some test string"));
        Task task = null;
        try {
            task = new Task(new SimpleDateFormat("dd.MM.yyyy").parse("13.05.2016"), "Kurbatov Maxim", "Test task description");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //setDefaultModel(new CompoundPropertyModel(task));


        final TaskProvider taskProvider = new TaskProvider();

        IColumn[] columns = new IColumn[3];
        columns[0] = new PropertyColumn(new Model("DeadLine"), "deadLine", "deadLine");
        columns[1] = new PropertyColumn(new Model("Author"), "author");
        columns[2] = new PropertyColumn(new Model("Description"), "description");

        DefaultDataTable table = new DefaultDataTable("datatable", columns, taskProvider, 10);

        add(table);

		add(new Label("deadLine", new PropertyModel(task, "deadLine")));
        add(new Label("author", new PropertyModel(task, "author")));
        add(new Label("description", new PropertyModel(task, "description")));
    }
}
