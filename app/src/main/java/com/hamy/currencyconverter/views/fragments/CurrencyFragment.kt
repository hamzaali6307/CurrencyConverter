package com.hamy.presentation.views.fragments

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.hamy.currencyconverter.R
import com.hamy.currencyconverter.networking.ViewModel.CurrencyViewModel
import com.hamy.currencyconverter.networking.utils.Resource
import com.hamy.currencyconverter.networking.utils.Utils
import com.hamy.currencyconverter.networking.utils.Utils.BUNDLE_TITLE
import com.hamy.currencyconverter.views.model.CurrencyName
import com.hamy.currencyconverter.views.model.CurrencyValue
import com.hamy.presentation.views.adapter.CurrencyAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.currency_fragment.*
import org.json.JSONObject
import java.util.Arrays
import java.util.Currency

@AndroidEntryPoint
class CurrencyFragment : Fragment(R.layout.currency_fragment) {

    lateinit var currentAdapter : CurrencyAdapter
    var currencyList = arrayListOf<CurrencyValue>()

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

                }

                is Resource.Success -> {
                  val currency = response.data!!

                    currencyList.add( CurrencyValue(currency.AED!!))
                    currencyList.add( CurrencyValue(currency.ALL!!))
                    currencyList.add( CurrencyValue(currency.AFN!!))

                    Log.d("myList",currencyList.toString())
                    currentAdapter.differ.submitList(currencyList)
                    Log.d("result", response.data.toString())

                }
                is Resource.Error -> {

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