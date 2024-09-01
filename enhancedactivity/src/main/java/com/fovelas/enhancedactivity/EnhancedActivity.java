package com.fovelas.enhancedactivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import java.util.Set;

public abstract class EnhancedActivity<T extends ViewDataBinding> extends AppCompatActivity
{
    private static final String TAG = "EnhancedActivity";

    protected T binding;
    protected boolean isDrawn = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        beforeCreate();
        super.onCreate(savedInstanceState);
    }

    protected final void onDraw(int layoutId)
    {
        Log.d(TAG, "onDraw() fired.");

        if (!isDrawn)
        {
            binding = DataBindingUtil.setContentView(EnhancedActivity.this, layoutId);
            isDrawn = true;
        }
        init();

        Log.d(TAG, "onDraw() completed.");
    }

    protected void beforeCreate() {}

    protected void init()
    {
        getOnBackPressedDispatcher().addCallback(callback);
    }

    protected void onBackPressedEnhanced() {}

    protected void onActivityResultEnhanced(ActivityResult result) {}

    protected void onRequestPermissionResultEnhanced(Boolean result) {}

    protected void onIntentExtrasMissing(String missingKey) {}

    private void enableStrictMode()
    {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().penaltyDeath().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().penaltyDeath().build());
    }

    protected final void checkIntentExtras(String... requiredKeys)
    {
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) return;

        Set<String> bundleKeySet = bundle.keySet();

        for (String key : requiredKeys)
        {
            if (!bundleKeySet.contains(key))
            {
                onIntentExtrasMissing(key);
                break;
            }
        }
    }

    protected final String getStringExtra(String s)
    {
        String data = getIntent().getStringExtra(s);
        if (data == null) return "none";
        else return data;
    }

    protected final boolean getBooleanExtra(String s)
    {
        return getIntent().getBooleanExtra(s, false);
    }

    protected final LayoutInflater getInflater()
    {
        return LayoutInflater.from(EnhancedActivity.this);
    }

    private final OnBackPressedCallback callback = new OnBackPressedCallback(true)
    {
        @Override
        public void handleOnBackPressed()
        {
            onBackPressedEnhanced();
        }
    };

    protected final ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>()
    {
        @Override
        public void onActivityResult(ActivityResult result)
        {
            onActivityResultEnhanced(result);
        }
    });

    protected final ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>()
    {
        @Override
        public void onActivityResult(Boolean result)
        {
            onRequestPermissionResultEnhanced(result);
        }
    });
}