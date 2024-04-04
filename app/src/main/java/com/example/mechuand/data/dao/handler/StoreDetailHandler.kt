package com.example.mechuand.data.dao.handler

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.mechuand.data.dao.DbOpenHelper
import com.example.mechuand.data.dto.StoreDetailDTO
import com.example.mechuand.data.dto.UserDTO

class StoreDetailHandler private constructor(ctx: Context) {
    private val openHelper: DbOpenHelper = DbOpenHelper(ctx, "store_detail.db", null, 1)
    private val sqLiteDatabase: SQLiteDatabase = openHelper.writableDatabase

    companion object {
        private var sqlHandler: StoreDetailHandler? = null
        fun open(ctx: Context): StoreDetailHandler {
            if (sqlHandler == null) {
                sqlHandler = StoreDetailHandler(ctx)
            }
            return sqlHandler as StoreDetailHandler
        }
    }
    fun close(): Unit {openHelper.close()}
    fun insert(dto: StoreDetailDTO): Long{
        val values = ContentValues()
        values.put("dNum",dto.dNum)
        values.put("premium",dto.premium)
        values.put("category",dto.category)
        values.put("offDay",dto.offDay)

        values.put("sNum",dto.sNum)

        return sqLiteDatabase.insert("store_detail", null, values)
    }
    fun update(dto: StoreDetailDTO): Unit {
        val values = ContentValues()
        values.put("dNum",dto.dNum)
        values.put("premium",dto.premium)
        values.put("category",dto.category)
        values.put("offDay",dto.offDay)

        values.put("sNum",dto.sNum)

        sqLiteDatabase.update("store_detail", values, "dNum=?", arrayOf(dto.dNum.toString()))
    }

    fun delete(dNum: Long): Unit {
        sqLiteDatabase.delete("store_detail", "dNum=?", arrayOf(dNum.toString()))
    }
    @SuppressLint("Range")
    fun get(dNum: Long): StoreDetailDTO? {
        val cursor: Cursor = sqLiteDatabase.query(
            "store_detail", null, "dNum=?", arrayOf(dNum.toString()), null, null, null
        )
        return if (cursor.moveToNext()) {
            val dNum = cursor.getLong(cursor.getColumnIndex("dNum"))
            val premium = cursor.getString(cursor.getColumnIndex("premium"))
            val category = cursor.getString(cursor.getColumnIndex("category"))
            val offDay = cursor.getString(cursor.getColumnIndex("offDay"))
            val sNum = cursor.getLong(cursor.getColumnIndex("sNum"))
            StoreDetailDTO(dNum, premium, category, offDay, sNum)
        } else null
    }
    @SuppressLint("Range")
    fun getList(): ArrayList<StoreDetailDTO> {
        var list: ArrayList<StoreDetailDTO> = ArrayList()
        val cursor: Cursor = sqLiteDatabase.query(
            "store_detail", null, null, null, null, null, null
        )
        while (cursor.moveToNext()) {
            val dNum = cursor.getLong(cursor.getColumnIndex("dNum"))
            val premium = cursor.getString(cursor.getColumnIndex("premium"))
            val category = cursor.getString(cursor.getColumnIndex("category"))
            val offDay = cursor.getString(cursor.getColumnIndex("offDay"))
            val sNum = cursor.getLong(cursor.getColumnIndex("sNum"))
            list.add(StoreDetailDTO(dNum, premium, category, offDay, sNum))
        }
        return list
    }
}