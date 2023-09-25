package com.farmwiseai.demoapp.activity;
import com.farmwiseai.demoapp.R;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView usernameTextView, passwordTextView;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        usernameTextView = findViewById(R.id.usernameTextView);
        passwordTextView = findViewById(R.id.passwordTextView);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);


        // Retrieve and display the saved username and password
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");

        usernameTextView.setText("Username: " + username);
        passwordTextView.setText("Password: " + password);
    }
}
