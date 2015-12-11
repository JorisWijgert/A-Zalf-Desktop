/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FX;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Ramon
 */
public class OverzichtController {

    @FXML
    ListView lvAfspraken;
    @FXML
    TextArea taInformatie, taVolgendeAfspraak, taDiagnose;
    @FXML
    ImageView ivFotoDichtbij, ivFotoVeraf;
    @FXML
    Button btVolgende, btVerstuur;

    public void OverzichtController() {
        this.ivFotoDichtbij = this.ivFotoVeraf = new ImageView();
        this.btVerstuur = this.btVolgende = new Button();
        this.taInformatie = this.taVolgendeAfspraak = this.taDiagnose = new TextArea();
        this.lvAfspraken = new ListView();
    }

    @FXML
    public void volgendePatient() {

    }

    public void setIvFotoDichtbij(Image ivFotoDichtbij) {
        this.ivFotoDichtbij.setImage(ivFotoDichtbij);
    }

    public void setIvFotoVeraf(Image ivFotoVeraf) {
        this.ivFotoVeraf.setImage(ivFotoVeraf);
    }
}
