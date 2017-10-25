package com.gzsoft.basedatos_ulp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Principal extends AppCompatActivity {
    private EditText editNombre,editApellido,editTelefono;
    private Button btnGuardar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        //getMenuInflater().inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        editNombre = (EditText) findViewById(R.id.etnombre);
        editApellido = (EditText) findViewById(R.id.etapellido);
        editTelefono = (EditText) findViewById(R.id.ettelefono);

        btnGuardar = (Button) findViewById(R.id.btguardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseApplication)getApplication()).insertarCliente(editNombre.getText().toString()
                        ,editApellido.getText().toString()
                        ,editTelefono.getText().toString());
                Intent in = new Intent(Principal.this, ListActivity.class);
                startActivity(in);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int it = item.getItemId();
        /*if (it = R.id.action_setting){
            return  true;
        }*/
        return super.onOptionsItemSelected(item);
    }
}
