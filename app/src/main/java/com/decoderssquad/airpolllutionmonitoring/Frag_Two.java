package com.decoderssquad.airpolllutionmonitoring;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Frag_Two extends Fragment {
    Button btc,btl;

    public Frag_Two() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.activity_frag__two, container, false);

       btc = v.findViewById(R.id.cnnct);
       btl=v.findViewById(R.id.lrn);

       btc.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent activityChangeIntent = new Intent(getActivity().getApplicationContext(), Device.class);
               startActivity(activityChangeIntent);

           }
       });


       btl.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent activityChangeIntent = new Intent(getActivity().getApplicationContext(), Device.class);
               startActivity(activityChangeIntent);

           }
       });




               return v;
    }

}
