package com.example.hemengoscanner;

import com.journeyapps.barcodescanner.CaptureActivity;

/**
 * This class is only created to have vertical camera layout when launching the camera.
 * It is set to have a fullSensor screen orientation (vertical) in the application manifest.
 * Then in the main activity, the QR Library (IntentIntegrator) is told to use this activity class
 * as the "capture" activity.
 */
public class AnyOrientationCaptureActivity extends CaptureActivity {
    // No need to do anything here for now.
}