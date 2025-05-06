import entities.*;
import services.Recherche;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Services {
    public static void main(String[] args) {
        Seeding seeding = new Seeding();

        Recherche servicerecherche = new Recherche();
        List<BorneRecharge> borneRecharges = new ArrayList<>();
        for (LieuRecharge lieu : seeding.getLieuRecharges()) {
            borneRecharges.addAll(lieu.getBornes());
        }
        for (BorneRecharge b : borneRecharges) {
            System.out.println(b.getId());
        }

        System.out.println("=======");

        List<BorneRecharge> result = servicerecherche.rechercher(
                borneRecharges,
                seeding.getReservations(),
                new Date(2025, Calendar.APRIL,15,12,15),
                new Date(2025, Calendar.APRIL,15,16,15));

        for (BorneRecharge b : result) {
            System.out.println(b.getId());
        }
    }
}
