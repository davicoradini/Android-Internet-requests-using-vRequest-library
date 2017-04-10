package com.andyfriends.usingvrequest;

import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.andyfriends.vrequest.IVRequestLoad;

/**
 * Testing the implementation of {@link IVRequestLoad}
 *
 *  We want to use it to automate the pagination using some sort of
 *  list like {@link ListView} or {@link RecyclerView}
 */
public class FlaskRequestLoadConf<T> implements IVRequestLoad<T> {

    private String baseUrl;
    private int page;

    public FlaskRequestLoadConf(String baseUrl) {
        this.baseUrl = baseUrl;
        page = 1;
    }

    @Override
    public String getUrl() {
        return baseUrl;
    }

    @Override
    public void onSuccessListener(T response) {
        page++;
    }

}
