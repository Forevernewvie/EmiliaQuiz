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
import com.example.firstapp.databinding.FragmentMainBinding

class MainFragment: Fragment() {

    lateinit var navController: NavController
    private var mBinding : FragmentMainBinding?=null
    private val binding get() = mBinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextBtn.setOnClickListener {
            navController = Navigation.findNavController(view)
            navController.navigate(R.id.action_mainFragment_to_questionFragment)
        }

    }

    override fun onDestroyView() {
        mBinding =null
        super.onDestroyView()
    }
}