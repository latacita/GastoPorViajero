package com.isunican.gastoporviajero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Declaramos variables para los elementos (vistas) de la interfaz
    TextView txtKm, txtPrecio, txtViajeros, txtConsumo, txtResultado;
    Button btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Al iniciar la actividad vinculamos los elementos de la interfaz con las variables declaradas anteriormente
        // Para ello buscamos los elementos por id
        txtKm = findViewById(R.id.txtKm);
        txtPrecio = findViewById(R.id.txtPrecio);
        txtViajeros = findViewById(R.id.txtViajeros);
        txtConsumo = findViewById(R.id.txtConsumo);
        txtResultado = findViewById(R.id.txtResultado);

        // Para el boton además definimos un listener
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);
    }


    // Cuando se lanza un evento de click comprobamos sobre quién ha sido (qué vista)
    public void onClick(View v){

        // Para ellos miramos su id
        // Si es el botón calcular procedemos a realizar el cálculo
        if(v.getId()==R.id.btnCalcular){

            //Realizamos comprobaciones para ver si en todos los campos de texto
            //han introducido algún valor numérico positivo
            //En caso de no ser así, mostramos un mensaje de error emergente

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

            //Si todos los valores son positivos realizamos el cálculo,
            //escribimos el resultado en el campo de texto que creamos para ello
            //y mostramos un mensaje emergente

            else {
                float gasto = (
                        ( Float.valueOf(txtConsumo.getText().toString()) / 100 )
                                * Float.valueOf(txtKm.getText().toString())
                                * Float.valueOf(txtPrecio.getText().toString())
                                )
                                / Float.valueOf(txtViajeros.getText().toString());

                txtResultado.setText(String.valueOf(gasto));

                Toast.makeText(this, android.R.string.ok, Toast.LENGTH_SHORT).show();
                Log.d("operacion","operacion correcta");
            }
        }


        else{
            Toast.makeText(this, android.R.string.no, Toast.LENGTH_SHORT).show();
            Log.d("operacion","operacion incorrecta");
        }


    }

    // Metodo para lanzar la actividad acercaDe
    // importar el paquete android.content.Intent
    public void lanzarAcercaDe(View view) {
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
    }


}
