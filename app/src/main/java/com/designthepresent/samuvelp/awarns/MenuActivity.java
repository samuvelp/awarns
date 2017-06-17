package com.designthepresent.samuvelp.awarns;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
public static MediaPlayer menuSOng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        menuSOng = MediaPlayer.create(MenuActivity.this,R.raw.bensoundenergy);
        menuSOng.start();

        Button BTN_playMenu = (Button) findViewById(R.id.UI_BTN_playmain);
        BTN_playMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                //finish();
            }
        });
        Button BTN_insta = (Button) findViewById(R.id.UI_BTN_insta);
        BTN_insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/imdesigning"));
                startActivity(intent);
            }
        });
        Button BTN_howto = (Button) findViewById(R.id.UI_BTN_HowTO);
        BTN_howto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,HowToActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        menuSOng.pause();
       // menuSOng=null;
        super.onPause();
    }

    @Override
    protected void onPostResume() {
        menuSOng.start();
        super.onPostResume();
    }
}

