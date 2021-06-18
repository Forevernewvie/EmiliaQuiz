package com.example.firstapp.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.RecyclerAdapter
import com.example.firstapp.databinding.QuestionfragmentBinding
import com.example.firstapp.myApp

class questionFragment : Fragment() {

    private var mBinding: QuestionfragmentBinding?=null
    private val binding get() = mBinding!!

    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = QuestionfragmentBinding.inflate(inflater,container,false)

        val contentDataArray = arrayListOf(
            contentData(1,"에밀리아는 14살이다.",R.drawable.icon,R.drawable.circle,R.drawable.x,false) ,
            contentData(2,"에밀리아는 예쁘다.",R.drawable.icon,R.drawable.circle,R.drawable.x,true),
            contentData(3,"에밀리아는 마녀다.",R.drawable.icon,R.drawable.circle,R.drawable.x,false),
            contentData(4,"에밀리아는 하프엘프다.",R.drawable.icon,R.drawable.circle,R.drawable.x,true),
            contentData(5,"에키드나는 에밀리아를 싫어한다.",R.drawable.icon,R.drawable.circle,R.drawable.x,true),
            contentData(6,"에밀리아는 팩에게 죽은적이 있다.",R.drawable.icon,R.drawable.circle,R.drawable.x,true),
            contentData(7,"에밀리아의 키는 164cm이다.",R.drawable.icon,R.drawable.circle,R.drawable.x,true),
            contentData(8,"에밀리아는 렘을 기억 한다.",R.drawable.icon,R.drawable.circle,R.drawable.x,false),
        )


        binding.recycle.layoutManager = LinearLayoutManager(myApp.instance)
        binding.recycle.adapter = RecyclerAdapter(contentDataArray)
        binding.recycle.setHasFixedSize(true)

        return binding.root
    }

    override fun onDestroyView() {
        mBinding =null
        super.onDestroyView()
    }
}