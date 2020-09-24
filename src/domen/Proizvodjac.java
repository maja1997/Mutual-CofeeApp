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
public class Proizvodjac implements IObjekat{
    private int proizvodjacID;
    private String imeProizvodjaca;

    public Proizvodjac() {
    }

    public Proizvodjac(int proizvodjacID, String imeProizvodjaca) {
        this.proizvodjacID = proizvodjacID;
        this.imeProizvodjaca = imeProizvodjaca;
    }

    public String getImeProizvodjaca() {
        return imeProizvodjaca;
    }

    public void setImeProizvodjaca(String imeProizvodjaca) {
        this.imeProizvodjaca = imeProizvodjaca;
    }

    public int getProizvodjacID() {
        return proizvodjacID;
    }

    public void setProizvodjacID(int proizvodjacID) {
        this.proizvodjacID = proizvodjacID;
    }

    @Override
    public String vratiNazivTabele() {
        return " proizvodjac ";
    }

    @Override
    public String joinUslov() {
        return "";
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
        return "";
    }

    @Override
    public String vratiVrednostiKolona() {
        return "";
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
            lista.add(new Proizvodjac(rs.getInt("proizvodjacID"), rs.getString("imeProizvodjaca")));
        }
        return lista;    
    }

    @Override
    public String toString() {
        return imeProizvodjaca;
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
        final Proizvodjac other = (Proizvodjac) obj;
        if (this.proizvodjacID != other.proizvodjacID) {
            return false;
        }
        return true;
    }

    
    
    
    
    
}
