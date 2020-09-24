/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maja
 */
public class Pozicija implements IObjekat{
    private int pozicijaID;
    private String nazivPozicije;
    private Sektor sektor;

    public Pozicija() {
    }

    public Pozicija(int pozicijaID, String nazivPozicije, Sektor sektor) {
        this.pozicijaID = pozicijaID;
        this.nazivPozicije = nazivPozicije;
        this.sektor = sektor;
    }

    public Sektor getSektor() {
        return sektor;
    }

    public void setSektor(Sektor sektor) {
        this.sektor = sektor;
    }

    public int getPozicijaID() {
        return pozicijaID;
    }

    public void setPozicijaID(int pozicijaID) {
        this.pozicijaID = pozicijaID;
    }

    public String getNazivPozicije() {
        return nazivPozicije;
    }

    public void setNazivPozicije(String nazivPozicije) {
        this.nazivPozicije = nazivPozicije;
    }

    @Override
    public String vratiNazivTabele() {
        return " pozicija ";
    }

    
    @Override
    public String joinUslov() {
        return " p join sektor s on p.sektorID = s.sektorID ";
    }

    @Override
    public String vratiWhereZaSelect() {
        return "";
    }

    @Override
    public String vratiSortiranje() {
        return "";
    }

    @Override
    public String vratiNaziveKolona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiKolona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String wherePrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String maxKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IObjekat> kreirajListu(ResultSet rs) throws Exception {
        List<IObjekat> lista = new ArrayList<>();
        while (rs.next()) {            
            Sektor s = new Sektor(rs.getInt("s.sektorID"), rs.getString("s.nazivSektora"));
            lista.add(new Pozicija(rs.getInt("p.pozicijaID"), rs.getString("p.nazivPozicije"), s));
        }
        return lista;    
    }

    @Override
    public String toString() {
        return nazivPozicije+" "+sektor.getNazivSektora();
    }
    
    
    
    
}
