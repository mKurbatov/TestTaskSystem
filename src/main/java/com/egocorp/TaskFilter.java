package com.egocorp;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by maxim on 5/18/16.
 */
public class TaskFilter implements Serializable {
    private Date dateFrom;
    private Date dateTo;
    private String authorName;
    private boolean showDone;

    public void setShowDone(boolean showDone) {
        this.showDone = showDone;
    }

    public boolean isShowDone() {

        return showDone;
    }

    public TaskFilter()
    {}

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {

        return authorName;
    }

    public Date getDateFrom()
    {
        return dateFrom;
    }
    public void setDateFrom(Date dateFrom)
    {
        this.dateFrom = dateFrom;
    }
    public Date getDateTo()
    {
        return dateTo;
    }
    public void setDateTo(Date dateTo)
    {
        this.dateTo = dateTo;
    }
}
