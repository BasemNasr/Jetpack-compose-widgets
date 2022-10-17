package com.bn.saudimarche.data.model.product

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductModel(
    val id: Int? = null,
    val name: String? = null,
    val image: String? = null,
    val price: String? = null,
    val price_before_discount: String? = null,
    val owner_name: String? = null,
    var isLike: Boolean? = false,
    var badge: String? = "",
    var quantity: Int? = 1,
) : Parcelable
