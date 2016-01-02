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
    private int patientNummer;
    private ArrayList<Afspraak> agenda;
    
    public Patient(String naam, Date geboorteDatum, int patientNummer) {
        this.naam = naam;
        this.geboorteDatum = geboorteDatum;
        this.patientNummer = patientNummer;
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
    
    public int getPatientNummer(){
        return this.patientNummer;
    }
    
    public String toString() {
        return String.valueOf(this.patientNummer + " " + this.naam + " " + this.geboorteDatum);
    }
}
