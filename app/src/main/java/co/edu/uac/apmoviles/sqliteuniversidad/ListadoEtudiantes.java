package co.edu.uac.apmoviles.sqliteuniversidad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListadoEtudiantes extends AppCompatActivity {
    List<Estudiante> listadoEstudiantes = new ArrayList<>();
    EstudianteController ec;
    RecyclerView elista;
    EstudianteCursorAdapter eca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_etudiantes);

        elista = findViewById(R.id.listaView);
        elista.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        ec = new EstudianteController(getApplicationContext());
        listadoEstudiantes.clear();
        Cursor cur = ec.allEstudiantes();

        while (cur.moveToNext()) {
            String codigo = cur.getString(cur.getColumnIndexOrThrow("codigo"));
            String nombre = cur.getString(cur.getColumnIndexOrThrow("nombre"));
            String programa = cur.getString(cur.getColumnIndexOrThrow("programa"));
            Estudiante e = new Estudiante(codigo, nombre, programa);
            listadoEstudiantes.add(e);
        }

        eca = new EstudianteCursorAdapter(listadoEstudiantes);
        elista.setAdapter(eca);
    }

}