package com.hamy.currencyconverter.networking.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.View
import com.hamy.currencyconverter.views.model.Rates
import com.hamy.currencyconverter.views.model.CurrencyName
import com.hamy.currencyconverter.views.model.CurrencyValue

object Utils {

    fun currencyList(
            response: Resource.Success<CurrencyName>,
            rates: Rates?,
    ): ArrayList<CurrencyValue> {
        return arrayListOf<CurrencyValue>().apply {
            response.data?.apply {
                add(CurrencyValue("AED", AED!!, rates?.AED))
                add(CurrencyValue("ALL", ALL!!, rates?.ALL))
                add(CurrencyValue("AFN", AFN!!, rates?.AFN))
                add(CurrencyValue("AMD", AMD!!, rates?.AMD))
                add(CurrencyValue("ANG", ANG!!, rates?.ANG))
                add(CurrencyValue("AOA", AOA!!, rates?.AOA))
                add(CurrencyValue("ARS", ARS!!, rates?.ARS))
                add(CurrencyValue("AUD", AUD!!, rates?.AUD))
                add(CurrencyValue("AWG", AWG!!, rates?.AWG))
                add(CurrencyValue("AZN", AZN!!, rates?.AZN))
                add(CurrencyValue("BAM", BAM!!, rates?.BAM))
                add(CurrencyValue("BBD", BBD!!, rates?.BBD))
                add(CurrencyValue("BDT", BDT!!, rates?.BDT))
                add(CurrencyValue("BGN", BGN!!, rates?.BGN))
                add(CurrencyValue("BHD", BHD!!, rates?.BHD))
                add(CurrencyValue("BIF", BIF!!, rates?.BIF))
                add(CurrencyValue("BMD", BMD!!, rates?.BMD))
                add(CurrencyValue("BND", BND!!, rates?.BND))
                add(CurrencyValue("BOB", BOB!!, rates?.BOB))
                add(CurrencyValue("BRL", BRL!!, rates?.BRL))
                add(CurrencyValue("BSD", BSD!!, rates?.BSD))
                add(CurrencyValue("BTC", BTC!!, rates?.BTC))
                add(CurrencyValue("BTC", BTC!!, rates?.BTC))
                add(CurrencyValue("BWP", BWP!!, rates?.BWP))
                add(CurrencyValue("BYN", BYN!!, rates?.BYN))
                add(CurrencyValue("BZD", BZD!!, rates?.BZD))
                add(CurrencyValue("CAD", CAD!!, rates?.CAD))
                add(CurrencyValue("CDF", CDF!!, rates?.CDF))
                add(CurrencyValue("CHF", CHF!!, rates?.CHF))
                add(CurrencyValue("CLF", CLF!!, rates?.CLF))
                add(CurrencyValue("CLP", CLP!!, rates?.CLP))
                add(CurrencyValue("CNH", CNH!!, rates?.CNH))
                add(CurrencyValue("CNY", CNY!!, rates?.CNY))
                add(CurrencyValue("COP", COP!!, rates?.COP))
                add(CurrencyValue("CRC", CRC!!, rates?.CRC))
                add(CurrencyValue("CUC", CUC!!, rates?.CUC))
                add(CurrencyValue("CUP", CUP!!, rates?.CUP))
                add(CurrencyValue("CVE", CVE!!, rates?.CVE))
                add(CurrencyValue("CZK", CZK!!, rates?.CZK))
                add(CurrencyValue("DJF", DJF!!, rates?.DJF))
                add(CurrencyValue("DKK", DKK!!, rates?.DKK))
                add(CurrencyValue("DOP", DOP!!, rates?.DOP))
                add(CurrencyValue("DZD", DZD!!, rates?.DZD))
                add(CurrencyValue("EGP", EGP!!, rates?.EGP))
                add(CurrencyValue("ERN", ERN!!, rates?.ERN))
                add(CurrencyValue("ETB", ETB!!, rates?.ETB))
                add(CurrencyValue("EUR", EUR!!, rates?.EUR))
                add(CurrencyValue("FJD", FJD!!, rates?.FJD))
                add(CurrencyValue("FKP", FKP!!, rates?.FKP))
                add(CurrencyValue("GBP", GBP!!, rates?.GBP))
                add(CurrencyValue("GEL", GEL!!, rates?.GEL))
                add(CurrencyValue("GGP", GGP!!, rates?.GGP))
                add(CurrencyValue("GHS", GHS!!, rates?.GHS))
                add(CurrencyValue("GIP", GIP!!, rates?.GIP))
                add(CurrencyValue("GMD", GMD!!, rates?.GMD))
                add(CurrencyValue("GNF", GNF!!, rates?.GNF))
                add(CurrencyValue("GTQ", GTQ!!, rates?.GTQ))
                add(CurrencyValue("GYD", GYD!!, rates?.GYD))
                add(CurrencyValue("HKD", HKD!!, rates?.HKD))
                add(CurrencyValue("HNL", HNL!!, rates?.HNL))
                add(CurrencyValue("HRK", HRK!!, rates?.HRK))
                add(CurrencyValue("HTG", HTG!!, rates?.HTG))
                add(CurrencyValue("HUF", HUF!!, rates?.HUF))
                add(CurrencyValue("IDR", IDR!!, rates?.IDR))
                add(CurrencyValue("ILS", ILS!!, rates?.ILS))
                add(CurrencyValue("DKK", DKK!!, rates?.DKK))
                add(CurrencyValue("IMP", IMP!!, rates?.IMP))
                add(CurrencyValue("INR", INR!!, rates?.INR))
                add(CurrencyValue("IQD", IQD!!, rates?.IQD))
                add(CurrencyValue("IRR", IRR!!, rates?.IRR))
                add(CurrencyValue("ISK", ISK!!, rates?.ISK))
                add(CurrencyValue("JEP", JEP!!, rates?.JEP))
                add(CurrencyValue("JMD", JMD!!, rates?.JMD))
                add(CurrencyValue("JOD", JOD!!, rates?.JOD))
                add(CurrencyValue("JPY", JPY!!, rates?.JPY))
                add(CurrencyValue("KES", KES!!, rates?.KES))
                add(CurrencyValue("KGS", KGS!!, rates?.KGS))
                add(CurrencyValue("KHR", KHR!!, rates?.KHR))
                add(CurrencyValue("KMF", KMF!!, rates?.KMF))
                add(CurrencyValue("KPW", KPW!!, rates?.KPW))
                add(CurrencyValue("KRW", KRW!!, rates?.KRW))
                add(CurrencyValue("KWD", KWD!!, rates?.KWD))
                add(CurrencyValue("KYD", KYD!!, rates?.KYD))
                add(CurrencyValue("KZT", KZT!!, rates?.KZT))
                add(CurrencyValue("LAK", LAK!!, rates?.LAK))
                add(CurrencyValue("LBP", LBP!!, rates?.LBP))
                add(CurrencyValue("LKR", LKR!!, rates?.LKR))
                add(CurrencyValue("LRD", LRD!!, rates?.LRD))
                add(CurrencyValue("LSL", LSL!!, rates?.LSL))
                add(CurrencyValue("LYD", LYD!!, rates?.LYD))
                add(CurrencyValue("MAD", MAD!!, rates?.MAD))
                add(CurrencyValue("MDL", MDL!!, rates?.MDL))
                add(CurrencyValue("MGA", MGA!!, rates?.MGA))
                add(CurrencyValue("MKD", MKD!!, rates?.MKD))
                add(CurrencyValue("MMK", MMK!!, rates?.MMK))
                add(CurrencyValue("MNT", MNT!!, rates?.MNT))
                add(CurrencyValue("MOP", MOP!!, rates?.MOP))
                add(CurrencyValue("MRU", MRU!!, rates?.MRU))
                add(CurrencyValue("MUR", MUR!!, rates?.MUR))
                add(CurrencyValue("MVR", MVR!!, rates?.MVR))
                add(CurrencyValue("MWK", MWK!!, rates?.MWK))
                add(CurrencyValue("MXN", MXN!!, rates?.MXN))
                add(CurrencyValue("MYR", MYR!!, rates?.MYR))
                add(CurrencyValue("MZN", MZN!!, rates?.MZN))
                add(CurrencyValue("NAD", NAD!!, rates?.NAD))
                add(CurrencyValue("NGN", NGN!!, rates?.NGN))
                add(CurrencyValue("NIO", NIO!!, rates?.NIO))
                add(CurrencyValue("NOK", NOK!!, rates?.NOK))
                add(CurrencyValue("NPR", NPR!!, rates?.NPR))
                add(CurrencyValue("OMR", OMR!!, rates?.OMR))
                add(CurrencyValue("PAB", PAB!!, rates?.OMR))
                add(CurrencyValue("PEN", PEN!!, rates?.PEN))
                add(CurrencyValue("PGK", PGK!!, rates?.PGK))
                add(CurrencyValue("PHP", PHP!!, rates?.PHP))
                add(CurrencyValue("PKR", PKR!!, rates?.PKR))
                add(CurrencyValue("PLN", PLN!!, rates?.PLN))
                add(CurrencyValue("PYG", PYG!!, rates?.PYG))
                add(CurrencyValue("QAR", QAR!!, rates?.QAR))
                add(CurrencyValue("RON", RON!!, rates?.RON))
                add(CurrencyValue("RSD", RSD!!, rates?.RSD))
                add(CurrencyValue("RUB", RUB!!, rates?.RUB))
                add(CurrencyValue("RWF", RWF!!, rates?.RWF))
                add(CurrencyValue("SAR", SAR!!, rates?.SAR))
                add(CurrencyValue("SBD", SBD!!, rates?.SBD))
                add(CurrencyValue("SCR", SCR!!, rates?.SCR))
                add(CurrencyValue("SDG", SDG!!, rates?.SDG))
                add(CurrencyValue("SEK", SEK!!, rates?.SEK))
                add(CurrencyValue("SGD", SGD!!, rates?.SGD))
                add(CurrencyValue("SHP", SHP!!, rates?.SHP))
                add(CurrencyValue("SLL", SLL!!, rates?.SLL))
                add(CurrencyValue("SOS", SOS!!, rates?.SOS))
                add(CurrencyValue("SRD", SRD!!, rates?.SRD))
                add(CurrencyValue("SSP", SSP!!, rates?.SSP))
                add(CurrencyValue("STD", STD!!, rates?.STD))
                add(CurrencyValue("STN", STN!!, rates?.STN))
                add(CurrencyValue("SVC", SVC!!, rates?.SVC))
                add(CurrencyValue("SYP", SYP!!, rates?.SYP))
                add(CurrencyValue("SZL", SZL!!, rates?.SZL))
                add(CurrencyValue("THB", THB!!, rates?.SZL))
                add(CurrencyValue("TJS", TJS!!, rates?.TJS))
                add(CurrencyValue("TMT", TMT!!, rates?.TMT))
                add(CurrencyValue("TND", TND!!, rates?.TND))
                add(CurrencyValue("TOP", TOP!!, rates?.TOP))
                add(CurrencyValue("TRY", TRY!!, rates?.TRY))
                add(CurrencyValue("TTD", TTD!!, rates?.TTD))
                add(CurrencyValue("TWD", TWD!!, rates?.TWD))
                add(CurrencyValue("TZS", TZS!!, rates?.TZS))
                add(CurrencyValue("UAH", UAH!!, rates?.UAH))
                add(CurrencyValue("UGX", UGX!!, rates?.UGX))
                add(CurrencyValue("USD", USD!!, rates?.USD))
                add(CurrencyValue("UYU", UYU!!, rates?.UYU))
                add(CurrencyValue("UZS", UZS!!, rates?.UZS))
                add(CurrencyValue("VEF", VEF!!, rates?.VEF))
                add(CurrencyValue("VES", VES!!, rates?.VES))
                add(CurrencyValue("VND", VND!!, rates?.VND))
                add(CurrencyValue("VUV", VUV!!, rates?.VUV))
                add(CurrencyValue("WST", WST!!, rates?.WST))
                add(CurrencyValue("XAF", XAF!!, rates?.XAF))
                add(CurrencyValue("XAG", XAG!!, rates?.XAG))
                add(CurrencyValue("XAU", XAU!!, rates?.XAU))
                add(CurrencyValue("XCD", XCD!!, rates?.XCD))
                add(CurrencyValue("XDR", XDR!!, rates?.XDR))
                add(CurrencyValue("XOF", XOF!!, rates?.XOF))
                add(CurrencyValue("XPD", XPD!!, rates?.XPD))
                add(CurrencyValue("XPF", XPF!!, rates?.XPF))
                add(CurrencyValue("XPT", XPT!!, rates?.XPT))
                add(CurrencyValue("YER", YER!!, rates?.YER))
                add(CurrencyValue("ZAR", ZAR!!, rates?.ZAR))
                add(CurrencyValue("ZMW", ZMW!!, rates?.ZMW))
                add(CurrencyValue("ZWL", ZWL!!, rates?.ZWL))
            }
        }
    }

    var BUNDLE_TITLE = ""

    fun View.OnClickListener.initMultipleViewsClickListener(vararg view: View) {
        for (v in view) {
            v.setOnClickListener(this)
        }
    }

    fun hasInternetConnected(context: Context): Boolean {

        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork = connectivityManager.activeNetwork ?: return false
            val networkCapabilities =
                connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
            return when {
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
                -> true
                else -> {
                    false
                }
            }
        } else { // necessary for lower version devices
            connectivityManager.activeNetworkInfo?.runCatching {
                return when (type) {
                    ConnectivityManager.TYPE_WIFI, ConnectivityManager.TYPE_MOBILE, ConnectivityManager.TYPE_ETHERNET -> true
                    else -> {
                        false
                    }
                }
            }
        }
        return false
    }

}