package com.example.virginmoneychallenge.ui.rooms

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoneychallenge.data.local.Room
import com.example.virginmoneychallenge.databinding.ItemRoomBinding

class RoomsAdapter() : RecyclerView.Adapter<RoomsAdapter.RoomsViewHolder>() {

    private var roomList: List<Room> = emptyList()

    inner class RoomsViewHolder(private val binding: ItemRoomBinding) : RecyclerView.ViewHolder(binding.root) {

        fun displayRoom(room: Room) = with(binding) {
            tvRoomId.text = "Room ID: " + room.id
            tvMaxOccupancy.text = "Max Occupancy: " + room.maxOccupancy
            if (room.isOccupied) {
                tvOccupancyStatus.text = "Occupancy Status: Occupied"
            } else {
                tvOccupancyStatus.text = "Occupancy Status: Not Occupied"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RoomsViewHolder(
            ItemRoomBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RoomsViewHolder, position: Int) {
        val currentRoom = roomList[position]
        holder.displayRoom(currentRoom)
    }

    override fun getItemCount(): Int {
        return roomList.size
    }

    fun setData(rooms: List<Room>) {
        this.roomList = rooms
        notifyDataSetChanged()
    }
}