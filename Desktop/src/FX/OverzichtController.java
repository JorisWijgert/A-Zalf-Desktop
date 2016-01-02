/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FX;

import Collection.Afspraak;
import Collection.Arts;
import Collection.Informatie;
import Collection.Patient;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Ramon
 */
public class OverzichtController implements Initializable {

    @FXML
    private ListView lvAfspraken = new ListView();
    @FXML
    private TextArea taInformatie;
    @FXML
    private TextArea taVolgendeAfspraak;
    @FXML
    private TextArea taDiagnose;

    @FXML
    private ImageView ivFotoDichtbij = new ImageView();
    @FXML
    private ImageView ivFotoVeraf = new ImageView();

    @FXML
    private Button btVolgende;
    @FXML
    private Button btVerstuur;
    
    private ArrayList<Afspraak> afsprakenArray = new ArrayList<>();
    private ObservableList<Afspraak> afsprakenObservable = FXCollections.observableArrayList();
    private ArrayList<Patient> patienten = new ArrayList<>();
    
    private Arts arts;
    

//ObservableList<Stavka> oListStavaka = FXCollections.observableArrayList(listStavaka);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taDiagnose.setText("Lorem Ipsum is slechts een proeftekst uit het drukkerij- en zetterijwezen. Lorem Ipsum is de standaard proeftekst in deze bedrijfstak sinds de 16e eeuw, toen een onbekende drukker een zethaak met letters nam en ze door elkaar husselde om een font-catalogus te maken. Het heeft niet alleen vijf eeuwen overleefd maar is ook, vrijwel onveranderd, overgenomen in elektronische letterzetting. Het is in de jaren '60 populair geworden met de introductie van Letraset vellen met Lorem Ipsum passages en meer recentelijk door desktop publishing software zoals Aldus PageMaker die versies van Lorem Ipsum bevatten.");
        taInformatie.setText("Informatie");
        taVolgendeAfspraak.setText("12:30");
        arts = new Arts("Theodore", "1");
    }

    @FXML
    public void volgendePatient() {
        System.out.println("Volgende patient!");
    }

    public void setIvFotoDichtbij(Image ivFotoDichtbij) {
        this.ivFotoDichtbij.setImage(ivFotoDichtbij);
    }

    public void setIvFotoVeraf(Image ivFotoVeraf) {
        this.ivFotoVeraf.setImage(ivFotoVeraf);
    }

    public void vullAlleAfspraken() {
        Patient patient = new Patient("Piet Fransen", new Date(23 - 02 - 1964), 11923);

        Informatie informatie = new Informatie("Klachten");
        Afspraak afspraak = new Afspraak(patient, arts, informatie, new Date(23 - 02 - 2016), new Date(23 - 02 - 2016));
        afsprakenArray.add(afspraak);
        laatAfsprakenInLijstZien();
    }

    public void laatAfsprakenInLijstZien() {
        lvAfspraken.getItems().setAll(FXCollections.observableArrayList(afsprakenObservable).toString());
    }
    
    @FXML
    public void verstuur(){
        System.out.println("Diagnose verstuurd!");
    }
    
    private void allePatienten(){
        Patient patient0 = new Patient("Piet Fransen", new Date(23 - 02 - 1964), 11923);
        patienten.add(patient0);
        Patient patient1 = new Patient("Sjaak Teeven", new Date(11 - 02 - 1965), 73645);
        patienten.add(patient1);
        Patient patient2 = new Patient("Fritz Pok", new Date(12 - 03 - 1966), 12543);
        patienten.add(patient2);
        Patient patient3 = new Patient("Thea Driesen", new Date(13 - 04 - 1967), 68432);
        patienten.add(patient3);
        Patient patient4 = new Patient("Theodora Navis", new Date(14 - 05 - 1968), 59080);
        patienten.add(patient4);
        Patient patient5 = new Patient("Bea Kippens", new Date(15 - 06 - 1969), 86756);
        patienten.add(patient5);
        Patient patient6 = new Patient("Truus Dekker", new Date(16 - 07 - 1963), 25701);
        patienten.add(patient6);
        Patient patient7 = new Patient("Sjra Lanken", new Date(17 - 8 - 1962), 24312);
        patienten.add(patient7);
        Patient patient8 = new Patient("Andre Duisters", new Date(18 - 9 - 1961), 46347);
        patienten.add(patient8);
        Patient patient9 = new Patient("Jac Mensens", new Date(19 - 10 - 1960), 74523);
        patienten.add(patient9);
    }
}
