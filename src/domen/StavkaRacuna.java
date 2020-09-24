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
public class StavkaRacuna implements IObjekat{
    private int rb;
    private int kolicina;
    private double iznos;
    private Proizvod proizvod;
    private Racun racun;

    public StavkaRacuna() {
    }

    public StavkaRacuna(int rb, int kolicina, double iznos, Proizvod proizvod, Racun racun) {
        this.rb = rb;
        this.kolicina = kolicina;
        this.iznos = iznos;
        this.proizvod = proizvod;
        this.racun = racun;
    }


    
    

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }
    
    

    public double getIznos() {
        return iznos;
    }

  

    public void setIznos(int iznos) {
        this.iznos = iznos;
    }
    
    

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }



    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public String vratiNazivTabele() {
        return " stavkaracuna ";
    }

    @Override
    public String joinUslov() {
        return " sr join proizvod p on sr.proizvodID = p.proizvodID join racun r on sr.racunID=r.racunID join proizvodjac pro on p.proizvodjacID = pro.proizvodjacID ";
    }

    @Override
    public String vratiWhereZaSelect() {
        return "WHERE sr.racunID= "+racun.getRacunID();
    }

    @Override
    public String vratiSortiranje() {
        return "";
    }

    @Override
    public String vratiNaziveKolona() {
        return " rb, racunID, kolicina, proizvodID, iznos";
    }

    @Override
    public String vratiVrednostiKolona() {
        return rb+ "," + racun.getRacunID() + ", "+ kolicina+", "+proizvod.getProizvodID()+", "+ iznos;
    }

    @Override
    public String vratiVrednostiUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String wherePrimarniKljuc() {
        return " racunID = "+ racun.getRacunID();
    }

    @Override
    public String maxKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IObjekat> kreirajListu(ResultSet rs) throws Exception {
        List<IObjekat> lista = new ArrayList<>();
        while (rs.next()) {            
            lista.add(new StavkaRacuna(rs.getInt("sr.rb"), rs.getInt("sr.kolicina"), rs.getDouble("sr.iznos"), new Proizvod(rs.getInt("p.proizvodID"), rs.getString("p.nazivProizvoda"), rs.getDouble("p.cena"), rs.getString("p.opis"), new Proizvodjac(rs.getInt("pro.proizvodjacID"), rs.getString("pro.imeProizvodjaca"))), null));
        }
        return lista;          
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
        final StavkaRacuna other = (StavkaRacuna) obj;
        if (!Objects.equals(this.proizvod, other.proizvod)) {
            return false;
        }
        return true;
    }
    
    
}
