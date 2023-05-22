package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "welcome to saleh app", Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "welcome to saleh app", Toast.LENGTH_LONG).show();

        ImageView image = (ImageView) findViewById(R.id.image_view);
        image.setClipToOutline(true);
        TextView tv = (TextView) findViewById(R.id.name_textview);
        if (tv.getText().length() > 17){
            tv.setText(tv.getText().subSequence(0, 15) + "...");
        }

        // call button
        Button call_button = (Button) findViewById(R.id.call_button);
        call_button.setOnClickListener(arg -> {
            checkPermission(Manifest.permission.CALL_PHONE, 1);
            // getting phone number from edit text and changing it to String
            String phone_number = "09381009650";
            // Getting instance of Intent with action as ACTION_CALL
            Intent phone_intent = new Intent(Intent.ACTION_CALL);

            // Set data of Intent through Uri by parsing phone number
            phone_intent.setData(Uri.fromParts("tel", phone_number, null));

            // start Intent
            startActivity(phone_intent);
        });

        // email button
        Button email_button = (Button) findViewById(R.id.email_button);
        email_button.setOnClickListener(view -> {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("plain/text");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "mohamadsaleh.shojai@gmail.com" });
            startActivity(Intent.createChooser(intent, "to app owner"));
            // define Intent object with action attribute as ACTION_SEND
        });


    }



    public void checkPermission(String permission, int requestCode)
    {
        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[] { permission }, requestCode);
        }
        else {
            Toast.makeText(MainActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }
}
