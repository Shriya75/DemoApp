package com.farmwiseai.demoapp;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class fragment_2 extends Fragment {

    // Define the Spinner and ArrayAdapter
    private Spinner citySpinner;
    private ArrayAdapter<String> cityAdapter;

    public fragment_2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        // Get the Spinner from the layout
        citySpinner = view.findViewById(R.id.idSpinnerCity);

        // Define an array of cities
        String[] cities = {"Delhi", "Chennai", "Bengaluru", "Mumbai", "Hosur"};

        // Create an ArrayAdapter using the string array and a default spinner layout
        cityAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, cities);

        // Specify the layout to use when the list of choices appears
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        citySpinner.setAdapter(cityAdapter);

        // Get the Register button from the layout
        Button registerButton = view.findViewById(R.id.idBtnRegister);

        // Set an OnClickListener for the Register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the button click here
                // You can add your user registration logic here

                // Display a success message using a Toast
                Toast.makeText(requireContext(), "User registered successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
