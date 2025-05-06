import entities.*;
import services.Recherche;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Services {
    public static void main(String[] args) {
        Seeding seeding = new Seeding();

        List<BorneRecharge> borneRecharges = new ArrayList<>();
        for (LieuRecharge lieu : seeding.getLieuRecharges()) {
            borneRecharges.addAll(lieu.getBornes());
        }
        for (BorneRecharge b : borneRecharges) {
            System.out.println(b.getId());
        }

        System.out.println("=======");

        Recherche r1 = new Recherche();
        r1.setBornesExistantes(seeding.getLieuRecharges());
        r1.setReservationsExistantes(seeding.getReservations());
        r1.setDateDebut(new Date(2025, Calendar.APRIL,15,12,15));
        r1.setDateFin(new Date(2025, Calendar.APRIL,15,16,15));

        List<BorneRecharge> result = r1.rechercher();
        for (BorneRecharge b : result) {
            System.out.println(b.getId());
        }
    }
}
