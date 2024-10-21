package org.example.view;
import org.example.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * View Klasse für den Worttrainer
 * @version 2024-09-29
 */
public class WorttrainerView {

    private WortTrainer wortTrainer;
    private WortTrainerSave wtSave;
    public WorttrainerView(WortTrainer wortTrainer) {
        this.wortTrainer = wortTrainer;
        this.wtSave = new WortTrainerSave(wortTrainer);

    }

    /**
     * Startet den Worttrainer und zeigt JOptionPane Dialoge an
     * @throws MalformedURLException
     */
    public void start() throws MalformedURLException {


        //Fragt ob ein Spielstand geladen werden soll
        if(JOptionPane.showConfirmDialog(null, "Möchten Sie einen Speicherstand laden?", "Speicherstand", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
            //lädt das Spiel mit Hilfe der Speichern Klasse
            wtSave.load();
        }



        //auswahl ob ein neuer Eintrag hinzugefügt werden soll
        int auswahl = JOptionPane.showConfirmDialog(null, "Möchten Sie einen neuen Eintrag hinzufügen?", "Neuer Eintrag", JOptionPane.YES_NO_OPTION);
        if(auswahl == JOptionPane.YES_OPTION) {
           String wort = JOptionPane.showInputDialog("Bitte geben Sie das Wort ein");
           String url = JOptionPane.showInputDialog("Bitte geben Sie die URL ein");
           wortTrainer.add(wort, url);
        }


        //Zeigt Bilder an und fragt nach dem Wort bis der Benutzer abbricht
        do {

            //Zeige bild an
            String link = wortTrainer.getUrl(wortTrainer.getIndex());
            try {
                URL url = new URI(link).toURL();
                Image image = ImageIO.read(url);


                int maxWidth = 600;
                int maxHeight = 600;


                int imageWidth = image.getWidth(null);
                int imageHeight = image.getHeight(null);


                double widthScale = (double) maxWidth / imageWidth;
                double heightScale = (double) maxHeight / imageHeight;
                double scaleFactor = Math.min(widthScale, heightScale);

                if (scaleFactor < 1) {
                    int newWidth = (int) (imageWidth * scaleFactor);
                    int newHeight = (int) (imageHeight * scaleFactor);
                    image = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                }

                ImageIcon imageIcon = new ImageIcon(image);
                JOptionPane.showMessageDialog(null, "", "Bildanzeige", JOptionPane.INFORMATION_MESSAGE, imageIcon); // Bild anzeigen
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }


            //wort eingabe und prüfen
            String eingabe = JOptionPane.showInputDialog("Bitte geben Sie das Wort ein");
            int loop = 0;
            //prüfen ob das wort richtig ist
            if (eingabe.equals(wortTrainer.getWort(wortTrainer.getIndex()))) {
                wortTrainer.randomEintrag();
                wortTrainer.addRichtigeWortAnzahl();
                wortTrainer.addWortAnzahl();
                //message dialog mit statistik option und ok option

                loop = JOptionPane.showConfirmDialog(null, "Das ist richtig! Noch ein Wort?", "Ergebnis", JOptionPane.YES_NO_OPTION);


            } else {
                wortTrainer.addWortAnzahl();
                loop = JOptionPane.showConfirmDialog(null, "Das ist leider falsch! Nochmal versuchen?", "Ergebnis", JOptionPane.YES_NO_OPTION);
            }

            //Wenn das Spiel beendet wurde
            if (loop == JOptionPane.NO_OPTION) {
                //Zeigt Statistik an
                JOptionPane.showMessageDialog(null, wortTrainer.statistik(), "Statistik", JOptionPane.INFORMATION_MESSAGE);
                //Fragt ob das Spiel gespeichert werden soll
                if((JOptionPane.showConfirmDialog(null, "Möchtest du das Spiel speichern?", "Speichern?", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION)) {
                    //speicher das Spiel mithilfe der speichern Klasse
                    wtSave.save();
                }
                break;
            }
        } while (true);

    }

}
