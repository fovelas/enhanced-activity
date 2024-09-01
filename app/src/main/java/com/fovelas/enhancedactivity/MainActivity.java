package com.fovelas.enhancedactivity;

import android.os.Bundle;
import android.util.Log;

import com.fovelas.enhancedactivity.databinding.ActivityMainBinding;

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