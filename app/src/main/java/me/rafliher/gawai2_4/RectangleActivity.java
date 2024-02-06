package me.rafliher.gawai2_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RectangleActivity extends AppCompatActivity {

    private EditText tPanjang, tLebar;
    private TextView tHasil;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rectangle_area);

        tPanjang = findViewById(R.id.txtPanjang);
        tLebar = findViewById(R.id.txtLebar);
        tHasil = findViewById(R.id.textView);
        btn1 = findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String panjang = tPanjang.getText().toString().trim();
                String lebar = tLebar.getText().toString().trim();

                int hasil = Integer.parseInt(panjang) * Integer.parseInt(lebar);
                tHasil.setText(String.valueOf(hasil));
            }
        });
    }
}