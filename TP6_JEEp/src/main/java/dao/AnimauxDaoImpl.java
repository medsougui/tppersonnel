package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Animaux;
import util.JPAutil;
public class AnimauxDaoImpl implements IAnimauxDao {
    private EntityManager entityManager = JPAutil.getEntityManager("TP5_JEE");

    @Override
    public Animaux save(Animaux animal) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(animal);
        tx.commit();
        return animal;
    }

    @Override
    public List<Animaux> animauxParMC(String mc) {
        List<Animaux> animaux = entityManager.createQuery("SELECT a FROM Animaux a WHERE a.nom LIKE :mc").setParameter("mc", "%" + mc + "%").getResultList();
        return animaux;
    }

    @Override
    public Animaux getAnimal(Long id) {
        return entityManager.find(Animaux.class, id);
    }

    @Override
    public Animaux updateAnimal(Animaux animal) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(animal);
        tx.commit();
        return animal;
    }

    @Override
    public void deleteAnimal(Long id) {
        Animaux animal = entityManager.find(Animaux.class, id);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(animal);
        tx.commit();
    }
}
