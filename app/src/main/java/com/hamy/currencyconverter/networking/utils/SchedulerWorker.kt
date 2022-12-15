package com.hamy.currencyconverter.networking.utils

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.hamy.currencyconverter.R
import com.hamy.currencyconverter.database.AppDatabase
import com.hamy.currencyconverter.database.dao.CurrencyDao
import com.hamy.currencyconverter.networking.RetroInstance

class SchedulerWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    private var database: CurrencyDao? = null

    override fun doWork(): Result {
        try {
            database = AppDatabase.getAppDataBase(applicationContext)?.routineDao()
            RetroInstance.api.getRates().execute().apply {
                if (isSuccessful && body() != null) {
                    body()?.rates?.apply {
                        database?.apply {
                            updateSell("AED", AED.toString())
                            updateSell("ALL", ALL.toString())
                            updateSell("AFN", AFN.toString())
                            updateSell("AMD", AMD.toString())
                            updateSell("ANG", ANG.toString())
                            updateSell("AOA", AOA.toString())
                            updateSell("ARS", ARS.toString())
                            updateSell("AUD", AUD.toString())
                            updateSell("AWG", AWG.toString())
                            updateSell("AZN", AZN.toString())
                            updateSell("BAM", BAM.toString())
                            updateSell("BBD", BBD.toString())
                            updateSell("BDT", BDT.toString())
                            updateSell("BGN", BGN.toString())
                            updateSell("BHD", BHD.toString())
                            updateSell("BIF", BIF.toString())
                            updateSell("BMD", BMD.toString())
                            updateSell("BND", BND.toString())
                            updateSell("BOB", BOB.toString())
                            updateSell("BRL", BRL.toString())
                            updateSell("BSD", BSD.toString())
                            updateSell("BTC", BTC.toString())
                            updateSell("BWP", BWP.toString())
                            updateSell("BYN", BYN.toString())
                            updateSell("BZD", BZD.toString())
                            updateSell("CAD", CAD.toString())
                            updateSell("CDF", CDF.toString())
                            updateSell("CHF", CHF.toString())
                            updateSell("CLF", CLF.toString())
                            updateSell("CLP", CLP.toString())
                            updateSell("CNH", CNH.toString())
                            updateSell("CNY", CNY.toString())
                            updateSell("COP", COP.toString())
                            updateSell("CRC", CRC.toString())
                            updateSell("CUC", CUC.toString())
                            updateSell("CUP", CUP.toString())
                            updateSell("CVE", CVE.toString())
                            updateSell("CZK", CZK.toString())
                            updateSell("DJF", DJF.toString())
                            updateSell("DKK", DKK.toString())
                            updateSell("DOP", DOP.toString())
                            updateSell("DZD", DZD.toString())
                            updateSell("EGP", EGP.toString())
                            updateSell("ERN", ERN.toString())
                            updateSell("ETB", ETB.toString())
                            updateSell("EUR", EUR.toString())
                            updateSell("FJD", FJD.toString())
                            updateSell("FKP", FKP.toString())
                            updateSell("GBP", GBP.toString())
                            updateSell("GEL", GEL.toString())
                            updateSell("GGP", GGP.toString())
                            updateSell("GHS", GHS.toString())
                            updateSell("GIP", GIP.toString())
                            updateSell("GMD", GMD.toString())
                            updateSell("GNF", GNF.toString())
                            updateSell("GTQ", GTQ.toString())
                            updateSell("GYD", GYD.toString())
                            updateSell("HKD", HKD.toString())
                            updateSell("HNL", HNL.toString())
                            updateSell("HRK", HRK.toString())
                            updateSell("HTG", HTG.toString())
                            updateSell("HUF", HUF.toString())
                            updateSell("IDR", IDR.toString())
                            updateSell("ILS", ILS.toString())
                            updateSell("DKK", DKK.toString())
                            updateSell("IMP", IMP.toString())
                            updateSell("INR", INR.toString())
                            updateSell("IQD", IQD.toString())
                            updateSell("IRR", IRR.toString())
                            updateSell("ISK", ISK.toString())
                            updateSell("JEP", JEP.toString())
                            updateSell("JMD", JMD.toString())
                            updateSell("JOD", JOD.toString())
                            updateSell("JPY", JPY.toString())
                            updateSell("KES", KES.toString())
                            updateSell("KGS", KGS.toString())
                            updateSell("KHR", KHR.toString())
                            updateSell("KMF", KMF.toString())
                            updateSell("KPW", KPW.toString())
                            updateSell("KRW", KRW.toString())
                            updateSell("KWD", KWD.toString())
                            updateSell("KYD", KYD.toString())
                            updateSell("KZT", KZT.toString())
                            updateSell("LAK", LAK.toString())
                            updateSell("LBP", LBP.toString())
                            updateSell("LKR", LKR.toString())
                            updateSell("LRD", LRD.toString())
                            updateSell("LSL", LSL.toString())
                            updateSell("LYD", LYD.toString())
                            updateSell("MAD", MAD.toString())
                            updateSell("MDL", MDL.toString())
                            updateSell("MGA", MGA.toString())
                            updateSell("MKD", MKD.toString())
                            updateSell("MMK", MMK.toString())
                            updateSell("MNT", MNT.toString())
                            updateSell("MOP", MOP.toString())
                            updateSell("MRU", MRU.toString())
                            updateSell("MUR", MUR.toString())
                            updateSell("MVR", MVR.toString())
                            updateSell("MWK", MWK.toString())
                            updateSell("MXN", MXN.toString())
                            updateSell("MYR", MYR.toString())
                            updateSell("MZN", MZN.toString())
                            updateSell("NAD", NAD.toString())
                            updateSell("NGN", NGN.toString())
                            updateSell("NIO", NIO.toString())
                            updateSell("NOK", NOK.toString())
                            updateSell("NPR", NPR.toString())
                            updateSell("OMR", OMR.toString())
                            updateSell("PAB", PAB.toString())
                            updateSell("PEN", PEN.toString())
                            updateSell("PGK", PGK.toString())
                            updateSell("PHP", PHP.toString())
                            updateSell("PKR", PKR.toString())
                            updateSell("PLN", PLN.toString())
                            updateSell("PYG", PYG.toString())
                            updateSell("QAR", QAR.toString())
                            updateSell("RON", RON.toString())
                            updateSell("RSD", RSD.toString())
                            updateSell("RUB", RUB.toString())
                            updateSell("RWF", RWF.toString())
                            updateSell("SAR", SAR.toString())
                            updateSell("SBD", SBD.toString())
                            updateSell("SCR", SCR.toString())
                            updateSell("SDG", SDG.toString())
                            updateSell("SEK", SEK.toString())
                            updateSell("SGD", SGD.toString())
                            updateSell("SHP", SHP.toString())
                            updateSell("SLL", SLL.toString())
                            updateSell("SOS", SOS.toString())
                            updateSell("SRD", SRD.toString())
                            updateSell("SSP", SSP.toString())
                            updateSell("STD", STD.toString())
                            updateSell("STN", STN.toString())
                            updateSell("SVC", SVC.toString())
                            updateSell("SYP", SYP.toString())
                            updateSell("SZL", SZL.toString())
                            updateSell("THB", THB.toString())
                            updateSell("TJS", TJS.toString())
                            updateSell("TMT", TMT.toString())
                            updateSell("TND", TND.toString())
                            updateSell("TOP", TOP.toString())
                            updateSell("TRY", TRY.toString())
                            updateSell("TTD", TTD.toString())
                            updateSell("TWD", TWD.toString())
                            updateSell("TZS", TZS.toString())
                            updateSell("UAH", UAH.toString())
                            updateSell("UGX", UGX.toString())
                            updateSell("USD", USD.toString())
                            updateSell("UYU", UYU.toString())
                            updateSell("UZS", UZS.toString())
                            updateSell("VEF", VEF.toString())
                            updateSell("VES", VES.toString())
                            updateSell("VND", VND.toString())
                            updateSell("VUV", VUV.toString())
                            updateSell("WST", WST.toString())
                            updateSell("XAG", XAG.toString())
                            updateSell("XAU", XAU.toString())
                            updateSell("XCD", XCD.toString())
                            updateSell("XDR", XDR.toString())
                            updateSell("XOF", XOF.toString())
                            updateSell("XPD", XPD.toString())
                            updateSell("XPF", XPF.toString())
                            updateSell("XPT", XPT.toString())
                            updateSell("YER", YER.toString())
                            updateSell("ZAR", ZAR.toString())
                            updateSell("ZMW", ZMW.toString())
                            updateSell("ZWL", ZWL.toString())

                        }
                    }

                    WorkerUtils.makeStatusNotification(
                        applicationContext.getString(R.string.new_data_available),
                        applicationContext
                    )
                    Result.success()
                } else {
                    Result.retry()
                }
            }
        } catch (ex: Exception) {
            ex.message
        }
        WorkerUtils.sleep()
        return Result.failure()
    }

    override fun onStopped() {
        super.onStopped()
        Log.i(TAG, "OnStopped called for this worker")
    }

    companion object {
        private val TAG = SchedulerWorker::class.java.simpleName
    }
}