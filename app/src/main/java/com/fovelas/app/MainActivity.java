package com.fovelas.app;

import android.os.Bundle;
import android.util.Log;

import com.fovelas.app.databinding.ActivityMainBinding;
import com.fovelas.enhancedactivity.EnhancedActivity;

public final class MainActivity extends EnhancedActivity<ActivityMainBinding>
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.onDraw(R.layout.activity_main);
        super.checkIntentExtras("example_key", "data");
    }

    @Override
    protected void init()
    {
        super.init();
    }

    @Override
    protected void onBackPressedEnhanced()
    {
        super.onBackPressedEnhanced();
        finish();
    }

    @Override
    protected void onIntentExtrasMissing(String missingKey)
    {
        super.onIntentExtrasMissing(missingKey);
        Log.d("MainActivity", "MissingKey: " + missingKey);
    }
}