package com.acheache.castillejo.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        contactos=new ArrayList<Contacto>();

        contactos.add(new Contacto("Horacio Castillejo Peña","944998648","acheachehh@gmail.com"));
        contactos.add(new Contacto("Juan Duran Chavez","944998610","juan@gmial.com"));
        contactos.add(new Contacto("Juana","944998610","juana@gmail.com"));
        contactos.add(new Contacto("Melo","944998445","melo@gmail.com"));


        ArrayList<String> nombreContacto=new ArrayList<>();
        for (Contacto contacto:contactos
             ) {
             nombreContacto.add(contacto.getNombre());
            
        }

        ListView lstContactos=(ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombreContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail),contactos.get(i).getEmail());
                startActivity(intent);
                finish();
            }
        });


    }
}
