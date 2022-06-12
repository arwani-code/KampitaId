package com.picodiploma.kampitaid.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.picodiploma.kampitaid.data.local.entity.QuakeEntity
import com.picodiploma.kampitaid.databinding.ListKampitaItemBinding
import com.picodiploma.kampitaid.ui.fragments.ListKampitaFragmentDirections
import com.picodiploma.kampitaid.utils.DateFormatter

class QuakeAdapter: ListAdapter<QuakeEntity, QuakeAdapter.MyViewHolder>(DIFF_CALLBACK) {

    private lateinit var onItemClickDetail: OnItemClickCallback

    fun onItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickDetail = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ListKampitaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val quake = getItem(position)
        holder.bind(quake)
    }

    inner class MyViewHolder(private val binding: ListKampitaItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(quake: QuakeEntity){
            binding.apply {
                tvMagnitude.text = "M ${quake.magnitude}"
                tvItemTitle.text = quake.station_location
                tvItemPublished.text =  DateFormatter.formatDate(quake.publishedAt.toString())

                rowItem.setOnClickListener {
                    val action = ListKampitaFragmentDirections.actionListFragmentToDetailKampitaFragment(quake)
                    itemView.findNavController().navigate(action)
                }
            }

            itemView.setOnClickListener {
                onItemClickDetail.onItemClicked(quake)
            }


        }
    }

    interface OnItemClickCallback{
        fun onItemClicked(quake: QuakeEntity)
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<QuakeEntity> =
            object : DiffUtil.ItemCallback<QuakeEntity>() {
                override fun areItemsTheSame(oldItem: QuakeEntity, newItem: QuakeEntity): Boolean {
                    return oldItem.id == newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(
                    oldItem: QuakeEntity,
                    newItem: QuakeEntity
                ): Boolean {
                return oldItem == newItem
                }
            }
    }
}