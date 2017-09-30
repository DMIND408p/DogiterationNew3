package com.example.deepu.dogwiteration1.DogBodyLanguage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.deepu.dogwiteration1.R;

/**
 * Created by qingyunhe on 23/08/2017.
 */

public class FirstPageForBodyLanguage extends Fragment implements View.OnClickListener {
    View view;
    Button btnSit, btnPlayful, btnStr, btnStand;

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_plant_fragment, menu);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){

        }else {
            getActivity().invalidateOptionsMenu();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.body_language_first_page, container, false);
        setHasOptionsMenu(true);

        btnSit = (Button) view.findViewById(R.id.btnSitting);
        btnSit.setOnClickListener(this);
        btnPlayful = (Button) view.findViewById(R.id.btnHap);
        btnPlayful.setOnClickListener(this);
        btnStr = (Button) view.findViewById(R.id.btnStress);
        btnStr.setOnClickListener(this);
        btnStand = (Button) view.findViewById(R.id.btnOpen);
        btnStand.setOnClickListener(this);
        getActivity().setTitle("Body Language");
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSitting:
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.body_main_page, new SittingDog(), "SittingFragmentTag");
                ft.addToBackStack(null);
                ft.commit();
                break;
            case R.id.btnHap:
                FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                ft1.replace(R.id.body_main_page, new PlayfulDog(), "PlayfulFragmentTag");
                ft1.addToBackStack(null);
                ft1.commit();
                break;
            case R.id.btnStress:
                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                ft2.replace(R.id.body_main_page, new StressedDog(), "NewFragmentTag");
                ft2.addToBackStack(null);
                ft2.commit();
                break;
            case R.id.btnOpen:
                FragmentTransaction ft3 = getFragmentManager().beginTransaction();
                ft3.replace(R.id.body_main_page, new StandBody(), "NewFragmentTag");
                ft3.addToBackStack(null);
                ft3.commit();
                break;
        }
    }
}
