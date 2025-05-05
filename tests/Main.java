import entities.BorneRecharge;
import entities.LieuRecharge;
import entities.Reservation;

public class Main {
    public static void main(String[] args) {
        LieuRecharge monLieu = new LieuRecharge();
        BorneRecharge maBorne1 = new BorneRecharge();
        BorneRecharge maBorne2 = new BorneRecharge();
        BorneRecharge maBorne3 = new BorneRecharge();

        monLieu.addBorne(maBorne1);
        monLieu.addBorne(maBorne2);
        monLieu.addBorne(maBorne3);

        System.out.println(monLieu.getBornes());

        monLieu.deleteBorne(maBorne2);

        System.out.println(monLieu.getBornes());
        
    }
}
