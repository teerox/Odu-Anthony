package com.example.anthonyodu.screens.filter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.anthonyodu.R
import com.example.anthonyodu.databinding.FilterListItemBinding
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.model.FilterArray


class FilterListAdapter(var context: Context, var myArrayList: FilterArray,private val clickListerner: (result: Filter) -> Unit): RecyclerView.Adapter<FilterListAdapter.ViewHolder>()
{
    class ViewHolder(var binding: FilterListItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Filter, clickListerner: (result: Filter) -> Unit){
            binding.filterList = item
            binding.root.setOnClickListener {
                clickListerner(item)
            }
           // var a = R.drawable.login_button
            Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(item.avatar).into(binding.smallimage)

            val colour = item.colors

            if (colour.isNotEmpty()){
                binding.showwhennotext.visibility = View.GONE
                binding.colourlayout.visibility = View.VISIBLE

                Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(R.drawable.green) .into(binding.button1)

                Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(R.drawable.violet).into(binding.button2)

                Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(R.drawable.yellow).into(binding.button3)

                Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(R.drawable.blue).into(binding.button4)

                Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(R.drawable.teal).into(binding.button5)

                Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(R.drawable.maroon).into(binding.button6)

                Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(R.drawable.circle).into(binding.button7)

                Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(R.drawable.aquamarine).into(binding.button8)

                Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(R.drawable.orange).into(binding.button9)

                Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(R.drawable.mau).into(binding.button10)
            }else{

                //Hide View
                binding.showwhennotext.visibility = View.VISIBLE
                binding.colourlayout.visibility = View.GONE
            }

            val countries = item.countries
            if (countries.isNotEmpty()) {
                binding.showwhennocounry.visibility = View.GONE
                binding.showcountries.visibility = View.VISIBLE
                binding.first.text = "China"
                binding.second.text = "South Africa"
                binding.third.text = "France"
                binding.fourt.text = "Mexico"
                binding.fivth.text = "Japan"
                binding.sixth.text ="Estonia"
                binding.seventh.text = "Colombia"
                binding.eighth.text = "China"

            }else{
                binding.showwhennocounry.visibility = View.VISIBLE
                binding.showcountries.visibility = View.GONE
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = FilterListItemBinding.inflate(view)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return myArrayList.size
         }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)= holder.bind(myArrayList[position], clickListerner)


}
