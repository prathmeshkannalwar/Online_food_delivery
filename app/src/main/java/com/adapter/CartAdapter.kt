package com.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feasta.databinding.CartItemBinding

class CartAdapter(private  val CartItems: MutableList<String>,private val CartItemPrice:MutableList<String>,private var CartImage: MutableList<Int>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

private val itemQuestities = IntArray(CartItems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
       holder.bind(position)
    }
    override fun getItemCount(): Int = CartItems.size


    inner class CartViewHolder(private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuestities [position]
                cartFoodName.text = CartItems[position]
                cartItemPrice.text = CartItemPrice[position]
                cartImage.setImageResource(CartImage[position])
                cartItemQuantity.text = quantity.toString()

                minusButton.setOnClickListener{
                    decreaseQuantity((position))
                }
                plusButton.setOnClickListener{
                    increaseQuantity(position)
                }
                deleteButton.setOnClickListener {
                    val itemPosition = adapterPosition
                    if(itemPosition != RecyclerView.NO_POSITION){
                        deleteitem(itemPosition)
                    }
                }
            }
        }

        private fun increaseQuantity(position: Int){
            if(itemQuestities[position]<10){
                itemQuestities[position]++
                binding.cartItemQuantity.text = itemQuestities[position].toString()
            }
        }

        private fun decreaseQuantity(position: Int){
            if(itemQuestities[position]>1){
                itemQuestities[position]--
                binding.cartItemQuantity.text = itemQuestities[position].toString()
            }
        }

        private fun deleteitem(position: Int){
            CartItems.removeAt(position)
            CartImage.removeAt(position)
            CartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,CartItems.size)
        }
    }
}