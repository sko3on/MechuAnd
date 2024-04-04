package com.example.mechuand.data.dao.handler

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.mechuand.data.dao.DbOpenHelper
import com.example.mechuand.data.dto.StoreDTO

class StoreHandler private constructor(ctx: Context){
    private val openHelper: DbOpenHelper = DbOpenHelper(ctx, "store.db", null, 1)
    private val sqLiteDatabase: SQLiteDatabase = openHelper.writableDatabase

    companion object {
        private var sqlHandler: StoreHandler? = null
        fun open(ctx: Context): StoreHandler {
            if (sqlHandler == null) {
                sqlHandler = StoreHandler(ctx)
            }
            return sqlHandler as StoreHandler
        }
    }
    fun close(): Unit {openHelper.close()}
    fun insert(dto: StoreDTO): Long{
        val values = ContentValues()
        values.put("sNum",dto.sNum)
        values.put("sId",dto.sId)
        values.put("sPw",dto.sPw)
        values.put("sName",dto.sName)
        values.put("sMobile",dto.sMobile)
        values.put("businessNum",dto.businessNum)

        return sqLiteDatabase.insert("store", null, values)
    }
    fun update(dto: StoreDTO): Unit {
        val values = ContentValues()
        values.put("sNum",dto.sNum)
        values.put("sId",dto.sId)
        values.put("sPw",dto.sPw)
        values.put("sName",dto.sName)
        values.put("sMobile",dto.sMobile)
        values.put("businessNum",dto.businessNum)

        sqLiteDatabase.update("store", values, "sNum=?", arrayOf(dto.sNum.toString()))
    }
    @SuppressLint("Range")
    fun get(sNum: Long): StoreDTO? {
        val cursor: Cursor = sqLiteDatabase.query(
            "store", null, "sNum=?", arrayOf(sNum.toString()), null, null, null
        )
        return if (cursor.moveToNext()) {
            val sNum = cursor.getLong(cursor.getColumnIndex("sNum"))
            val sId = cursor.getString(cursor.getColumnIndex("sId"))
            val sPw = cursor.getString(cursor.getColumnIndex("sPw"))
            val sName = cursor.getString(cursor.getColumnIndex("sName"))
            val sMobile = cursor.getString(cursor.getColumnIndex("sMobile"))
            val businessNum = cursor.getString(cursor.getColumnIndex("businessNum"))
            StoreDTO(sNum, sId, sPw, sName, sMobile, businessNum)
        } else null
    }
    @SuppressLint("Range")
    fun getList(): ArrayList<StoreDTO> {
        var list: ArrayList<StoreDTO> = ArrayList()
        val cursor: Cursor = sqLiteDatabase.query(
            "store", null, null, null, null, null, null
        )
        while (cursor.moveToNext()) {
            val sNum = cursor.getLong(cursor.getColumnIndex("sNum"))
            val sId = cursor.getString(cursor.getColumnIndex("sId"))
            val sPw = cursor.getString(cursor.getColumnIndex("sPw"))
            val sName = cursor.getString(cursor.getColumnIndex("sName"))
            val sMobile = cursor.getString(cursor.getColumnIndex("sMobile"))
            val businessNum = cursor.getString(cursor.getColumnIndex("businessNum"))
            list.add(StoreDTO(sNum, sId, sPw, sName, sMobile, businessNum))
        }
        return list
    }
}