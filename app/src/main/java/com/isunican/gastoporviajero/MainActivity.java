package com.isunican.gastoporviajero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtKm, txtPrecio, txtViajeros, txtConsumo, txtResultado;
    Button btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtKm = findViewById(R.id.txtKm);
        txtPrecio = findViewById(R.id.txtPrecio);
        txtViajeros = findViewById(R.id.txtViajeros);
        txtConsumo = findViewById(R.id.txtConsumo);
        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v.getId()==R.id.btnCalcular){

            //GastoViajero=((consumo/100)*kmRecorridos*precioLitro)/numeroViajeros

            if( Float.valueOf(txtConsumo.getText().toString()) <= 0 ) {
                Toast.makeText(this, R.string.error_consumo, Toast.LENGTH_SHORT).show();
            }
            else if( Float.valueOf(txtKm.getText().toString()) <= 0 ) {
                Toast.makeText(this, R.string.error_km, Toast.LENGTH_SHORT).show();
            }
            else if( Float.valueOf(txtPrecio.getText().toString()) <= 0 ) {
                Toast.makeText(this, R.string.error_precio, Toast.LENGTH_SHORT).show();
            }
            else if( Float.valueOf(txtViajeros.getText().toString()) <= 0 ) {
                Toast.makeText(this, R.string.error_viajeros, Toast.LENGTH_SHORT).show();
            }
            else {
                float gasto = (
                        ( Float.valueOf(txtConsumo.getText().toString()) / 100 )
                                * Float.valueOf(txtKm.getText().toString())
                                * Float.valueOf(txtPrecio.getText().toString())
                                )
                                / Float.valueOf(txtViajeros.getText().toString());

                txtResultado.setText(String.valueOf(gasto));

                Toast.makeText(this, android.R.string.ok, Toast.LENGTH_SHORT).show();
            }
        }


        else{
            Toast.makeText(this, android.R.string.no, Toast.LENGTH_SHORT).show();
        }


    }
}
