package org.example.view;
import org.example.WortTrainer;

import javax.swing.JOptionPane;

public class WorttrainerView {

    private WortTrainer wortTrainer;
    public WorttrainerView(WortTrainer wortTrainer) {
        this.wortTrainer = wortTrainer;

    }

    public void start() {

        //auswahl ob ein speichestand geladen werden soll
        int auswahl = JOptionPane.showConfirmDialog(null, "Möchten Sie einen Speicherstand laden?", "Speicherstand", JOptionPane.YES_NO_OPTION);
        if(auswahl == JOptionPane.YES_OPTION) {
            //wortTrainer.laden();
        }





    }



}
