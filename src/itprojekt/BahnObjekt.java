/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itprojekt;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martin
 */
public class BahnObjekt {
    public int ID;
    public String Linie;
    public int Richtung;
    public String Datum;
    public int Auslastung;
    public int cAuslastung;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setRichtung(int Richtung) {
        this.Richtung = Richtung;
    }

    public void setDatum(String Datum) {
        this.Datum = Datum;
    }

    public void setAuslastung(int Auslastung) {
        this.Auslastung = Auslastung;
    }

    public void setcAuslastung(int cAuslastung) {
        this.cAuslastung = cAuslastung;
    }
	
	public BahnObjekt(int ID, String Linie,int Richtung, String Datum, int Auslastung, int cAuslastung) {
            this.ID =ID;
            this.Linie = Linie;
            this.Richtung = Richtung;
            this.Datum =Datum;
            this.Auslastung = Auslastung;
            this.cAuslastung = cAuslastung;
	}
        
        public BahnObjekt(int ID){
            this.ID = ID;
        }

	public String getDatum() {
		return Datum;
	}
        
        public int getAuslastungBerechnet() {
            double a = (double) cAuslastung; 
            double b = (double) Auslastung; 
            double berechnet = (a/b)*100;
            return (int)berechnet;
	}
        
        public double getUhrzeit() throws ParseException{
            SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss");
            Date answeredTime = ft.parse(Datum);
            double h = answeredTime.getHours();
            double m = answeredTime.getMinutes();

            double real =  h+(m/100);
            return real;
        } 
}
