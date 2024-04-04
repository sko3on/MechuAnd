package com.example.mechuand.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mechuand.R
import com.example.mechuand.vo.StoreVO

class StoreAdapter : RecyclerView.Adapter<StoreAdapter.StoreViewHolder>() {

    private var storeList: ArrayList<StoreVO> = ArrayList()

    fun setList(list: ArrayList<StoreVO>) {
        storeList = list
        notifyDataSetChanged()
    }

    fun addStore(dto: StoreVO) {
        storeList.add(dto)
        notifyDataSetChanged()
    }

    fun setStore(position: Int, dto: StoreVO) {
        storeList[position] = dto
        notifyDataSetChanged()
    }

    fun getStore(position: Int): StoreVO {
        return storeList[position]
    }

    inner class StoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val sNumTv: TextView = itemView.findViewById(R.id.sNum)
        private val sIdTv: TextView = itemView.findViewById(R.id.sIdTv)
        private val sPwTv: TextView = itemView.findViewById(R.id.sPwTv)
        private val sNameTv: TextView = itemView.findViewById(R.id.sNameTv)
        private val sMobileTv: TextView = itemView.findViewById(R.id.sMobileTv)
        private val businessNumTv: TextView = itemView.findViewById(R.id.businessNumTv)

        fun bind(storeDTO: StoreVO) {
            sNumTv.text = storeDTO.sNum.toString()
            sIdTv.text = storeDTO.sId
            sPwTv.text = storeDTO.sPw
            sNameTv.text = storeDTO.sName
            sMobileTv.text = storeDTO.sMobile
            businessNumTv.text = storeDTO.businessNum
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_store, parent, false)
        return StoreViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val storeDTO = storeList[position]
        holder.bind(storeDTO)
    }

    override fun getItemCount(): Int {
        return storeList.size
    }
}
