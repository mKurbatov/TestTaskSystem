package com.egocorp;

import org.apache.wicket.extensions.markup.html.repeater.data.table.*;
import org.apache.wicket.model.*;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		//add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

		// TODO Add your page's components here
		final TaskProvider taskProvider = new TaskProvider();

        List<IColumn> columns = new ArrayList<>();
        columns.add(new MyPropertyColumn(new Model("Срок выполнения"), "deadLine", "deadLine"));
        columns.add(new MyPropertyColumn(new Model("Ф.И.О. автора"), "author", "author"));
        columns.add(new MyPropertyColumn(new Model("Описание"), "description"));

        MyDataTable table = new MyDataTable("datatable", columns, taskProvider, 10);

        table.addTopToolbar(new HeadersToolbar<>(table, taskProvider));

        add(table);

    }
}
