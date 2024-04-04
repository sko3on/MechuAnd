package com.example.mechuand.data.test_retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechuand.data.dto.UserDTO
import com.example.mechuand.databinding.ListUserBinding

class MyViewHolder(val binding: ListUserBinding) : RecyclerView.ViewHolder(binding.root)

class MyAdapter(val ctx: Context, val datas: MutableList<UserDTO>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return datas?.size ?: 0  // ?: 왼쪽값이 널이 아니면 값, 널이면 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder(ListUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        val model = datas!![position]
        binding.uNumTv.text = model.uNum.toString()
        binding.uIdTv.text = model.uId
        binding.uPwTv.text = model.uPw
        binding.uBirthTv.text = model.uBirth.toString()
        binding.uEmailTv.text = model.uEmail
        binding.uGenderTv.text = model.uGender
        binding.uNameTv.text = model.uName
        binding.uMobileTv.text = model.uMobile
    }
}









