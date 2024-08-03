package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActualizarRegistro extends AppCompatActivity {
    EditText id, nombre, telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_registro);
        this.id=findViewById(R.id.idNombre);
        this.nombre=findViewById(R.id.nombreUsuario);
        this.telefono=findViewById(R.id.telefono);
    }
//AQUI TENGO QUE COLOCAR LOS CAMPOS DE LOS NOMBRES PRINCIPALES.


    public void onClick(View view){
        Intent intent = null;
        switch (view.getId()){

            case R.id.btnActualizar:
                this.actualizarProducto();
                break;

            case R.id.btnCancelar:
                intent = new Intent(getApplicationContext(), MainActivity3.class);
                break;
        }
        if (intent!=null){
            startActivity(intent);
        }
    }



    private void actualizarProducto() {
        try {
            Conexion conexion = new Conexion(this, Assets.DB_NAME, null, Assets.DB_VERSION);
            int result = conexion.actualizarUsuario(id.getText().toString(), nombre.getText().toString(), telefono.getText().toString());
            if (result > 0) {
                Toast.makeText(getApplicationContext(), "Producto Actualizado", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Error al actualizar producto", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }





}

//AQUI TENGO LOS 3 METODOS QUE SON DE REGISTRAR, ACTUALIZAR Y ELIMINAR EL PRODUCTO, EN REGISTRAR SOLO TENGO QUE CAMBIAR EL NOMBRE DE LA TABLA Y DEL ID PRINCIPAL.
//EN EL SWTICH TENGO QUE COLOCAR LA FUNCIONALIDAD QUE QUIERO HACER ES DECIR CADA METODO.