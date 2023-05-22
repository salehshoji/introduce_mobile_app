package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView image = (ImageView) findViewById(R.id.image_view);
        image.setClipToOutline(true);
        TextView tv = (TextView) findViewById(R.id.name_TV);
        if (tv.getText().length() > 17){
            tv.setText(tv.getText().subSequence(0, 15) + "...");
        }

    }

}
