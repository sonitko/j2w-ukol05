package cz.czechitas.java2webapps.ukol5.controller;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.EnumSet;

public class RegistraceForm {
    @NotBlank
    private String jmeno, prijmeni;
    @NotBlank
    private String datum;
    @NotNull
    private Pohlavi pohlavi;
    private EnumSet<Sport> sport;
    @NotBlank
    private String turnus;
    @Email
    private String email;
    private String telefon;

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setPohlavi(Pohlavi pohlavi) {
        this.pohlavi = pohlavi;
    }

    public void setTurnus(String turnus) {
        this.turnus = turnus;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public String getDatum() {
        return datum;
    }

    public Pohlavi getPohlavi() {
        return pohlavi;
    }

    public void setSport(EnumSet<Sport> sport) {
        this.sport = sport;
    }

    public EnumSet<Sport> getSport() {
        return sport;
    }

    public String getTurnus() {
        return turnus;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }
}
