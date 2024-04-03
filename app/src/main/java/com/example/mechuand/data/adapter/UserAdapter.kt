package com.example.mechuand.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mechuand.R
import com.example.mechuand.data.dto.UserDTO

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    private var list:ArrayList<UserDTO> = ArrayList<UserDTO>()
    fun setList(list: ArrayList<UserDTO>): Unit {this.list = list}


    fun addUser(dto: UserDTO){list.add(dto); notifyDataSetChanged()}

    fun setUser(position: Int, dto: UserDTO){list.set(position, dto); notifyDataSetChanged()}

    fun getUser(position: Int):UserDTO{return list.get(position)}


    inner class UserViewHolder(private val userView: View) : RecyclerView.ViewHolder(userView) {
        val uNumTv: TextView = userView.findViewById(R.id.uNumTv)
        val uIdTv: TextView = userView.findViewById(R.id.uIdTv)
        val uBirthTv: TextView = userView.findViewById(R.id.uBirthTv)
        val uEmailTv: TextView = userView.findViewById(R.id.uEmailTv)
        val uGenderTv: TextView = userView.findViewById(R.id.uGenderTv)
        val uMobileTv: TextView = userView.findViewById(R.id.uMobileTv)
        val uNameTv: TextView = userView.findViewById(R.id.uNameTv)
        val uPwTv: TextView = userView.findViewById(R.id.uPwTv)


        fun setUser(dto: UserDTO): Unit {
            uNumTv.text =dto.uNum.toString()
            uIdTv.text =dto.uId
            uBirthTv.text =dto.uBirth.toString()
            uEmailTv.text =dto.uEmail
            uGenderTv.text =dto.uGender
            uMobileTv.text =dto.uMobile
            uNameTv.text =dto.uName
            uPwTv.text =dto.uPw
        }

    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_user, parent, false)
        return UserViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val userDTO = list.get(position)
        holder.setUser(userDTO)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}