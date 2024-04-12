package metier.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "animaux")
public class Animaux implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "NOM")
    private String nom;
    
    @Column(name = "type")
    private String type;
    
    private double age;
    
    @ManyToOne
    @JoinColumn(name = "idclass")
    private Classes classes;

    public Animaux() {
        super();
    }

    public Animaux(String nom, Classes classes) {
        super();
        this.nom = nom;
        this.classes = classes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Animaux [id=" + id + ", nom=" + nom + ", type=" + type + ", age=" + age + ", classes=" + classes + "]";
    }
}
