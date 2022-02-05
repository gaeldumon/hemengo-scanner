package com.example.hemengoscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ScanManuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_manu);

        TextView helpTextManu = (TextView) this.findViewById(R.id.helpTextManu);
        helpTextManu.setSelected(true);
    }
}