package ui;

import entities.*;

import java.util.List;
import java.util.Scanner;

public class CLI {
    public Scanner scanner;

    public CLI() {
        scanner = new Scanner(System.in);
    }

    public void printMenu() {
        System.out.println("=== Electricity Business ===\n" +
                "1. S'inscrire\n" +
                "2. Valider l'inscription\n" +
                "3. Se connecter\n" +
                "4. Rechercher & réserver une borne\n" +
                "5. Gérer mes réservations\n" +
                "6. Administration (lieux / bornes)\n" +
                "0. Quitter\n");
    }
    public void printMenuAdmin() {
        System.out.println("===== Menu ADMIN =====\n" +
                "1. Ajouter lieu\n" +
                "2. Ajouter borne\n" +
                "0. Quitter\n");
    }

    public void input(Utilisateur user) {
        System.out.println("Votre email : ");
        user.setEmail(scanner.nextLine());

        System.out.println("Votre mot de passe : ");
        user.setMdp(scanner.nextLine());

        System.out.println("Votre nom : ");
        user.setNom(scanner.nextLine());

        System.out.println("Votre prenom : ");
        user.setPrenom(scanner.nextLine());
    }

    public void input(Credentials credentials) {
        System.out.println("Votre email : ");
        credentials.setEmail(scanner.nextLine());

        System.out.println("Votre mot de passe : ");
        credentials.setMdp(scanner.nextLine());
    }

    public void input(LieuRecharge lieu) {
        System.out.println("Le nom du lieu : ");
        lieu.setNom(scanner.nextLine());

        System.out.println("L'adresse du lieu : ");
        lieu.setAdresse(scanner.nextLine());
    }

    public void input(BorneRecharge borne) {
        borne.etat = EtatBorne.DISPONIBLE;

        System.out.println("Tarif horaire de la borne : ");
        borne.setTarifHoraire(Float.parseFloat(scanner.nextLine()));
    }


    public Utilisateur chooseUtilisateur(List<Utilisateur> users) {
        boolean conti = true;
        int input = 0;

        while (conti) {
            System.out.println("Choisissez parmis les utilisateurs suivants : ");
            for (int i = 0; i < users.size(); i++) {
                Utilisateur u = users.get(i);
                System.out.println(i + 1 + ". " + u.getEmail() + " - " + u.getNom() + " " + u.getPrenom());
            }
            System.out.println("Votre choix : ");

            try {
                input = Integer.parseInt(scanner.nextLine());

                if (input < 1 || input > users.size()) {
                    System.out.println("Veuillez entrer un numéro valide (compris entre 1 et " + users.size() + ")");
                } else {
                    conti = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un numéro");
            }
        }
        return users.get(input - 1);
    }

    public LieuRecharge chooseLieuRecharge(List<LieuRecharge> lieux) {
        boolean conti = true;
        int input = 0;

        while (conti) {
            System.out.println("Choisissez parmis les lieux suivants : ");
            for (int i = 0; i < lieux.size(); i++) {
                LieuRecharge l = lieux.get(i);
                System.out.println(i + 1 + ". " + l.getNom() + " - " + l.getAdresse());
            }
            System.out.println("Votre choix : ");

            try {
                input = Integer.parseInt(scanner.nextLine());

                if (input < 1 || input > lieux.size()) {
                    System.out.println("Veuillez entrer un numéro valide (compris entre 1 et " + lieux.size() + ")");
                } else {
                    conti = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un numéro");
            }
        }
        return lieux.get(input - 1);
    }
}
