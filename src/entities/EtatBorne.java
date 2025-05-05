package entities;

public enum EtatBorne {
    DISPONIBLE(0,"Disponible"),
    EN_COURS_D_UTILISATION(1,"En cours d'utilisation"),
    HORS_SERVICE(2, "Hors Service");

    int index;
    String str;

    EtatBorne(int index, String str) {
        this.index = index;
        this.str = str;
    }
}
