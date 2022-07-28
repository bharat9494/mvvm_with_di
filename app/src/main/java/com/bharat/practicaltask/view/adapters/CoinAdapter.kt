package com.bharat.practicaltask.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bharat.practicaltask.R
import com.bharat.practicaltask.data.models.Coin
import com.bumptech.glide.Glide


class CoinAdapter : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    var data =  listOf<Coin>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_coin, parent, false)
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin: Coin = data[position]
        holder.coinText.text = coin.name

        Glide.with(holder.coinImage.context)
            .load(coin.pictures?.front?.url)
            .centerInside()
            .error(R.drawable.ic_baseline_do_not_disturb_24)
            .into(holder.coinImage)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var coinText: TextView
        var coinImage: ImageView

        init {
            coinText = itemView.findViewById(R.id.textCoinName)
            coinImage = itemView.findViewById(R.id.imageCoin)
        }
    }

}