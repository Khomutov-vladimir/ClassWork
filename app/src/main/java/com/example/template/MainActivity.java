package com.example.template;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG_ESCAPE = "ESCAPE";
    private static final String MY_TAG = "MY_LIFECYCLE";

    // Bonus: this counter is NOT saved on purpose (teaser for next lesson)
    private int counter = 0;

    private TextView counterText;
    private TextView statusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Edge-to-edge: apply system-bar insets to the root view
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Android 12+: Back on the first screen only moves the app to the background.
        // We call finish() so Back really closes this screen (like on older Android versions).
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        });

        // --- The escape room: play it through Logcat, don't open Vault.java ---
        Vault.attach(this, savedInstanceState);

        // TODO (Part B): add Log.d(MY_TAG, "onCreate") here

        Log.d(MY_TAG, "onCreate");

        // --- Wire the Escape button ---
        EditText passwordInput = findViewById(R.id.passwordInput);
        Button escapeButton = findViewById(R.id.escapeButton);
        statusText = findViewById(R.id.statusText);

        escapeButton.setOnClickListener(v -> {
            String attempt = passwordInput.getText().toString();
            if (Vault.check(attempt)) {
                statusText.setText("ESCAPED!");
                Log.i(TAG_ESCAPE, "ESCAPED");
            } else {
                statusText.setText("Wrong password - check Logcat");
            }
        });

        // --- Wire the counter button (NOT saved on purpose) ---
        counterText = findViewById(R.id.counterText);
        Button counterButton = findViewById(R.id.counterButton);
        counterButton.setOnClickListener(v -> {
            counter++;
            counterText.setText(String.valueOf(counter));
        });

        // TODO (Bonus): the counter resets when you rotate. Fix it with onSaveInstanceState.
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter", 0);
            counterText.setText(String.valueOf(counter));
        }
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
    }

    // TODO (Part B): override onStart() - remember super.onStart()

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MY_TAG, "onStart");
    }


    // TODO (Part B): override onResume() - remember super.onResume()

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(MY_TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // TODO (Part B): add Log.d(MY_TAG, "onPause") here

        Log.d(MY_TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        // TODO (Part B): add Log.d(MY_TAG, "onStop") here

        Log.d(MY_TAG, "onStop");
    }

    // TODO (Part B): override onDestroy() - remember super.onDestroy()

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(MY_TAG, "onDestroy");
    }
}
