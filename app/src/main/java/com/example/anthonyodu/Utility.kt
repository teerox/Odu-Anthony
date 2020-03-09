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
import com.example.anthonyodu.model.CarOwner
import com.example.anthonyodu.model.CarOwnerList
import com.example.anthonyodu.model.Color
import com.example.anthonyodu.model.Filter
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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

    @SuppressLint("DefaultLocale")
    suspend fun filter(list: CarOwnerList, criteria: Filter): CarOwnerList {
        val result = CarOwnerList()
        withContext(Dispatchers.IO) {
            for (i in 0 until list.size) {
                //if (list[i].year.toLong() in criteria.start_year..criteria.end_year) {
                if ((criteria.gender.capitalize() == list[i].gender.capitalize())
                    or (criteria.gender.isEmpty())
                ) {
                    if ((list[i].country.capitalize() in criteria.countries.map { it.capitalize() })
                        or criteria.countries.isEmpty()
                    ) {
                        if ((list[i].carColor.capitalize() in criteria.colors.map { it.capitalize() })
                            or criteria.colors.isEmpty()
                        ) {
                            result.add(
                                CarOwner(
                                    list[i].id,
                                    // R.drawable.car1,
                                    list[i].firstName,
                                    list[i].lastName,
                                    list[i].email,
                                    list[i].country,
                                    list[i].carModel,
                                    list[i].year,
                                    list[i].carColor,
                                    list[i].gender,
                                    list[i].jobTitle,
                                    list[i].bio
                                )
                            )
                        }
                    }
                    // }
                }
            }
        }
        return result

    }




}