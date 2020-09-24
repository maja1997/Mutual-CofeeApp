/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Maja
 */
public interface IObjekat extends Serializable{

    public String vratiNazivTabele();

    public String joinUslov();

    public String vratiWhereZaSelect();

    public String vratiSortiranje();

    public String vratiNaziveKolona();

    public String vratiVrednostiKolona();

    public String vratiVrednostiUpdate();

    public String wherePrimarniKljuc();

    public String maxKljuc();

    List<IObjekat> kreirajListu(ResultSet rs) throws Exception;
}
