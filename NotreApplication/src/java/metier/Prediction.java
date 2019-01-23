/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author p1702174
 */
public class Prediction {
    
    private int id;
    private String type;
    private String libelle;

    public Prediction(int id, String type, String libelle) {
        this.id = id;
        this.type = type;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Prediction{" + "id=" + id + ", type=" + type + ", libelle=" + libelle + '}';
    }
    
}
