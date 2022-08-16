package com.example.shoppinglist.data

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class ShopItemDbModelUpdate(

    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "count")
    val count: Int,
)