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

    var BUNDLE_TITLE = "bundle"
    var selectedTpe = "type"
    var currency = ""
    var currencyFrom = "PKR"
    var currencyTo = "PKR"

    fun currencyList(  // updating rates after 30 Mint of interval
        response: Resource.Success<CurrencyName>,
        rates: Rates?,
    ): ArrayList<CurrencyValue> {
        return arrayListOf<CurrencyValue>().apply {
            response.data?.apply {
                add(CurrencyValue(1, "AED", AED!!, rates?.AED.toString()))
                add(CurrencyValue(2, "ALL", ALL!!, rates?.ALL.toString()))
                add(CurrencyValue(3, "AFN", AFN!!, rates?.AFN.toString()))
                add(CurrencyValue(4, "AMD", AMD!!, rates?.AMD.toString()))
                add(CurrencyValue(5, "ANG", ANG!!, rates?.ANG.toString()))
                add(CurrencyValue(6, "AOA", AOA!!, rates?.AOA.toString()))
                add(CurrencyValue(7, "ARS", ARS!!, rates?.ARS.toString()))
                add(CurrencyValue(8, "AUD", AUD!!, rates?.AUD.toString()))
                add(CurrencyValue(9, "AWG", AWG!!, rates?.AWG.toString()))
                add(CurrencyValue(10, "AZN", AZN!!, rates?.AZN.toString()))
                add(CurrencyValue(11, "BAM", BAM!!, rates?.BAM.toString()))
                add(CurrencyValue(12, "BBD", BBD!!, rates?.BBD.toString()))
                add(CurrencyValue(13, "BDT", BDT!!, rates?.BDT.toString()))
                add(CurrencyValue(14, "BGN", BGN!!, rates?.BGN.toString()))
                add(CurrencyValue(15, "BHD", BHD!!, rates?.BHD.toString()))
                add(CurrencyValue(16, "BIF", BIF!!, rates?.BIF.toString()))
                add(CurrencyValue(17, "BMD", BMD!!, rates?.BMD.toString()))
                add(CurrencyValue(18, "BND", BND!!, rates?.BND.toString()))
                add(CurrencyValue(19, "BOB", BOB!!, rates?.BOB.toString()))
                add(CurrencyValue(20, "BRL", BRL!!, rates?.BRL.toString()))
                add(CurrencyValue(21, "BSD", BSD!!, rates?.BSD.toString()))
                add(CurrencyValue(22, "BTC", BTC!!, rates?.BTC.toString()))
                add(CurrencyValue(23, "BWP", BWP!!, rates?.BWP.toString()))
                add(CurrencyValue(24, "BYN", BYN!!, rates?.BYN.toString()))
                add(CurrencyValue(25, "BZD", BZD!!, rates?.BZD.toString()))
                add(CurrencyValue(26, "CAD", CAD!!, rates?.CAD.toString()))
                add(CurrencyValue(27, "CDF", CDF!!, rates?.CDF.toString()))
                add(CurrencyValue(28, "CHF", CHF!!, rates?.CHF.toString()))
                add(CurrencyValue(29, "CLF", CLF!!, rates?.CLF.toString()))
                add(CurrencyValue(30, "CLP", CLP!!, rates?.CLP.toString()))
                add(CurrencyValue(31, "CNH", CNH!!, rates?.CNH.toString()))
                add(CurrencyValue(32, "CNY", CNY!!, rates?.CNY.toString()))
                add(CurrencyValue(33, "COP", COP!!, rates?.COP.toString()))
                add(CurrencyValue(34, "CRC", CRC!!, rates?.CRC.toString()))
                add(CurrencyValue(35, "CUC", CUC!!, rates?.CUC.toString()))
                add(CurrencyValue(36, "CUP", CUP!!, rates?.CUP.toString()))
                add(CurrencyValue(37, "CVE", CVE!!, rates?.CVE.toString()))
                add(CurrencyValue(38, "CZK", CZK!!, rates?.CZK.toString()))
                add(CurrencyValue(39, "DJF", DJF!!, rates?.DJF.toString()))
                add(CurrencyValue(40, "DKK", DKK!!, rates?.DKK.toString()))
                add(CurrencyValue(41, "DOP", DOP!!, rates?.DOP.toString()))
                add(CurrencyValue(42, "DZD", DZD!!, rates?.DZD.toString()))
                add(CurrencyValue(43, "EGP", EGP!!, rates?.EGP.toString()))
                add(CurrencyValue(44, "ERN", ERN!!, rates?.ERN.toString()))
                add(CurrencyValue(45, "ETB", ETB!!, rates?.ETB.toString()))
                add(CurrencyValue(46, "EUR", EUR!!, rates?.EUR.toString()))
                add(CurrencyValue(47, "FJD", FJD!!, rates?.FJD.toString()))
                add(CurrencyValue(48, "FKP", FKP!!, rates?.FKP.toString()))
                add(CurrencyValue(49, "GBP", GBP!!, rates?.GBP.toString()))
                add(CurrencyValue(50, "GEL", GEL!!, rates?.GEL.toString()))
                add(CurrencyValue(51, "GGP", GGP!!, rates?.GGP.toString()))
                add(CurrencyValue(52, "GHS", GHS!!, rates?.GHS.toString()))
                add(CurrencyValue(53, "GIP", GIP!!, rates?.GIP.toString()))
                add(CurrencyValue(54, "GMD", GMD!!, rates?.GMD.toString()))
                add(CurrencyValue(55, "GNF", GNF!!, rates?.GNF.toString()))
                add(CurrencyValue(56, "GTQ", GTQ!!, rates?.GTQ.toString()))
                add(CurrencyValue(57, "GYD", GYD!!, rates?.GYD.toString()))
                add(CurrencyValue(58, "HKD", HKD!!, rates?.HKD.toString()))
                add(CurrencyValue(59, "HNL", HNL!!, rates?.HNL.toString()))
                add(CurrencyValue(60, "HRK", HRK!!, rates?.HRK.toString()))
                add(CurrencyValue(61, "HTG", HTG!!, rates?.HTG.toString()))
                add(CurrencyValue(62, "HUF", HUF!!, rates?.HUF.toString()))
                add(CurrencyValue(63, "IDR", IDR!!, rates?.IDR.toString()))
                add(CurrencyValue(64, "ILS", ILS!!, rates?.ILS.toString()))
                add(CurrencyValue(65, "DKK", DKK!!, rates?.DKK.toString()))
                add(CurrencyValue(66, "IMP", IMP!!, rates?.IMP.toString()))
                add(CurrencyValue(67, "INR", INR!!, rates?.INR.toString()))
                add(CurrencyValue(68, "IQD", IQD!!, rates?.IQD.toString()))
                add(CurrencyValue(69, "IRR", IRR!!, rates?.IRR.toString()))
                add(CurrencyValue(70, "ISK", ISK!!, rates?.ISK.toString()))
                add(CurrencyValue(71, "JEP", JEP!!, rates?.JEP.toString()))
                add(CurrencyValue(72, "JMD", JMD!!, rates?.JMD.toString()))
                add(CurrencyValue(73, "JOD", JOD!!, rates?.JOD.toString()))
                add(CurrencyValue(74, "JPY", JPY!!, rates?.JPY.toString()))
                add(CurrencyValue(75, "KES", KES!!, rates?.KES.toString()))
                add(CurrencyValue(76, "KGS", KGS!!, rates?.KGS.toString()))
                add(CurrencyValue(77, "KHR", KHR!!, rates?.KHR.toString()))
                add(CurrencyValue(78, "KMF", KMF!!, rates?.KMF.toString()))
                add(CurrencyValue(79, "KPW", KPW!!, rates?.KPW.toString()))
                add(CurrencyValue(80, "KRW", KRW!!, rates?.KRW.toString()))
                add(CurrencyValue(81, "KWD", KWD!!, rates?.KWD.toString()))
                add(CurrencyValue(82, "KYD", KYD!!, rates?.KYD.toString()))
                add(CurrencyValue(83, "KZT", KZT!!, rates?.KZT.toString()))
                add(CurrencyValue(84, "LAK", LAK!!, rates?.LAK.toString()))
                add(CurrencyValue(85, "LBP", LBP!!, rates?.LBP.toString()))
                add(CurrencyValue(86, "LKR", LKR!!, rates?.LKR.toString()))
                add(CurrencyValue(87, "LRD", LRD!!, rates?.LRD.toString()))
                add(CurrencyValue(88, "LSL", LSL!!, rates?.LSL.toString()))
                add(CurrencyValue(89, "LYD", LYD!!, rates?.LYD.toString()))
                add(CurrencyValue(90, "MAD", MAD!!, rates?.MAD.toString()))
                add(CurrencyValue(91, "MDL", MDL!!, rates?.MDL.toString()))
                add(CurrencyValue(92, "MGA", MGA!!, rates?.MGA.toString()))
                add(CurrencyValue(93, "MKD", MKD!!, rates?.MKD.toString()))
                add(CurrencyValue(94, "MMK", MMK!!, rates?.MMK.toString()))
                add(CurrencyValue(95, "MNT", MNT!!, rates?.MNT.toString()))
                add(CurrencyValue(96, "MOP", MOP!!, rates?.MOP.toString()))
                add(CurrencyValue(97, "MRU", MRU!!, rates?.MRU.toString()))
                add(CurrencyValue(98, "MUR", MUR!!, rates?.MUR.toString()))
                add(CurrencyValue(99, "MVR", MVR!!, rates?.MVR.toString()))
                add(CurrencyValue(100, "MWK", MWK!!, rates?.MWK.toString()))
                add(CurrencyValue(101, "MXN", MXN!!, rates?.MXN.toString()))
                add(CurrencyValue(102, "MYR", MYR!!, rates?.MYR.toString()))
                add(CurrencyValue(103, "MZN", MZN!!, rates?.MZN.toString()))
                add(CurrencyValue(104, "NAD", NAD!!, rates?.NAD.toString()))
                add(CurrencyValue(105, "NGN", NGN!!, rates?.NGN.toString()))
                add(CurrencyValue(106, "NIO", NIO!!, rates?.NIO.toString()))
                add(CurrencyValue(107, "NOK", NOK!!, rates?.NOK.toString()))
                add(CurrencyValue(108, "NPR", NPR!!, rates?.NPR.toString()))
                add(CurrencyValue(109, "OMR", OMR!!, rates?.OMR.toString()))
                add(CurrencyValue(110, "PAB", PAB!!, rates?.OMR.toString()))
                add(CurrencyValue(111, "PEN", PEN!!, rates?.PEN.toString()))
                add(CurrencyValue(112, "PGK", PGK!!, rates?.PGK.toString()))
                add(CurrencyValue(113, "PHP", PHP!!, rates?.PHP.toString()))
                add(CurrencyValue(114, "PKR", PKR!!, rates?.PKR.toString()))
                add(CurrencyValue(115, "PLN", PLN!!, rates?.PLN.toString()))
                add(CurrencyValue(116, "PYG", PYG!!, rates?.PYG.toString()))
                add(CurrencyValue(117, "QAR", QAR!!, rates?.QAR.toString()))
                add(CurrencyValue(118, "RON", RON!!, rates?.RON.toString()))
                add(CurrencyValue(119, "RSD", RSD!!, rates?.RSD.toString()))
                add(CurrencyValue(120, "RUB", RUB!!, rates?.RUB.toString()))
                add(CurrencyValue(121, "RWF", RWF!!, rates?.RWF.toString()))
                add(CurrencyValue(122, "SAR", SAR!!, rates?.SAR.toString()))
                add(CurrencyValue(123, "SBD", SBD!!, rates?.SBD.toString()))
                add(CurrencyValue(124, "SCR", SCR!!, rates?.SCR.toString()))
                add(CurrencyValue(125, "SDG", SDG!!, rates?.SDG.toString()))
                add(CurrencyValue(126, "SEK", SEK!!, rates?.SEK.toString()))
                add(CurrencyValue(127, "SGD", SGD!!, rates?.SGD.toString()))
                add(CurrencyValue(128, "SHP", SHP!!, rates?.SHP.toString()))
                add(CurrencyValue(129, "SLL", SLL!!, rates?.SLL.toString()))
                add(CurrencyValue(130, "SOS", SOS!!, rates?.SOS.toString()))
                add(CurrencyValue(131, "SRD", SRD!!, rates?.SRD.toString()))
                add(CurrencyValue(132, "SSP", SSP!!, rates?.SSP.toString()))
                add(CurrencyValue(133, "STD", STD!!, rates?.STD.toString()))
                add(CurrencyValue(134, "STN", STN!!, rates?.STN.toString()))
                add(CurrencyValue(135, "SVC", SVC!!, rates?.SVC.toString()))
                add(CurrencyValue(136, "SYP", SYP!!, rates?.SYP.toString()))
                add(CurrencyValue(137, "SZL", SZL!!, rates?.SZL.toString()))
                add(CurrencyValue(138, "THB", THB!!, rates?.SZL.toString()))
                add(CurrencyValue(139, "TJS", TJS!!, rates?.TJS.toString()))
                add(CurrencyValue(140, "TMT", TMT!!, rates?.TMT.toString()))
                add(CurrencyValue(141, "TND", TND!!, rates?.TND.toString()))
                add(CurrencyValue(142, "TOP", TOP!!, rates?.TOP.toString()))
                add(CurrencyValue(143, "TRY", TRY!!, rates?.TRY.toString()))
                add(CurrencyValue(144, "TTD", TTD!!, rates?.TTD.toString()))
                add(CurrencyValue(145, "TWD", TWD!!, rates?.TWD.toString()))
                add(CurrencyValue(146, "TZS", TZS!!, rates?.TZS.toString()))
                add(CurrencyValue(147, "UAH", UAH!!, rates?.UAH.toString()))
                add(CurrencyValue(148, "UGX", UGX!!, rates?.UGX.toString()))
                add(CurrencyValue(149, "USD", USD!!, rates?.USD.toString()))
                add(CurrencyValue(150, "UYU", UYU!!, rates?.UYU.toString()))
                add(CurrencyValue(151, "UZS", UZS!!, rates?.UZS.toString()))
                add(CurrencyValue(152, "VEF", VEF!!, rates?.VEF.toString()))
                add(CurrencyValue(153, "VES", VES!!, rates?.VES.toString()))
                add(CurrencyValue(154, "VND", VND!!, rates?.VND.toString()))
                add(CurrencyValue(155, "VUV", VUV!!, rates?.VUV.toString()))
                add(CurrencyValue(156, "WST", WST!!, rates?.WST.toString()))
                add(CurrencyValue(157, "XAG", XAG!!, rates?.XAG.toString()))
                add(CurrencyValue(158, "XAU", XAU!!, rates?.XAU.toString()))
                add(CurrencyValue(159, "XCD", XCD!!, rates?.XCD.toString()))
                add(CurrencyValue(160, "XDR", XDR!!, rates?.XDR.toString()))
                add(CurrencyValue(161, "XOF", XOF!!, rates?.XOF.toString()))
                add(CurrencyValue(162, "XPD", XPD!!, rates?.XPD.toString()))
                add(CurrencyValue(163, "XPF", XPF!!, rates?.XPF.toString()))
                add(CurrencyValue(164, "XPT", XPT!!, rates?.XPT.toString()))
                add(CurrencyValue(165, "YER", YER!!, rates?.YER.toString()))
                add(CurrencyValue(166, "ZAR", ZAR!!, rates?.ZAR.toString()))
                add(CurrencyValue(167, "ZMW", ZMW!!, rates?.ZMW.toString()))
                add(CurrencyValue(168, "ZWL", ZWL!!, rates?.ZWL.toString()))
            }
        }
    }

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