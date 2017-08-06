package com.example.android.iak1_e1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // ui
    EditText hargaPerKmEdit;
    EditText jarakEdit;
    EditText tipsEdit;

    // data
    String hargaPerKm_string;
    String jarak_string;
    String tips_string;
    int hargaPerKm;
    int jarak;
    int tips;
    int totalHarga;
    int hargaDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hargaPerKmEdit = (EditText) findViewById(R.id.harga_edittext);
        hargaPerKm_string = hargaPerKmEdit.getText().toString();
        hargaPerKm = Integer.parseInt(hargaPerKm_string);
        jarakEdit = (EditText) findViewById(R.id.jarak_edittext);
        jarak_string = jarakEdit.getText().toString();
        jarak = Integer.parseInt(jarak_string);
        tipsEdit = (EditText) findViewById(R.id.tips_edittext);
        tips_string = tipsEdit.getText().toString();
        tips = Integer.parseInt(tips_string);

        totalHarga = hargaPerKm * jarak + tips;
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
