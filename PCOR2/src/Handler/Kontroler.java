/* Kontroler.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package Handler;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKPorudzbina;


public abstract class Kontroler { // Handler
    protected EkranskaForma ef;
    protected BrokerBazePodataka bbp;
    protected DKPorudzbina ip;   // Promenljivo!!!
    protected String poruka;
    protected Kontroler kon; // successor
    protected Kontroler konOsnovni;
    
    public Kontroler(Kontroler kon1,Kontroler konOsnovni1) {kon=kon1; konOsnovni = konOsnovni1;}
    public void Povezi(Kontroler kon) {}
    public EkranskaForma getEkranskaForma(){return ef;}
    public void setIkonu(String nazivIkone){}
    public void startAudioKlip(String nazivKlipa){}
    public Kontroler getKontroler(){return kon;}
    public void setKontroler(Kontroler kon1){kon = kon1;}
    public BrokerBazePodataka getBrokerBazePodataka(){return bbp;}
     
    public boolean zapamtiDomenskiObjekat(){ return kon.zapamtiDomenskiObjekat();} 
    public boolean kreirajDomenskiObjekat(){return kon.kreirajDomenskiObjekat();} 
    public boolean obrisiDomenskiObjekat(){ return kon.obrisiDomenskiObjekat();} 
    public boolean promeniDomenskiObjekat(){return kon.promeniDomenskiObjekat();} 
    public boolean nadjiDomenskiObjekat(){return kon.nadjiDomenskiObjekat();} 
    public void napuniDomenskiObjekatIzGrafickogObjekta(){kon.napuniDomenskiObjekatIzGrafickogObjekta();}
    
    public void prikaziPoruku(String poruka){}
    
}
