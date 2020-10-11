package co.edu.uac.apmoviles.sqliteuniversidad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EstudianteCursorAdapter extends RecyclerView.Adapter<EstudianteCursorAdapter.EstudianteViewHolder>{

    private List<Estudiante> EstudiantesDatos;


    public EstudianteCursorAdapter(List<Estudiante> EstudiantesDatos){
        this.EstudiantesDatos = EstudiantesDatos;
    }

    public class EstudianteViewHolder extends RecyclerView.ViewHolder {

        TextView codigoText;
        TextView nombreText;
        TextView programaText;

        public EstudianteViewHolder(@NonNull View itemView) {
            super(itemView);

            codigoText = itemView.findViewById(R.id.codigoText);
            nombreText = itemView.findViewById(R.id.nombreText);
            programaText = itemView.findViewById(R.id.programaText);
        }
    }

    @NonNull
    @Override
    public EstudianteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.estudiante_item, parent, false);
        return new EstudianteViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull EstudianteViewHolder holder, int position) {
        Estudiante e = EstudiantesDatos.get(position);
        holder.codigoText.setText(e.getCodigo());
        holder.nombreText.setText(e.getNombre());
        holder.programaText.setText(e.getPrograma());
    }

    @Override
    public int getItemCount() {
        return EstudiantesDatos.size();
    }


}
