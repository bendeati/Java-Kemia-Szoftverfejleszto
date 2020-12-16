
package bdc_kemia;

/**
 *
 * @author Bende Attila
 */
public class Elemek {
   
    //adattagok
    private int ev; //ha ókor: 0
    private String nev;
    private String vegyjel;
    private String rendszam;
    private String felfedezo;
    
    //getterek

    public int getEv() {
        return ev;
    }

    public String getNev() {
        return nev;
    }

    public String getVegyjel() {
        return vegyjel;
    }

    public String getRendszam() {
        return rendszam;
    }

    public String getFelfedezo() {
        return felfedezo;
    }
    
    //konstruktor

    public Elemek(int ev, String nev, String vegyjel, String rendszam, String felfedezo) {
        this.ev = ev;
        this.nev = nev;
        this.vegyjel = vegyjel;
        this.rendszam = rendszam;
        this.felfedezo = felfedezo;
    }
    
}
