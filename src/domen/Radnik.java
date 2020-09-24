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
public class Radnik implements IObjekat{
    private int radnikID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String sifra;

    public Radnik() {
    }

    public Radnik(int radnikID, String ime, String prezime, String korisnickoIme, String sifra) {
        this.radnikID = radnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public int getRadnikID() {
        return radnikID;
    }

    public void setRadnikID(int radnikID) {
        this.radnikID = radnikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    @Override
    public String vratiNazivTabele() {
        return " radnik ";
    }

    @Override
    public String joinUslov() {
        return "";
    }

    @Override
    public String vratiWhereZaSelect() {
        return " WHERE korisnickoIme='"+korisnickoIme+"' AND sifra='"+sifra+"' LIMIT 1";
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
            lista.add(new Radnik(rs.getInt("radnikID"), rs.getString("ime"), rs.getString("prezime"), rs.getString("korisnickoIme"), rs.getString("sifra")));
        }
        return lista;
    }
    
    
}
