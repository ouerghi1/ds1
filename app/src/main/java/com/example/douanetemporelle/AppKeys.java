
package com.example.douanetemporelle;

public class AppKeys {

    public static String getKey(String matricule, String nom) {
        return matricule + "_" + nom;
    }

    public static final String MATRICULE = "0724";

    public static String NOM() {
        return getKey(MATRICULE, "NOM_VOYAGEUR");
    }

    public static String NAISSANCE() {
        return getKey(MATRICULE, "ANNEE_NAISSANCE");
    }

    public static String DESTINATION() {
        return getKey(MATRICULE, "ANNEE_DESTINATION");
    }

    public static String MOTIF() {
        return getKey(MATRICULE, "MOTIF_VOYAGE");
    }

    public static String VERDICT() {
        return getKey(MATRICULE, "VERDICT");
    }
}
