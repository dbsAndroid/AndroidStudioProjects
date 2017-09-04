package com.liberties.iveagh.templatenavdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by iveagh on 03/09/17.
 */
//ImageView iv = (ImageView)findViewById(v);
//        iv.setImageResource(R.drawable.image_name);

public class HelloActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {

        // Required call through to Activity.onCreate()
        // Restore any saved instance state
        super.onCreate(savedInstanceState);

        // Set up the application's user interface (content view)
        setContentView(R.layout.registrationpage);
    }
}