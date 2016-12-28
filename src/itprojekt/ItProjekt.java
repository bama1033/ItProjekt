/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itprojekt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//TODO:
//Exceltabelle Bahn/Bike anbinden
//Datenmodell Bike überlegen mit jul
//Auslesung &Umwandlung der Daten in gegebenes Format mit JUl
//Daten in list schmeißen um einfach im Graph überzugeben
//Hin & Rückfahrt beachten(20 Minuten) korridor

/**
 *
 * @author Martin
 */
public class ItProjekt extends Application {
    
        BahnObjekt d1 = new BahnObjekt(1,"U6",1,"00:35:00",519,100);
        BahnObjekt d2 = new BahnObjekt(2,"U6",2,"01:40:00",519,80);
        BahnObjekt d3 = new BahnObjekt(3,"U6",1,"08:40:00",519,50);
        BahnObjekt d4 = new BahnObjekt(4,"U6",2,"10:40:00",519,200);
        BahnObjekt d5 = new BahnObjekt(5,"U6",1,"12:40:00",519,400);
        BahnObjekt d6 = new BahnObjekt(6,"U6",1,"16:40:00",519,10);
        BahnObjekt d7 = new BahnObjekt(7,"U6",2,"18:40:00",519,90);
        BahnObjekt d8 = new BahnObjekt(8,"U6",1,"22:40:00",519,100);
        ArrayList<BahnObjekt> list = new ArrayList<>();
        
        public void init(Stage primaryStage) throws FileNotFoundException, IOException, ParseException {
        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);

        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root));
        NumberAxis xAxis = new NumberAxis("Uhrzeit", 0.0, 24.0, 3);
        NumberAxis yAxis = new NumberAxis("Auslastung", 0, 100, 10);
        ObservableList<XYChart.Series<Double,Integer>> lineChartData = FXCollections.observableArrayList(
            new LineChart.Series<>("Ubahn", FXCollections.observableArrayList(
            new XYChart.Data<>(d1.getUhrzeit(), d1.getAuslastungBerechnet()),
            new XYChart.Data<>(d2.getUhrzeit(), d2.getAuslastungBerechnet()),
            new XYChart.Data<>(d3.getUhrzeit(), d3.getAuslastungBerechnet()),
            new XYChart.Data<>(d4.getUhrzeit(), d4.getAuslastungBerechnet()),
            new XYChart.Data<>(d5.getUhrzeit(), d5.getAuslastungBerechnet()),
            new XYChart.Data<>(d6.getUhrzeit(), d6.getAuslastungBerechnet()),
            new XYChart.Data<>(d7.getUhrzeit(), d7.getAuslastungBerechnet()),
            new XYChart.Data<>(d8.getUhrzeit(), d8.getAuslastungBerechnet())
            ))
        );
        LineChart chart = new LineChart(xAxis, yAxis, lineChartData);
        /*
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
           
            @Override
            public void handle(ActionEvent event) {      
            }
         });
*/
        root.getChildren().add(chart);
        }
        
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException {
                        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Martin\\Desktop\\IT projekt\\ubahn.xlsx");
                        //"C:/Users/Martin/Desktop/projekt/ubahn.xlsx""
                        //"C:\Users\Martin\Desktop\IT projekt\\ubahn.xlsx"
                        //Workbook ist das Sysnonym für Exceldatei
                        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream); 
                        //sheet ist die Excel-Seite, alternativ getsheet("zoo") statt int parameter
			XSSFSheet worksheet1 = workbook.getSheetAt(0);
			XSSFRow row1 = worksheet1.getRow(0);
                        //verkürzt System.out.println(XSSFCell cellA1 = row1.getCell(0).getStringCellValue()); loook video
			XSSFCell cellA1 = row1.getCell(0);
			String a1Val = cellA1.getStringCellValue();
			XSSFCell cellB1 = row1.getCell( 1);
			String b1Val = cellB1.getStringCellValue();
			System.out.println("A1: " + a1Val);
			System.out.println("B1: " + b1Val);
            try {
                init(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(ItProjekt.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ItProjekt.class.getName()).log(Level.SEVERE, null, ex);
            }
        primaryStage.show();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException  {

        launch(args);
    } 
}
