package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Classes;
import util.JPAutil;

public class ClassesDaoImpl implements IClassesDao {
    private EntityManager entityManager = JPAutil.getEntityManager("TP6_JEE");

    @Override
    public Classes save(Classes classe) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(classe);
        tx.commit();
        return classe;
    }

    @Override
    public Classes getClasses(Long id) {
        return entityManager.find(Classes.class, id);
    }

    @Override
    public Classes updateClasses(Classes classe) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(classe);
        tx.commit();
        return classe;
    }

    @Override
    public void deleteClasses(Long id) {
        Classes classe = entityManager.find(Classes.class, id);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(classe);
        tx.commit();
    }

    @Override
    public List<Classes> getAllClasses() {
        List<Classes> classes = entityManager.createQuery("select c from Classes c", Classes.class).getResultList();
        return classes;
    }
}
