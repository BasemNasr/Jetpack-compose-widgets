package com.bn.saudimarche.data.model.categories

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryModel(
    val id: Int? = null,
    val name: String? = null,
    val image: String? = null,
) : Parcelable
