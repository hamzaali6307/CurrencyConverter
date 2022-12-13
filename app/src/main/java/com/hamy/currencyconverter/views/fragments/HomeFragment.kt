package com.hamy.currencyconverter.views.fragments

import android.os.Bundle
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
                            setFromCurrencyCode(currencyCode)
                            setFromCurrencyRate((defaultRate.toString()))
                            tv_to_currency.text = getToCurrencyCode()

                            ("1$ = ${defaultRate.toString()} $currencyCode").also { tv_from_curr_rate.text = it }
                            "1 $currencyCode = ${defaultRate.toString()}".also { tv_to_curr_rate.text = it }


                        }
                    }
                    "To" -> {
                        tv_to_currency.text = currencyCode
                        lifecycleScope.launch() {
                            setToCurrencyCode(currencyCode)
                            setToCurrencyRate(defaultRate.toString())

                            et_currency.setText( getFromCurrencyRate())
                            tv_from_currency.text = getFromCurrencyCode()
                            "1 ${tv_from_currency.text} = ${getFromCurrencyRate()}".also { tv_from_curr_rate.text = it }
                            "1 $currencyCode = ${defaultRate.toString()}".also { tv_to_curr_rate.text = it }

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