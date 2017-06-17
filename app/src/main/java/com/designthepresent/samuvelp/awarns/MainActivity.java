package com.designthepresent.samuvelp.awarns;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends FragmentActivity   {
public static Bundle bundle = new Bundle();
public static int backstackCount=0;
public static int onpause_flag=0;
public static MediaPlayer mainMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainMediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.bensoundepic);

                StartFragment startFragment = new StartFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.UI_fragmentContainer,startFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


        //starting startfragment from mainactivity


    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount()==backstackCount){
            this.finish();
        }
      //else getFragmentManager().popBackStack();
    }

   @Override
    protected void onPause() {
        StartFragment startFragment = new StartFragment();
        if(startFragment.millisUntilFinished_Start>0){
            onpause_flag=1;
            startFragment.finalCountDownTimer.cancel();
            startFragment.finalCountDownTimer.onFinish();
            startFragment.millisUntilFinished_Start=0;
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        ColorAFragment colorAFragment = new ColorAFragment();
        colorAFragment.point=1;
        TextView TV_point = (TextView) findViewById(R.id.UI_TV_point);
        TV_point.setText("0");
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(fragmentManager.getBackStackEntryCount()==0){
            startActivity(new Intent(MainActivity.this,MenuActivity.class));
        }
        super.onResume();
    }
}
