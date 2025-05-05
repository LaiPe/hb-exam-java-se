package interfaces;

import entities.BorneRecharge;
import entities.Reservation;
import entities.Utilisateur;

public interface ReservationService {
    public Reservation reserver(Utilisateur user, BorneRecharge borne);
    public boolean accepter(Reservation reservation);
    public boolean refuser(Reservation reservation);
}
