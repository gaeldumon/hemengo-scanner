package com.example.hemengoscanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

// Implements the interface onClickListener of the View class for the onclick behaviour of button
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button scanBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencing and initializing layout elements
        scanBtn = findViewById(R.id.btnScan);

        // Adding listener to the button
        scanBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // The IntentIntegrator class is the class of QR library. We need to declare an instance of it.
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);

        // We only allow QR Codes
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);

        // We display a short message at the bottom of the camera screen
        intentIntegrator.setPrompt("Veuillez scanner le QR Code présent sur le distributeur");

        // To have vertical camera layout (AnyOrientationCaptureActivity has fullSensor screen orientation)
        intentIntegrator.setCaptureActivity(AnyOrientationCaptureActivity.class);

        // Locking up the vertical orientation
        intentIntegrator.setOrientationLocked(true);

        // Launching scan
        intentIntegrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (intentResult != null) {

            if (intentResult.getContents() == null) {
                // If the intentResult is null then we toast a message
                Toast.makeText(getBaseContext(), "Scan annulé", Toast.LENGTH_LONG).show();

            } else {
                // If the intentResult is not null we display the qr code content
                String msgContent = "Distributeur reconnu ! (data: " + intentResult.getContents() + ")";
                Toast.makeText(getBaseContext(), msgContent, Toast.LENGTH_LONG).show();
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
