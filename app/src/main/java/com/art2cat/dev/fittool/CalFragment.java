package com.art2cat.dev.fittool;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalFragment extends Fragment {

private String mKj;
private String mKcal;
    public CalFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cal, container, false);
        EditText kj = view.findViewById(R.id.kj);
        EditText kcal = view.findViewById(R.id.kcal);

        kj.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mKj = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (!mKj.isEmpty()) {
                    kcal.setText(FitUtils.newInstance().kjToKcal(mKj));
                }
            }
        });

        kcal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mKcal = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {
//                if (!mKcal.isEmpty()) {
//                    kj.setText(FitUtils.newInstance().kcalToKj(mKcal));
//                }
            }
        });
        return view;
    }

}
