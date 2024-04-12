package dao;

import java.util.List;
import metier.entities.Animaux;

public interface IAnimauxDao {
    public Animaux save(Animaux animal);
    public List<Animaux> animauxParMC(String mc);
    public Animaux getAnimal(Long id);
    public Animaux updateAnimal(Animaux animal);
    public void deleteAnimal(Long id);
}
