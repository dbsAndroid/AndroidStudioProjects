package com.dbs.iveagh.cryptosync;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

public class LoginScreen extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);

        final EditText uname = (EditText) findViewById(R.id.username_edittext);
        final EditText passwd = (EditText) findViewById(R.id.password_edittext);

        final Button loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                if (checkPassword(uname.getText(), passwd.getText())) {

                    // Create an explicit Intent for starting the HelloAndroid
                    // Activity
                    Intent helloAndroidIntent = new Intent(LoginScreen.this,
                            HelloAndroid.class);

                    // Use the Intent to start the HelloAndroid Activity
                    startActivity(helloAndroidIntent);
                } else {
                    uname.setText("");
                    passwd.setText("");
                }
            }
        });

        final Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                // Create an explicit Intent for starting the Registration Screen
                Intent registerIntent = new Intent(LoginScreen.this, RegistrationScreen.class);

                // Use the Intent to start the HelloAndroid Activity
                startActivity(registerIntent);
            }
        });

        //try some registration
        final Button regBtn = (Button) findViewById(R.id.regBtn);
        regBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent regPageIntent = new Intent(LoginScreen.this, RegistrationPage.class);

                //start Activity by using Intent regRage
                startActivity(regPageIntent);
            }
        });



        //final EditText btnTxt = "that button was clicked";
        //
        final EditText editText = (EditText) findViewById(R.id.editText);
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                //try to find output text pane
                //findViewById(R.id.editText);
                button.setText("got Pressed");
                editText.setText("That was one serious button today" +
                        "and I've had fun " +
                        "/n to be sure");
            }
        });

        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        final ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (toggleButton.isChecked()) {
                    toggleButton.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                else {
                    toggleButton.setBackgroundColor(getResources().getColor(R.color.lime));
                    editText2.setTextColor(getResources().getColor(R.color.green));
                    editText2.setText("that was greeny" +
                            "what else to do?");
                    editText2.setBackgroundColor(getResources().getColor(R.color.aqua));
                }
            }
        });

    }

    private boolean checkPassword(Editable uname, Editable passwd) {
        // Just pretending to extract text and check password
        return new Random().nextBoolean();
    }
}
