package interfaces;

import entities.BorneRecharge;
import entities.Reservation;

import java.util.Date;
import java.util.List;

public interface BorneService {
    public List<BorneRecharge> rechercher(List<BorneRecharge> bornesExistantes, List<Reservation> reservationsExistantes, Date debut, Date fin);
}
