package com.hamy.currencyconverter.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamy.currencyconverter.R
import com.hamy.currencyconverter.database.AppDatabase
import com.hamy.currencyconverter.database.dao.CurrencyDao
import com.hamy.currencyconverter.networking.utils.*
import com.hamy.currencyconverter.networking.utils.Utils.BUNDLE_TITLE
import com.hamy.currencyconverter.networking.utils.Utils.selectedTpe
import com.hamy.currencyconverter.networking.viewModel.CurrencyRatesViewModel
import com.hamy.currencyconverter.networking.viewModel.CurrencyViewModel
import com.hamy.currencyconverter.views.model.CurrencyName
import com.hamy.presentation.views.adapter.CurrencyAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_currency.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CurrencyFragment : DialogFragment(R.layout.fragment_currency) {
    private var database: CurrencyDao? = null

    lateinit var currentAdapter: CurrencyAdapter
    private var session: DefaultPreferences? = null

    lateinit var job: Job

    private val currencyViewModel: CurrencyViewModel by viewModels()
    private val currencyRatesViewModel: CurrencyRatesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        currencyViewModel.getCurrency()
        currencyRatesViewModel.getCurrencyRates()

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        setRecyclerView()
    }

    private fun setRecyclerView() {

        currentAdapter = CurrencyAdapter {
            showSnackBar(rv_currency, it.currencyValue)
            findNavController().navigate(R.id.action_currency_to_home, Bundle().apply {
                putString(Utils.BUNDLE_TITLE, selectedTpe)
                putSerializable("model", it)
            })
        }

        rv_currency.apply {
            adapter = currentAdapter
            layoutManager = LinearLayoutManager(requireActivity())
        }
    }

    private fun initViews() {
        database = AppDatabase.getAppDataBase(requireActivity())?.routineDao()
        session = DefaultPreferences(requireContext())
        ll_pb.visible()
        database?.getSellList().apply {
            if (this.isNullOrEmpty()) {
                job = lifecycleScope.launch() {
                    selectedTpe = arguments?.getString(BUNDLE_TITLE)!!

                    currencyViewModel.currencyList.observe(requireActivity()) { response ->
                        when (response) {
                            is Resource.Loading -> {
                                ll_pb.visible()
                            }

                            is Resource.Success -> {
                                ll_pb.gone()
                                getCurrencyRates(response)
                            }
                            is Resource.Error -> {
                                ll_pb.gone()
                                showSnackBar(rv_currency, getString(R.string.network_failure_error))

                            }
                            else -> {}
                        }
                    }
                }
            } else {
                ll_pb.gone()
                currentAdapter.differ.submitList(this)
            }
        }
    }

    private fun getCurrencyRates(currency: Resource.Success<CurrencyName>) { // hitting rates for currencies
        currencyRatesViewModel.currencyRatesList.observe(requireActivity()) { response ->
            when (response) {
                is Resource.Loading -> {
                    ll_pb.visible()
                }

                is Resource.Success -> {
                    ll_pb.gone()

                    Utils.currencyList(
                        currency,
                        response.data?.rates
                    ).apply {
                        this.forEach {
                            database?.insertSellList(it)
                        }
                        currentAdapter.differ.submitList(this)
                    }
                }
                is Resource.Error -> {
                    ll_pb.gone()
                    showSnackBar(rv_currency, getString(R.string.network_failure_error))

                }
                else -> {}
            }
        }
    }

    override fun onStop() {
        super.onStop()

        job.apply {
            if (isActive) cancel()
        }
    }
}