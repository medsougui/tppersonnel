package web;

import java.util.ArrayList;
import java.util.List;
import metier.entities.Animaux;

public class AnimauxModele {
    private String motCle;
    List<Animaux> animaux = new ArrayList<>();

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public List<Animaux> getAnimaux() {
        return animaux;
    }

    public void setAnimaux(List<Animaux> animaux) {
        this.animaux = animaux;
    }
}
