package com.example.android.iak1_e1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        jarakEdit = (EditText) findViewById(R.id.jarak_edittext);
        tipsEdit = (EditText) findViewById(R.id.tips_edittext);
    }

    private void hitung() {
        hargaPerKm_string = hargaPerKmEdit.getText().toString();
        jarak_string = jarakEdit.getText().toString();
        tips_string = tipsEdit.getText().toString();

        hargaPerKm = Integer.parseInt(hargaPerKm_string);
        jarak = Integer.parseInt(jarak_string);
        tips = Integer.parseInt(tips_string);

        totalHarga = hargaPerKm * jarak + tips;
    }

    public void tunai(View view) {
        // kalkulasi dan ambil data dari EditText
        hitung();

        TextView metodeTextView = (TextView) findViewById(R.id.metode_textview);
        metodeTextView.setText("TUNAI");
        TextView displayTextView = (TextView) findViewById(R.id.display_textview);
        Toast.makeText(this, String.valueOf(totalHarga), Toast.LENGTH_SHORT).show();
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
