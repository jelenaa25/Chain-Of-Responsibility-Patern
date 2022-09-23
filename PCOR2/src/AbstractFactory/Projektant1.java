/* Projektant1.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package AbstractFactory;


import Handler.Kontroler;
import AbstractProductA.*;
import AbstractProductB.*;
import ConcreteHandler.Kontroler2;
import ConcreteHandler.KontrolerStOg;
import ConcreteHandler.KontrolerVrOg;

// Promenljivo!!!
public class Projektant1 implements Projektant {
        
    @Override
    public EkranskaForma kreirajEkranskuFormu() {
        Panel pan = new Panel1(); // Promenljivo!!!
        EkranskaForma2 ip = new EkranskaForma2(); // Promenljivo!!!
        ip.setPanel(pan);
        return ip;
    }   
    
    @Override
    public BrokerBazePodataka kreirajBrokerBazePodataka () 
      { BrokerBazePodataka dbbr = new BrokerBazePodataka1(); // Promenljivo!!!
        return dbbr;}  
    
    @Override
    public Kontroler kreirajKontroler (EkranskaForma ef,BrokerBazePodataka dbbr) {
        Kontroler2 kon = new Kontroler2(ef,dbbr); // Promenljivo!!!
        KontrolerStOg stog = new KontrolerStOg(kon,kon);
        KontrolerVrOg vrog = new KontrolerVrOg(stog,kon);
        return vrog;
    }
        
   
}

