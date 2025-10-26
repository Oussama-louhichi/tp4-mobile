package com.iset.tp4_mobile;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OccupationAdapter extends RecyclerView.Adapter<OccupationAdapter.OccupationViewHolder> {

    private List<Occupation> occupations;

    public OccupationAdapter(List<Occupation> occupations) {
        this.occupations = occupations;
    }

    @NonNull
    @Override
    public OccupationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.occupation_view, parent, false);
        return new OccupationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OccupationViewHolder holder, int position) {
        holder.setOccupation(occupations.get(position));
    }

    @Override
    public int getItemCount() {
        return occupations.size();
    }

    public static class OccupationViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNom, txtCategorie;
        private Occupation occupation;

        public OccupationViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNom = itemView.findViewById(R.id.txtNom);
            txtCategorie = itemView.findViewById(R.id.txtCategorie);

            // Clique sur un item → ouvrir OccupationActivity
            itemView.setOnClickListener(v -> {
                if (occupation != null) {
                    Intent intent = new Intent(v.getContext(), OccupationActivity.class);
                    intent.putExtra("occupationId", occupation.getId());
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    v.getContext().startActivity(intent);
                }
            });
        }

        public void setOccupation(Occupation occupation) {
            this.occupation = occupation;
            txtNom.setText(occupation.getNom());
            txtCategorie.setText(occupation.getCategorie());
        }
    }
}
