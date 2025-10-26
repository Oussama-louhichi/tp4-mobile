package com.iset.tp4_mobile;

public class Occupation {
    private int id;
    private String nom;
    private String categorie;
    private String description;

    public Occupation(int id, String nom, String categorie, String description) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.description = description;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getCategorie() { return categorie; }
    public String getDescription() { return description; }
}
