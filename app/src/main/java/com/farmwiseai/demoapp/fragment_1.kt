package com.farmwiseai.demoapp;
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.NavDirections

class fragment_1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_1, container, false)

        // create instance of navigate button
        val navigateButton: Button = view.findViewById(R.id.navigate_button)

        // handle the navigate button to navigate to the fragment 2
        navigateButton.setOnClickListener {
            val actionId = R.id.fragment_2 // Replace with the ID of fragment_2.java in your navigation graph
            findNavController().navigate(actionId)
        }

        return view
    }
}