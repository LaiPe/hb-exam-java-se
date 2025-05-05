package services;

import entities.BorneRecharge;
import entities.EtatBorne;
import entities.Reservation;
import entities.StatutReservation;
import interfaces.BorneService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Recherche implements BorneService {
    /**
     * @param bornesExistantes
     * @param debut
     * @param fin
     * @return
     */
    @Override
    public List<BorneRecharge> rechercher(List<BorneRecharge> bornesExistantes, List<Reservation> reservationsExistantes, Date debut, Date fin) {
        if (bornesExistantes == null || debut == null || fin == null) {
            throw new IllegalArgumentException("Les arguments ne peuvent pas être null");
        }

        if (debut.after(fin)) {
            throw new IllegalArgumentException("La date de début doit être antérieure à la date de fin");
        }

        List<BorneRecharge> bornesDisponibles = new ArrayList<>();

        for (BorneRecharge borne : bornesExistantes) {
            if (borne.getEtat() == EtatBorne.DISPONIBLE) {
                boolean estDisponible = true;

                List<Reservation> reservationsBorne = getReservationsPourBorne(reservationsExistantes, borne);

                for (Reservation reservation : reservationsBorne) {
                    if (!(reservation.getDateFin().before(debut) || reservation.getDateDebut().after(fin)) &&
                            reservation.getStatut() != StatutReservation.REFUSEE) {
                        estDisponible = false;
                        break;
                    }
                }

                if (estDisponible) {
                    bornesDisponibles.add(borne);
                }
            }
        }
        return bornesDisponibles;
    }
    private List<Reservation> getReservationsPourBorne(List<Reservation> reservationsExistantes, BorneRecharge borne) {
        List<Reservation> reservationsDisponibles = new ArrayList<>();
        for (Reservation reservation : reservationsExistantes) {
            if (reservation.getBorne().getId() == borne.getId()) {
                reservationsDisponibles.add(reservation);
            }
        }
        return reservationsDisponibles;
    }
}
