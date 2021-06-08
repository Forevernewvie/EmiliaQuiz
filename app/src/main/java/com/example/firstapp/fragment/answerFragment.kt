package com.example.firstapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.firstapp.R

class answerFragment: Fragment() {

    lateinit var navController: NavController
    lateinit var home_Btn: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.answerfragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        home_Btn=view.findViewById(R.id.home_Btn)
        navController =Navigation.findNavController(view)
        home_Btn.setOnClickListener {


            navController.navigate(R.id.action_answerFragment_to_mainFragment)

        }

    }


}