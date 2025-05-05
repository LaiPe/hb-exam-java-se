import entities.Credentials;
import entities.LieuRecharge;
import entities.Reservation;
import entities.Utilisateur;
import services.Authentification;
import ui.CLI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Mémoire temp vu que pas de bdd
        List<Utilisateur> utilisateurs = new ArrayList<>();
        List<LieuRecharge> lieuRecharges = new ArrayList<>();
        List<Reservation> reservations = new ArrayList<>();

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

            if (input.equals("1")) {
                Utilisateur user = new Utilisateur();
                cli.input(user);

                Authentification auth = new Authentification();
                String code = auth.inscription(user);

                System.out.println("Code de validation : " + code);
                //TODO envoi mail validation w/ code

                utilisateurs.add(user);
            }
            else if (input.equals("2")) {
                Utilisateur user = cli.choose(utilisateurs);

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
            else if (input.equals("3")) {
                Utilisateur user = cli.choose(utilisateurs);
                Credentials credentials = new Credentials();
                cli.input(credentials);

                Authentification auth = new Authentification();
                try {
                    if (auth.connection(user,credentials)) {
                        System.out.println("Connecté ! Bienvenue " + user.getPrenom());
                        session = user;
                    } else {
                        System.out.println("Mot de passe ou email invalide !");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }

        } while (!input.equals("0"));
    }
}
