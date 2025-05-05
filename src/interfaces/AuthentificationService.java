package interfaces;

import entities.Utilisateur;

public interface AuthentificationService {
    public String inscription(Utilisateur user);
    public boolean validation(Utilisateur user);
    public boolean connection(Utilisateur user);
}
