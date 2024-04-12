package dao;

import java.util.List;
import metier.entities.Classes;

public interface IClassesDao {
    public Classes save(Classes classe);
    public Classes getClasses(Long id);
    public Classes updateClasses(Classes classe);
    public void deleteClasses(Long id);
    public List<Classes> getAllClasses();
}
