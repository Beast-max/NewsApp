package com.example.newsapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Model::class], version = 2, exportSchema = false)
abstract class RoomDB: RoomDatabase() {
    abstract fun RepoDatabaseDao():Dao

    companion object{
        private var INSTANCE:RoomDB?=null

        fun getinstanc(context: Context):RoomDB{
            if(INSTANCE==null){
                INSTANCE = Room.databaseBuilder( context.applicationContext,
                    RoomDB::class.java,
                    "RepoDB")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE as RoomDB
        }
    }
}