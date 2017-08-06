package com.example.android.iak1_e1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText hargaPerKmEdit = (EditText) findViewById(R.id.harga_edittext);
    String hargaPerKm_string = hargaPerKmEdit.getText().toString();
    int hargaPerKm = Integer.parseInt(hargaPerKm_string);
    EditText jarakEdit = (EditText) findViewById(R.id.jarak_edittext);
    String jarak_string = jarakEdit.getText().toString();
    int jarak = Integer.parseInt(jarak_string);
    EditText tipsEdit = (EditText) findViewById(R.id.tips_edittext);
    String tips_string = tipsEdit.getText().toString();
    int tips = Integer.parseInt(tips_string);
    int totalHarga = hargaPerKm*jarak+tips;
    int hargaDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tunai(View view) {
        TextView metodeTextView = (TextView) findViewById(R.id.metode_textview);
        metodeTextView.setText("TUNAI");
        TextView displayTextView = (TextView) findViewById(R.id.display_textview);
        hargaDisplay = totalHarga;
        displayTextView.setText("Rp. " + hargaDisplay);
    }

    public void voucher(View view) {
        TextView metodeTextView = (TextView) findViewById(R.id.metode_textview);
        metodeTextView.setText("VOUCHER");
        TextView displayTextView = (TextView) findViewById(R.id.display_textview);
        hargaDisplay = totalHarga - 5 / 100 * totalHarga;
        displayTextView.setText("Rp. " + hargaDisplay);
    }
}
