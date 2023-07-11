package com.example.virginmoneychallenge.ui.people

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.virginmoneychallenge.R
import com.example.virginmoneychallenge.data.local.People
import com.example.virginmoneychallenge.databinding.ItemPersonBinding

class PeopleAdapter(private val onPeopleClick: (People) -> Unit) : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    private var peopleList: List<People> = emptyList()

    inner class PeopleViewHolder(private val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root) {

        fun displayPerson(person: People) = with(binding) {
            tvPerson.text = person.firstName + " " + person.lastName
            Glide.with(ivAvatar)
                .load(person.avatar)
                .circleCrop()
                .placeholder(R.drawable.default_avatar)
                .into(ivAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PeopleViewHolder(
            ItemPersonBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val currentPerson = peopleList[position]
        holder.displayPerson(currentPerson)
        holder.itemView.setOnClickListener {
            onPeopleClick(currentPerson)
        }
    }

    override fun getItemCount(): Int {
        return peopleList.size
    }

    fun setData(people: List<People>) {
        this.peopleList = people
        notifyDataSetChanged()
    }
}