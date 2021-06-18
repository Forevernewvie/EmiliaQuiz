package com.example.firstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.CustomToastLayoutBinding
import com.example.firstapp.databinding.LayoutRecyclerviewItemBinding
import com.example.firstapp.fragment.contentData

class RecyclerAdapter(val contentList:ArrayList<contentData>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    lateinit var navController: NavController


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = LayoutRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = contentList[position]

        holder.itembinding.qNum.text = data.num.toString()
        holder.itembinding.question.text = data.question
        holder.itembinding.eImage.setImageResource(data.img)
        holder.itembinding.o.setImageResource(data.O_Img)
        holder.itembinding.x.setImageResource(data.X_Imag)
        holder.itembinding.check.text = data.check.toString()

        holder.itembinding.o.setOnClickListener {
            onClickCorrect(position,it!!)
        }

        holder.itembinding.x.setOnClickListener {
            onClickInCorrect(position,it!!)
        }
    }

    override fun getItemCount(): Int {
        return contentList.size
    }

    class ViewHolder(val itembinding:LayoutRecyclerviewItemBinding) : RecyclerView.ViewHolder(itembinding.root)


    fun onClickCorrect(position: Int, _view: View) {

        if (contentList.get(position).check == true && contentList.size==1 ) {
            removeRecyclerViewData(position)
            navController = Navigation.findNavController(_view)
            navController.navigate(R.id.action_questionFragment_to_answerFragment)
        }

        else if (contentList.get(position).check == true) {
            removeRecyclerViewData(position)

        } else {
            customToastView()
        }
    }
        fun onClickInCorrect(position: Int, _view: View) {
            if (contentList.get(position).check == false && contentList.size.equals(1) ) {
                removeRecyclerViewData(position)
                navController = Navigation.findNavController(_view)
                navController.navigate(R.id.action_questionFragment_to_answerFragment)
            }

            else if (contentList.get(position).check == false) {
                    removeRecyclerViewData(position)
            } else {
                customToastView()
            }
        }

    fun customToastView(){

        val toast = Toast.makeText(myApp.instance, "틀렸어요.", Toast.LENGTH_SHORT)
        var gg = CustomToastLayoutBinding.inflate(LayoutInflater.from(myApp.instance))

        toast.view = gg.root
        toast.show()
    }

    fun removeRecyclerViewData(position: Int){
        contentList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, contentList.size)
    }

}


