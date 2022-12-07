package com.hamy.presentation.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hamy.currencyconverter.databinding.ItemCurrencyBinding
import com.hamy.currencyconverter.views.model.CurrencyValue
import kotlinx.android.synthetic.main.item_currency.view.*

class CurrencyAdapter(private val onItemClick: (currency: CurrencyValue) -> Unit) :
    RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    private val differCallBack = object : DiffUtil.ItemCallback<CurrencyValue>() {
        override fun areItemsTheSame(oldItem: CurrencyValue, newItem: CurrencyValue): Boolean {
            return oldItem.currencyCode == newItem.currencyCode
        }

        override fun areContentsTheSame(oldItem: CurrencyValue, newItem: CurrencyValue): Boolean {
            return oldItem.currencyCode == newItem.currencyCode
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(differ.currentList[position])
    }

    override fun getItemCount() = differ.currentList.size

    inner class ViewHolder(binding: ItemCurrencyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun binding(currency: CurrencyValue) {
            itemView.apply {
                currency.apply {
                    tv_name.text = currency.currencyValue
                    tv_code.text = currency.currencyCode
                    tv_rate.text = currency.defaultRate.toString()
                }

                setOnClickListener {
                    onItemClick(currency)
                }
            }
        }
    }
}

