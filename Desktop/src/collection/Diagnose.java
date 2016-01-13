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
public class Diagnose {

    private String beschrijving, qrCode, prescriptie;

    private ArrayList<Date> reminders;

    private String inname;

    public Diagnose(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Diagnose(String beschrijving, String qrCode, String prescriptie) {
        this.beschrijving = beschrijving;
        this.qrCode = qrCode;
        this.prescriptie = prescriptie;
        this.reminders = new ArrayList();
    }

    public Diagnose(String beschrijving, String prescriptie) {
        this.beschrijving = beschrijving;
        this.prescriptie = prescriptie;
    }

    public Diagnose(String beschrijving, String qrCode, ArrayList<Date> reminders, String prescriptie) {
        this.beschrijving = beschrijving;
        this.qrCode = qrCode;
        this.reminders = reminders;
        this.prescriptie = prescriptie;
    }

    public void setReminders(ArrayList<Date> reminders) {
        this.reminders = reminders;
    }

    public String getPrescriptie() {
        return this.prescriptie;
    }

    public void setInname(String inname) {
        this.inname = inname;
    }

    public String getInname() {
        return this.inname;
    }

    @Override
    public String toString() {
        return this.beschrijving;
    }
}
