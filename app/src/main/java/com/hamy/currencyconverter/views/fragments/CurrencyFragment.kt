package com.hamy.currencyconverter.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamy.currencyconverter.R
import com.hamy.currencyconverter.networking.viewModel.CurrencyViewModel
import com.hamy.currencyconverter.networking.utils.Resource
import com.hamy.currencyconverter.networking.utils.Utils.BUNDLE_TITLE
import com.hamy.currencyconverter.networking.utils.Utils.currencyList
import com.hamy.currencyconverter.networking.utils.gone
import com.hamy.currencyconverter.networking.utils.showSnackBar
import com.hamy.currencyconverter.networking.utils.visible
import com.hamy.currencyconverter.views.model.CurrencyValue
import com.hamy.presentation.views.adapter.CurrencyAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_currency.*

@AndroidEntryPoint
class CurrencyFragment : Fragment(R.layout.fragment_currency) {

    lateinit var currentAdapter: CurrencyAdapter

    private val currencyViewModel: CurrencyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        currencyViewModel.getCurrency()

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        setRecyclerView()
    }

    private fun setRecyclerView() {

        currentAdapter = CurrencyAdapter {

        }

        rv_currency.apply {
            adapter = currentAdapter
            layoutManager = LinearLayoutManager(requireActivity())
        }
    }

    private fun initViews() {

        currencyViewModel.currencyList.observe(requireActivity()) { response ->
            when (response) {
                is Resource.Loading -> {
                    ll_pb.visible()
                }

                is Resource.Success -> {
                    ll_pb.gone()
                    currentAdapter.differ.submitList(currencyList(response))
                }
                is Resource.Error -> {
                    ll_pb.gone()
                    showSnackBar(rv_currency, getString(R.string.network_failure_error))

                }
                else -> {}
            }
        }

        when (arguments?.getString(BUNDLE_TITLE)) {
            "From" -> {}
            "To" -> {}
        }
    }
}