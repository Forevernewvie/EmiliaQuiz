package com.example.firstapp.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.myApp

class RecyclerAdapter(val contentList:ArrayList<contentData>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    lateinit var view : View
    lateinit var navController: NavController
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.layout_recyclerview_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.num.text = contentList.get(position).num.toString()
        holder.thumnail.setImageResource(contentList.get(position).img)
        holder.question.text = contentList.get(position).question
        holder.correct.setImageResource(contentList.get(position).O_Img)
        holder.incorrect.setImageResource(contentList.get(position).X_Imag)
        holder.check.text = contentList.get(position).check.toString()
        holder.correct.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                onClickCorrect(position)
            }
        })

        holder.incorrect.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                onClickInCorrect(position)
            }
        })

    }

    override fun getItemCount(): Int {
        return contentList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val num = itemView.findViewById<TextView>(R.id.q_Num) //질문번호
        val thumnail = itemView.findViewById<ImageView>(R.id.e_Image) //질문 이미지
        val question = itemView.findViewById<TextView>(R.id.question) // 질문
        val correct = itemView.findViewById<ImageView>(R.id.o) //o
        val incorrect = itemView.findViewById<ImageView>(R.id.x) //x
        val check = itemView.findViewById<TextView>(R.id.check)
    }

    fun onClickCorrect(position: Int) {

        if (contentList.get(position).check == true && contentList.size==1 ) {
            removeRecyclerViewData(position)
            navController = Navigation.findNavController(view)
            navController.navigate(R.id.action_questionFragment_to_answerFragment)
        }

        else if (contentList.get(position).check == true) {
            removeRecyclerViewData(position)

        } else {
            customToastView()
        }
    }
    fun onClickInCorrect(position: Int) {
        if (contentList.get(position).check == false && contentList.size.equals(1) ) {
            removeRecyclerViewData(position)
            navController = Navigation.findNavController(view)
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
        var img_View =
            LayoutInflater.from(myApp.instance).inflate(R.layout.custom_toast_layout, null)
        toast.view = img_View
        toast.show()
    }

    fun removeRecyclerViewData(position: Int){
        contentList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, contentList.size)
    }

}