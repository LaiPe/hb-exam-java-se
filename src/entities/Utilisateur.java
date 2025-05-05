package entities;

public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String codeValidation;
    private boolean estValide;

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

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getCodeValidation() {
        return codeValidation;
    }
    public void setCodeValidation(String codeValidation) {
        this.codeValidation = codeValidation;
    }

    public boolean isEstValide() {
        return estValide;
    }
    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }
}
