package com.art2cat.dev.fittool;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class BMIFragment extends Fragment {

    private static final String TAG = "BMIFragment";
    private Activity mActivity;


    public BMIFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bmi, container, false);
        EditText height = view.findViewById(R.id.height);
        EditText weight = view.findViewById(R.id.weight);

        MainActivity mainActivity = (MainActivity) mActivity;



        Button button = view.findViewById(R.id.calculate);

        button.setOnClickListener(view1 -> {
            String hs = height.getText().toString();
            String ws = weight.getText().toString();
            if (!hs.isEmpty() && !ws.isEmpty() && Double.valueOf(hs) != 0) {
                String result = FitUtils.newInstance().calculateBMI(hs, ws);
                Log.d(TAG, "onClick: " + result);
                if (mainActivity.mTextMessage != null) {
                    mainActivity.mTextMessage.setText(result);
                }
            } else {
                Snackbar.make(view1, "height can't be zero", Snackbar.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
