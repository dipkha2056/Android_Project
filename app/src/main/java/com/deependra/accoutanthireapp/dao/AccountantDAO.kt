package com.deependra.accoutanthireapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.deependra.accoutanthireapp.entity.Accountant

@Dao
interface AccountantDAO {

    @Insert
    suspend fun insertAccountant(accountant : MutableList<Accountant>)

    @Query("select * from Accountant")
    suspend fun getAllAccountants() : MutableList<Accountant>
}