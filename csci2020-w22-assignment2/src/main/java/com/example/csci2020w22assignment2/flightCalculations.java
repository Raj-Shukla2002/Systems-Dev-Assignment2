package com.example.csci2020w22assignment2;

import java.util.List;

public class flightCalculations {
    public double seats_min(List<flightRecord> flights){
        double val = flights.get(0).getAvail();
        for(int i=0; i<flights.size(); i++){
            if(flights.get(i).getAvail() < val){
                val = flights.get(i).getAvail();
            }
        }
        return val;
    }
    public double seats_max(List<flightRecord> flights){
        double val = flights.get(0).getAvail();
        for(int i=0; i<flights.size(); i++){
            if(flights.get(i).getAvail() > val){
                val = flights.get(i).getAvail();
            }
        }
        return val;
    }
    public double seats_avg(List<flightRecord> flights){
        double val = 0;
        for(int i=0; i<flights.size(); i++){
            val += flights.get(i).getAvail();
        }
        val = val/flights.size();
        return val;
    }

    public int incident90s_min(List<flightRecord> flights){
        int val = flights.get(0).getIncidents_85_99();
        for(int i=0; i<flights.size(); i++){
            if(flights.get(i).getIncidents_85_99() < val){
                val = flights.get(i).getIncidents_85_99();
            }
        }
        return val;
    }
    public int incident90s_max(List<flightRecord> flights){
        int val = flights.get(0).getIncidents_85_99();
        for(int i=0; i<flights.size(); i++){
            if(flights.get(i).getIncidents_85_99() > val){
                val = flights.get(i).getIncidents_85_99();
            }
        }
        return val;
    }
    public int incident90s_avg(List<flightRecord> flights){
        int val = 0;
        for(int i=0; i<flights.size(); i++){
            val += flights.get(i).getIncidents_85_99();
        }
        val = val/flights.size();
        return val;
    }
    public int fatal_incident90s_min(List<flightRecord> flights){
        int val = flights.get(0).getFatal_accidents_85_99();
        for(int i=0; i<flights.size(); i++){
            if(flights.get(i).getFatal_accidents_85_99() < val){
                val = flights.get(i).getFatal_accidents_85_99();
            }
        }
        return val;
    }
    public int fatal_incident90s_max(List<flightRecord> flights){
        int val = flights.get(0).getFatal_accidents_85_99();
        for(int i=0; i<flights.size(); i++){
            if(flights.get(i).getFatal_accidents_85_99() > val){
                val = flights.get(i).getFatal_accidents_85_99();
            }
        }
        return val;
    }
    public int fatal_incident90s_avg(List<flightRecord> flights){
        int val = 0;
        for(int i=0; i<flights.size(); i++){
            val += flights.get(i).getFatal_accidents_85_99();
        }
        val = val/flights.size();
        return val;
    }
    public int fatalities_90s_min(List<flightRecord> flights){
        int val = flights.get(0).getFatalities_85_99();
        for(int i=0; i<flights.size(); i++){
            if(flights.get(i).getFatalities_85_99() < val){
                val = flights.get(i).getFatalities_85_99();
            }
        }
        return val;
    }
    public int fatalities_90s_max(List<flightRecord> flights){
        int val = flights.get(0).getFatalities_85_99();
        for(int i=0; i<flights.size(); i++){
            if(flights.get(i).getFatalities_85_99() > val){
                val = flights.get(i).getFatalities_85_99();
            }
        }
        return val;
    }
    public int fatalities_90s_avg(List<flightRecord> flights){
        int val = 0;
        for(int i=0; i<flights.size(); i++){
            val += flights.get(i).getFatalities_85_99();
        }
        val = val/flights.size();
        return val;
    }

    //buh
    public int incident00s_min(List<flightRecord> flights){
        int val = flights.get(0).getIncidents_00_14();
        for(int i=0; i<flights.size(); i++){
            if(flights.get(i).getIncidents_00_14() < val){
                val = flights.get(i).getIncidents_00_14();
            }
        }
        return val;
    }
    public int incident00s_max(List<flightRecord> flights){
        int val = flights.get(0).getIncidents_00_14();
        for(int i=0; i<flights.size(); i++){
            if(flights.get(i).getIncidents_00_14() > val){
                val = flights.get(i).getIncidents_00_14();
            }
        }
        return val;
    }
    public int incident00s_avg(List<flightRecord> flights){
        int val = 0;
        for(int i=0; i<flights.size(); i++){
            val += flights.get(i).getIncidents_00_14();
        }
        val = val/flights.size();
        return val;
    }
    public int fatal_incident00s_min(List<flightRecord> flights){
        int val = flights.get(0).getFatal_accidents_00_14();
        for(int i=0; i<flights.size(); i++){
            if(flights.get(i).getFatal_accidents_00_14() < val){
                val = flights.get(i).getFatal_accidents_00_14();
            }
        }
        return val;
    }
    public int fatal_incident00s_max(List<flightRecord> flights){
        int val = flights.get(0).getFatal_accidents_00_14();
        for(int i=0; i<flights.size(); i++){
            if(flights.get(i).getFatal_accidents_00_14() > val){
                val = flights.get(i).getFatal_accidents_00_14();
            }
        }
        return val;
    }
    public int fatal_incident00s_avg(List<flightRecord> flights){
        int val = 0;
        for(int i=0; i<flights.size(); i++){
            val += flights.get(i).getFatal_accidents_00_14();
        }
        val = val/flights.size();
        return val;
    }
    public int fatalities_00s_min(List<flightRecord> flights){
        int val = flights.get(0).getFatalities_00_14();
        for(int i=0; i<flights.size(); i++){
            if(flights.get(i).getFatalities_00_14() < val){
                val = flights.get(i).getFatalities_00_14();
            }
        }
        return val;
    }
    public int fatalities_00s_max(List<flightRecord> flights){
        int val = flights.get(0).getFatalities_00_14();
        for(int i=0; i<flights.size(); i++){
            if(flights.get(i).getFatalities_00_14() > val){
                val = flights.get(i).getFatalities_00_14();
            }
        }
        return val;
    }
    public int fatalities_00s_avg(List<flightRecord> flights){
        int val = 0;
        for(int i=0; i<flights.size(); i++){
            val += flights.get(i).getFatalities_00_14();
        }
        val = val/flights.size();
        return val;
    }

    public int total_inci_min(List<flightRecord> flights){
        int val = flights.get(0).getTotal_incidents_85_14();
        for(int i=0; i<flights.size(); i++){
            if(flights.get(i).getTotal_incidents_85_14() < val){
                val = flights.get(i).getTotal_incidents_85_14();
            }
        }
        return val;
    }
    public int total_inci_max(List<flightRecord> flights){
        int val = flights.get(0).getTotal_incidents_85_14();
        for(int i=0; i<flights.size(); i++){
            if(flights.get(i).getTotal_incidents_85_14() > val){
                val = flights.get(i).getTotal_incidents_85_14();
            }
        }
        return val;
    }
    public int total_inci_avg(List<flightRecord> flights){
        int val = 0;
        for(int i=0; i<flights.size(); i++){
            val += flights.get(i).getTotal_incidents_85_14();
        }
        val = val/flights.size();
        return val;
    }

}
