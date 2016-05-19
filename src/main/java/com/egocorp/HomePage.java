package com.egocorp;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
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
        columns.add(new MyPropertyColumn(new Model("Срок выполнения"), "deadLine", "deadLine"));
        columns.add(new MyPropertyColumn(new Model("Ф.И.О. автора"), "author", "author"));
        columns.add(new MyPropertyColumn(new Model("Описание"), "description"));

        final MyDataTable table = new MyDataTable("datatable", columns, taskProvider, 10);
        table.setOutputMarkupId(true);
        table.addTopToolbar(new HeadersToolbar<>(table, taskProvider));

        add(table);

        FilterForm<TaskFilter> filterForm = new FilterForm("filterForm", taskProvider);
        FilterForm<TaskFilter> filterForm2 = new FilterForm("filterForm2", taskProvider);

        TextField dateFrom = new TextField<>("dateFrom", PropertyModel.of(taskProvider, "filterState.dateFrom"));
        TextField dateTo = new TextField<>("dateTo", PropertyModel.of(taskProvider, "filterState.dateTo"));
        TextField authorName = new TextField<>("authorName", PropertyModel.of(taskProvider, "filterState.authorName"));
        CheckBox showDone = new CheckBox("showDone", new PropertyModel<Boolean>(taskProvider, "filterState.showDone"));
        TextField description = new TextField<>("description", PropertyModel.of(taskProvider, "filterState.description"));

        authorName.add(new ChangeBehavior("onkeyup", table));
        description.add(new ChangeBehavior("onkeyup", table));
        dateFrom.add(new ChangeBehavior("onchange", table));
        dateTo.add(new ChangeBehavior("onchange", table));
        showDone.add(new ChangeBehavior("onchange", table));

        filterForm.add(dateFrom);
        filterForm.add(dateTo);
        filterForm.add(authorName);
        filterForm.add(showDone);
        filterForm2.add(description);
        add(filterForm);
        add(filterForm2);

    }
}
