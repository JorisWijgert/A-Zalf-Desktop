/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.awt.Image;

/**
 *
 * @author brunodelsing
 */
public class Informatie {

    private String klachten, opmerkingen;
    private Image fotoDichtbij, fotoVeraf;

    public Informatie(String klachten) {
        this.klachten = klachten;
    }

    public Informatie(String klachten, Image fotoDichtbij, Image fotoVeraf) {
        this.klachten = klachten;
        this.fotoDichtbij = fotoDichtbij;
        this.fotoVeraf = fotoVeraf;
    }

    public Informatie(String klachten, Image fotoDichtbij, Image fotoVeraf, String opmerkingen) {
        this.klachten = klachten;
        this.fotoDichtbij = fotoDichtbij;
        this.fotoVeraf = fotoVeraf;
        this.opmerkingen = opmerkingen;
    }

    public String getKlachten() {
        return klachten;
    }

    public String getOpmerkingen() {
        return opmerkingen;
    }

    public Image getFotoDichtbij() {
        return fotoDichtbij;
    }

    public Image getFotoVeraf() {
        return fotoVeraf;
    }

    @Override
    public String toString() {
        return this.getKlachten();
    }

}
