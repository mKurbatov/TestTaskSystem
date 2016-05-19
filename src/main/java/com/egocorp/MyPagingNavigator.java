package com.egocorp;

import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.IPagingLabelProvider;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;

/**
 * Created by FormsDeveloper on 5/19/16.
 */
public class MyPagingNavigator extends PagingNavigator {
    public MyPagingNavigator(String id, IPageable pageable) {
        super(id, pageable);
    }

    public MyPagingNavigator(String id, IPageable pageable, IPagingLabelProvider labelProvider) {
        super(id, pageable, labelProvider);
    }
}
