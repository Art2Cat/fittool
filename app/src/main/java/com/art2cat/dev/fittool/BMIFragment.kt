package com.art2cat.dev.fittool


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


class BMIFragment : Fragment() {
    private var mActivity: Activity? = null


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mActivity = context as Activity?

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bmi, container, false)
        val height = view.findViewById<EditText>(R.id.height)
        val weight = view.findViewById<EditText>(R.id.weight)

        val mainActivity = mActivity as MainActivity?


        val button = view.findViewById<Button>(R.id.calculate)

        button.setOnClickListener { view1 ->
            val hs = height.text.toString()
            val ws = weight.text.toString()
            if (!hs.isEmpty() && !ws.isEmpty()) {
                val result = FitUtils.calculateBMI(hs, ws)
                Log.d(TAG, "onClick: " + result)
                if (mainActivity!!.mTextMessage != null) {
                    mainActivity.mTextMessage!!.text = result
                }
            } else {
                Snackbar.make(view1, "height can't be zero", Snackbar.LENGTH_SHORT).show()
            }
        }
        return view
    }

    companion object {

        private val TAG = "BMIFragment"
    }

}
