package com.example.csci2020w22assignment2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        //insert your path to csv file from your machine before running
        String file = "C:\\Users\\hidde\\OneDrive\\Desktop\\Systems-Dev-Assignment2\\csci2020-w22-assignment2\\src\\main\\resources\\com\\example\\csci2020w22assignment2\\airline_safety.csv";
        BufferedReader reader = null;
        String line = "";
        List<flightRecord> records = new ArrayList<>();

        //Part 1
        try {
            // Reading CSV File and getting data
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while((line =  reader.readLine()) != null){
                String[] row = line.split(",");

                //Storing the data
                String al = row[0];
                double a = Double.parseDouble(row[1]);
                int i_85_99 = Integer.parseInt(row[2]);
                int fa_85_99 = Integer.parseInt(row[3]);
                int f_85_99 = Integer.parseInt(row[4]);
                int i_00_14 = Integer.parseInt(row[5]);
                int fa_00_14 = Integer.parseInt(row[6]);
                int f_00_14 = Integer.parseInt(row[7]);
                int total = i_85_99 + i_00_14;

                flightRecord record
                        = new flightRecord(al, a, i_85_99, fa_85_99, f_85_99, i_00_14, fa_00_14, f_00_14, total);

                records.add(record);

                //FOR TESTING; delete before submission
//                System.out.println(record);
//                System.out.println();
//                for (String index : row){
//                    System.out.printf("%-10s", index);
//                }
//                System.out.println();

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
           try {
               assert reader != null;
               reader.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
        }

        //Part 2 (commented out code are so u can see tha values)
        List<Double> avails = new ArrayList<Double>();

        List<Integer> incidents8599 = new ArrayList<Integer>();
        List<Integer> f_accidents8599 = new ArrayList<Integer>();
        List<Integer> fatalities8599 = new ArrayList<Integer>();

        List<Integer> incidents0014 = new ArrayList<Integer>();
        List<Integer> f_accidents0014 = new ArrayList<Integer>();
        List<Integer> fatalities0014 = new ArrayList<Integer>();

        List<Integer> total8514 = new ArrayList<Integer>();

        for (flightRecord record:records) {
            avails.add(record.getAvail());
            incidents8599.add(record.getIncidents_85_99());
            f_accidents8599.add(record.getFatal_accidents_85_99());
            fatalities8599.add(record.getFatalities_85_99());

            incidents0014.add(record.getIncidents_00_14());
            f_accidents0014.add(record.getFatal_accidents_00_14());
            fatalities0014.add(record.getFatalities_00_14());

            total8514.add(record.getTotal_incidents_85_14());
            //System.out.println(record.getTotal_incidents_85_14());

        }

        Statistics col1 = new Statistics(avails, "double");
        //System.out.println("Avails = " + col1);

        Statistics col2 = new Statistics(incidents8599);
        //System.out.println("Incidents 85-99 = " + col2);
        Statistics col3 = new Statistics(f_accidents8599);
        //System.out.println("Fatal accidents 85-99 = " + col3);
        Statistics col4 = new Statistics(fatalities8599);
        //System.out.println("Fatalities 85-99 = " + col4);

        Statistics col5 = new Statistics(incidents0014);
        //System.out.println("Incidents 00-14 = " + col5);
        Statistics col6 = new Statistics(f_accidents0014);
        //System.out.println("Fatal accidents 00-14 = " + col6);
        Statistics col7 = new Statistics(fatalities0014);
        //System.out.println("Fatalities 00-14 = " + col7);

        Statistics totals = new Statistics(total8514);
        //System.out.println("Total incidents 85-14 = " + totals);


    }
}