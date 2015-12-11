/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import FX.OverzichtController;
import javafx.scene.image.Image;

/**
 *
 * @author Ramon
 */
public class Administratie {

    private OverzichtController overzichtController;
    private Image image;
    
    public void setup() {
        overzichtController = new OverzichtController();      
        overzichtController.setIvFotoDichtbij(kiesImage("Dichtbij"));
    }
    
    private Image kiesImage(String filenaam){
        return image = new Image("/recourses/"+ filenaam + ".jpg");
    }

}
