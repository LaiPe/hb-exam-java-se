package services;

import entities.*;
import entities.Reservation;
import interfaces.BorneService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Recherche implements BorneService {
    private List<BorneRecharge> bornesExistantes;
    private List<Reservation> reservationsExistantes;
    private Date debut;
    private Date fin;

    public void setBornesExistantes(List<LieuRecharge> lieux) {
        bornesExistantes = new ArrayList<>();
        for (LieuRecharge lieu : lieux) {
            bornesExistantes.addAll(lieu.getBornes());
        }
    }

    public void setReservationsExistantes(List<Reservation> reservationsExistantes) {
        this.reservationsExistantes = reservationsExistantes;
    }

    public void setDateDebut(Date debut) {
        this.debut = debut;
    }
    public void setDateFin(Date fin) {
        this.fin = fin;
    }

    @Override
    public List<BorneRecharge> rechercher() {
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
