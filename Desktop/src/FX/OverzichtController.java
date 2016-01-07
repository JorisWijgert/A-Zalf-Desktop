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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private ImageView ivLogo;

    @FXML
    private Button btVolgende;
    @FXML
    private Button btVerstuur;
    
    private ArrayList<Afspraak> afsprakenArray = new ArrayList<>();
    private ObservableList<Afspraak> afsprakenObservable = FXCollections.observableArrayList(afsprakenArray);
    private ArrayList<Patient> patienten = new ArrayList<>();
    private ArrayList<Informatie> informaties = new ArrayList<>();
    
    private Arts arts;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //taDiagnose.setText("Lorem Ipsum is slechts een proeftekst uit het drukkerij- en zetterijwezen. Lorem Ipsum is de standaard proeftekst in deze bedrijfstak sinds de 16e eeuw, toen een onbekende drukker een zethaak met letters nam en ze door elkaar husselde om een font-catalogus te maken. Het heeft niet alleen vijf eeuwen overleefd maar is ook, vrijwel onveranderd, overgenomen in elektronische letterzetting. Het is in de jaren '60 populair geworden met de introductie van Letraset vellen met Lorem Ipsum passages en meer recentelijk door desktop publishing software zoals Aldus PageMaker die versies van Lorem Ipsum bevatten.");
        //taInformatie.setText("Informatie");
        //taVolgendeAfspraak.setText("12:30");
        arts = new Arts("Theodore", "1");
        this.vulAllePatienten();
        this.vulAlleInformatie();
        this.vulAlleAfspraken();
        
        ivLogo.setImage(new Image("/recourses/logo2.png"));
        ivFotoDichtbij.setImage(new Image("/recourses/Dichtbij.jpg"));
        ivFotoVeraf.setImage(new Image("/recourses/Veraf.jpg"));
        taDiagnose.setText("De klachten verdwijnen meestal vanzelf binnen enige dagen tot weken. \nVoorkom krabben of wrijven. Was de huid goed met water. \nOgen kunt u met water uitspoelen. Om verdere \nverspreiding van de brandharen over het lichaam te \nvoorkomen en om de ontstekingsreactie tegen te gaan \nis het zinvol de huid direct na de blootstelling met plakband te strippen, \nom zo alle brandharen te verwijderen. Bij lichte klachten zijn geen \nmedicijnen nodig. Bij hevige jeuk kunnen anti-jeuk middelen helpen, \nzoals een crème op basis van menthol, aloë vera of calendula. \nDeze middelen zijn verkrijgbaar bij apotheek of drogist. \nBij aanhoudend ernstige klachten kunt u contact \nopnemen met uw huisarts.");
        
        lvAfspraken.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Afspraak>(){
            @Override
            public void changed(ObservableValue<? extends Afspraak> observable, Afspraak oldValue, Afspraak newValue) {
                Afspraak afspraak = newValue;
                taInformatie.setText(afspraak.getInformatie().toString());
                //taDiagnose.setText(afspraak.getDiagnose().toString());
                //System.out.println(afspraak.toString());
            }
        });
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

    public void laatAfsprakenInLijstZien() {
        lvAfspraken.getItems().setAll(FXCollections.observableArrayList(afsprakenArray));
    }
    
    @FXML
    public void verstuur(){
        System.out.println("Diagnose verstuurd!");
    }
    
    private void vulAllePatienten(){
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
    
    private void vulAlleInformatie(){
         Informatie informatie0 = new Informatie("Klachten0");
         informaties.add(informatie0);
         Informatie informatie1 = new Informatie("Klachten1");
         informaties.add(informatie1);
         Informatie informatie2 = new Informatie("Klachten2");
         informaties.add(informatie2);
         Informatie informatie3 = new Informatie("Klachten3");
         informaties.add(informatie3);
         Informatie informatie4 = new Informatie("Klachten4");
         informaties.add(informatie4);
         Informatie informatie5 = new Informatie("Klachten5");
         informaties.add(informatie5);
         Informatie informatie6 = new Informatie("Klachten6");
         informaties.add(informatie6);
         Informatie informatie7 = new Informatie("Klachten7");
         informaties.add(informatie7);
         Informatie informatie8 = new Informatie("Klachten8");
         informaties.add(informatie8);
         Informatie informatie9 = new Informatie("Klachten9");
         informaties.add(informatie9);
    }
    
    private void vulAlleAfspraken(){
        
        Afspraak afspraak;
        
        for(int i = 0; i<10; i++){
            Patient patient = patienten.get(i);
            Informatie informatie = informaties.get(i);
            afspraak = new Afspraak(patient, arts, informatie, new Date(23 - 02 - 2016), new Date(23 - 02 - 2016));
            afsprakenArray.add(afspraak);
        }
        laatAfsprakenInLijstZien();
    }
}
