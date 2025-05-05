package entities;

public class BorneRecharge {
    private int id;
    private EtatBorne etat;
    private double tarifHoraire;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public EtatBorne getEtat() {
        return etat;
    }
    public void setEtat(EtatBorne etat) {
        this.etat = etat;
    }

    public double getTarifHoraire() {
        return tarifHoraire;
    }
    public void setTarifHoraire(double tarifHoraire) {
        this.tarifHoraire = tarifHoraire;
    }

}
