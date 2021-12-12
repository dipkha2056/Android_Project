package com.deependra.accoutanthireapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.deependra.accoutanthireapp.dao.AccountantDAO
import com.deependra.accoutanthireapp.entity.Accountant


@Database(
        entities =[(Accountant::class)],
        version = 2,
        exportSchema = false
)
abstract class AccountantDB : RoomDatabase() {

    abstract fun getAccountantDAO(): AccountantDAO

    companion object {
        @Volatile
        private var instance: AccountantDB? = null

        fun getInstance(context: Context): AccountantDB {
            if (instance == null) {
                synchronized(AccountantDB::class) {
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(
                        context.applicationContext,
                        AccountantDB::class.java,
                        "AccountantDB"
                ).build()
    }

}