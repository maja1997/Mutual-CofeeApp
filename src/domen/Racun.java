/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Maja
 */
public class Racun implements IObjekat{
    private int racunID;
    private Date datumIzrade;
    private double ukupanIznos;
    private Pozicija pozicija;
    private Radnik radnik;
    private ArrayList<StavkaRacuna> listaStavki;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public Racun() {
        listaStavki = new ArrayList<>();
    }

    public Racun(int racunID, Date datumIzrade, double ukupanIznos, Pozicija pozicija, Radnik radnik, ArrayList<StavkaRacuna> listaStavki) {
        this.racunID = racunID;
        this.datumIzrade = datumIzrade;
        this.ukupanIznos = ukupanIznos;
        this.pozicija = pozicija;
        this.radnik = radnik;
        this.listaStavki = listaStavki;
    }

    public ArrayList<StavkaRacuna> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(ArrayList<StavkaRacuna> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public int getRacunID() {
        return racunID;
    }

    public void setRacunID(int racunID) {
        this.racunID = racunID;
    }

    public Date getDatumIzrade() {
        return datumIzrade;
    }

    public void setDatumIzrade(Date datumIzrade) {
        this.datumIzrade = datumIzrade;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Pozicija getPozicija() {
        return pozicija;
    }

    public void setPozicija(Pozicija pozicija) {
        this.pozicija = pozicija;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    @Override
    public String vratiNazivTabele() {
        return " racun ";
    }

    @Override
    public String joinUslov() {
        return" rac join radnik r on rac.radnikID = r.radnikID join pozicija p on rac.pozicijaID = p.pozicijaID join sektor s on p.sektorID=s.sektorID ";
    }

    @Override
    public String vratiWhereZaSelect() {
        if(datumIzrade==null)
            return "";
        //if(!sdf.format(datumIzrade).equals("")){
        
        return " WHERE rac.datumIzrade = '"+new java.sql.Date(datumIzrade.getTime())+"'";
        
        
    }

    @Override
    public String vratiSortiranje() {
        return " ORDER BY rac.datumIzrade ASC";   
    }

    @Override
    public String vratiNaziveKolona() {
        return "datumIzrade, ukupanIznos, radnikID, pozicijaID";    
    }

    @Override
    public String vratiVrednostiKolona() {
        return "'"+new java.sql.Date(datumIzrade.getTime())+"' , "+ukupanIznos+", "+radnik.getRadnikID()+", "+pozicija.getPozicijaID();
    }

    @Override
    public String vratiVrednostiUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String wherePrimarniKljuc() {
        return " racunID = "+racunID;
    }

    @Override
    public String maxKljuc() {
        return " racunID ";
    }

    @Override
    public List<IObjekat> kreirajListu(ResultSet rs) throws Exception {
         List<IObjekat> lista = new ArrayList<>();
        while (rs.next()) { 
            
            lista.add(new Racun(rs.getInt("rac.racunID"), new Date(rs.getDate("rac.datumIzrade").getTime()), rs.getDouble("rac.ukupanIznos"), new Pozicija(rs.getInt("p.pozicijaID"), rs.getString("p.nazivPozicije"), new Sektor(rs.getInt("s.sektorID"), rs.getString("s.nazivSektora"))), new Radnik(rs.getInt("r.radnikID"), rs.getString("r.ime"), rs.getString("r.prezime"), rs.getString("r.korisnickoIme"), rs.getString("r.sifra")), null));
        }
        return lista;    
    }   
}
