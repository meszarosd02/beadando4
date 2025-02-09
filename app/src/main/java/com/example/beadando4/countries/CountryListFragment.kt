package com.example.beadando4.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beadando4.databinding.CountryListFragmentBinding

class CountryListFragment : Fragment() {

    private val viewModel: CountryViewModel by viewModels()

    private var _binding: CountryListFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CountryListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CountryListAdapter()

        binding.countryRv.layoutManager = LinearLayoutManager(this.context)
        binding.countryRv.adapter = adapter

        viewModel.countries.observe(this.viewLifecycleOwner) { countries ->
            countries.let {
                adapter.submitList(it)
            }
        }

    }
}