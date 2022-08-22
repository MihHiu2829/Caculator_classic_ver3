package com.example.project_61;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_61.databinding.M002ActCalcBinding;

public class M002_act_calc extends AppCompatActivity {
    private M002ActCalcBinding binding  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = M002ActCalcBinding.inflate(getLayoutInflater()) ;
        setContentView(binding.getRoot()) ;
        initView();
    }

    private void initView() {
        Intent intent = getIntent() ;
        if(intent == null )
        {
            return ;
        }
        String type = intent.getStringExtra(M001_act_main.KEY_TYPE);
        PairAB ab = (PairAB) intent.getSerializableExtra(M001_act_main.KEY_AB);
        int rs = 0 ;
        if(type.equals(M001_act_main.SUM_TYPE))
        {
            rs = ab.getA()+ab.getB() ;
        }else   rs = ab.getA() - ab.getB() ;

        binding.tvCalc.setText(String.format("%s %s %s = %s",ab.getA(),type,ab.getB(),rs));
    }
}