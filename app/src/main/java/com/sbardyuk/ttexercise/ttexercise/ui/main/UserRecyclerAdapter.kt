package com.sbardyuk.ttexercise.ttexercise.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.sbardyuk.ttexercise.ttexercise.data.User
import com.sbardyuk.ttexercise.ttexercise.databinding.UserItemLayoutBinding

class UserRecyclerAdapter(private var items: List<User>, private var listener: OnItemClickListener)
    : RecyclerView.Adapter<UserRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = UserItemLayoutBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    override fun getItemCount(): Int = items.size

    fun replaceData(newData: ArrayList<User>) {
        this.items = newData
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class ViewHolder(private var binding: UserItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: User, listener: OnItemClickListener?) {
            binding.listItem = item

            if (listener != null) {
                binding.root.setOnClickListener { _ -> listener.onItemClick(layoutPosition) }
            }

            binding.executePendingBindings()
        }
    }
}