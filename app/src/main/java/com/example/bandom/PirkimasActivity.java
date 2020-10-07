package com.example.bandom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PirkimasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Button sukurti = findViewById(R.id.Grizti);
        final CheckBox pirm = findViewById(R.id.pirmas);
        final CheckBox antr = findViewById(R.id.antras);
        final CheckBox trec = findViewById(R.id.trecias);
//        final RadioButton deliveryes = findViewById(R.id.deliveryyes);
//        final RadioButton deliverno = findViewById(R.id.deliveryno);
        final RadioGroup delivery = findViewById(R.id.new_entry_delivery_group);
        final TextView price = findViewById(R.id.kaina);
        final Spinner spinneris1 = findViewById(R.id.spinner1);

        sukurti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sunumaistas = "";
                if (pirm.isChecked()) {
                    sunumaistas = sunumaistas + pirm.getText().toString() + " ";
                }
                if (antr.isChecked()) {
                    sunumaistas = sunumaistas + antr.getText().toString() + " ";
                }
                if (trec.isChecked()) {
                    sunumaistas = sunumaistas + trec.getText().toString() + " ";
                }
                int selectedDeliveryType = delivery.getCheckedRadioButtonId();
                RadioButton deliveryType = findViewById(selectedDeliveryType);
                String selectedDeliveryTypeBtnName = deliveryType.getText().toString();
                double kaina = Double.parseDouble(price.getText().toString());
                String payment = String.valueOf(spinneris1.getSelectedItemId());

                //    public Kate(String kaciumaistas, String pristatymas, double kaina, String atsiskaitymas, String veisle){
                Sunys suo = new Sunys(sunumaistas, selectedDeliveryTypeBtnName, kaina, payment );

                Toast.makeText(PirkimasActivity.this,
                        "KaciuMaistas" + suo.getSunumaistas() + "\n" +
                                "pristatymas" + suo.getPristatymas() + "\n" +
                                "kaina" + suo.getKaina() + "\n" +
                                "pristatymnas" + suo.getPristatymas() + "\n" +
                                "Veisle" + suo.getVeisle() + "\n",
                        Toast.LENGTH_SHORT).show();
                Intent gotoLoginActivity = new Intent(PirkimasActivity.this, LoginActivity.class);
                startActivity(gotoLoginActivity);
            }
        });



    }
}