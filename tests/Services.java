import entities.*;
import services.Recherche;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Services {
    public static void main(String[] args) {
        // Mémoire temp vu que pas de bdd
        List<Utilisateur> utilisateurs = new ArrayList<>();
        List<LieuRecharge> lieuRecharges = new ArrayList<>();
        List<Reservation> reservations = new ArrayList<>();

        // Seeding
        Utilisateur u1 = new Utilisateur();
        u1.setNom("John");
        u1.setPrenom("Doe");
        u1.setEstValide(true);
        u1.setMdp("aa");
        u1.setEmail("emaildefou@djoufara.com");
        utilisateurs.add(u1);

        BorneRecharge b1 = new BorneRecharge();
        b1.setId(1);
        b1.setEtat(EtatBorne.DISPONIBLE);
        b1.setTarifHoraire(1.2);

        BorneRecharge b2 = new BorneRecharge();
        b2.setId(2);
        b2.setEtat(EtatBorne.DISPONIBLE);
        b2.setTarifHoraire(1.45);

        BorneRecharge b3 = new BorneRecharge();
        b2.setId(3);
        b2.setEtat(EtatBorne.DISPONIBLE);
        b2.setTarifHoraire(1.3);

        LieuRecharge l1 = new LieuRecharge();
        l1.setId(1);
        l1.setNom("Lieu de fou malade");
        l1.setAdresse("5 rue du dev");
        l1.addBorne(b1);
        l1.addBorne(b2);

        LieuRecharge l2 = new LieuRecharge();
        l2.setId(2);
        l2.setNom("Lieu dingue");
        l2.setAdresse("10 rue de perrier");
        l2.addBorne(b3);

        lieuRecharges.add(l1);
        lieuRecharges.add(l2);

        Reservation r1 = new Reservation();
        r1.setId(1);
        r1.setBorne(b1);
        r1.setStatut(StatutReservation.VALIDEE);
        r1.setUtilisateur(u1);
        r1.setDateDebut(new Date(2025, Calendar.APRIL,15,10,15));
        r1.setDateFin(new Date(2025, Calendar.APRIL,15,11,45));

        Reservation r2 = new Reservation();
        r2.setId(2);
        r2.setBorne(b2);
        r2.setStatut(StatutReservation.VALIDEE);
        r2.setUtilisateur(u1);
        r2.setDateDebut(new Date(2025, Calendar.APRIL,15,14,30));
        r2.setDateFin(new Date(2025, Calendar.APRIL,15,15,45));

        reservations.add(r1);
        reservations.add(r2);

        Recherche servicerecherche = new Recherche();
        List<BorneRecharge> borneRecharges = new ArrayList<>();
        for (LieuRecharge lieu : lieuRecharges) {
            borneRecharges.addAll(lieu.getBornes());
        }
        for (BorneRecharge b : borneRecharges) {
            System.out.println(b.getId());
        }
        System.out.println("=======");
        List<BorneRecharge> result = servicerecherche.rechercher(
                borneRecharges,
                reservations,
                new Date(2025, Calendar.APRIL,16,12,15),
                new Date(2025, Calendar.APRIL,16,13,15));

        for (BorneRecharge b : result) {
            System.out.println(b.getId());
        }
    }
}
