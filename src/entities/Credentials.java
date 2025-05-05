package entities;

public class Credentials {
    private String email;
    private String mdp;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public boolean isValidFor(Utilisateur user) {
        return (this.email.equals(user.getEmail()) && this.mdp.equals(user.getMdp()));
    }
}
