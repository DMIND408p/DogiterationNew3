package com.example.deepu.dogwiteration1.drawerFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.deepu.dogwiteration1.DogBodyLanguage.FirstPageForBodyLanguage;
import com.example.deepu.dogwiteration1.R;

/**
 * Created by qingyunhe on 22/08/2017.
 */

public class Body extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.body, container, false);
        setHasOptionsMenu(true);
        getFragmentManager().beginTransaction().
                add(R.id.body_main_page, new FirstPageForBodyLanguage(), "mainPage").
                commit();
        getActivity().setTitle("Body Language");

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.blank_menu, menu);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){

        }else {
            getActivity().setTitle("Body Language");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_search);
        item.setVisible(false);
    }


}
