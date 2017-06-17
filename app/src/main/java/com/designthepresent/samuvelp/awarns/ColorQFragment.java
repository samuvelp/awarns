//on ColorQfragment pops the different color questions
//it will replace new fragment if exceeds one sec using countdowntimer
//it will replace new fragment less than one sec by onClicking
package com.designthepresent.samuvelp.awarns;


import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorQFragment extends Fragment {
public static CountDownTimer countDownTimer;

    public ColorQFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        MainActivity.backstackCount=1;//for  onBackPressed flag
        View view = inflater.inflate(R.layout.fragment_color_q, container, false);
        TextView TV_colorQ = (TextView) view.findViewById(R.id.UI_TV_colorq);
        //write code to allocate different colornames and colorcid using random starts
        final String colorNames[]={"Orange","Brown","Yellow","Green","Blue","Pink","Purple","Black","Red"};
        final String colorId[]={"#ff5e00","#9b6f17","#fde541","#16aa25","#4286f4","#ef39ce","#8a32ef","#000000","#ed4444"};
        //Random class to generate random color and names
        Random randomNames = new Random();
        Random randomColorId = new Random();

        final int colorNames_num= randomNames.nextInt((8-0)+1)+0;
        final int colorid_num=randomColorId.nextInt((8-0)+1)+0;//index number of colorId use random class to generate random Id

        TV_colorQ.setText(colorNames[colorNames_num]);
        TV_colorQ.setTextColor(Color.parseColor(colorId[colorid_num]));

        //write code to allocate different colornames and colorcid using random ends

         countDownTimer=new CountDownTimer(1000,1000){ //coundown timer to navigate to colorA fragment

            @Override
            public void onTick(long millisUntilFinished) {
                //MainActivity.backstackCount=1;//for  onBackPressed flag

                Fragment f = getFragmentManager().findFragmentById(R.id.UI_fragmentContainer);
                if(f==null)countDownTimer.cancel();
            }

            @Override
            public void onFinish() {

                ColorAFragment colorAFragment = new ColorAFragment();
                MainActivity.bundle.putInt("colorIdq", Color.parseColor(colorId[colorid_num]));


                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.UI_fragmentContainer, colorAFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();


            }
        }.start();


        TV_colorQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  //onClick to navigate to ColorA fragment



                ColorAFragment colorAFragment = new ColorAFragment();
                MainActivity.bundle.putInt("colorIdq",Color.parseColor(colorId[colorid_num]));

                    FragmentManager fragmentManager = getFragmentManager();

                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.UI_fragmentContainer, colorAFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                countDownTimer.cancel(); //if onclicked then cancel the countdown timer

            }
        });


        return  view;
    }

}
