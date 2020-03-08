package com.example.anthonyodu.screens.carowner

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.anthonyodu.R
import com.example.anthonyodu.databinding.CarOwnerListItemBinding
import com.example.anthonyodu.model.CarOwner
import com.example.anthonyodu.model.CarOwnerList

class CarOwnerAdapter(var context: Context, private var myArrayList: CarOwnerList):RecyclerView.Adapter<CarOwnerAdapter.ViewHolder>(){
    class ViewHolder(var binding:CarOwnerListItemBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(item:CarOwner){
           binding.carOwnerItem = item
            when (item.carColor) {
                "Red" -> {
                  //  binding.smallimage.setBackgroundColor(Color.RED)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.circle) .into(binding.smallimage)
                }
                "Green" -> {
                   // binding.smallimage.setBackgroundColor(Color.GREEN)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.green) .into(binding.smallimage)
                }
                "Violet" -> {
                   // binding.smallimage.setBackgroundColor(Color.VIOLET)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.violet) .into(binding.smallimage)
                }
                "Yellow" -> {
                   // binding.smallimage.setBackgroundColor(Color.YELLOW)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.yellow) .into(binding.smallimage)
                }
                "Blue" -> {
                   // binding.smallimage.setBackgroundColor(Color.BLUE)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.blue) .into(binding.smallimage)
                }
                "Teal" -> {
                   // binding.smallimage.setBackgroundColor(Color.TEAL)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.teal) .into(binding.smallimage)

                }
                "Maroon" -> {
                   // binding.smallimage.setBackgroundColor(Color.MAROON)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.maroon) .into(binding.smallimage)
                }
                "Aquamarine" -> {
                   // binding.smallimage.setBackgroundColor(Color.AQUAMARINE)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.aquamarine) .into(binding.smallimage)
                }
                "Orange" -> {
                   // binding.smallimage.setBackgroundColor(Color.ORANGE)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.orange) .into(binding.smallimage)
                }
                "Mauv" -> {
                   // binding.smallimage.setBackgroundColor(Color.MAUV)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.mau) .into(binding.smallimage)
                }
                "Puce" -> {
                   // binding.smallimage.setBackgroundColor(Color.PUCE)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.puce) .into(binding.smallimage)
                }
                "Indigo" -> {
                   // binding.smallimage.setBackgroundColor(Color.INDIGO)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.indigo) .into(binding.smallimage)
                }
                "Turquoise" -> {
                    //binding.smallimage.setBackgroundColor(Color.TURQUOISE)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.turquoise) .into(binding.smallimage)
                }
                "Goldenrod" -> {
                    //binding.smallimage.setBackgroundColor(Color.GOLDENROD)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.goldenrod) .into(binding.smallimage)
                }
                "Fuscia" -> {
                   // binding.smallimage.setBackgroundColor(Color.FUSCIA)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.fuscia) .into(binding.smallimage)
                }
                "Pink" -> {
                   // binding.smallimage.setBackgroundColor(Color.PINK)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.pink) .into(binding.smallimage)
                }
                "Crimson" -> {
                   // binding.smallimage.setBackgroundColor(Color.CRIMSON)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.crimson) .into(binding.smallimage)
                }
                "Khaki" -> {
                  //  binding.smallimage.setBackgroundColor(Color.KHAKI)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.khaki) .into(binding.smallimage)
                }
                else -> {
                    //binding.smallimage.setBackgroundColor(Color.BLACK)
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.black) .into(binding.smallimage)
                }
            }

           // binding.smallimage.setBackgroundColor(Color.parseColor(item.carColor));
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarOwnerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = CarOwnerListItemBinding.inflate(view)
        return ViewHolder(binding)
         }

    override fun getItemCount(): Int {
        return myArrayList.size
    }

    override fun onBindViewHolder(holder: CarOwnerAdapter.ViewHolder, position: Int) = holder.bind(myArrayList[position])

}