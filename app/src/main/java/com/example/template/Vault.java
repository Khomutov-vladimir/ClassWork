package com.example.template;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

/**
 * Don't peek - play the game!
 * The escape room lives here: it watches the screen's lifecycle and drops the clues into Logcat.
 */
public final class Vault implements DefaultLifecycleObserver {

    private static final String[] VAULT = {
            "EMOCLEW",
            "KCAB",
            "OT",
            "DIORDNA"
    };
    private static final String T1 = new StringBuilder("EPACSE").reverse().toString();
    private static final String T2 = new StringBuilder("TERCES").reverse().toString();

    private final boolean recreated;

    private Vault(boolean recreated) {
        this.recreated = recreated;
    }

    /** Starts the escape room for this screen. Call once from onCreate. */
    public static void attach(LifecycleOwner screen, Bundle savedInstanceState) {
        screen.getLifecycle().addObserver(new Vault(savedInstanceState != null));
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        if (!recreated) {
            Log.i(T1, "Clue 1: " + clue(1));
        } else {
            Log.i(T1, "Clue 4: " + clue(4));
        }
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        Log.i(T1, "Clue 2: " + clue(2));
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
        Log.w(T2, "Clue 3: " + clue(3));
        Log.i(T1, "Clue 3 is hidden under another tag...");
    }

    /**
     * Returns clue n (1-4).
     */
    static String clue(int n) {
        if (n < 1 || n > VAULT.length) {
            throw new IndexOutOfBoundsException("Clue index must be 1-" + VAULT.length);
        }
        return new StringBuilder(VAULT[n - 1]).reverse().toString();
    }

    /**
     * Checks the player's password (case-insensitive, extra spaces ignored).
     */
    public static boolean check(String attempt) {
        if (attempt == null) return false;
        String cleaned = attempt.trim().replaceAll("\\s+", " ");
        String expected = clue(1) + " " + clue(2) + " " + clue(3) + " " + clue(4);
        return cleaned.equalsIgnoreCase(expected);
    }
}
