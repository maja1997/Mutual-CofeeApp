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
public class Sektor implements IObjekat{
    
    private int sektorID;
    private String nazivSektora;

    public Sektor() {
    }

    public Sektor(int sektorID, String nazivSektora) {
        this.sektorID = sektorID;
        this.nazivSektora = nazivSektora;
    }
    
    public int getSektorID() {
        return sektorID;
    }

    public void setSektorID(int sektorID) {
        this.sektorID = sektorID;
    }

    public String getNazivSektora() {
        return nazivSektora;
    }

    public void setNazivSektora(String nazivSektora) {
        this.nazivSektora = nazivSektora;
    }    

    @Override
    public String vratiNazivTabele() {
        return " sektor ";
    }

    @Override
    public String joinUslov() {
        return "";
    }

    @Override
    public String vratiWhereZaSelect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSortiranje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            lista.add(new Sektor(rs.getInt("sektorID"), rs.getString("nazivSektora")));
        }
        return lista;    
    }



    @Override
    public String toString() {
        return nazivSektora;
    }
    
    
    
}
