package com.example.mechuand.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mechuand.R
import com.example.mechuand.vo.StoreDetailVO

class StoreDetailAdapter : RecyclerView.Adapter<StoreDetailAdapter.StoreDetailViewHolder>() {

    private var storeDetailList: ArrayList<StoreDetailVO> = ArrayList()

    fun setList(list: ArrayList<StoreDetailVO>) {
        storeDetailList = list
        notifyDataSetChanged()
    }

    fun addStoreDetail(dto: StoreDetailVO) {
        storeDetailList.add(dto)
        notifyDataSetChanged()
    }

    fun setStoreDetail(position: Int, dto: StoreDetailVO) {
        storeDetailList[position] = dto
        notifyDataSetChanged()
    }

    fun getStoreDetail(position: Int): StoreDetailVO {
        return storeDetailList[position]
    }

    inner class StoreDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //private val dNumTv: TextView = itemView.findViewById(R.id.dNum)
        private val premiumTv: TextView = itemView.findViewById(R.id.premiumTv)
        private val categoryTv: TextView = itemView.findViewById(R.id.categoryTv)
        private val offDayTv: TextView = itemView.findViewById(R.id.offDayTv)
        private val sNumTv: TextView = itemView.findViewById(R.id.sNum)

        fun bind(storeDetailVO: StoreDetailVO) {
            //dNumTv.text = storeDetailVO.dNum.toString()
            premiumTv.text = storeDetailVO.premium
            categoryTv.text = storeDetailVO.category
            offDayTv.text = storeDetailVO.offDay
            sNumTv.text = storeDetailVO.sNum.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreDetailViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_store_detail, parent, false)
        return StoreDetailViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StoreDetailViewHolder, position: Int) {
        val storeDetailVO = storeDetailList[position]
        holder.bind(storeDetailVO)
    }

    override fun getItemCount(): Int {
        return storeDetailList.size
    }
}
