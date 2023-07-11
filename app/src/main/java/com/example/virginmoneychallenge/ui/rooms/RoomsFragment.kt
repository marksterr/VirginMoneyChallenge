package com.example.virginmoneychallenge.ui.rooms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoneychallenge.databinding.FragmentRoomsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomsFragment : Fragment() {

    private var _binding: FragmentRoomsBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<RoomsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return FragmentRoomsBinding.inflate(inflater, container, false).apply {
            _binding = this
            val adapter = RoomsAdapter()

            viewModel.rooms.observe(
                viewLifecycleOwner,
                Observer {
                    adapter.setData(it)
                }
            )

            binding.rvRooms.adapter = adapter
            binding.rvRooms.layoutManager = LinearLayoutManager(requireContext())

        }.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}