//colorA fragment check whether the seleced color is right or wrong
//it decides the points for the game usging point integer

package com.designthepresent.samuvelp.awarns;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorAFragment extends Fragment {
    public static int point =1;  //point integer variable

    public ColorAFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity.backstackCount=1;//for  onBackPressed flag
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_color_a, container, false);
        final TextView TV_c1 = (TextView) view.findViewById(R.id.UI_TV_c1);
        final TextView TV_c2 = (TextView) view.findViewById(R.id.UI_TV_c2);
        final TextView TV_c3 = (TextView) view.findViewById(R.id.UI_TV_c3);
        final TextView TV_c4 = (TextView) view.findViewById(R.id.UI_TV_c4);
        final TextView TV_c5 = (TextView) view.findViewById(R.id.UI_TV_c5);
        final TextView TV_c6 = (TextView) view.findViewById(R.id.UI_TV_c6);
        final TextView TV_c7 = (TextView) view.findViewById(R.id.UI_TV_c7);
        final TextView TV_c8 = (TextView) view.findViewById(R.id.UI_TV_c8);
        final TextView TV_c9 = (TextView) view.findViewById(R.id.UI_TV_c9);

        String colorNames[]={"Red","Pink","Yellow","Black","Blue","Purple","Brown","Green","Orange"};
        final String colorId[]={"#ed4444","#ef39ce","#fde541","#000000","#4286f4","#8a32ef","#9b6f17","#16aa25","#ff5e00"};
        final String colorIdnum[]=new String[9];
        TextView tvs[] ={TV_c1,TV_c2,TV_c3,TV_c4,TV_c5,TV_c6,TV_c7,TV_c8,TV_c9};


            final Integer[] arr = new Integer[9];
            for(int k=0;k<arr.length;k++){
                arr[k]=k;
            }
            Collections.shuffle(Arrays.asList(arr));
            for(int j=0;j<9;j++){
                tvs[j].setText(colorNames[arr[j]]);
                colorIdnum[j]=colorId[arr[j]];
                //tvs[j].setTextColor(Color.parseColor(colorId[arr[j]]));
            }


        TV_c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorQFragment colorQFragment = new ColorQFragment();
                colorQFragment.countDownTimer.cancel();  //canceling the coundowntimer atlast moment if user in COLORQ fragment it tends to navigate user to colorA fragment but it wont have any fragment and leads to mull reference
                int colorQ =MainActivity.bundle.getInt("colorIdq");//getiing color from colorA fragment
                //following code checks whether coloQ color and colorA are same
                if(colorQ==Color.parseColor(colorIdnum[0])){
                    TextView TV_point = (TextView) getActivity().findViewById(R.id.UI_TV_point);
                    int inc=point++;
                    String res =Integer.toString(inc);
                    TV_point.setText(res);
                    // code to go back to colorQfragment
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.UI_fragmentContainer, colorQFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else{
                    StartFragment startFragment = new StartFragment();
                    startFragment.finalCountDownTimer.cancel();
                    startFragment.finalCountDownTimer.onFinish();
                }
            }

        });


        TV_c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorQFragment colorQFragment = new ColorQFragment();
                colorQFragment.countDownTimer.cancel();  //canceling the coundowntimer atlast moment if user in COLORQ fragment it tends to navigate user to colorA fragment but it wont have any fragment and leads to mull reference
                int colorQ =MainActivity.bundle.getInt("colorIdq");//getiing color from colorA fragment
                //following code checks whether coloQ color and colorA are same
                if(colorQ==Color.parseColor(colorIdnum[1])){
                    TextView TV_point = (TextView) getActivity().findViewById(R.id.UI_TV_point);
                    int inc=point++;
                    String res =Integer.toString(inc);
                    TV_point.setText(res);
                    // code to go back to colorQfragment
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.UI_fragmentContainer, colorQFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else{
                    StartFragment startFragment = new StartFragment();
                    startFragment.finalCountDownTimer.cancel();
                    startFragment.finalCountDownTimer.onFinish();
                }
            }
        });
        TV_c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorQFragment colorQFragment = new ColorQFragment();
                colorQFragment.countDownTimer.cancel();  //canceling the coundowntimer atlast moment if user in COLORQ fragment it tends to navigate user to colorA fragment but it wont have any fragment and leads to mull reference
                int colorQ =MainActivity.bundle.getInt("colorIdq");//getiing color from colorA fragment
                //following code checks whether coloQ color and colorA are same
                if(colorQ==Color.parseColor(colorIdnum[2])){
                    TextView TV_point = (TextView) getActivity().findViewById(R.id.UI_TV_point);
                    int inc=point++;
                    String res =Integer.toString(inc);
                    TV_point.setText(res);
                    // code to go back to colorQfragment
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.UI_fragmentContainer, colorQFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else{
                    StartFragment startFragment = new StartFragment();
                    startFragment.finalCountDownTimer.cancel();
                    startFragment.finalCountDownTimer.onFinish();
                }
            }
        });
        TV_c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorQFragment colorQFragment = new ColorQFragment();
                colorQFragment.countDownTimer.cancel();  //canceling the coundowntimer atlast moment if user in COLORQ fragment it tends to navigate user to colorA fragment but it wont have any fragment and leads to mull reference
                int colorQ =MainActivity.bundle.getInt("colorIdq");//getiing color from colorA fragment
                //following code checks whether coloQ color and colorA are same
                if(colorQ==Color.parseColor(colorIdnum[3])){
                    TextView TV_point = (TextView) getActivity().findViewById(R.id.UI_TV_point);
                    int inc=point++;
                    String res =Integer.toString(inc);
                    TV_point.setText(res);
                    // code to go back to colorQfragment
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.UI_fragmentContainer, colorQFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else{
                    StartFragment startFragment = new StartFragment();
                    startFragment.finalCountDownTimer.cancel();
                    startFragment.finalCountDownTimer.onFinish();
                }
            }
        });

        TV_c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorQFragment colorQFragment = new ColorQFragment();
                colorQFragment.countDownTimer.cancel();  //canceling the coundowntimer atlast moment if user in COLORQ fragment it tends to navigate user to colorA fragment but it wont have any fragment and leads to mull reference
                int colorQ =MainActivity.bundle.getInt("colorIdq");//getiing color from colorA fragment
                //following code checks whether coloQ color and colorA are same
                if(colorQ==Color.parseColor(colorIdnum[4])){
                    TextView TV_point = (TextView) getActivity().findViewById(R.id.UI_TV_point);
                    int inc=point++;
                    String res =Integer.toString(inc);
                    TV_point.setText(res);
                    // code to go back to colorQfragment
                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.UI_fragmentContainer, colorQFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
                    else{
                    StartFragment startFragment = new StartFragment();
                    startFragment.finalCountDownTimer.cancel();
                    startFragment.finalCountDownTimer.onFinish();
                     }
                }

        });
        TV_c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorQFragment colorQFragment = new ColorQFragment();
                colorQFragment.countDownTimer.cancel();  //canceling the coundowntimer atlast moment if user in COLORQ fragment it tends to navigate user to colorA fragment but it wont have any fragment and leads to mull reference
                int colorQ =MainActivity.bundle.getInt("colorIdq");//getiing color from colorA fragment
                //following code checks whether coloQ color and colorA are same
                if(colorQ==Color.parseColor(colorIdnum[5])){
                    TextView TV_point = (TextView) getActivity().findViewById(R.id.UI_TV_point);
                    int inc=point++;
                    String res =Integer.toString(inc);
                    TV_point.setText(res);
                    // code to go back to colorQfragment
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.UI_fragmentContainer, colorQFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else{
                    StartFragment startFragment = new StartFragment();
                    startFragment.finalCountDownTimer.cancel();
                    startFragment.finalCountDownTimer.onFinish();
                }
            }
        });
        TV_c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorQFragment colorQFragment = new ColorQFragment();
                colorQFragment.countDownTimer.cancel();  //canceling the coundowntimer atlast moment if user in COLORQ fragment it tends to navigate user to colorA fragment but it wont have any fragment and leads to mull reference
                int colorQ =MainActivity.bundle.getInt("colorIdq");//getiing color from colorA fragment
                //following code checks whether coloQ color and colorA are same
                if(colorQ==Color.parseColor(colorIdnum[6])){
                    TextView TV_point = (TextView) getActivity().findViewById(R.id.UI_TV_point);
                    int inc=point++;
                    String res =Integer.toString(inc);
                    TV_point.setText(res);
                    // code to go back to colorQfragment
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.UI_fragmentContainer, colorQFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else{
                    StartFragment startFragment = new StartFragment();
                    startFragment.finalCountDownTimer.cancel();
                    startFragment.finalCountDownTimer.onFinish();
                }
            }
        });
        TV_c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorQFragment colorQFragment = new ColorQFragment();
                colorQFragment.countDownTimer.cancel();  //canceling the coundowntimer atlast moment if user in COLORQ fragment it tends to navigate user to colorA fragment but it wont have any fragment and leads to mull reference
                int colorQ =MainActivity.bundle.getInt("colorIdq");//getiing color from colorA fragment
                //following code checks whether coloQ color and colorA are same
                if(colorQ==Color.parseColor(colorIdnum[7])){
                    TextView TV_point = (TextView) getActivity().findViewById(R.id.UI_TV_point);
                    int inc=point++;
                    String res =Integer.toString(inc);
                    TV_point.setText(res);
                    // code to go back to colorQfragment
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.UI_fragmentContainer, colorQFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else{
                    StartFragment startFragment = new StartFragment();
                    startFragment.finalCountDownTimer.cancel();
                    startFragment.finalCountDownTimer.onFinish();
                }
            }
        });
        TV_c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorQFragment colorQFragment = new ColorQFragment();
                colorQFragment.countDownTimer.cancel();  //canceling the coundowntimer atlast moment if user in COLORQ fragment it tends to navigate user to colorA fragment but it wont have any fragment and leads to mull reference
                int colorQ =MainActivity.bundle.getInt("colorIdq");//getiing color from colorA fragment
                //following code checks whether coloQ color and colorA are same
                if(colorQ==Color.parseColor(colorIdnum[8])){
                    TextView TV_point = (TextView) getActivity().findViewById(R.id.UI_TV_point);
                    int inc=point++;
                    String res =Integer.toString(inc);
                    TV_point.setText(res);
                    // code to go back to colorQfragment
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.UI_fragmentContainer, colorQFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else{
                    StartFragment startFragment = new StartFragment();
                    startFragment.finalCountDownTimer.cancel();
                    startFragment.finalCountDownTimer.onFinish();
                }
            }
        });
        return view;
    }

}
