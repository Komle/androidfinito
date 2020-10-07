package com.example.bandom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;

public class Search extends AppCompatActivity {

    private static final String INSERT_URL = "http://androidoapsas.epizy.com/mobile/dbconnect.php";


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
        final EditText price = findViewById(R.id.kaina);
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
                Sunys suo = new Sunys(sunumaistas, selectedDeliveryTypeBtnName, kaina, payment);
                databaseInsert(suo);
                Toast.makeText(Search.this,
                        "KaciuMaistas" + suo.sunumaistas() + "\n" +
                                "pristatymas" + suo.getPristatymas() + "\n" +
                                "kaina" + suo.getKaina() + "\n" +
                                "pristatymnas" + suo.getPristatymas() + "\n" +
                                "Veisle" + suo.getVeisle() + "\n",
                        Toast.LENGTH_SHORT).show();
                Intent gotoLoginActivity = new Intent(Search.this, LoginActivity.class);
                startActivity(gotoLoginActivity);
            }
        });



    }

    private void databaseInsert(Sunys suo) {
        class NewEntry extends AsyncTask<String, Void, String> {

            ProgressDialog loading;
            DB db = new DB();

            //            @Override
            protected void onPreExecuted() {
                super.onPreExecute();
                loading = ProgressDialog.show(Search.this,
                        getResources().getString(R.string.new_entry_database_info),
                        null, true, true);
            }

            @Override
            protected String doInBackground(String... strings) {
                HashMap<String, String> kate = new HashMap<String, String>();
                kate.put("kaciumaistas", strings[0]);
                kate.put("pristatymas", strings[1]);
                kate.put("KAINA", strings[2]);
                kate.put("atsiskaitymas", strings[3]);
                kate.put("veisle", strings[4]);
                kate.put("action", "insert");

                String result = db.sendPostRequest(INSERT_URL, kate);

                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(Search.this, s,
                        Toast.LENGTH_SHORT).show();
                Intent gotoSearchActivity = new Intent(Search.this,
                        Search.class);
                startActivity(gotoSearchActivity);
            }

        }
        NewEntry newEntry = new NewEntry();
        newEntry.execute(
                suo.getSunumaistas(),
                suo.getPristatymas(),
                Double.toString(suo.getKaina()) ,
                suo.getAtsiskaitymas(),
                suo.getVeisle()
        );
    }

}