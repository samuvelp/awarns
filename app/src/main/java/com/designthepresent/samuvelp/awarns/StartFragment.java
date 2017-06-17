//startfragment is the gateway opened to start the game
//it runs the countdown timer for almost 45sec
//it points to ColorQFragment
// onFinish() it remove all the fragment from the stack and publish the result
package com.designthepresent.samuvelp.awarns;


import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;


/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {
    //declaring TextSwitcher object reference, TextSwitcher helps to change its property at any time here I changed its color when time is less than 10
    TextSwitcher TVS_timer;
    TextView TV_timer;
    public  static CountDownTimer finalCountDownTimer;
    public static long millisUntilFinished_Start;
    public static MediaPlayer countdownMP;
    public StartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        //start image view reference
        ImageView img_start = (ImageView) view.findViewById(R.id.UI_img_play);

        countdownMP = MediaPlayer.create(getActivity(),R.raw.countdown);

        // image on click listener
        img_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MainActivity mainActivity = new MainActivity();
                mainActivity.mainMediaPlayer.start();

                final ColorQFragment colorQFragment = new ColorQFragment();
                FragmentManager fragmentManager = getFragmentManager();
                final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.UI_fragmentContainer,colorQFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                TVS_timer = (TextSwitcher) getActivity().findViewById(R.id.UI_TV_timer);

                TVS_timer.setFactory(new ViewSwitcher.ViewFactory() {
                    @Override
                    public View makeView() {
                        TextView textView = new TextView(getContext());
                        textView.setLayoutParams(new TextSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

                        textView.setTextSize(28);
                        textView.setHint("10");

                        textView.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
                        return textView;
                    }
                });
                //countdown timer for 30 seconds starts
                finalCountDownTimer= new CountDownTimer(30000,1000){

                    @Override
                    public void onTick(long millisUntilFinished) { //keeps on updating the coundowntime

                        millisUntilFinished_Start=millisUntilFinished;
                        TV_timer = (TextView) TVS_timer.getChildAt(0);
                        if(millisUntilFinished<=10000) {TV_timer.setTextColor(Color.RED);
                            //MainActivity.mainMediaPlayer.pause();
                            countdownMP.start();}
                        TV_timer.setText(""+(millisUntilFinished)/1000);
                    }

                    @Override
                    public void onFinish() {
                        countdownMP.pause();
                        mainActivity.mainMediaPlayer.pause();

                        colorQFragment.countDownTimer.cancel(); //cancel the COLORQ fragment's countdowntime if it was started
                        TV_timer.setText("0");
                        FragmentManager fm = getActivity().getSupportFragmentManager();
                        //pops all the fragment in stack
                        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                            fm.popBackStack();
                        }
                        ColorAFragment colorAFragment = new ColorAFragment();
                        int final_point = colorAFragment.point;

                        String score;
                        if(final_point>0)
                            score = Integer.toString(final_point-1);
                        else score = Integer.toString(final_point);

                        MainActivity mainActivity = new MainActivity();
                        if(mainActivity.onpause_flag==0) {
                            Intent intent = new Intent(getActivity(), PopUpAcrivity.class);

                            if (millisUntilFinished_Start <= 1999) {
                                intent.putExtra("wrongNtime", "Times Up..Bruh!");
                            } else intent.putExtra("wrongNtime", "You were wrong..!");
                            intent.putExtra("finalPoint", score);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            mainActivity.finish();
                        }
                       // Toast.makeText(getActivity(),score,Toast.LENGTH_LONG).show();
                        colorAFragment.point=0;
                        MainActivity.backstackCount=0;//for  onBackPressed flag
                        millisUntilFinished_Start=0;
                    }
                }.start();
            }
        });

        return  view;
    }

}
