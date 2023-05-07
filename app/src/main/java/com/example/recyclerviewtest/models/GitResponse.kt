package com.example.recyclerviewtest.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// https://stackoverflow.com/questions/64925126/how-to-use-parcelize-now-that-kotlin-android-extensions-is-being-deprecated
@Parcelize
data class RepoResult(val items: List<Item>) : Parcelable

@Parcelize
data class Item(
    val id: Long?,
    val name: String?,
    val fullName: String?,
    val owner: Owner,
    val private: Boolean,
    val htmlUrl: String?,
    val description: String?
) : Parcelable

@Parcelize
data class Owner(val login: String?, val id: Long?, val avatarUrl: String?) : Parcelable
