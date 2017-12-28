package com.art2cat.dev.fittool


import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

class CalFragment : Fragment() {

    private var mKj: String? = null
    private var mKcal: String? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cal, container, false)
        val kj = view.findViewById<EditText>(R.id.kj)
        val kcal = view.findViewById<EditText>(R.id.kcal)

        kj.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                mKj = charSequence.toString()
            }

            override fun afterTextChanged(editable: Editable) {

                if (!mKj!!.isEmpty()) {
                    kcal.setText(FitUtils.kjToKcal(mKj))
                }
            }
        })

        kcal.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                mKcal = charSequence.toString()
            }

            override fun afterTextChanged(editable: Editable) {
                //                if (!mKcal.isEmpty()) {
                //                    kj.setText(FitUtils.newInstance().kcalToKj(mKcal));
                //                }
            }
        })
        return view
    }

}
