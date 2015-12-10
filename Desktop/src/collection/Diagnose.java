/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author brunodelsing
 */
public class Diagnose {
    
    private String beschrijving, qrCode;
    
    private ArrayList<Date> reminders;
    
    public Diagnose(String beschrijving, String qrCode) {
        this.beschrijving = beschrijving;
        this.qrCode = qrCode;
        this.reminders = new ArrayList();
    }
    
    public Diagnose(String beschrijving, String qrCode, ArrayList<Date> reminders) {
        this.beschrijving = beschrijving;
        this.qrCode = qrCode;
        this.reminders = reminders;
    }
    
    public void setReminders(ArrayList<Date> reminders) {
        this.reminders = reminders;
    }
}
