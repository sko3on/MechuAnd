package com.example.mechuand.data.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// 데이터베이스가 없으면 생성하고, 있으면 업데이트하며, 테이블을 생성하고 검색할 수 있도록 해주는 객체
class DbOpenHelper(
    ctx: Context?, name: String, factory: SQLiteDatabase.CursorFactory?, ver: Int
) : SQLiteOpenHelper(ctx, name, factory, ver) {

    private val CREATE_USER_TABLE = """
    CREATE TABLE IF NOT EXISTS user (
        _unum INTEGER PRIMARY KEY AUTOINCREMENT,
        uid TEXT,
        upw TEXT,
        uemail TEXT,
        uname TEXT,
        ubirth LONG,
        ugender TEXT,
        umobile TEXT,
        CONSTRAINT fk_reservation FOREIGN KEY (_unum) REFERENCES reservation(unum),
        CONSTRAINT fk_remenuorder FOREIGN KEY (_unum) REFERENCES remenuorder(unum)
    )
""".trimIndent()

    private val CREATE_Reservation_TABLE = """
    CREATE TABLE IF NOT EXISTS reservation (
        _rnum INTEGER PRIMARY KEY AUTOINCREMENT,
        person INTEGER,
        hour INTEGER,
        minute INTEGER,
        etc TEXT,
        ordertime LONG,
        unum INTEGER,
        CONSTRAINT fk_user FOREIGN KEY (unum) REFERENCES user(_unum),
        CONSTRAINT fk_remenuorder FOREIGN KEY (rnum) REFERENCES remenuorder(rnum)
    )
""".trimIndent()

    private val CREATE_REMENUORDER_TABLE = """
    CREATE TABLE IF NOT EXISTS remenuorder (
        _onum INTEGER PRIMARY KEY AUTOINCREMENT,
        ordermenu TEXT,
        menucount INTEGER,
        unum INTEGER,
        rnum INTEGER,
        CONSTRAINT fk_user FOREIGN KEY (unum) REFERENCES user(_unum),
        CONSTRAINT fk_reservation FOREIGN KEY (rnum) REFERENCES reservation(rnum)
    )
""".trimIndent()

    private val CREATE_STORE_TABLE = """
    CREATE TABLE IF NOT EXISTS store (
        _snum INTEGER PRIMARY KEY AUTOINCREMENT,
        sid TEXT,
        spw TEXT,
        sname TEXT,
        smobile TEXT,
        businessnum TEXT,
        CONSTRAINT fk_store_detail FOREIGN KEY (_snum) REFERENCES storedetail(snum),
        CONSTRAINT fk_store_menu FOREIGN KEY (_snum) REFERENCES storemenu(snum),
        CONSTRAINT fk_reservation FOREIGN KEY (_snum) REFERENCES reservation(snum)
    )
""".trimIndent()

    private val CREATE_storeDetail_TABLE = """
    CREATE TABLE IF NOT EXISTS store_detail (
        _dnum INTEGER PRIMARY KEY AUTOINCREMENT,
        premium TEXT,
        category TEXT,
        offDay TEXT,
        snum INTEGER,
        CONSTRAINT fk_user FOREIGN KEY (snum) REFERENCES store(_snum)
    )
""".trimIndent()

    private val CREATE_storeMenu_TABLE = """
    CREATE TABLE IF NOT EXISTS store_menu (
        _mnum INTEGER PRIMARY KEY AUTOINCREMENT,
        mName TEXT,
        mPrice TEXT,
        description TEXT,
        snum INTEGER,
        CONSTRAINT fk_user FOREIGN KEY (snum) REFERENCES store(_snum)
    )
""".trimIndent()

    override fun onCreate(db: SQLiteDatabase?) {
        db?.setForeignKeyConstraintsEnabled(true)
        db?.execSQL(CREATE_USER_TABLE)
        db?.execSQL(CREATE_Reservation_TABLE)
        db?.execSQL(CREATE_REMENUORDER_TABLE)
        db?.execSQL(CREATE_STORE_TABLE)
        db?.execSQL(CREATE_storeDetail_TABLE)
        db?.execSQL(CREATE_storeMenu_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion != newVersion) {
            db?.execSQL("DROP TABLE IF EXISTS user")
            db?.execSQL("DROP TABLE IF EXISTS reservation")
            db?.execSQL("DROP TABLE IF EXISTS remenuorder")
            db?.execSQL("DROP TABLE IF EXISTS store")
            db?.execSQL("DROP TABLE IF EXISTS store_detail")
            db?.execSQL("DROP TABLE IF EXISTS store_menu")
            onCreate(db)
        }
    }
}
