package com.example.mechuand.data.dao.handler

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.mechuand.data.dao.DbOpenHelper
import com.example.mechuand.data.dto.UserDTO

class UserHandler private constructor(ctx: Context){
    private val openHelper: DbOpenHelper = DbOpenHelper(ctx, "user.db", null, 1)
    private val sqLiteDatabase: SQLiteDatabase = openHelper.writableDatabase

    companion object {
        private var sqlHandler: UserHandler? = null
        fun open(ctx: Context): UserHandler {
            if (sqlHandler == null) {
                sqlHandler = UserHandler(ctx)
            }
            return sqlHandler as UserHandler
        }
    }

    fun close(): Unit {openHelper.close()}
    fun insert(dto: UserDTO): Long{
        val values = ContentValues()
        values.put("uId",dto.uId)
        values.put("uBirth",dto.uBirth)
        values.put("uMobile",dto.uMobile)
        values.put("uGender",dto.uGender)
        values.put("uEmail",dto.uEmail)
        values.put("uName",dto.uName)
        values.put("uPw",dto.uPw)

        return sqLiteDatabase.insert("user", null, values)
    }



    fun update(dto: UserDTO): Unit {
        val values = ContentValues()
        values.put("_uNum", dto.uNum)
        values.put("uId",dto.uId)
        values.put("uPw",dto.uPw)
        values.put("uMobile",dto.uMobile)
        values.put("uName",dto.uName)
        values.put("uEmail",dto.uEmail)
        values.put("uBirth",dto.uBirth)
        values.put("uGender",dto.uGender)

        sqLiteDatabase.update("user", values, "_uNum=?", arrayOf(dto.uNum.toString()))
    }

    fun delete(uNum: Long): Unit {
        sqLiteDatabase.delete("user", "_uNum=?", arrayOf(uNum.toString()))
    }

    @SuppressLint("Range")
    fun get(uNum: Long): UserDTO? {
        val cursor: Cursor = sqLiteDatabase.query(
            "user", null, "_uNum=?", arrayOf(uNum.toString()), null, null, null
        )
        return if (cursor.moveToNext()) {
            val _uNum = cursor.getLong(cursor.getColumnIndex("_uNum"))
            val uId = cursor.getString(cursor.getColumnIndex("uId"))
            val uPw = cursor.getString(cursor.getColumnIndex("uPw"))
            val uMobile = cursor.getString(cursor.getColumnIndex("uMobile"))
            val uName = cursor.getString(cursor.getColumnIndex("uName"))
            val uEmail = cursor.getString(cursor.getColumnIndex("uEmail"))
            val uBirth = cursor.getLong(cursor.getColumnIndex("uBirth"))
            val uGender = cursor.getString(cursor.getColumnIndex("uGender"))
            UserDTO(_uNum, uId, uPw, uEmail, uName, uBirth, uGender, uMobile)
        } else null
    }

    @SuppressLint("Range")
    fun getList(): ArrayList<UserDTO> {
        var list: ArrayList<UserDTO> = ArrayList()
        val cursor: Cursor = sqLiteDatabase.query(
            "user", null, null, null, null, null, null
        )
        while (cursor.moveToNext()) {
            val _uNum = cursor.getLong(cursor.getColumnIndex("_uNum"))
            val uId = cursor.getString(cursor.getColumnIndex("uId"))
            val uPw = cursor.getString(cursor.getColumnIndex("uPw"))
            val uMobile = cursor.getString(cursor.getColumnIndex("uMobile"))
            val uName = cursor.getString(cursor.getColumnIndex("uName"))
            val uEmail = cursor.getString(cursor.getColumnIndex("uEmail"))
            val uBirth = cursor.getLong(cursor.getColumnIndex("uBirth"))
            val uGender = cursor.getString(cursor.getColumnIndex("uGender"))
            list.add(UserDTO(_uNum, uId, uPw, uEmail, uName, uBirth, uGender, uMobile))
        }
        return list
    }

}