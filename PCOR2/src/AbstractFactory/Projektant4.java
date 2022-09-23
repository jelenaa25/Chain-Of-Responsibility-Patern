/* Projektant4.java
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
import ConcreteHandler.Kontroler1;

// Promenljivo!!!
public class Projektant4 implements Projektant {
        
    @Override
    public EkranskaForma kreirajEkranskuFormu() {
        Panel pan = new Panel1(); // Promenljivo!!!
        EkranskaForma2 ip = new EkranskaForma2(); // Promenljivo!!!
        ip.setPanel(pan);
        return ip;
    }   
    
    @Override
    public BrokerBazePodataka kreirajBrokerBazePodataka () 
      { BrokerBazePodataka dbbr = new BrokerBazePodataka2(); // Promenljivo!!!
        return dbbr;}  
    
    @Override
    public Kontroler kreirajKontroler (EkranskaForma ef,BrokerBazePodataka dbbr) {
        Kontroler kon = new Kontroler1(ef,dbbr); // Promenljivo!!!
        return kon;
    }
        
   
}

