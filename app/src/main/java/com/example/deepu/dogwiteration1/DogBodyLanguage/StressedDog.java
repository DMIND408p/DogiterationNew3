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
public class StressedDog extends Fragment {


    private RadioGroup rdGrp3;
    private ImageView imGrp3;
    private Integer[] photos3 = {R.drawable.angry, R.drawable.anxious, R.drawable.needspace, R.drawable.nosestrees, R.drawable.stressedyawn, R.drawable.stressscratch, R.drawable.stressrelease, R.drawable.threatened};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_stressed_dog, container, false);
        this.imGrp3 = (ImageView) v.findViewById(R.id.imageView8);
        this.rdGrp3 = (RadioGroup) v.findViewById(R.id.radGrp3);
        this.rdGrp3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton radioButton = (RadioButton) radioGroup.findViewById(i);
                int index = radioGroup.indexOfChild(radioButton);
                imGrp3.setImageResource(photos3[index]);
            }
        });
        getActivity().setTitle("Stressed Language");
        return v;

    }

}
