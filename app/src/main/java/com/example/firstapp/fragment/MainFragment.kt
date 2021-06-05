package com.example.firstapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.firstapp.R

class MainFragment: Fragment() {

    lateinit var navController: NavController
    lateinit var next_btn: ImageButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        next_btn=view.findViewById(R.id.next_btn)
        navController =Navigation.findNavController(view)
        next_btn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_questionFragment)


        }

    }


}