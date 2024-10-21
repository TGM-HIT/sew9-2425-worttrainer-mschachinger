package org.example;

import java.io.Serializable;

/**
 * Ein Objekt welches ein Wort und eine URL beinhaltet
 * @author Marcel Schachinger
 * @version 2024-09-29
 */
public class WortEintrag implements Serializable {
    private String wort;
    private String url;

    public WortEintrag(String wort, String url) throws IllegalArgumentException {
        if(wort.length() > 1) {
            this.wort = wort;
        }
        else {
            throw new IllegalArgumentException("Das Wort ist zu kurz");
        }
        if(checkURL(url)) {
            this.url = url;
        }
//		else {
//			throw new IllegalArgumentException("Deine Url ist ung�ltig");
//		}

    }

    /**
     * @return the wort
     */
    public String getWort() {
        return wort;
    }

    /**
     * @param wort the wort to set
     */
    public void setWort(String wort) throws IllegalArgumentException {
        if(this.wort.length() > 1) {
            this.wort = wort;
        }
        else {
            throw new IllegalArgumentException("Das Wort ist zu kurz");
        }
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Ueberprueft ob eine Url nach dem Muster http://beispiel.de aufgebaut ist
     * @return true/false
     */
    public boolean checkURL(String url) {
        /**

        int secondSlash = url.indexOf('/') + 1;
        int dot = 0;
        int firstCharacter = secondSlash + 1;

        //Wenn die URL nicht mit http:// oder https:// beginnt
        if(!(secondSlash == 6 || secondSlash == 7)) {
            return false;
        }

        //Wenn nach dem zweiten Slash kein Buchstabe folgt
        if(!(url.charAt(firstCharacter) >= 'A' && url.charAt(firstCharacter) <= 'z')) {
            return false;
        }

        //An welchem Index ist der Punkt
        for(int i = firstCharacter; i < url.length(); i++) {
            if(url.charAt(i) >= 'A' && url.charAt(i) <= 'z') {

            }
            else if(url.charAt(i) == '.') {
                dot = i;
            }
            else {
                return false;
            }
        }

        //Wenn nach dem Punkt kein Buchstabe folgt
        if(!(url.charAt(dot + 1) >= 'A' && url.charAt(dot + 1) <= 'z')) {
            return false;
        }

        return true;
         **/
        //return true;
        //regex url checker
        return url.matches("^(https?:\\/\\/)([\\w.-]+)(\\/[^\\s]*)?$");

    }


    /**
     * @return String mit Wort und URL
     */
    @Override
    public String toString() {
        return wort + "; " + url;
    }

}
