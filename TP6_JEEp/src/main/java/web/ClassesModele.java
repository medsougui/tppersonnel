package web;

import java.util.ArrayList;
import java.util.List;
import metier.entities.Classes;

public class ClassesModele {
    private List<Classes> classes = new ArrayList<>();

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }
}
