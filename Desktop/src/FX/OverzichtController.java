/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FX;

import Collection.Afspraak;
import Collection.Arts;
import Collection.Diagnose;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;

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
    private Label lbVolgendeAfspraak;
    @FXML
    private Label lbHuidigePatient;
    @FXML
    private Label lbWelkomArts;
    
    @FXML
    private TextField tfPrescriptie;
    @FXML
    private TextField tfInnameMedicatie;

    @FXML
    private Button btVolgende;
    @FXML
    private Button btVerstuur;

    private ArrayList<Afspraak> afsprakenArray = new ArrayList<>();
    private ObservableList<Afspraak> afsprakenObservable = FXCollections.observableArrayList(afsprakenArray);
    private ArrayList<Patient> patienten = new ArrayList<>();
    private ArrayList<Informatie> informaties = new ArrayList<>();
    private ArrayList<Diagnose> diagnoses = new ArrayList<>();

    private Arts arts;
    private Afspraak geselecteerdeAfspraak;
    private int indexHuidigeAfspraak = 9;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        arts = new Arts("Theodore", "1");
        this.vulAllePatienten();
        this.vulAlleInformatie();
        this.vulAlleDiagnoses();
        this.vulAlleAfspraken();
        
        lbWelkomArts.setText("Welkom, " + arts.getNaam());
        ivFotoDichtbij.setImage(new Image("/recourses/Dichtbij2.jpg"));
        ivFotoVeraf.setImage(new Image("/recourses/Veraf2.jpg"));

        ivLogo.setImage(new Image("/recourses/logo2.png"));
        lbVolgendeAfspraak.setText("10 Minuten");
        
        lvAfspraken.getSelectionModel().select(indexHuidigeAfspraak);
        lbHuidigePatient.setText(patienten.get(indexHuidigeAfspraak).getPatientNummer() + " " + patienten.get(indexHuidigeAfspraak).getAchternaam() + " " + patienten.get(indexHuidigeAfspraak).getVoornaam());
        
        lvAfspraken.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Afspraak>() {
            @Override
            public void changed(ObservableValue<? extends Afspraak> observable, Afspraak oldValue, Afspraak newValue) {
                geselecteerdeAfspraak = newValue;
                taInformatie.setText(geselecteerdeAfspraak.getInformatie().toString());
                taDiagnose.setText(geselecteerdeAfspraak.getDiagnose().toString());

                if ((lvAfspraken.getSelectionModel().getSelectedIndex() % 2) == 0) {
                    ivFotoDichtbij.setImage(new Image("/recourses/Dichtbij.jpg"));
                    ivFotoVeraf.setImage(new Image("/recourses/Veraf.jpg"));
                } else {
                    ivFotoDichtbij.setImage(new Image("/recourses/Dichtbij2.jpg"));
                    ivFotoVeraf.setImage(new Image("/recourses/Veraf2.jpg"));
                }
            }
        });
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
    public void volgendePatient() {
        indexHuidigeAfspraak++;
        if (indexHuidigeAfspraak >= lvAfspraken.getItems().size()) {
            System.out.println("Geen afspraken meer!");
        } else {
            if ((indexHuidigeAfspraak) < afsprakenArray.size()) {
                lvAfspraken.getSelectionModel().select(indexHuidigeAfspraak);
                if ((indexHuidigeAfspraak % 2) == 0) {
                    ivFotoDichtbij.setImage(new Image("/recourses/Dichtbij.jpg"));
                    ivFotoVeraf.setImage(new Image("/recourses/Veraf.jpg"));
                } else {
                    ivFotoDichtbij.setImage(new Image("/recourses/Dichtbij2.jpg"));
                    ivFotoVeraf.setImage(new Image("/recourses/Veraf2.jpg"));
                }
            } else {
                System.out.println("Geen patiënten meer!");
            }
            System.out.println("Volgende patiënt!");
            lbHuidigePatient.setText(patienten.get(indexHuidigeAfspraak).getPatientNummer() + " " + patienten.get(indexHuidigeAfspraak).getAchternaam() + " " + patienten.get(indexHuidigeAfspraak).getVoornaam());
            tfPrescriptie.setText(geselecteerdeAfspraak.getDiagnose().getPrescriptie());
        }
    }

    @FXML
    public void verstuur() {
        geselecteerdeAfspraak.setDiagnose(new Diagnose(taDiagnose.getText()));
        System.out.println("Diagnose verstuurd!");
    }

    private void vulAllePatienten() {
        Patient patient0 = new Patient("Piet", "Fransen", new Date(1964, 6, 20, 0, 0), 11923);
        patienten.add(patient0);
        Patient patient1 = new Patient("Sjaak", "Teeven", new Date(1965, 2, 11, 0, 0), 73645);
        patienten.add(patient1);
        Patient patient2 = new Patient("Fritz", "Pok", new Date(1966, 3, 12, 0, 0), 12543);
        patienten.add(patient2);
        Patient patient3 = new Patient("Thea", "Driesen", new Date(1967, 4, 12, 0, 0), 68432);
        patienten.add(patient3);
        Patient patient4 = new Patient("Theodora", "Navis", new Date(1968, 5, 14, 0, 0), 59080);
        patienten.add(patient4);
        Patient patient5 = new Patient("Bea", "Kippens", new Date(1969, 6, 15, 0, 0), 86756);
        patienten.add(patient5);
        Patient patient6 = new Patient("Truus", "Dekker", new Date(1963, 7, 16, 0, 0), 25701);
        patienten.add(patient6);
        Patient patient7 = new Patient("Sjra", "Lanken", new Date(1962, 8, 17, 0, 0), 24312);
        patienten.add(patient7);
        Patient patient8 = new Patient("Andre", "Duisters", new Date(1961, 9, 18, 0, 0), 46347);
        patienten.add(patient8);
        Patient patient9 = new Patient("Jac", "Mensens", new Date(1960, 10, 19, 0, 0), 74523);
        patienten.add(patient9);
        Patient patient10 = new Patient("Frans", "Diederiks", new Date(1950, 4, 18, 0, 0), 74663);
        patienten.add(patient10);
        Patient patient11 = new Patient("Julia", "Davids", new Date(19651, 5, 17, 0, 0), 71123);
        patienten.add(patient11);
        Patient patient12 = new Patient("Robert", "Janse", new Date(19652, 6, 16, 0, 0), 92113);
        patienten.add(patient12);
        Patient patient13 = new Patient("Francien", "Mensens", new Date(1953, 7, 15, 0, 0), 76166);
        patienten.add(patient13);
        Patient patient14 = new Patient("Dennis", "Pok", new Date(1954, 8, 14, 0, 0), 43256);
        patienten.add(patient14);
        Patient patient15 = new Patient("Vanessa", "Driesen", new Date(1955, 12, 19, 0, 0), 92613);
        patienten.add(patient15);
        Patient patient16 = new Patient("Quin", "Simmens", new Date(1956, 10, 12, 0, 0), 83513);
        patienten.add(patient16);
        Patient patient17 = new Patient("Samsom", "Roberts", new Date(1957, 9, 11, 0, 0), 43432);
        patienten.add(patient17);
    }

    private void vulAlleInformatie() {
        int i = 0;
        Informatie informatie0 = new Informatie(getPatient(i).getPatientNummer() + " " + getPatient(i).getAchternaam() + " " + getPatient(i).getVoornaam() + " " + getPatient(i).getGeboorteDatum().getYear() + "\n\nDe patiënt heeft last van: \n- Wratten op de tenen. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 4 dagen");
        informaties.add(informatie0);
        Informatie informatie1 = new Informatie(getPatient(i++).getPatientNummer() + " " + getPatient(i).getAchternaam() + " " + getPatient(i).getVoornaam() + " " + getPatient(i).getGeboorteDatum().getYear() + "\n\nDe patiënt heeft last van: \n- Galbulten op de rug. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 15 dagen");
        informaties.add(informatie1);
        Informatie informatie2 = new Informatie(getPatient(i++).getPatientNummer() + " " + getPatient(i).getAchternaam() + " " + getPatient(i).getVoornaam() + " " + getPatient(i).getGeboorteDatum().getYear() + "\n\nDe patiënt heeft last van: \n- Spataderen op de onderarmen. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 40 dagen");
        informaties.add(informatie2);
        Informatie informatie3 = new Informatie(getPatient(i++).getPatientNummer() + " " + getPatient(i).getAchternaam() + " " + getPatient(i).getVoornaam() + " " + getPatient(i).getGeboorteDatum().getYear() + "\n\nDe patiënt heeft last van: \n- Schimmelinfecties tussen de vingers. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 12 dagen");
        informaties.add(informatie3);
        Informatie informatie4 = new Informatie(getPatient(i++).getPatientNummer() + " " + getPatient(i).getAchternaam() + " " + getPatient(i).getVoornaam() + " " + getPatient(i).getGeboorteDatum().getYear() + "\n\nDe patiënt heeft last van: \n- Eczeem in de hals en op de elleboog. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 2 dagen");
        informaties.add(informatie4);
        Informatie informatie5 = new Informatie(getPatient(i++).getPatientNummer() + " " + getPatient(i).getAchternaam() + " " + getPatient(i).getVoornaam() + " " + getPatient(i).getGeboorteDatum().getYear() + "\n\nDe patiënt heeft last van: \n- Moedervlekken op de neus. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 23 dagen");
        informaties.add(informatie5);
        Informatie informatie6 = new Informatie(getPatient(i++).getPatientNummer() + " " + getPatient(i).getAchternaam() + " " + getPatient(i).getVoornaam() + " " + getPatient(i).getGeboorteDatum().getYear() + "\n\nDe patiënt heeft last van: \n- Zonbeschadeging op de buik. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 12 dagen");
        informaties.add(informatie6);
        Informatie informatie7 = new Informatie(getPatient(i++).getPatientNummer() + " " + getPatient(i).getAchternaam() + " " + getPatient(i).getVoornaam() + " " + getPatient(i).getGeboorteDatum().getYear() + "\n\nDe patiënt heeft last van: \n- Ouderdomswratten op de knokkels van de linker hand. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 36 dagen");
        informaties.add(informatie7);
        Informatie informatie8 = new Informatie(getPatient(i++).getPatientNummer() + " " + getPatient(i).getAchternaam() + " " + getPatient(i).getVoornaam() + " " + getPatient(i).getGeboorteDatum().getYear() + "\n\nDe patiënt heeft last van: \n- Psoriasis op de knieën. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 7 dagen");
        informaties.add(informatie8);
        Informatie informatie9 = new Informatie(getPatient(i++).getPatientNummer() + " " + getPatient(i).getAchternaam() + " " + getPatient(i).getVoornaam() + " " + getPatient(i).getGeboorteDatum().getYear() + "\n\nDe patiënt heeft last van: \n- Wratten op de handen en voeten. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 17 dagen");
        informaties.add(informatie9);
        Informatie informatie10 = new Informatie(getPatient(i++).getPatientNummer() + " " + getPatient(i).getAchternaam() + " " + getPatient(i).getVoornaam() + " " + getPatient(i).getGeboorteDatum().getYear() + "\n\nDe patiënt heeft last van: \n- Zonbeschadeging op de buik. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 12 dagen");
        informaties.add(informatie10);
        Informatie informatie11 = new Informatie(getPatient(i++).getPatientNummer() + " " + getPatient(i).getAchternaam() + " " + getPatient(i).getVoornaam() + " " + getPatient(i).getGeboorteDatum().getYear() + "\n\nDe patiënt heeft last van: \n- Spataderen op de onderarmen. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 40 dagen");
        informaties.add(informatie11);
        Informatie informatie12 = new Informatie(getPatient(i++).getPatientNummer() + " " + getPatient(i).getAchternaam() + " " + getPatient(i).getVoornaam() + " " + getPatient(i).getGeboorteDatum().getYear() + "\n\nDe patiënt heeft last van: \n- Schimmelinfecties tussen de vingers. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 12 dagen");
        informaties.add(informatie12);
        Informatie informatie13 = new Informatie(getPatient(i++).getPatientNummer() + " " + getPatient(i).getAchternaam() + " " + getPatient(i).getVoornaam() + " " + getPatient(i).getGeboorteDatum().getYear() + "\n\nDe patiënt heeft last van: \n- Galbulten op de rug. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 15 dagen");
        informaties.add(informatie13);
        Informatie informatie14 = new Informatie(getPatient(i++).getPatientNummer() + " " + getPatient(i).getAchternaam() + " " + getPatient(i).getVoornaam() + " " + getPatient(i).getGeboorteDatum().getYear() + "\n\nDe patiënt heeft last van: \n- Zonbeschadeging op de buik. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 12 dagen");
        informaties.add(informatie14);
        Informatie informatie15 = new Informatie(getPatient(i++).getPatientNummer() + " " + getPatient(i).getAchternaam() + " " + getPatient(i).getVoornaam() + " " + getPatient(i).getGeboorteDatum().getYear() + "\n\nDe patiënt heeft last van: \n- Wratten op de handen en voeten. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 17 dagen");
        informaties.add(informatie15);
        Informatie informatie16 = new Informatie(getPatient(i++).getPatientNummer() + " " + getPatient(i).getAchternaam() + " " + getPatient(i).getVoornaam() + " " + getPatient(i).getGeboorteDatum().getYear() + "\n\nDe patiënt heeft last van: \n- Wratten op de handen en voeten. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 17 dagen");
        informaties.add(informatie16);
        Informatie informatie17 = new Informatie(getPatient(i++).getPatientNummer() + " " + getPatient(i).getAchternaam() + " " + getPatient(i).getVoornaam() + " " + getPatient(i).getGeboorteDatum().getYear() + "\n\nDe patiënt heeft last van: \n- Wratten op de handen en voeten. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 17 dagen");
        informaties.add(informatie17);
    }

    private Patient getPatient(int i) {
        Patient patient = patienten.get(i);
        return patient;
    }

    private void vulAlleDiagnoses() {
        Diagnose diagnose0 = new Diagnose("De klachten verdwijnen meestal vanzelf binnen enige dagen tot weken. Voorkom krabben of wrijven. Was de huid goed met water. Ogen kunt u met water uitspoelen. Om verdere verspreiding van de brandharen over het lichaam te voorkomen en om de ontstekingsreactie tegen te gaan is het zinvol de huid direct na de blootstelling met plakband te strippen, om zo alle brandharen te verwijderen. Bij lichte klachten zijn geen medicijnen nodig. Bij hevige jeuk kunnen anti-jeuk middelen helpen, zoals een crème op basis van menthol, aloë vera of calendula. Deze middelen zijn verkrijgbaar bij apotheek of drogist. Bij aanhoudend ernstige klachten kunt u contact opnemen met uw huisarts.", "Bactroban");
        diagnoses.add(diagnose0);
        Diagnose diagnose1 = new Diagnose("Om klachten te voorkomen kunt u het beste de rupsen met rust laten en contact met hun nesten en spinsels voorkomen. Dat geldt ook voor uw huisdier(en). Als u rupsen aantreft op gemeentebomen, neem dan contact op met de gemeentewerf, telefoon (0481) 372 684. Treft u de rupsen aan op particuliere bomen? Dan kan de gemeente u helaas niet helpen. U kunt zelf een bedrijf inschakelen om de rupsen te laten verwijderen.", "Daktarin");
        diagnoses.add(diagnose1);
        Diagnose diagnose2 = new Diagnose("Na direct contact met de brandharen kan binnen 8 uur een rode pijnlijke huiduitslag met hevige jeuk ontstaan, die zich kenmerkt door bultjes, pukkeltjes of met vochtgevulde blaasjes die kunnen gaan ontsteken. Vaak ontstaan deze reacties op de onbedekte huid, maar door versleping met bijvoorbeeld zweet kan dit ook plaatsvinden op de bedekte huid. Als er brandharen in de ogen terechtkomen, kunnen zij binnen 1 tot 4 uur een heftige reactie geven van het oogbindvlies en/of hoornvlies met zwelling, roodheid en jeuk en in sommige gevallen met ontstekingen. Na inademing kunnen brandharen irritatie of ontsteking geven van het slijmvlies van de bovenste luchtwegen (neus, keel en bovenste gedeelte luchtpijp). De klachten lijken op een neusverkoudheid. Tevens kunnen mensen ook klagen over pijn in de keel en eventuele slikstoornissen, in sommige gevallen is er sprake van kortademigheid. Daarnaast kunnen algemene klachten optreden, zoals braken, duizeligheid, koorts en algehele malaise.", "Madopar");
        diagnoses.add(diagnose2);
        Diagnose diagnose3 = new Diagnose("Seborrhoïsch eczeem is een huidaandoening waarbij er roodheid en schilfers zijn; vooral in het gezicht en op het behaarde hoofd. De aandoening ontstaat aan het begin van de puberteit en is niet besmettelijk. In de kinderjaren komt het vrijwel niet voor. Meestal zijn er afwisselend periodes waarin de verschijnselen minder, of juist erger zijn.\n"
                + " \n"
                + "Bij deze aandoening speelt het micro-organisme Pityrosporum ovale (een gistsoort) een belangrijke rol. Dit micro-organisme is van nature op ieders huid aanwezig. Bij mensen met seborrhoïsch eczeem echter in grotere hoeveelheden dan normaal. Waardoor dit komt weet men niet. Het afweersysteem van het lichaam reageert op de gist met een ontsteking. Dit veroorzaakt de roodheid van het eczeem.", "Metopiron");
        diagnoses.add(diagnose3);
        Diagnose diagnose4 = new Diagnose("‘Roos’ is de mildste vorm van seborrhoïsch eczeem, Er zijn dan fijne schilfertjes op het behaarde hoofd, waarbij er ook jeuk is. In een ernstigere vorm wordt de hoofdhuid rood en neem de schilfering toe. Seborrhoïsch eczeem op de onbehaarde huid geeft ook jeuk, roodheid en schilfering. Deze schilfering is vaak wat gelig van kleur en doet wasachtig/vettig aan. De jeuk bij seborrhoïsch eczeem is meestal milder dan bij andere vormen van eczeem, maar de verschijnselen kunnen cosmetisch erg storend zijn.", "Picosulfaat");
        diagnoses.add(diagnose4);
        Diagnose diagnose5 = new Diagnose("Alopecia areata treedt meestal plotseling op. In ernstige gevallen valt het haar met grote plukken uit. Meestal zijn er alleen kale plekken op de hoofdhuid. Hoe de ziekte verloopt, is erg onvoorspelbaar. In de meeste gevallen gaat het haar spontaan weer groeien binnen enkele maanden tot jaren.", "Ultacit");
        diagnoses.add(diagnose5);
        Diagnose diagnose6 = new Diagnose("Als er door de haaruitval duidelijke kale plekken op de hoofdhuid ontstaan, is het gemakkelijk om de diagnose te stellen. Dat is moeilijker als de haren gelijkmatig verspreid uitvallen. Soms is het nodig de haarwortels en/of huidweefsel in het laboratorium te onderzoeken. Op die manier wordt duidelijk of het om alopecia areata gaat, of om een andere aandoening. Omdat andere auto-immuunziekten, zoals bijvoorbeeld schildklierziekten, vaker voorkomen bij mensen met alopecia areata, wordt bloedonderzoek gedaan.", "Wartec");
        diagnoses.add(diagnose6);
        Diagnose diagnose7 = new Diagnose("Het belangrijkste kenmerk van constitutioneel eczeem is hevige jeuk. Verdere is de huid rood en schilferig, met kleine bultjes. Ook kunnen blaasjes ontstaan en waaruit vocht kan komen. De hele huid is droog en kan ruw aanvoelen. Door de jeuk kunnen krabwondjes ontstaan. Als het eczeem langere tijd bestaat, kunnen er ruwe en verdikte plekken op de huid ontstaan.", "Tambocor");
        diagnoses.add(diagnose7);
        Diagnose diagnose8 = new Diagnose("De dermatoloog stelt de diagnose door de huid te bekijken en te vragen naar de jeuk. Ook zal de dermatoloog u vragen of er familieleden zijn met eczeem, astma of allergieën.", "Tasigna");
        diagnoses.add(diagnose8);
        Diagnose diagnose9 = new Diagnose("");
        diagnoses.add(diagnose9);
        Diagnose diagnose10 = new Diagnose("");
        diagnoses.add(diagnose10);
        Diagnose diagnose11 = new Diagnose("");
        diagnoses.add(diagnose11);
        Diagnose diagnose12 = new Diagnose("");
        diagnoses.add(diagnose12);
        Diagnose diagnose13 = new Diagnose("");
        diagnoses.add(diagnose13);
        Diagnose diagnose14 = new Diagnose("");
        diagnoses.add(diagnose14);
        Diagnose diagnose15 = new Diagnose("");
        diagnoses.add(diagnose15);
        Diagnose diagnose16 = new Diagnose("");
        diagnoses.add(diagnose16);
        Diagnose diagnose17 = new Diagnose("");
        diagnoses.add(diagnose17);
    }

    private void vulAlleAfspraken() {

        Afspraak afspraak;

        for (int i = 0; i < 17; i++) {
            Patient patient = patienten.get(i);
            Informatie informatie = informaties.get(i);
            afspraak = new Afspraak(patient, arts, informatie, new Date(23 - 02 - 2016), new Date(23 - 02 - 2016));
            afspraak.setDiagnose(diagnoses.get(i));
            afsprakenArray.add(afspraak);
        }
        laatAfsprakenInLijstZien();
    }
}
