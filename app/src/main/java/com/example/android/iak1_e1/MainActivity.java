package com.example.android.iak1_e1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
        TextView displayTextView = (TextView) findViewById(R.id.display_textview);

        hargaDisplay = totalHarga;
        Toast.makeText(this, String.valueOf(hargaDisplay), Toast.LENGTH_SHORT).show();

        metodeTextView.setText("TUNAI");
        displayTextView.setText("Rp. " + hargaDisplay);
    }

    public void voucher(View view) {
        hitung();

        TextView metodeTextView = (TextView) findViewById(R.id.metode_textview);
        TextView displayTextView = (TextView) findViewById(R.id.display_textview);

        double discount = 50 / 100;
        int currPrice = totalHarga;
        double hargaDisplay = totalHarga - (discount * currPrice);
        Log.e("totalHarga", String.valueOf(discount));
        Toast.makeText(this, String.valueOf(hargaDisplay), Toast.LENGTH_SHORT).show();

        metodeTextView.setText("VOUCHER");
        displayTextView.setText("Rp. " + hargaDisplay);
    }
}