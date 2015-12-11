/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author brunodelsing
 */
public class Patient {
    
    private String naam;
    private Date geboorteDatum;
    private ArrayList<Afspraak> agenda;
    
    public Patient(String naam, Date geboorteDatum) {
        this.naam = naam;
        this.geboorteDatum = geboorteDatum;
        this.agenda = new ArrayList();
    }
    
    public boolean add(Afspraak afspraak) {
        if (afspraak != null) {
            return this.agenda.add(afspraak);
        } else {
            return false;
        }
    }
    
    public String getNaam() {
        return this.naam;
    }
    
    public Date getGeboorteDatum() {
        return this.geboorteDatum;
    }
}
