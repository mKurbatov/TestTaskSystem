package com.egocorp;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.extensions.markup.html.repeater.data.table.*;
import org.apache.wicket.model.*;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

        List<IColumn> columns = new ArrayList<>();
        columns.add(new PropertyColumn(new Model("Срок выполнения"), "deadLine", "deadLine"));
        columns.add(new PropertyColumn(new Model("Ф.И.О. автора"), "author", "author"));
        columns.add(new PropertyColumn(new Model("Описание"), "description"));

        DefaultDataTable table = new DefaultDataTable("datatable", columns, taskProvider, 10);

        add(table);

       
    }
}
