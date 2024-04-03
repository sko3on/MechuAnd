package com.example.mechuand.data.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// Databas 없으면 생성, 있으면 업데이트, table 생성 검색할 수 있도록 해주는 객체
class DbOpenHelper(
    ctx: Context?, name: String, factory: SQLiteDatabase.CursorFactory?, ver: Int
) : SQLiteOpenHelper(ctx, name, factory, ver) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.setForeignKeyConstraintsEnabled(true)
        db?.execSQL(
            "create table if not exists user " +
                    "( _unum integer primary key autoincrement, " +
                    "uid text," +
                    "upw text," +
                    "uemail text," +
                    "uname text," +
                    "ubirth Long, " +
                    "ugender text, " +
                    "umobile text)"
        )

        db?.execSQL(
            "CREATE TABLE IF NOT EXISTS store (" +
                    "sNum INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "sId TEXT, " +
                    "sPw TEXT, " +
                    "sName TEXT, " +
                    "sMobile TEXT, " +
                    "businessNum TEXT)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion != newVersion) {
            db?.execSQL("drop table if exists user")
            db?.execSQL("DROP TABLE IF EXISTS store")
            onCreate(db)
        }

    }
}
