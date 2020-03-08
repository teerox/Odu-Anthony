package com.example.anthonyodu

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.view.View
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.example.anthonyodu.model.Color
import com.google.android.material.snackbar.Snackbar

object Utility {

     const val MY_PERMISSIONS_REQUEST_WRITE_STORAGE = 1

    //@SuppressLint("ResourceType")
    fun colourGet(color: String, context: Context):Drawable?{
        when (color) {
            "Green" -> {
               // val redNo = ContextCompat.getColor(context, R.color.green)
                return AppCompatResources.getDrawable(context, R.color.green)
            }
            "Violet" -> {
              //  val redNo = ContextCompat.getColor(context, R.color.violet)
                return ContextCompat.getDrawable(context,R.color.violet)
            }
            "Yellow" -> {
              //  val redNo = ContextCompat.getColor(context, R.color.yellow)
                return ContextCompat.getDrawable(context,R.color.yellow)
            }
            "Blue" -> {
              //  val redNo = ContextCompat.getColor(context, R.color.blue)
                return ContextCompat.getDrawable(context,R.color.blue)
            }
            "Teal" -> {
               // val redNo = ContextCompat.getColor(context, R.color.teal)
                return ContextCompat.getDrawable(context,R.color.teal)
            }
            "Maroon" -> {
               // val redNo = ContextCompat.getColor(context, R.color.maroon)
                return ContextCompat.getDrawable(context, R.color.maroon)
            }
            "Red" -> {
               // val redNo = ContextCompat.getColor(context, R.color.red)
                return ContextCompat.getDrawable(context,R.color.red)
            }
            "Orange" -> {
               // val redNo = ContextCompat.getColor(context, R.color.orange)
                return ContextCompat.getDrawable(context,R.color.orange)
            }
            "Mauv" -> {
               // val redNo = ContextCompat.getColor(context, R.color.mauv)
                return ContextCompat.getDrawable(context,R.color.mauv)
            }
            else -> {
               // val redNo = ContextCompat.getColor(context, R.color.white)
                return ContextCompat.getDrawable(context, R.color.white)
            }
        }
    }





}