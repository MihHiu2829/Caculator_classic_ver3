package com.example.project_61;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.project_61.databinding.M001ActMainBinding;

public class M001_act_main extends AppCompatActivity implements View.OnClickListener {
    public static final String SUM_TYPE = "+";
    public static final String SUB_TYPE = "-";
    public static final String KEY_TYPE = "+";
    public static final String KEY_AB = "KEY_AB";
    protected M001ActMainBinding binding ;  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = M001ActMainBinding.inflate(getLayoutInflater()); 
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        binding.btSub.setOnClickListener(v->doCalc(SUB_TYPE));
        binding.btSum.setOnClickListener(v->doCalc(SUM_TYPE));
    }

    private void doCalc(String type) {
            String txtA = binding.edtNA.getText().toString() ;
            String txtB = binding.edtNB.getText().toString() ;
            if (txtA == null || txtB == null)
                Toast.makeText(this, "Please, enter a,b", Toast.LENGTH_SHORT).show();

            PairAB ab = new PairAB(Integer.parseInt(txtA),Integer.parseInt(txtB)) ;
            Intent intent = new Intent() ;
            intent.setClass(this, M002_act_calc.class);
            intent.putExtra(KEY_TYPE,type);
            intent.putExtra(KEY_AB,ab) ;
                startActivity(intent);
    }


    @Override
    public void onClick(View view) {

    }
}