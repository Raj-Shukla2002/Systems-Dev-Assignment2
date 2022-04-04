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

        try {
            // Reading CSV File and getting data
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while((line =  reader.readLine()) != null){
                String[] row = line.split(",");

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
                System.out.println(record);
                System.out.println();
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
    }
}