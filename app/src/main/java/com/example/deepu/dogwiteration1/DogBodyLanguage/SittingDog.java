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
public class SittingDog extends Fragment {

    private RadioGroup rdGrp2;
    private ImageView imGrp2;
    private Integer []photos = { R.drawable.hostile,R.drawable.feedme,R.drawable.dlike,R.drawable.respect};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sitting_dog, container, false);
        this.imGrp2 = (ImageView) v.findViewById(R.id.imageView12);
        this.rdGrp2 = (RadioGroup) v.findViewById(R.id.sitGrp);
        this.rdGrp2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton radioButton = (RadioButton) radioGroup.findViewById(i);
                int index = radioGroup.indexOfChild(radioButton);
                imGrp2.setImageResource(photos[index]);


            }
        });
        getActivity().setTitle("Sitting Body Language");
        return v;

    }

}
