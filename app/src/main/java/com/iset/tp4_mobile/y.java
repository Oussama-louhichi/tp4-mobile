package com.iset.tp4_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler = findViewById(R.id.recyclerOccupations);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        OccupationAdapter adapter = new OccupationAdapter(OccupationsSingleton.getInstance().getOccupations());
        recycler.setAdapter(adapter);
    }
}
