package interfaces;

import entities.BorneRecharge;

import java.util.Date;
import java.util.List;

public interface BorneService {
    public List<BorneRecharge> rechercher(List<BorneRecharge> bornesExistantes, Date debut, Date fin);
}
