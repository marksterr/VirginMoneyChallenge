package com.example.virginmoneychallenge.ui.people

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.virginmoneychallenge.R
import com.example.virginmoneychallenge.databinding.FragmentPeopleDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleDetailFragment : Fragment() {

    private var _binding: FragmentPeopleDetailBinding? = null
    private val binding get() = _binding!!

    private val personName by lazy { arguments?.getString("personName") }
    private val avatar by lazy { arguments?.getString("avatar") }
    private val email by lazy { arguments?.getString("email") }
    private val jobTitle by lazy { arguments?.getString("jobTitle") }
    private val favColor by lazy { arguments?.getString("favColor") }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentPeopleDetailBinding.inflate(inflater, container, false).apply {
            _binding = this

            Glide.with(ivAvatar)
                .load(avatar)
                .circleCrop()
                .placeholder(R.drawable.default_avatar)
                .into(ivAvatar)
            tvPersonName.text = personName
            tvEmail.text = email
            tvJobTitle.text = jobTitle
            tvFavColor.text = favColor

        }.root
    }
}