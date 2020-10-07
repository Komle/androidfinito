package com.example.bandom;

public class Sunys {
    private String sunumaistas;
    private String pristatymas;
    private double kaina;
    private String atsiskaitymas;
    private String veisle;

    public Sunys(String kaciumaistas, String pristatymas, double kaina, String atsiskaitymas, String veisle){
        this.sunumaistas = kaciumaistas;
        this.pristatymas = pristatymas;
        this.kaina = kaina;
        this.atsiskaitymas = atsiskaitymas;
        this.veisle = veisle;
    }

    public String getSunumaistas() {
        return sunumaistas;
    }

    public void setSunumaistas(String kaciumaistas) {
        this.sunumaistas = kaciumaistas;
    }

    public String getPristatymas() {
        return pristatymas;
    }

    public void setPristatymas(String pristatymas) {
        this.pristatymas = pristatymas;
    }

    public double getKaina() {
        return kaina;
    }

    public void setKaina(double kaina) {
        this.kaina = kaina;
    }

    public String getAtsiskaitymas() {
        return atsiskaitymas;
    }

    public void setAtsiskaitymas(String atsiskaitymas) {
        this.atsiskaitymas = atsiskaitymas;
    }

    public String getVeisle() {
        return veisle;
    }

    public void setVeisle(String veisle) {
        this.veisle = veisle;
    }
}