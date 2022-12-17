package com.hamy.currencyconverter.networking.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.ViewModelProvider
import androidx.test.rule.ActivityTestRule
import com.hamy.currencyconverter.networking.utils.Resource
import com.hamy.currencyconverter.views.activities.MainActivity
import com.hamy.currencyconverter.views.model.CurrencyConvert
import com.hamy.currencyconverter.views.model.CurrencyName
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response
import java.lang.reflect.Method

internal class CurrencyViewModelTest {

    private lateinit var viewModel: CurrencyViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        val mainActivity = activityRule.activity
        viewModel = ViewModelProvider(mainActivity)[CurrencyViewModel::class.java]
    }

    @Test
    fun currencyResponseSuccess() {
        val currencyName = CurrencyName()
        val response: Response<CurrencyName> = Response.success(currencyName)

        // Used reflection api to access private method of CurrencyViewModel
        val method: Method = viewModel.javaClass.getDeclaredMethod("handleNewsResponse", Response::class.java)
        method.isAccessible = true
        val resource: Resource<CurrencyName> = method.invoke(viewModel, response) as Resource<CurrencyName>
        Assert.assertEquals(resource.data,currencyName) // Add the expected output in second argument according to your needs.
    }
    @Test
    fun currencyResponseFailure() {
        val currencyConvert = CurrencyConvert(true,403,"not_allowed","Single-currency Conversion API not available with this App ID - please contact support@openexchangerates.org to upgrade your account.")
        val response: Response<CurrencyConvert> = Response.success(currencyConvert)

        // Used reflection api to access private method of CurrencyViewModel
        val method: Method = viewModel.javaClass.getDeclaredMethod("handleNewsResponse", Response::class.java)
        method.isAccessible = true
        val resource: Resource<CurrencyConvert> = method.invoke(viewModel, response) as Resource<CurrencyConvert>
        Assert.assertEquals(resource.data?.status,currencyConvert.status) // Add the expected output in second argument according to your needs.
    }
}