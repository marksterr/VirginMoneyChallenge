package com.example.virginmoneychallenge.ui.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoneychallenge.databinding.FragmentPeopleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment : Fragment() {

    private var _binding: FragmentPeopleBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<PeopleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return FragmentPeopleBinding.inflate(inflater, container, false).apply {
            _binding = this
            val adapter = PeopleAdapter()

            viewModel.people.observe(
                viewLifecycleOwner,
                Observer {
                    adapter.setData(it)
                }
            )

            binding.rvPeople.adapter = adapter
            binding.rvPeople.layoutManager = LinearLayoutManager(requireContext())

        }.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}