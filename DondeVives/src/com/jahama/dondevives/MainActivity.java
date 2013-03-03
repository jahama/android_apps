package com.jahama.dondevives;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private static final String TAG = "Main Activity";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
         * Se crea la Interfaz de Usuario(IU) principal con el diseño definido en el archivo
         * layout/acivity_main.xml
         */
        setContentView(R.layout.activity_main);
        // Conectar el un objeto boton a la IU con el metodo findViewById
        final EditText txtDireccion = (EditText)findViewById(R.id.txtDireccion);
        // Conectar el un objeto boton a la IU con el metodo findViewById
        Button btnVerMapa = (Button)findViewById(R.id.btnVerMapa);
        // Manejar el evento de pulsar el boton
        btnVerMapa.setOnClickListener(new Button.OnClickListener(){
        	public void onClick(View view){
        		try{ // Si se pincha el boton de Ver Mapa
        			// Recogo el contenido del textfield (la ciudad)
        			String ciudad = txtDireccion.getText().toString();
        			ciudad = ciudad.replace(' ', '+');
        			Log.v(TAG,"Ciudad seleccionada :" + ciudad);
        			// Ahora que tengo al direccion tengo que crear un INTENT, para buscar la direccion que se 
        			// puesto en el textfield.
        			 Intent i = new Intent(android.content.Intent.ACTION_VIEW, 
        					 Uri.parse("geo:0,0?q=" + ciudad));
        			// Ejecutar la aplicacion
        			 startActivity(i);
        			
        			
        		}catch (Exception e){
        			Log.v(TAG,"Excepcion :" + e.getMessage());
        		}
        	}
        
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
