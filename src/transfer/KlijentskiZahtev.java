/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import domen.IObjekat;
import java.io.Serializable;

/**
 *
 * @author Maja
 */
public class KlijentskiZahtev implements Serializable{
    private String operacija;
    private IObjekat parametar;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(String operacija, IObjekat parametar) {
        this.operacija = operacija;
        this.parametar = parametar;
    }

    public IObjekat getParametar() {
        return parametar;
    }

    public void setParametar(IObjekat parametar) {
        this.parametar = parametar;
    }

    public String getOperacija() {
        return operacija;
    }

    public void setOperacija(String operacija) {
        this.operacija = operacija;
    }
    
    
}
