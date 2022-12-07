package com.hamy.currencyconverter.networking.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.View
import com.hamy.currencyconverter.views.model.CurrencyName
import com.hamy.currencyconverter.views.model.CurrencyValue

object Utils {

    fun currencyList(response: Resource.Success<CurrencyName>): ArrayList<CurrencyValue> {
      return  arrayListOf<CurrencyValue>().apply {
            response.data?.apply {

                add(CurrencyValue("AED", AED!!))
                add(CurrencyValue("ALL", ALL!!))
                add(CurrencyValue("AFN", AFN!!))
                add(CurrencyValue("AMD", AMD!!))
                add(CurrencyValue("ANG", ANG!!))
                add(CurrencyValue("AOA", AOA!!))
                add(CurrencyValue("ARS", ARS!!))
                add(CurrencyValue("AUD", AUD!!))
                add(CurrencyValue("AWG", AWG!!))
                add(CurrencyValue("AZN", AZN!!))
                add(CurrencyValue("BAM", BAM!!))
                add(CurrencyValue("BBD", BBD!!))
                add(CurrencyValue("BDT", BDT!!))
                add(CurrencyValue("BGN", BGN!!))
                add(CurrencyValue("BHD", BHD!!))
                add(CurrencyValue("BIF", BIF!!))
                add(CurrencyValue("BMD", BMD!!))
                add(CurrencyValue("BND", BND!!))
                add(CurrencyValue("BOB", BOB!!))
                add(CurrencyValue("BRL", BRL!!))
                add(CurrencyValue("BSD", BSD!!))
                add(CurrencyValue("BTC", BTC!!))
                add(CurrencyValue("BTC", BTC!!))
                add(CurrencyValue("BWP", BWP!!))
                add(CurrencyValue("BYN", BYN!!))
                add(CurrencyValue("BZD", BZD!!))
                add(CurrencyValue("CAD", CAD!!))
                add(CurrencyValue("CDF", CDF!!))
                add(CurrencyValue("CHF", CHF!!))
                add(CurrencyValue("CLF", CLF!!))
                add(CurrencyValue("CLP", CLP!!))
                add(CurrencyValue("CNH", CNH!!))
                add(CurrencyValue("CNY", CNY!!))
                add(CurrencyValue("COP", COP!!))
                add(CurrencyValue("CRC", CRC!!))
                add(CurrencyValue("CUC", CUC!!))
                add(CurrencyValue("CUP", CUP!!))
                add(CurrencyValue("CVE", CVE!!))
                add(CurrencyValue("CZK", CZK!!))
                add(CurrencyValue("DJF", DJF!!))
                add(CurrencyValue("DKK", DKK!!))
                add(CurrencyValue("DOP", DOP!!))
                add(CurrencyValue("DZD", DZD!!))
                add(CurrencyValue("EGP", EGP!!))
                add(CurrencyValue("ERN", ERN!!))
                add(CurrencyValue("ETB", ETB!!))
                add(CurrencyValue("EUR", EUR!!))
                add(CurrencyValue("FJD", FJD!!))
                add(CurrencyValue("FKP", FKP!!))
                add(CurrencyValue("GBP", GBP!!))
                add(CurrencyValue("GEL", GEL!!))
                add(CurrencyValue("GGP", GGP!!))
                add(CurrencyValue("GHS", GHS!!))
                add(CurrencyValue("GIP", GIP!!))
                add(CurrencyValue("GMD", GMD!!))
                add(CurrencyValue("GNF", GNF!!))
                add(CurrencyValue("GTQ", GTQ!!))
                add(CurrencyValue("GYD", GYD!!))
                add(CurrencyValue("HKD", HKD!!))
                add(CurrencyValue("HNL", HNL!!))
                add(CurrencyValue("HRK", HRK!!))
                add(CurrencyValue("HTG", HTG!!))
                add(CurrencyValue("HUF", HUF!!))
                add(CurrencyValue("IDR", IDR!!))
                add(CurrencyValue("ILS", ILS!!))
                add(CurrencyValue("DKK", DKK!!))
                add(CurrencyValue("IMP", IMP!!))
                add(CurrencyValue("INR", INR!!))
                add(CurrencyValue("IQD", IQD!!))
                add(CurrencyValue("IRR", IRR!!))
                add(CurrencyValue("ISK", ISK!!))
                add(CurrencyValue("JEP", JEP!!))
                add(CurrencyValue("JMD", JMD!!))
                add(CurrencyValue("JOD", JOD!!))
                add(CurrencyValue("JPY", JPY!!))
                add(CurrencyValue("KES", KES!!))
                add(CurrencyValue("KGS", KGS!!))
                add(CurrencyValue("KHR", KHR!!))
                add(CurrencyValue("KMF", KMF!!))
                add(CurrencyValue("KPW", KPW!!))
                add(CurrencyValue("KRW", KRW!!))
                add(CurrencyValue("KWD", KWD!!))
                add(CurrencyValue("KYD", KYD!!))
                add(CurrencyValue("KZT", KZT!!))
                add(CurrencyValue("LAK", LAK!!))
                add(CurrencyValue("LBP", LBP!!))
                add(CurrencyValue("LKR", LKR!!))
                add(CurrencyValue("LRD", LRD!!))
                add(CurrencyValue("LSL", LSL!!))
                add(CurrencyValue("LYD", LYD!!))
                add(CurrencyValue("MAD", MAD!!))
                add(CurrencyValue("MDL", MDL!!))
                add(CurrencyValue("MGA", MGA!!))
                add(CurrencyValue("MKD", MKD!!))
                add(CurrencyValue("MMK", MMK!!))
                add(CurrencyValue("MNT", MNT!!))
                add(CurrencyValue("MOP", MOP!!))
                add(CurrencyValue("MRU", MRU!!))
                add(CurrencyValue("MUR", MUR!!))
                add(CurrencyValue("MVR", MVR!!))
                add(CurrencyValue("MWK", MWK!!))
                add(CurrencyValue("MXN", MXN!!))
                add(CurrencyValue("MYR", MYR!!))
                add(CurrencyValue("MZN", MZN!!))
                add(CurrencyValue("NAD", NAD!!))
                add(CurrencyValue("NGN", NGN!!))
                add(CurrencyValue("NIO", NIO!!))
                add(CurrencyValue("NOK", NOK!!))
                add(CurrencyValue("NPR", NPR!!))
                add(CurrencyValue("OMR", OMR!!))
                add(CurrencyValue("PAB", PAB!!))
                add(CurrencyValue("PEN", PEN!!))
                add(CurrencyValue("PGK", PGK!!))
                add(CurrencyValue("PHP", PHP!!))
                add(CurrencyValue("PKR", PKR!!))
                add(CurrencyValue("PLN", PLN!!))
                add(CurrencyValue("PYG", PYG!!))
                add(CurrencyValue("QAR", QAR!!))
                add(CurrencyValue("RON", RON!!))
                add(CurrencyValue("RSD", RSD!!))
                add(CurrencyValue("RUB", RUB!!))
                add(CurrencyValue("RWF", RWF!!))
                add(CurrencyValue("SAR", SAR!!))
                add(CurrencyValue("SBD", SBD!!))
                add(CurrencyValue("SCR", SCR!!))
                add(CurrencyValue("SDG", SDG!!))
                add(CurrencyValue("SEK", SEK!!))
                add(CurrencyValue("SGD", SGD!!))
                add(CurrencyValue("SHP", SHP!!))
                add(CurrencyValue("SLL", SLL!!))
                add(CurrencyValue("SOS", SOS!!))
                add(CurrencyValue("SRD", SRD!!))
                add(CurrencyValue("SSP", SSP!!))
                add(CurrencyValue("STD", STD!!))
                add(CurrencyValue("STN", STN!!))
                add(CurrencyValue("SVC", SVC!!))
                add(CurrencyValue("SYP", SYP!!))
                add(CurrencyValue("SZL", SZL!!))
                add(CurrencyValue("THB", THB!!))
                add(CurrencyValue("TJS", TJS!!))
                add(CurrencyValue("TMT", TMT!!))
                add(CurrencyValue("TND", TND!!))
                add(CurrencyValue("TOP", TOP!!))
                add(CurrencyValue("TRY", TRY!!))
                add(CurrencyValue("TTD", TTD!!))
                add(CurrencyValue("TWD", TWD!!))
                add(CurrencyValue("TZS", TZS!!))
                add(CurrencyValue("UAH", UAH!!))
                add(CurrencyValue("UGX", UGX!!))
                add(CurrencyValue("USD", USD!!))
                add(CurrencyValue("UYU", UYU!!))
                add(CurrencyValue("UZS", UZS!!))
                add(CurrencyValue("VEF", VEF!!))
                add(CurrencyValue("VES", VES!!))
                add(CurrencyValue("VND", VND!!))
                add(CurrencyValue("VUV", VUV!!))
                add(CurrencyValue("WST", WST!!))
                add(CurrencyValue("XAF", XAF!!))
                add(CurrencyValue("XAG", XAG!!))
                add(CurrencyValue("XAU", XAU!!))
                add(CurrencyValue("XCD", XCD!!))
                add(CurrencyValue("XDR", XDR!!))
                add(CurrencyValue("XOF", XOF!!))
                add(CurrencyValue("XPD", XPD!!))
                add(CurrencyValue("XPF", XPF!!))
                add(CurrencyValue("XPT", XPT!!))
                add(CurrencyValue("YER", YER!!))
                add(CurrencyValue("ZAR", ZAR!!))
                add(CurrencyValue("ZMW", ZMW!!))
                add(CurrencyValue("ZWL", ZWL!!))
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