import entities.*;
import services.Authentification;
import ui.CLI;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Seeding
        Seeding seeding = new Seeding();
        List<Utilisateur> utilisateurs = seeding.getUtilisateurs();
        List<LieuRecharge> lieuRecharges = seeding.getLieuRecharges();
        List<Reservation> reservations = seeding.getReservations();


        // Utilisateur couramment connecté (simulacre de sessioning)
        Utilisateur session = null;

        // Init UI
        CLI cli = new CLI();
        String input;

        // Menuing loop
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
                    input = "";
                }
                default -> {
                    System.out.println("Veuillez rentrez un choix valide !");
                }
            }
        } while (!input.equals("0"));
    }
}
