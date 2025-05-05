package entities;

import java.util.Date;

public class Reservation {
    private int id;
    private Utilisateur utilisateur;
    private BorneRecharge borne;
    private Date debut;
    private Date fin;
    private StatutReservation statut;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public BorneRecharge getBorne() {
        return borne;
    }
    public void setBorne(BorneRecharge borne) {
        this.borne = borne;
    }

    public Date getDateDebut() {
        return debut;
    }
    public void setDateDebut(Date dateDebut) {
        this.debut = dateDebut;
    }

    public Date getDateFin() {
        return fin;
    }
    public void setDateFin(Date dateFin) {
        this.fin = dateFin;
    }

    public StatutReservation getStatut() {
        return statut;
    }
    public void setStatut(StatutReservation statut) {
        this.statut = statut;
    }
}
