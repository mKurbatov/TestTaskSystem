package com.egocorp;

import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;

/**
 * Created by FormsDeveloper on 5/19/16.
 */
public class BootsrapPagingNavigator extends PagingNavigator {
    public BootsrapPagingNavigator(String id, IPageable pageable) {
        super(id, pageable);
    }
}
