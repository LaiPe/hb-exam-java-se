import entities.*;
import services.Authentification;
import ui.CLI;

import java.util.*;

public class Main {
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

        LieuRecharge l1 = new LieuRecharge();
        l1.setId(1);
        l1.setNom("Lieu de fou malade");
        l1.setAdresse("5 rue du dev");
        l1.addBorne(b1);
        l1.addBorne(b2);

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

        // Utilisateur couramment connecté (simulacre de sessioning)
        Utilisateur session = null;

        CLI cli = new CLI();
        String input;

        do {
            if (session != null) {
                System.out.println("Connecté en tant que " + session.getPrenom() + " " + session.getNom());
            }
            cli.printMenu();

            System.out.print("Votre choix : ");
            input = cli.scanner.nextLine();

            switch (input) {
                case "1" -> {
                    Utilisateur user = new Utilisateur();
                    cli.input(user);

                    Authentification auth = new Authentification();
                    String code = auth.inscription(user);

                    System.out.println("Code de validation : " + code);
                    //TODO envoi mail validation w/ code

                    utilisateurs.add(user);
                }
                case "2" -> {
                    Utilisateur user = cli.chooseUtilisateur(utilisateurs);

                    Authentification auth = new Authentification();
                    System.out.println("Entrez le code de validation reçu : ");
                    try {
                        if (auth.validation(user, cli.scanner.nextLine())) {
                            System.out.println("Compte validé !");
                        } else {
                            System.out.println("Code invalide, veuillez rééessayer.");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                case "3" -> {
                    Utilisateur user = cli.chooseUtilisateur(utilisateurs);
                    Credentials credentials = new Credentials();
                    cli.input(credentials);

                    Authentification auth = new Authentification();
                    try {
                        if (auth.connection(user, credentials)) {
                            System.out.println("Connecté ! Bienvenue " + user.getPrenom());
                            session = user;
                        } else {
                            System.out.println("Mot de passe ou email invalide !");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "4" -> {
                    if (session != null) {

                    } else {
                        System.out.println("Veuillez vous connecter.");
                    }
                }

                case "6" -> {
                    do {
                        cli.printMenuAdmin();

                        System.out.print("Votre choix : ");
                        input = cli.scanner.nextLine();

                        switch (input) {
                            case "1" -> {
                                LieuRecharge lieu = new LieuRecharge();
                                cli.input(lieu);
                                lieuRecharges.add(lieu);
                                System.out.println("Lieu de recharge ajouté avec succès !");
                            }
                            case "2" -> {
                                LieuRecharge lieu = cli.chooseLieuRecharge(lieuRecharges);
                                BorneRecharge borne = new BorneRecharge();
                                cli.input(borne);
                                lieu.addBorne(borne);
                                System.out.println("Borne ajoutée avec succès !");
                            }
                            default -> {
                                System.out.println("Veuillez rentrez un choix valide !");
                            }
                        }
                    } while (!input.equals("0"));
                }
                default -> {
                    System.out.println("Veuillez rentrez un choix valide !");
                }
            }
        } while (!input.equals("0"));
    }
}
