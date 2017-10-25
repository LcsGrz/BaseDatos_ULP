package com.gzsoft.basedatos_ulp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Usuario on 25/10/2017.
 */

public class ListActivity extends ActionBarActivity {
    private TextView lista;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lista =(TextView) findViewById(R.id.tvlista);
        for (String it:((BaseApplication)getApplication()).nombreClientes()){
            lista.setText(lista.getText() + it);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_list,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       /* if(item.getItemId() == R.id.action_settings){
            return true;
        }*/
        return super.onOptionsItemSelected(item);
    }
}
