package com.example.deepu.dogwiteration1.DogBodyLanguage;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.deepu.dogwiteration1.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class StandBody extends Fragment {

    private RadioGroup rdGrp1;
    private ImageView imGrp1;
    private Integer[] photos = {R.drawable.alert, R.drawable.relaxed, R.drawable.suspicious, R.drawable.curious};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_stand_body, container, false);
        this.imGrp1 = (ImageView) v.findViewById(R.id.imageView6);
        this.rdGrp1 = (RadioGroup) v.findViewById(R.id.radioStandGroup);
        this.rdGrp1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton radioButton = (RadioButton) radioGroup.findViewById(i);
                int index = radioGroup.indexOfChild(radioButton);
                imGrp1.setImageResource(photos[index]);
            }
        });
        getActivity().setTitle("Standing Language");
        return v;

    }

}
