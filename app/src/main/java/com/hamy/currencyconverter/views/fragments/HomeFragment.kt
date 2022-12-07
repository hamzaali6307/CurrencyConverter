package com.hamy.currencyconverter.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hamy.currencyconverter.R
import com.hamy.currencyconverter.networking.utils.Utils.initMultipleViewsClickListener
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home),View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
       initMultipleViewsClickListener(tv_to_currency,tv_from_currency)
    }

    override fun onClick(v: View?) {
        when(v){
            tv_to_currency, tv_from_currency -> {
                findNavController().navigate(R.id.action_home_to_currency)
            }
        }
    }
}