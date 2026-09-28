package com.example.a4_tarasenko;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        showScreen1();
    }

    private void showScreen1() {
        setContentView(R.layout.activity_main);
        applyWindowInsets(findViewById(R.id.main));

        Button btnRegister = findViewById(R.id.btnRegister);
        if (btnRegister != null) {
            btnRegister.setOnClickListener(v -> showScreen2());
        }
    }

    private void showScreen2() {
        setContentView(R.layout.activity_linear);
        applyWindowInsets(findViewById(android.R.id.content));

        TextView tvDetailInfo = findViewById(R.id.tvDetailInfo);
        if (tvDetailInfo != null) {
            tvDetailInfo.setOnClickListener(v -> showScreen3());
        }
    }

    private void showScreen3() {
        setContentView(R.layout.activity_table);
        applyWindowInsets(findViewById(android.R.id.content));
    }

    private void applyWindowInsets(View view) {
        if (view != null) {
            ViewCompat.setOnApplyWindowInsetsListener(view, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
    }
}
