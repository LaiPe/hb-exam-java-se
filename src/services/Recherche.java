package services;

import entities.BorneRecharge;
import interfaces.BorneService;

import java.util.Date;
import java.util.List;

public class Recherche implements BorneService {
    /**
     * @param bornesExistantes
     * @param debut
     * @param fin
     * @return
     */
    @Override
    public List<BorneRecharge> rechercher(List<BorneRecharge> bornesExistantes, Date debut, Date fin) {
        return List.of();
    }
}
