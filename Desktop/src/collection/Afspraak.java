/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.Date;

/**
 *
 * @author brunodelsing
 */
public class Afspraak {

    private Date tijdstip, tijdsduur;

    private Patient patient;
    private Arts arts;

    private Informatie informatie;
    private Diagnose diagnose;
    private String prescriptie;

    public Afspraak(Patient patient, Arts arts, Informatie informatie, Date tijdstip, Date tijdsduur) {
        this.patient = patient;
        this.arts = arts;
        this.tijdsduur = tijdsduur;
        this.tijdstip = tijdstip;
        this.informatie = informatie;
        this.diagnose = null;
    }

    public Date getTijdstip() {
        return tijdstip;
    }

    public Date getTijdsduur() {
        return tijdsduur;
    }

    public Patient getPatient() {
        return patient;
    }

    public Arts getArts() {
        return arts;
    }

    public Informatie getInformatie() {
        return informatie;
    }

    public void setDiagnose(Diagnose diagnose) {
        this.diagnose = diagnose;
    }

    public Diagnose getDiagnose() {
        return diagnose;
    }
    
    public void setPrescriptie(String prescriptie){
        this.prescriptie = prescriptie;
    }
    
    public String getPrescriptie(){
        return this.prescriptie;
    }

    @Override
    public String toString() {
        return this.getPatient().toString();
    }
}
