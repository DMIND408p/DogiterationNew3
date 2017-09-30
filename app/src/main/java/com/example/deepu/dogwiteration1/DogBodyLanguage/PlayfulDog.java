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
public class PlayfulDog extends Fragment {

    private RadioGroup rdGrp4;
    private ImageView imGrp4;
    private Integer []photos4 = { R.drawable.prettyplease,R.drawable.stalking,R.drawable.iloveu,R.drawable.happy,R.drawable.friendlyandpolite,R.drawable.lovebug,R.drawable.overjoyed,R.drawable.friendly,R.drawable.dontstoplove};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_playful_dog, container, false);
        this.imGrp4 = (ImageView) v.findViewById(R.id.imageView7);
        this.rdGrp4 = (RadioGroup) v.findViewById(R.id.rdGrp4);
        this.rdGrp4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton radioButton = (RadioButton) radioGroup.findViewById(i);
                int index = radioGroup.indexOfChild(radioButton);
                imGrp4.setImageResource(photos4[index]);
            }
        });
        getActivity().setTitle("Happy Language");
        return v;
    }


}
