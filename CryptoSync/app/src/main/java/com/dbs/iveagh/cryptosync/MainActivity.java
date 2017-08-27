package com.dbs.iveagh.cryptosync;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button loginButton = (Button) findViewById(R.id.log_reg_btn);
        loginButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                    // Create an explicit Intent for starting the HelloAndroid
                    // Activity
                    Intent loginScreenIntent = new Intent(MainActivity.this,
                            LoginScreen.class);

                    // Use the Intent to start the HelloAndroid Activity
                    startActivity(loginScreenIntent);
            }
        });
    }
}
