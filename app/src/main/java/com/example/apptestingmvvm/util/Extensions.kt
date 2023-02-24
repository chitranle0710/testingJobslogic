package com.example.apptestingmvvm.util

import android.view.View

fun View.beGone() {
    this.visibility = View.GONE
}

fun View.beVisible() {
    this.visibility = View.VISIBLE
}