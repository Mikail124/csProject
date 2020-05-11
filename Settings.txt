package com.example.idk;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class Settings {
    
    enum DarkModeConfigg {
        YE, NO, FOLLOW_SYSTEM
    }

    private static final String TAG = "Settings";

    public void changePassword() {
        FirebaseAuth.getInstance().sendPasswordResetEmail("user@example.com")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Email sent.");
                        }
                    }
                });
    }

    public void shouldEnableDarkMode(MainActivity.DarkModeConfigg darkModeConfig)
    {
        switch (darkModeConfig) {
            case YE:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case NO:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case FOLLOW_SYSTEM:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                break;
        }

    }

    private void applyLanguage(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        context.getResources().getConfiguration().setLocale(locale);
        context.getResources().updateConfiguration(context.getResources().getConfiguration(), context.getResources().getDisplayMetrics());

    }

}
