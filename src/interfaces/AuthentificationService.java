package interfaces;

import entities.Credentials;
import entities.Utilisateur;

public interface AuthentificationService {
    public String inscription(Utilisateur user);
    public boolean validation(Utilisateur user, String codeValidation) throws Exception;
    public boolean connection(Utilisateur user, Credentials credentials) throws Exception;
}
