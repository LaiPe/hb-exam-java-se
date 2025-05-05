package services;

import entities.Credentials;
import entities.Utilisateur;
import interfaces.AuthentificationService;
import utilities.CodeGenerator;

public class Authentification implements AuthentificationService {
    /**
     * @param user
     * @return
     */
    @Override
    public String inscription(Utilisateur user) {
        user.setCodeValidation(CodeGenerator.generateCode(10));
        user.setEstValide(false);

        //TODO try&catch écriture en bdd

        return user.getCodeValidation();
    }

    /**
     * @param user Utilisateur contenant au minimum l'id
     * @param codeValidation
     * @return
     */
    @Override
    public boolean validation(Utilisateur user, String codeValidation) throws Exception {
        //TODO try&catch fetch user from bdd by id
        if (user.getCodeValidation().isEmpty()) {
            throw new Exception("Utilisateur codeValidation is empty");
        }

        if (user.getCodeValidation().equals(codeValidation)) {
            user.setEstValide(true);
            return true;
        }
        return false;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public boolean connection(Utilisateur user, Credentials credentials) throws Exception {
        //TODO try&catch fetch user credentials from bdd by id

        if (!user.isEstValide()){
            throw new Exception("Utilisateur estValide is false");
        }

        return credentials.isValidFor(user);
    }
}
