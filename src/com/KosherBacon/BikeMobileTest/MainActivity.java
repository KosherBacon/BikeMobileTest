package com.KosherBacon.BikeMobileTest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        /*
        NEVER EVER EVER EVER EVER EVER EVER have hardcoded username and passwords.

        This is only done for sake of simplicity to quickly prototype this app
         */
        final String username = "kosher@bacon.com";
        final String password = "ilikebacon";

        /*
        EditText fields from the main.xml page to later grab data from
         */
        final EditText usernameField = (EditText) findViewById(R.id.usernameField);
        final EditText passwordField = (EditText) findViewById(R.id.passwordField);

        Button loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usernameField.getText().toString();
                String pass = passwordField.getText().toString();
                if (user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(getBaseContext(), "Complete all fields!", Toast.LENGTH_SHORT).show();
                } else {
                    if (!user.equals(username) || !pass.equals(password)) {
                        Toast.makeText(getBaseContext(), "Invalid username or password!", Toast.LENGTH_SHORT).show();
                    } else {

                    }
                }
            }
        });
    }
}
