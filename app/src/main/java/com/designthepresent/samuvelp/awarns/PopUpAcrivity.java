package com.designthepresent.samuvelp.awarns;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PopUpAcrivity extends AppCompatActivity {
    public static String score;
    public static MediaPlayer popUpActivityMP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_acrivity);
        popUpActivityMP = MediaPlayer.create(PopUpAcrivity.this,R.raw.bensoundepic);
        popUpActivityMP.start();
       /* DisplayMetrics displayMetrics =new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        getWindow().setLayout((int)(width*0.8),(int)(height*0.6));*/

        score = getIntent().getExtras().getString("finalPoint");
        String wrongNtime = getIntent().getExtras().getString("wrongNtime");
        TextView TV_finalScore = (TextView) findViewById(R.id.UI_TV_finalPoint);
        TextView TV_wrongNtime = (TextView) findViewById(R.id.UI_TV_wrong);
        TV_finalScore.setText(score);
        TV_wrongNtime.setText(wrongNtime);

        ImageButton IMGbtnplayagain = (ImageButton) findViewById(R.id.UI_IMGbtn_playagain);
        IMGbtnplayagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopUpAcrivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                ColorAFragment colorAFragment = new ColorAFragment();
                colorAFragment.point=1;
            }
        });

        ImageButton IMGbtn_share = (ImageButton) findViewById(R.id.UI_IMGbtn_sharebutton);
        IMGbtn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareSubject="A War nS Game..!";
                String shareBody ="Hey, I have scored "+score+ " points in 'A War nS' android app, its really nice to increase our ability of awareness.Checkout the app link in bio! instagram.com/imDesigning";
                intent.putExtra(Intent.EXTRA_SUBJECT,shareSubject);
                intent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(intent,"Share Via"));
            }
        });
    }



    @Override
    protected void onPause() {
        popUpActivityMP.pause();
        finish();
        super.onPause();
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}
