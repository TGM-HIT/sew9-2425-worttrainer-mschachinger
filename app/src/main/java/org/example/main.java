package org.example;

public class main {

    public static void main(String[] args) {
        WortEintrag we = new WortEintrag("Hallo", "https://google.com");
        System.out.println(we.checkURL("https://google.com"));

    }
}
