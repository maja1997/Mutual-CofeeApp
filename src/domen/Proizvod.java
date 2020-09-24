/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Maja
 */
public class Proizvod implements IObjekat{
    private int proizvodID;
    private String nazivProizvoda;
    private double cena;
    private String opis;
    private Proizvodjac proizvodjac;

    public Proizvod() {
    }

    public Proizvod(int proizvodID, String nazivProizvoda, double cena, String opis, Proizvodjac proizvodjac) {
        this.proizvodID = proizvodID;
        this.nazivProizvoda = nazivProizvoda;
        this.cena = cena;
        this.opis = opis;
        this.proizvodjac = proizvodjac;
    }

    public void setProizvodjac(Proizvodjac proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public Proizvodjac getProizvodjac() {
        return proizvodjac;
    }

 

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getProizvodID() {
        return proizvodID;
    }

    public void setProizvodID(int proizvodID) {
        this.proizvodID = proizvodID;
    }

    public String getNazivProizvoda() {
        return nazivProizvoda;
    }

    public void setNazivProizvoda(String nazivProizvoda) {
        this.nazivProizvoda = nazivProizvoda;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return nazivProizvoda + ", "+proizvodjac.getImeProizvodjaca();
    }

    @Override
    public String vratiNazivTabele() {
        return " proizvod ";
    }

    @Override
    public String joinUslov() {
        return " p join proizvodjac pr on p.proizvodjacID = pr.proizvodjacID ";
    }

    @Override
    public String vratiWhereZaSelect() {
        if(!nazivProizvoda.equals("")){
            return " WHERE p.nazivProizvoda LIKE '%"+nazivProizvoda+"%'";
        }
        return "";
    }

    @Override
    public String vratiSortiranje() {
        return " ORDER BY p.cena ASC";
    }

    @Override
    public String vratiNaziveKolona() {
        return "nazivProizvoda, cena, opis, proizvodjacID";
    }

    @Override
    public String vratiVrednostiKolona() {
        return "'"+nazivProizvoda+"',"+cena+", '"+opis+"', "+proizvodjac.getProizvodjacID();
    }

    @Override
    public String vratiVrednostiUpdate() {
        return " nazivProizvoda = '"+nazivProizvoda+"', cena = "+cena+", opis = '"+opis+"', proizvodjacID = "+ proizvodjac.getProizvodjacID();
    }

    @Override
    public String wherePrimarniKljuc() {
        return " proizvodID =" + proizvodID;
    }

    @Override
    public String maxKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IObjekat> kreirajListu(ResultSet rs) throws Exception {
         List<IObjekat> lista = new ArrayList<>();
        while (rs.next()) {            
            lista.add(new Proizvod(rs.getInt("proizvodID"), rs.getString("nazivProizvoda"), rs.getDouble("cena"), rs.getString("opis"), new Proizvodjac(rs.getInt("proizvodjacID"), rs.getString("imeProizvodjaca"))));
        }
        return lista;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proizvod other = (Proizvod) obj;
        if (Double.doubleToLongBits(this.cena) != Double.doubleToLongBits(other.cena)) {
            return false;
        }
        if (!Objects.equals(this.nazivProizvoda, other.nazivProizvoda)) {
            return false;
        }
        if (!Objects.equals(this.opis, other.opis)) {
            return false;
        }
        if (!Objects.equals(this.proizvodjac, other.proizvodjac)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
