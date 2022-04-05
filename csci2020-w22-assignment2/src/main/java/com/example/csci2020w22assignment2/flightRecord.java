package com.example.csci2020w22assignment2;

public class flightRecord {
    String airline;
    double avail;
    int incidents_85_99;
    int fatal_accidents_85_99;
    int fatalities_85_99;
    int incidents_00_14;
    int fatal_accidents_00_14;
    int fatalities_00_14;
    int total_incidents_85_14;

    public flightRecord(String al, double a, int i_85_99, int fa_85_99, int f_85_99, int i_00_14, int fa_00_14, int f_00_14, int total) {
        this.airline = al;
        this.avail = a;
        this.incidents_85_99 = i_85_99;
        this.fatal_accidents_85_99 = fa_85_99;
        this.fatalities_85_99 = f_85_99;
        this.incidents_00_14 = i_00_14;
        this.fatal_accidents_00_14 = fa_00_14;
        this.fatalities_00_14 = f_00_14;
        this.total_incidents_85_14 = total;
    }

    public String getAirline() {
        return airline;
    }

    public double getAvail() {
        return avail;
    }

    public int getIncidents_85_99() {
        return incidents_85_99;
    }

    public int getFatal_accidents_85_99() {
        return fatal_accidents_85_99;
    }

    public int getFatalities_85_99() {
        return fatalities_85_99;
    }

    public int getIncidents_00_14() {
        return incidents_00_14;
    }

    public int getFatal_accidents_00_14() {
        return fatal_accidents_00_14;
    }

    public int getFatalities_00_14() {
        return fatalities_00_14;
    }

    public int getTotal_incidents_85_14() {
        return total_incidents_85_14;
    }

    @Override
    public String toString() {
        return "flightRecord{" +
                "airline='" + airline + '\'' +
                ", avail=" + avail +
                ", incidents_85_99=" + incidents_85_99 +
                ", fatal_accidents_85_99=" + fatal_accidents_85_99 +
                ", fatalities_85_99=" + fatalities_85_99 +
                ", incidents_00_14=" + incidents_00_14 +
                ", fatal_accidents_00_14=" + fatal_accidents_00_14 +
                ", fatalities_00_14=" + fatalities_00_14 +
                ", total_incidents_85_14=" + total_incidents_85_14 +
                '}';
    }
}
