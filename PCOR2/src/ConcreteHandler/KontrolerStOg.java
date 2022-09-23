/* ProxyKontroler.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package ConcreteHandler;



import DomainClasses.DKSto;
import Handler.Kontroler;


public class KontrolerStOg extends Kontroler{ // Proxy
       
    
    
    public KontrolerStOg(Kontroler kon1,Kontroler konOsnovni) {super(kon1,konOsnovni);}
          
    @Override
    public boolean promeniDomenskiObjekat()
    
      {
         if (nadjiPredmet()) 
             return kon.promeniDomenskiObjekat();
         else
             return false;
      } 
    
    public boolean nadjiPredmet(){
    boolean signal;
    konOsnovni.getBrokerBazePodataka().makeConnection();
    DKSto pr = new DKSto();
    int SifraPredmeta = Integer.parseInt(konOsnovni.getEkranskaForma().getPanel().getSifraStola());
    pr.setSifraStola(SifraPredmeta);
    
    pr = (DKSto)konOsnovni.getBrokerBazePodataka().findRecord(pr); // Promenljivo!!!
    if (pr != null) 
        { poruka = "Систем je нашао сто.";  // Promenljivo!!!
          signal = true;
        }
        else
        { poruka ="Систем није нашао сто!!!"; // Promenljivo!!!
          signal = false;
        }
    konOsnovni.prikaziPoruku(poruka);
    konOsnovni.getBrokerBazePodataka().closeConnection();
    return signal;   
   
    }
}