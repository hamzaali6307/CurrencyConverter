package com.hamy.currencyconverter.networking.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.ViewModelProvider
import androidx.test.rule.ActivityTestRule
import com.hamy.currencyconverter.networking.utils.Resource
import com.hamy.currencyconverter.views.activities.MainActivity
import com.hamy.currencyconverter.views.model.CurrencyConvert
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response
import java.lang.reflect.Method

internal class CurrencyConverterViewModelTest {

    private lateinit var viewModel: CurrencyConverterViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        val mainActivity = activityRule.activity
        viewModel = ViewModelProvider(mainActivity)[CurrencyConverterViewModel::class.java]
    }

    @Test
    fun currencyConvertResponse() { // only eror from api for free versiona api
        val currencyConvert = CurrencyConvert(true,403,"not_allowed","Single-currency Conversion API not available with this App ID - please contact support@openexchangerates.org to upgrade your account.")
        val response: Response<CurrencyConvert> = Response.success(currencyConvert)

        // Used reflection api to access private method of CurrencyViewModel
        val method: Method = viewModel.javaClass.getDeclaredMethod("handleNewsResponse", Response::class.java)
        method.isAccessible = true
        val resource: Resource<CurrencyConvert> = method.invoke(viewModel, response) as Resource<CurrencyConvert>
        Assert.assertEquals(resource.data?.error,currencyConvert.error) // Add the expected output in second argument according to your needs.
    }

    @Test
    fun currencyConvertResponseFailure() {
        val currencyConvert = CurrencyConvert(true,403,"not_allowed","Single-currency Conversion API not available with this App ID - please contact support@openexchangerates.org to upgrade your account.")
        val response: Response<CurrencyConvert> = Response.success(currencyConvert)

        // Used reflection api to access private method of CurrencyViewModel
        val method: Method = viewModel.javaClass.getDeclaredMethod("handleNewsResponse", Response::class.java)
        method.isAccessible = true
        val resource: Resource<CurrencyConvert> = method.invoke(viewModel, response) as Resource<CurrencyConvert>
        Assert.assertEquals(resource.data?.status,currencyConvert.status) // Add the expected output in second argument according to your needs.
    }
}