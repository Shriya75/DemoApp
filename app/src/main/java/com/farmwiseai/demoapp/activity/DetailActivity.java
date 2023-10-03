package com.farmwiseai.demoapp.activity;

import com.farmwiseai.demoapp.R;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.AdapterView;

import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.content.Intent;

public class DetailActivity extends AppCompatActivity {

    private TextView usernameTextView, passwordTextView;
    private SharedPreferences sharedPreferences;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private Spinner stateSpinner;

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

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get a reference to the Spinner
        stateSpinner = findViewById(R.id.stateSpinner);

        // Create an ArrayAdapter with a list of states
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);

        // Add states to the adapter
        adapter.add("Tamilnadu");
        adapter.add("Karnataka");
        adapter.add("Maharastra");
        adapter.add("Rajasthan");
        adapter.add("Kerela");

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        stateSpinner.setAdapter(adapter);

        // Set an item selected listener for the Spinner
        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Handle the selected state here
                String selectedState = parentView.getItemAtPosition(position).toString();
                // You can perform any actions needed with the selected state.
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle the case when nothing is selected (optional)
            }
        });

        // Add any other code or functionality you need for DetailActivity here
    }

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Add this method to open the MainActivity when needed
    private void openMainActivity() {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }
}
