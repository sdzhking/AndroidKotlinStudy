package com.sdzking.recyclerviewtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sdzking.recyclerviewtest.databinding.FruitItemBinding

class FruitAdapter(private val fruitList: List<Fruit>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {
//    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
//
//        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
//        val fruitName: TextView = view.findViewById(R.id.fruitName)
//
//    }
    inner class ViewHolder (binding: FruitItemBinding) : RecyclerView.ViewHolder(binding.root){

        val fruitImage: ImageView = binding.fruitImage
        val fruitName: TextView = binding.fruitName

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        val view = FruitItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitImage.setImageResource(fruit.imageId)
        holder.fruitName.text = fruit.name
    }

    override fun getItemCount() = fruitList.size
}