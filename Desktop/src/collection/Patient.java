/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author brunodelsing
 */
public class Patient {

    private String achternaam;
    private String voornaam;
    private Date geboorteDatum;
    private int patientNummer;
    private ArrayList<Afspraak> agenda;

    public Patient(String voornaam, String achternaam, Date geboorteDatum, int patientNummer) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
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

    public String getVoornaam() {
        return this.voornaam;
    }

    public String getAchternaam() {
        return this.achternaam;
    }

    public Date getGeboorteDatum() {
        return this.geboorteDatum;
    }

    public int getPatientNummer() {
        return this.patientNummer;
    }

    private String getRandomMinute() {
        Random rn = new Random();
        String answer = String.valueOf(rn.nextInt(60));
        
        if(Integer.valueOf(answer) < 10){
            answer = ("0")+answer;
        }
        return answer;
    }

    public String toString() {
        return String.valueOf("13:" + getRandomMinute() + "\t" + this.patientNummer + " - " + this.achternaam + ", " + this.voornaam);
    }
}
