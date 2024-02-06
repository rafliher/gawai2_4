package me.rafliher.gawai2_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnRectangle, btnTriangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRectangle = findViewById(R.id.buttonRectangle);
        btnTriangle = findViewById(R.id.buttonTriangle);

        btnTriangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RectangleActivity.class);
                startActivity(intent);
            }
        });

        btnRectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TriangleActivity.class);
                startActivity(intent);
            }
        });
    }
}