package com.example.mechuand.data.adapter

import android.view.View

interface OnMemberItemClickHandler {
    fun onItemClick(holder: MemberAdapter.MemberViewHolder, v: View, idx: Int)
}
