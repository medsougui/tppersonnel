package metier.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nomClass;
    
   
    private List<Animaux> animauxList;

    public Classes() {
        super();
    }

    public Classes(String nomClass) {
        super();
        this.nomClass = nomClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomClass() {
        return nomClass;
    }

    public void setNomClass(String nomClass) {
        this.nomClass = nomClass;
    }

    public List<Animaux> getAnimauxList() {
        return animauxList;
    }

    public void setAnimauxList(List<Animaux> animauxList) {
        this.animauxList = animauxList;
    }

    @Override
    public String toString() {
        return "Classes [id=" + id + ", nomClass=" + nomClass + "]";
    }
}
