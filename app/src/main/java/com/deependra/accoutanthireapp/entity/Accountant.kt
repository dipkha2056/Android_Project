package com.deependra.accoutanthireapp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Accountant(
        val name: String? = null,
        val qualification: String? = null,
        val experience: String? = null,
        val number: String? = null,
        val description: String? = null,
        val charge: String? = null,
        val accountantImage: String? = null
) {
    @PrimaryKey
    var accountantID: Int? = null
}
