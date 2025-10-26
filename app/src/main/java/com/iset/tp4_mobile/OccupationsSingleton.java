package com.iset.tp4_mobile;

import java.util.ArrayList;
import java.util.List;

public class OccupationsSingleton {
    private static final OccupationsSingleton instance = new OccupationsSingleton();
    private final List<Occupation> occupations = new ArrayList<>();

    private OccupationsSingleton() {
        occupations.add(new Occupation(1, "Cinéma", "Loisir", "Regarder un film"));
        occupations.add(new Occupation(2, "Football", "Sport", "Jouer avec des amis"));
        occupations.add(new Occupation(3, "Bricolage", "Maison", "Réparer des objets"));
    }

    public static OccupationsSingleton getInstance() {
        return instance;
    }

    public List<Occupation> getOccupations() {
        return occupations;
    }

    public Occupation getOccupation(int occupationId) {
        for (Occupation o : occupations)
            if (o.getId() == occupationId) return o;
        return null;
    }
}
