package com.hamy.currencyconverter.views.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hamy.currencyconverter.R
import com.hamy.currencyconverter.networking.utils.*
import com.hamy.currencyconverter.networking.utils.Utils.currency
import com.hamy.currencyconverter.networking.utils.Utils.currencyFrom
import com.hamy.currencyconverter.networking.utils.Utils.currencyTo
import com.hamy.currencyconverter.networking.utils.Utils.initMultipleViewsClickListener
import com.hamy.currencyconverter.networking.utils.Utils.selectedTpe
import com.hamy.currencyconverter.networking.viewModel.CurrencyConverterViewModel
import com.hamy.currencyconverter.views.model.CurrencyValue
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), View.OnClickListener {
    private val currencyConverterViewModel : CurrencyConverterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currencyConverterViewModel.getCurrencyRate(if(et_currency.text.toString().isNotEmpty()) et_currency.text.toString().toDouble() else  0.0,tv_from_currency.text.toString(),tv_to_currency.text.toString())

        initViews()

        et_currency.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                lifecycleScope.launch {
                    if (!et_currency.text.isNullOrEmpty() && et_currency.text.toString().toInt()!= 0)  {
                        currencyConverterViewModel.currencyList.observe(requireActivity()) { response ->
                            when (response) { // as api in free version not convert gives error only, Manually convert rates
                                is Resource.Error -> {

                                    showSnackBar(cl_home, getString(R.string.error_from_response))
                                    lifecycleScope.launch {
                                        tv_converted_currency.text =
                                            (((et_currency.text.toString()).toFloat() / getFromCurrencyRate().toFloat()) * getToCurrencyRate().toFloat()).toString()
                                    }
                                }
                                else -> {}
                            }
                        }
                    }else{
                        tv_converted_currency.text = "0"
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })
    }

    private fun initViews() {
        DefaultPreferences(requireActivity())

        initMultipleViewsClickListener(tv_to_currency, tv_from_currency)
        if (!arguments?.isEmpty!!) {

            selectedTpe = arguments?.getString(Utils.BUNDLE_TITLE)!!

            (arguments?.getSerializable("model")!! as CurrencyValue).apply {

                when (selectedTpe) {
                    "From" -> {
                        lifecycleScope.launch {
                            tv_from_currency.text = currencyCode
                            tv_to_currency.text = getToCurrencyCode()

                            setFromCurrencyCode(currencyCode)
                            setFromCurrencyRate((defaultRate.toString()))

                            ("1$ = ${defaultRate.toString()} $currencyCode").also {
                                tv_from_curr_rate.text = it
                            }
                            "1$ = ${getToCurrencyRate()} ${getToCurrencyCode()}".also {
                                tv_to_curr_rate.text = it
                            }

                        }
                    }
                    "To" -> {
                        lifecycleScope.launch {
                            tv_to_currency.text = currencyCode
                            tv_from_currency.text = getFromCurrencyCode()

                            setToCurrencyCode(currencyCode)
                            setToCurrencyRate(defaultRate.toString())

                            "1 $ = ${getFromCurrencyRate()} ${getFromCurrencyCode()}".also {
                                tv_from_curr_rate.text = it
                            }
                            "1 $ = ${defaultRate.toString()} $currencyCode".also {
                                tv_to_curr_rate.text = it
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            tv_from_currency -> {
                findNavController().navigate(R.id.action_home_to_currency, Bundle().apply {
                    selectedTpe = "From"
                    putString(Utils.BUNDLE_TITLE, selectedTpe)
                })
            }
            tv_to_currency -> {
                findNavController().navigate(R.id.action_home_to_currency, Bundle().apply {
                    selectedTpe = "To"
                    putString(Utils.BUNDLE_TITLE, selectedTpe)
                })
            }
        }
    }
}