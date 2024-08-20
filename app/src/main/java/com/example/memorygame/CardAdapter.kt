package com.example.memorygame

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.memorygame.databinding.ItemCardBinding

class CardAdapter(
    val cardList: List<Card>,
    val onCardClick: (Card) -> Unit
) : RecyclerView.Adapter<CardAdapter.CardHolder>() {

    class CardHolder(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card, onCardClick: (Card) -> Unit) {
            binding.imageView.setImageResource(if (card.isFaceUp) card.image else R.drawable.background)
            binding.root.setOnClickListener {
                onCardClick(card)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardHolder(binding)
    }

    override fun getItemCount(): Int = cardList.size

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.bind(cardList[position], onCardClick)
    }
}
