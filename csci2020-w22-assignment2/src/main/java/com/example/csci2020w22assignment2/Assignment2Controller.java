package com.example.csci2020w22assignment2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


import java.io.*;
import java.net.URL;
import java.util.*;

public class Assignment2Controller implements Initializable {
    @FXML
    private BarChart barChart;

    public double[] available_seats_stats = new double[3];
    public int[] incidents_90s_stats = new int[3];
    public int[] fatal_accidents_90s_stats = new int[3];
    public int[] fatalities_90s_stats = new int[3];
    public int[] incidents_00s_stats = new int[3];
    public int[] fatal_accidents_00s_stats = new int[3];
    public int[] fatalities_00s_stats = new int[3];
    public int[] total_incidents_stats = new int[3];

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String line = "";
        List<flightRecord> flights = new ArrayList<>();
        //reading csv file
        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\com\\example\\csci2020w22assignment2\\airline_safety.csv"));
            int counter = 0;
            while((line = br.readLine()) != null) {
                String[] value = line.split(",");
                if(counter == 0){
                    counter += 1;
                }
                else {
                    flights.add(new flightRecord(value[0], Double.valueOf(value[1]), Integer.valueOf(value[2]), Integer.valueOf(value[3]), Integer.valueOf(value[4])
                            , Integer.valueOf(value[5]), Integer.valueOf(value[6]), Integer.valueOf(value[7]), (Integer.valueOf(value[2]) + Integer.valueOf(value[5]))));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        Part1(flights);
        Part2(flights);
        //Part 3:
        XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
        series1.setName("Fatal_accidents_85_99");
        for(int i=0; i<flights.size(); i++){
            series1.getData().add(new XYChart.Data(flights.get(i).getAirline(), flights.get(i).getFatal_accidents_85_99()));
        }

        XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
        series2.setName("Fatal_accidents_00_14");
        for(int i=0; i<flights.size(); i++){
            series2.getData().add(new XYChart.Data(flights.get(i).getAirline(), flights.get(i).getFatal_accidents_00_14()));
        }
        barChart.getData().addAll(series1, series2);

    }

    public void Part1(List<flightRecord> flights){
        //writing xml file
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("flights");
            document.appendChild(root);


            for(int i=0; i<flights.size(); i++) {
                Element airline = document.createElement("airline");
                root.appendChild(airline);

                Attr attr = document.createAttribute("name");
                attr.setValue(flights.get(i).getAirline());
                airline.setAttributeNode(attr);

                Element avail = document.createElement("avail_seat_km_per_week");
                avail.appendChild(document.createTextNode(Double.toString(flights.get(i).getAvail())));
                airline.appendChild(avail);

                Element inci90s = document.createElement("incidents_85_99");
                inci90s.appendChild(document.createTextNode(Double.toString(flights.get(i).getIncidents_85_99())));
                airline.appendChild(inci90s);

                Element fatalinci90s = document.createElement("fatal_accidents_85_99");
                fatalinci90s.appendChild(document.createTextNode(Double.toString(flights.get(i).getFatal_accidents_85_99())));
                airline.appendChild(fatalinci90s);

                Element fatal90s = document.createElement("fatalities_85_99");
                fatal90s.appendChild(document.createTextNode(Double.toString(flights.get(i).getFatalities_85_99())));
                airline.appendChild(fatal90s);

                Element inci00s = document.createElement("incidents_00_14");
                inci00s.appendChild(document.createTextNode(Double.toString(flights.get(i).getIncidents_00_14())));
                airline.appendChild(inci00s);

                Element fatalinci00s = document.createElement("fatal_accidents_00_14");
                fatalinci00s.appendChild(document.createTextNode(Double.toString(flights.get(i).getFatal_accidents_00_14())));
                airline.appendChild(fatalinci00s);

                Element fatal00s = document.createElement("fatalities_00_14");
                fatal00s.appendChild(document.createTextNode(Double.toString(flights.get(i).getFatalities_00_14())));
                airline.appendChild(fatal00s);

                Element totalinci = document.createElement("total_incidents");
                totalinci.appendChild(document.createTextNode(Double.toString(flights.get(i).getTotal_incidents_85_14())));
                airline.appendChild(totalinci);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("src\\main\\resources\\com\\example\\csci2020w22assignment2\\converted_airline_safety.xml"));
            System.out.println(streamResult.getOutputStream());

            transformer.transform(domSource, streamResult);
            System.out.println("Made XML File: coverted_airline_safety.xml");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void Part2(List<flightRecord> flights){
        flightCalculations temp = new flightCalculations();
        available_seats_stats[0] = temp.seats_min(flights);
        available_seats_stats[1] = temp.seats_max(flights);
        available_seats_stats[2] = temp.seats_avg(flights);

        incidents_90s_stats[0] = temp.incident90s_min(flights);
        incidents_90s_stats[1] = temp.incident90s_max(flights);
        incidents_90s_stats[2] = temp.incident90s_avg(flights);

        fatal_accidents_90s_stats[0] = temp.fatal_incident90s_min(flights);
        fatal_accidents_90s_stats[1] = temp.fatal_incident90s_max(flights);
        fatal_accidents_90s_stats[2] = temp.fatal_incident90s_avg(flights);

        fatalities_90s_stats[0] = temp.fatalities_90s_min(flights);
        fatalities_90s_stats[1] = temp.fatalities_90s_max(flights);
        fatalities_90s_stats[2] = temp.fatalities_90s_avg(flights);

        incidents_00s_stats[0] = temp.incident00s_min(flights);
        incidents_00s_stats[1] = temp.incident00s_max(flights);
        incidents_00s_stats[2] = temp.incident00s_avg(flights);

        fatal_accidents_00s_stats[0] = temp.fatal_incident00s_min(flights);
        fatal_accidents_00s_stats[1] = temp.fatal_incident00s_max(flights);
        fatal_accidents_00s_stats[2] = temp.fatal_incident00s_avg(flights);

        fatalities_00s_stats[0] = temp.fatalities_00s_min(flights);
        fatalities_00s_stats[1] = temp.fatalities_00s_max(flights);
        fatalities_00s_stats[2] = temp.fatalities_00s_avg(flights);

        total_incidents_stats[0] = temp.total_inci_min(flights);
        total_incidents_stats[1] = temp.total_inci_max(flights);
        total_incidents_stats[2] = temp.total_inci_avg(flights);

        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("Summary");
            document.appendChild(root);


            Element airline = document.createElement("Stat");
            root.appendChild(airline);


            Element avail = document.createElement("Name");
            avail.appendChild(document.createTextNode("avail_seat_km_per_week"));
            airline.appendChild(avail);

            Element min = document.createElement("Min");
            min.appendChild(document.createTextNode(Double.toString(available_seats_stats[0])));
            airline.appendChild(min);

            Element max = document.createElement("Max");
            max.appendChild(document.createTextNode(Double.toString(available_seats_stats[1])));
            airline.appendChild(max);


            Element avg = document.createElement("Avg");
            avg.appendChild(document.createTextNode(Double.toString(available_seats_stats[2])));
            airline.appendChild(avg);


            Element airline2 = document.createElement("Stat");
            root.appendChild(airline2);

            Element avail2 = document.createElement("Name");
            avail2.appendChild(document.createTextNode("incidents_85_99"));
            airline2.appendChild(avail2);

            Element min2 = document.createElement("Min");
            min2.appendChild(document.createTextNode(Double.toString(incidents_90s_stats[0])));
            airline2.appendChild(min2);

            Element max2 = document.createElement("Max");
            max2.appendChild(document.createTextNode(Double.toString(incidents_90s_stats[1])));
            airline2.appendChild(max2);


            Element avg2 = document.createElement("Avg");
            avg2.appendChild(document.createTextNode(Double.toString(incidents_90s_stats[2])));
            airline2.appendChild(avg2);


            Element airline3 = document.createElement("Stat");
            root.appendChild(airline3);

            Element avail3 = document.createElement("Name");
            avail3.appendChild(document.createTextNode("fatal_accidents_85_99"));
            airline3.appendChild(avail3);

            Element min3 = document.createElement("Min");
            min3.appendChild(document.createTextNode(Double.toString(fatal_accidents_90s_stats[0])));
            airline3.appendChild(min3);

            Element max3 = document.createElement("Max");
            max3.appendChild(document.createTextNode(Double.toString(fatal_accidents_90s_stats[1])));
            airline3.appendChild(max3);

            Element avg3 = document.createElement("Avg");
            avg3.appendChild(document.createTextNode(Double.toString(fatal_accidents_90s_stats[2])));
            airline3.appendChild(avg3);


            Element airline4 = document.createElement("Stat");
            root.appendChild(airline4);

            Element avail4 = document.createElement("Name");
            avail4.appendChild(document.createTextNode("fatalities_85_99"));
            airline4.appendChild(avail4);

            Element min4 = document.createElement("Min");
            min4.appendChild(document.createTextNode(Double.toString(fatalities_90s_stats[0])));
            airline4.appendChild(min4);

            Element max4 = document.createElement("Max");
            max4.appendChild(document.createTextNode(Double.toString(fatalities_90s_stats[1])));
            airline4.appendChild(max4);

            Element avg4 = document.createElement("Avg");
            avg4.appendChild(document.createTextNode(Double.toString(fatalities_90s_stats[2])));
            airline4.appendChild(avg4);


            Element airline5 = document.createElement("Stat");
            root.appendChild(airline5);

            Element avail5 = document.createElement("Name");
            avail5.appendChild(document.createTextNode("incidents_00_14"));
            airline5.appendChild(avail5);

            Element min5 = document.createElement("Min");
            min5.appendChild(document.createTextNode(Double.toString(incidents_00s_stats[0])));
            airline5.appendChild(min5);

            Element max5 = document.createElement("Max");
            max5.appendChild(document.createTextNode(Double.toString(incidents_00s_stats[1])));
            airline5.appendChild(max5);

            Element avg5 = document.createElement("Avg");
            avg5.appendChild(document.createTextNode(Double.toString(incidents_00s_stats[2])));
            airline5.appendChild(avg5);


            Element airline6 = document.createElement("Stat");
            root.appendChild(airline6);

            Element avail6 = document.createElement("Name");
            avail6.appendChild(document.createTextNode("fatal_accidents_00_14"));
            airline6.appendChild(avail6);

            Element min6 = document.createElement("Min");
            min6.appendChild(document.createTextNode(Double.toString(fatal_accidents_00s_stats[0])));
            airline6.appendChild(min6);

            Element max6 = document.createElement("Max");
            max6.appendChild(document.createTextNode(Double.toString(fatal_accidents_00s_stats[1])));
            airline6.appendChild(max6);

            Element avg6 = document.createElement("Avg");
            avg6.appendChild(document.createTextNode(Double.toString(fatal_accidents_00s_stats[2])));
            airline6.appendChild(avg6);


            Element airline7 = document.createElement("Stat");
            root.appendChild(airline7);

            Element avail7 = document.createElement("Name");
            avail7.appendChild(document.createTextNode("fatalities_00_14"));
            airline7.appendChild(avail7);

            Element min7 = document.createElement("Min");
            min7.appendChild(document.createTextNode(Double.toString(fatalities_00s_stats[0])));
            airline7.appendChild(min7);

            Element max7 = document.createElement("Max");
            max7.appendChild(document.createTextNode(Double.toString(fatalities_00s_stats[1])));
            airline7.appendChild(max7);

            Element avg7 = document.createElement("Avg");
            avg7.appendChild(document.createTextNode(Double.toString(fatalities_00s_stats[2])));
            airline7.appendChild(avg7);


            Element airline8 = document.createElement("Stat");
            root.appendChild(airline8);

            Element avail8 = document.createElement("Name");
            avail8.appendChild(document.createTextNode("total_incidents"));
            airline8.appendChild(avail8);

            Element min8 = document.createElement("Min");
            min8.appendChild(document.createTextNode(Double.toString(total_incidents_stats[0])));
            airline8.appendChild(min8);

            Element max8 = document.createElement("Max");
            max8.appendChild(document.createTextNode(Double.toString(total_incidents_stats[1])));
            airline8.appendChild(max8);

            Element avg8 = document.createElement("Avg");
            avg8.appendChild(document.createTextNode(Double.toString(total_incidents_stats[2])));
            airline8.appendChild(avg8);



            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("src\\main\\resources\\com\\example\\csci2020w22assignment2\\airline_summary_statistic.xml"));

            transformer.transform(domSource, streamResult);
            System.out.println("Made XML File: airline_summary_statistic.xml");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}