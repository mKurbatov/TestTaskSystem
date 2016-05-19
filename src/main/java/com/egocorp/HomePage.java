package com.egocorp;

import org.apache.wicket.extensions.markup.html.repeater.data.table.*;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterForm;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.TextField;
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
        columns.add(new DatePropertyColumn(new Model("Срок выполнения"), "deadLine", "deadLine"));
        columns.add(new TextPropertyColumn(new Model("Ф.И.О. автора"), "author", "author"));
        columns.add(new TextPropertyColumn(new Model("Описание"), "description"));

        final TaskDataTable table = new TaskDataTable("datatable", columns, taskProvider, 10);
        table.setOutputMarkupId(true);
        table.addTopToolbar(new HeadersToolbar<>(table, taskProvider));

        add(table);

        add(new MyPagingNavigator("navigator", table));

        FilterForm<TaskFilter> filterFormLeft = new FilterForm("filterFormLeft", taskProvider);
        FilterForm<TaskFilter> filterFormDesc = new FilterForm("filterFormDesc", taskProvider);

        TextField dateFrom = new TextField<>("dateFrom", PropertyModel.of(taskProvider, "filterState.dateFrom"));
        TextField dateTo = new TextField<>("dateTo", PropertyModel.of(taskProvider, "filterState.dateTo"));
        TextField authorName = new TextField<>("authorName", PropertyModel.of(taskProvider, "filterState.authorName"));
        CheckBox showDone = new CheckBox("showDone", new PropertyModel<Boolean>(taskProvider, "filterState.showDone"));
        TextField description = new TextField<>("description", PropertyModel.of(taskProvider, "filterState.description"));

        authorName.add(new ChangeBehavior("keyup", table));
        description.add(new ChangeBehavior("keyup", table));
        dateFrom.add(new ChangeBehavior("change", table));
        dateTo.add(new ChangeBehavior("change", table));
        showDone.add(new ChangeBehavior("change", table));

        filterFormLeft.add(dateFrom);
        filterFormLeft.add(dateTo);
        filterFormLeft.add(authorName);
        filterFormLeft.add(showDone);
        filterFormDesc.add(description);
        add(filterFormLeft);
        add(filterFormDesc);

        FormAdd form = new FormAdd("FormAdd");

        add(form);
    }
}
