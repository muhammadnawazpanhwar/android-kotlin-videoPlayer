package com.example.videoplayer

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.videoplayer.databinding.FoldersViewBinding

class FoldersAdapter(private val context: Context, private var folderList: ArrayList<Folder>): RecyclerView.Adapter<FoldersAdapter.MyHolder>() {
    class MyHolder(binding: FoldersViewBinding): RecyclerView.ViewHolder(binding.root){
        val folderName = binding.folderNameFV
        val root = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(FoldersViewBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.folderName.text = folderList[position].folderName
        holder.root.setOnClickListener {
            val intent = Intent(context, FoldersActivity::class.java)
            intent.putExtra("position", position)
            ContextCompat.startActivity(context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return folderList.size
    }
}