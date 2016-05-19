package com.egocorp;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;

/**
 * Created by FormsDeveloper on 5/19/16.
 */
public class ChangeBehavior extends AjaxFormComponentUpdatingBehavior {
    private Component comp;
    public ChangeBehavior(String event, Component comp) {
        super(event);
        this.comp = comp;
    }

    @Override
    protected void onUpdate(AjaxRequestTarget ajaxRequestTarget) {
        ajaxRequestTarget.add(comp);
    }

}
