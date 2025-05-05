package services;

import entities.BorneRecharge;
import entities.Utilisateur;
import interfaces.ReservationService;

public class Reservation implements ReservationService {
    /**
     * @param user
     * @param borne
     * @return
     */
    @Override
    public entities.Reservation reserver(Utilisateur user, BorneRecharge borne) {
        return null;
    }

    /**
     * @param reservation
     * @return
     */
    @Override
    public boolean accepter(entities.Reservation reservation) {
        return false;
    }

    /**
     * @param reservation
     * @return
     */
    @Override
    public boolean refuser(entities.Reservation reservation) {
        return false;
    }
}
