package com.example.deepu.dogwiteration1.PlantRelevant;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deepu.dogwiteration1.R;

/**
 * Created by qingyunhe on 20/08/2017.
 */

public class NonToxicPlantHolder {
    TextView nameText;
    ImageView img;

    public NonToxicPlantHolder(View itemView) {
        nameText = (TextView) itemView.findViewById(R.id.nonToxicPlantNameText);
        img = (ImageView) itemView.findViewById(R.id.nonToxicPlantImage);
    }
}
