package com.hamy.currencyconverter.views.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hamy.currencyconverter.R
import com.hamy.currencyconverter.networking.utils.*
import com.hamy.currencyconverter.networking.utils.Utils.initMultipleViewsClickListener
import com.hamy.currencyconverter.networking.utils.Utils.selectedTpe
import com.hamy.currencyconverter.views.model.CurrencyValue
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch

class HomeFragment : Fragment(R.layout.fragment_home), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        et_currency.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                lifecycleScope.launch {
                    if (!et_currency.text.isNullOrEmpty() && et_currency.text.toString()!= ("0") ) {
                        tv_result.text =
                            (((et_currency.text.toString()).toFloat() / getFromCurrencyRate().toFloat()) * getToCurrencyRate().toFloat()).toString()
                    }else{
                        tv_result.text = "0"
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

            Utils.selectedTpe = arguments?.getString(Utils.BUNDLE_TITLE)!!

            (arguments?.getSerializable("model")!! as CurrencyValue).apply {

                when (selectedTpe) {
                    "From" -> {
                        lifecycleScope.launch() {
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
                        lifecycleScope.launch() {
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
                    putString(Utils.BUNDLE_TITLE, "From")
                })
            }
            tv_to_currency -> {
                findNavController().navigate(R.id.action_home_to_currency, Bundle().apply {
                    putString(Utils.BUNDLE_TITLE, "To")
                })
            }
        }
    }
}