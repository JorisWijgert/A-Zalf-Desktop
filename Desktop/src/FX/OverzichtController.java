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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        arts = new Arts("Theodore", "1");
        this.vulAllePatienten();
        this.vulAlleInformatie();
        this.vulAlleDiagnoses();
        this.vulAlleAfspraken();

        ivFotoDichtbij.setImage(new Image("/recourses/Dichtbij2.jpg"));
        ivFotoVeraf.setImage(new Image("/recourses/Veraf2.jpg"));

        ivLogo.setImage(new Image("/recourses/logo2.png"));
        lbVolgendeAfspraak.setText("10 Minuten");

        lvAfspraken.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Afspraak>() {
            @Override
            public void changed(ObservableValue<? extends Afspraak> observable, Afspraak oldValue, Afspraak newValue) {
                geselecteerdeAfspraak = newValue;
                taInformatie.setText(geselecteerdeAfspraak.getInformatie().toString());
                taDiagnose.setText(geselecteerdeAfspraak.getDiagnose().toString());
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
        int index = lvAfspraken.getSelectionModel().getSelectedIndex();
        if ((index + 1) < afsprakenArray.size()) {
            lvAfspraken.getSelectionModel().select(index + 1);
            if ((index % 2) == 0) {
                ivFotoDichtbij.setImage(new Image("/recourses/Dichtbij.jpg"));
                ivFotoVeraf.setImage(new Image("/recourses/Veraf.jpg"));
            } else {
                ivFotoDichtbij.setImage(new Image("/recourses/Dichtbij2.jpg"));
                ivFotoVeraf.setImage(new Image("/recourses/Veraf2.jpg"));
            }
        } else {
            System.out.println("U bent afgewerkt!");
        }
        System.out.println("Volgende patient!");
    }

    @FXML
    public void verstuur() {
        geselecteerdeAfspraak.setDiagnose(new Diagnose(taDiagnose.getText()));
        System.out.println("Diagnose verstuurd!");
    }

    private void vulAllePatienten() {
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

    private void vulAlleInformatie() {
        Informatie informatie0 = new Informatie("De patiënt heeft last van: \n- Wratten op de tenen. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 4 dagen");
        informaties.add(informatie0);
        Informatie informatie1 = new Informatie("De patiënt heeft last van: \n- Galbulten op de rug. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 15 dagen");
        informaties.add(informatie1);
        Informatie informatie2 = new Informatie("De patiënt heeft last van: \n- Spataderen op de onderarmen. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 40 dagen");
        informaties.add(informatie2);
        Informatie informatie3 = new Informatie("De patiënt heeft last van: \n- Schimmelinfecties tussen de vingers. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 12 dagen");
        informaties.add(informatie3);
        Informatie informatie4 = new Informatie("De patiënt heeft last van: \n- Eczeem in de hals en op de elleboog. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 2 dagen");
        informaties.add(informatie4);
        Informatie informatie5 = new Informatie("De patiënt heeft last van: \n- Moedervlekken op de neus. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 23 dagen");
        informaties.add(informatie5);
        Informatie informatie6 = new Informatie("De patiënt heeft last van: \n- Zonbeschadeging op de buik. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 12 dagen");
        informaties.add(informatie6);
        Informatie informatie7 = new Informatie("De patiënt heeft last van: \n- Ouderdomswratten op de knokkels van de linker hand. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 36 dagen");
        informaties.add(informatie7);
        Informatie informatie8 = new Informatie("De patiënt heeft last van: \n- Psoriasis op de knieën. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 7 dagen");
        informaties.add(informatie8);
        Informatie informatie9 = new Informatie("De patiënt heeft last van: \n- Wratten op de handen en voeten. \n\n De aantal dagen dat de patiënt er al last van heeft: \n- 17 dagen");
        informaties.add(informatie9);
    }

    private void vulAlleDiagnoses() {
        Diagnose diagnose0 = new Diagnose("De klachten verdwijnen meestal vanzelf binnen enige dagen tot weken. Voorkom krabben of wrijven. Was de huid goed met water. Ogen kunt u met water uitspoelen. Om verdere verspreiding van de brandharen over het lichaam te voorkomen en om de ontstekingsreactie tegen te gaan is het zinvol de huid direct na de blootstelling met plakband te strippen, om zo alle brandharen te verwijderen. Bij lichte klachten zijn geen medicijnen nodig. Bij hevige jeuk kunnen anti-jeuk middelen helpen, zoals een crème op basis van menthol, aloë vera of calendula. Deze middelen zijn verkrijgbaar bij apotheek of drogist. Bij aanhoudend ernstige klachten kunt u contact opnemen met uw huisarts.");
        diagnoses.add(diagnose0);
        Diagnose diagnose1 = new Diagnose("Om klachten te voorkomen kunt u het beste de rupsen met rust laten en contact met hun nesten en spinsels voorkomen. Dat geldt ook voor uw huisdier(en). Als u rupsen aantreft op gemeentebomen, neem dan contact op met de gemeentewerf, telefoon (0481) 372 684. Treft u de rupsen aan op particuliere bomen? Dan kan de gemeente u helaas niet helpen. U kunt zelf een bedrijf inschakelen om de rupsen te laten verwijderen.");
        diagnoses.add(diagnose1);
        Diagnose diagnose2 = new Diagnose("Na direct contact met de brandharen kan binnen 8 uur een rode pijnlijke huiduitslag met hevige jeuk ontstaan, die zich kenmerkt door bultjes, pukkeltjes of met vochtgevulde blaasjes die kunnen gaan ontsteken. Vaak ontstaan deze reacties op de onbedekte huid, maar door versleping met bijvoorbeeld zweet kan dit ook plaatsvinden op de bedekte huid. Als er brandharen in de ogen terechtkomen, kunnen zij binnen 1 tot 4 uur een heftige reactie geven van het oogbindvlies en/of hoornvlies met zwelling, roodheid en jeuk en in sommige gevallen met ontstekingen. Na inademing kunnen brandharen irritatie of ontsteking geven van het slijmvlies van de bovenste luchtwegen (neus, keel en bovenste gedeelte luchtpijp). De klachten lijken op een neusverkoudheid. Tevens kunnen mensen ook klagen over pijn in de keel en eventuele slikstoornissen, in sommige gevallen is er sprake van kortademigheid. Daarnaast kunnen algemene klachten optreden, zoals braken, duizeligheid, koorts en algehele malaise.");
        diagnoses.add(diagnose2);
        Diagnose diagnose3 = new Diagnose("Seborrhoïsch eczeem is een huidaandoening waarbij er roodheid en schilfers zijn; vooral in het gezicht en op het behaarde hoofd. De aandoening ontstaat aan het begin van de puberteit en is niet besmettelijk. In de kinderjaren komt het vrijwel niet voor. Meestal zijn er afwisselend periodes waarin de verschijnselen minder, of juist erger zijn.\n"
                + " \n"
                + "Bij deze aandoening speelt het micro-organisme Pityrosporum ovale (een gistsoort) een belangrijke rol. Dit micro-organisme is van nature op ieders huid aanwezig. Bij mensen met seborrhoïsch eczeem echter in grotere hoeveelheden dan normaal. Waardoor dit komt weet men niet. Het afweersysteem van het lichaam reageert op de gist met een ontsteking. Dit veroorzaakt de roodheid van het eczeem.");
        diagnoses.add(diagnose3);
        Diagnose diagnose4 = new Diagnose("‘Roos’ is de mildste vorm van seborrhoïsch eczeem, Er zijn dan fijne schilfertjes op het behaarde hoofd, waarbij er ook jeuk is. In een ernstigere vorm wordt de hoofdhuid rood en neem de schilfering toe. Seborrhoïsch eczeem op de onbehaarde huid geeft ook jeuk, roodheid en schilfering. Deze schilfering is vaak wat gelig van kleur en doet wasachtig/vettig aan. De jeuk bij seborrhoïsch eczeem is meestal milder dan bij andere vormen van eczeem, maar de verschijnselen kunnen cosmetisch erg storend zijn.");
        diagnoses.add(diagnose4);
        Diagnose diagnose5 = new Diagnose("Alopecia areata treedt meestal plotseling op. In ernstige gevallen valt het haar met grote plukken uit. Meestal zijn er alleen kale plekken op de hoofdhuid. Hoe de ziekte verloopt, is erg onvoorspelbaar. In de meeste gevallen gaat het haar spontaan weer groeien binnen enkele maanden tot jaren.");
        diagnoses.add(diagnose5);
        Diagnose diagnose6 = new Diagnose("Als er door de haaruitval duidelijke kale plekken op de hoofdhuid ontstaan, is het gemakkelijk om de diagnose te stellen. Dat is moeilijker als de haren gelijkmatig verspreid uitvallen. Soms is het nodig de haarwortels en/of huidweefsel in het laboratorium te onderzoeken. Op die manier wordt duidelijk of het om alopecia areata gaat, of om een andere aandoening. Omdat andere auto-immuunziekten, zoals bijvoorbeeld schildklierziekten, vaker voorkomen bij mensen met alopecia areata, wordt bloedonderzoek gedaan.");
        diagnoses.add(diagnose6);
        Diagnose diagnose7 = new Diagnose("Het belangrijkste kenmerk van constitutioneel eczeem is hevige jeuk. Verdere is de huid rood en schilferig, met kleine bultjes. Ook kunnen blaasjes ontstaan en waaruit vocht kan komen. De hele huid is droog en kan ruw aanvoelen. Door de jeuk kunnen krabwondjes ontstaan. Als het eczeem langere tijd bestaat, kunnen er ruwe en verdikte plekken op de huid ontstaan.");
        diagnoses.add(diagnose7);
        Diagnose diagnose8 = new Diagnose("De dermatoloog stelt de diagnose door de huid te bekijken en te vragen naar de jeuk. Ook zal de dermatoloog u vragen of er familieleden zijn met eczeem, astma of allergieën.");
        diagnoses.add(diagnose8);
        Diagnose diagnose9 = new Diagnose("");
        diagnoses.add(diagnose9);
    }

    private void vulAlleAfspraken() {

        Afspraak afspraak;

        for (int i = 0; i < 10; i++) {
            Patient patient = patienten.get(i);
            Informatie informatie = informaties.get(i);
            afspraak = new Afspraak(patient, arts, informatie, new Date(23 - 02 - 2016), new Date(23 - 02 - 2016));
            afspraak.setDiagnose(diagnoses.get(i));
            afsprakenArray.add(afspraak);
        }
        laatAfsprakenInLijstZien();
    }
}
