package entities;

import java.util.ArrayList;
import java.util.List;

public class LieuRecharge {
    private int id;
    private String nom;
    private String adresse;
    private List<BorneRecharge> bornes;

    public LieuRecharge() {
        bornes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<BorneRecharge> getBornes() {
        return bornes;
    }
    public void addBorne(BorneRecharge borne) {
        bornes.add(borne);
    }
    public void deleteBorne(BorneRecharge borne) {
        bornes.remove(borne);
    }

}
