/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.util.ArrayList;

/**
 *
 * @author brunodelsing
 */
public class Arts {
    
    private String naam, kamerNr;  
    private ArrayList<Afspraak> agenda;
    
    public Arts(String naam, String kamerNr) {
        this.naam = naam;
        this.kamerNr = kamerNr;
        this.agenda = new ArrayList();
    }
    
    public boolean roepPatientOp(Patient patient) {
        return false;
    }
    
    public boolean add(Afspraak afspraak) {       
        if (afspraak != null) {
            return agenda.add(afspraak);
        }
        else {
            return false;
        }
    }

    public String getKamerNr() {
        return this.kamerNr;
    }
    
    public void setKamerNr(String kamerNr) {
        this.kamerNr = kamerNr;
    }
    
    public String getNaam() {
        return this.naam;
    }
    
}
