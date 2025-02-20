/* Kontroler1.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package ConcreteHandler;




import AbstractProductA.*;
import AbstractProductB.*;
import Handler.Kontroler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.DKPorudzbina;  // Promenljivo


public final class Kontroler1 extends Kontroler{ // RealSubject
   
    
   
    
    public Kontroler1(EkranskaForma ef1,BrokerBazePodataka bbp1){super(null,null);ef=ef1;bbp=bbp1;}
    
     
    @Override
    public void Povezi(Kontroler kon)
    {
     
     if (kon != null) 
     {   
         javax.swing.JButton Kreiraj = ef.getPanel().getKreiraj();
         javax.swing.JButton Promeni = ef.getPanel().getPromeni();
         javax.swing.JButton Obrisi = ef.getPanel().getObrisi();
         javax.swing.JButton Nadji = ef.getPanel().getNadji();
         Kreiraj.addActionListener( new OsluskivacKreiraj(kon));
         Promeni.addActionListener( new OsluskivacPromeni(kon));
         Obrisi.addActionListener( new OsluskivacObrisi(kon));
         Nadji.addActionListener( new OsluskivacNadji(kon));
        javax.swing.JTextField SifraPrijave = ef.getPanel().getSifraPorudzbine1(); // Promenljivo!!!
        SifraPrijave.addFocusListener( new OsluskivacNadji1(kon));
     }   
    }
    
    // Promenljivo!!!  
    @Override
    public void napuniDomenskiObjekatIzGrafickogObjekta()   {
       ip= new DKPorudzbina();
       ip.setSifraPorudzbine(getInteger(ef.getPanel().getSifraPorudzbine()));
       ip.setSto(getInteger(ef.getPanel().getSifraStola()));
       ip.setPalacinka(ef.getPanel().getPalacinka());
       ip.setPreliv(ef.getPanel().getPreliv());
       ip.setVoce(ef.getPanel().getVoce());
    
    }

    // Promenljivo!!!
    public void napuniGrafickiObjekatIzDomenskogObjekta(DKPorudzbina ip){
       ef.getPanel().setSifraPorudzbine(Integer.toString(ip.getSifraPorudzbine()));
       ef.getPanel().setSifraStola(Integer.toString(ip.getSto()));
       ef.getPanel().setPalacinka(ip.getPalacinka());
       ef.getPanel().setPreliv(ip.getPreliv());
       ef.getPanel().setVoce(ip.getVoce());
      
    }

// Promenljivo!!!
public void isprazniGrafickiObjekat(){
 ef.getPanel().setSifraPorudzbine("");
 ef.getPanel().setPalacinka("nista");
 ef.getPanel().setPreliv("nista");
 ef.getPanel().setVoce("nista");
 ef.getPanel().setSifraStola("");
 
}

public void prikaziPoruku() 
{ ef.getPanel().setPoruka(poruka);
      
  Timer timer = new Timer();
  
  timer.schedule(new TimerTask() {
  @Override
  public void run() {
    ef.getPanel().setPoruka(""); 
  }
}, 3000);
  
}

public int getInteger(String s) {
    int broj = 0;
    try
        {
            if(s != null)
                broj = Integer.parseInt(s);
        }
            catch (NumberFormatException e)
            { broj = 0;}
   
    return broj;
}


 
@Override 
public boolean zapamtiDomenskiObjekat(){ 
    
    bbp.makeConnection();
    boolean signal = bbp.insertRecord(ip);
    if (signal==true) 
        { bbp.commitTransation();
          poruka ="������ �� �������� ���� ��������."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
          poruka ="������ �� ���� �� ������� ���� ��������."; // Promenljivo!!!  
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal; 
       
    }
    
@Override
public boolean kreirajDomenskiObjekat(){
    boolean signal;
    ip= new DKPorudzbina(); // Promenljivo!!!
    AtomicInteger counter = new AtomicInteger(0);
    
    bbp.makeConnection();
    if (!bbp.getCounter(ip,counter)) return false;
    if (!bbp.increaseCounter(ip,counter)) return false;
          
    ip.setSifraPorudzbine(counter.get()); // Promenljivo!!!
    signal = bbp.insertRecord(ip);
    if (signal==true) 
        { bbp.commitTransation();
          napuniGrafickiObjekatIzDomenskogObjekta(ip);
          poruka = "������ �� ������� ���� ��������."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
        isprazniGrafickiObjekat();
        poruka ="������ �� ���� �� ������ ���� ��������."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;
}

@Override
public boolean obrisiDomenskiObjekat(){
    bbp.makeConnection();
    boolean signal = bbp.deleteRecord(ip);
    if (signal==true) 
        { bbp.commitTransation();
          poruka = "������ je o������ ��������."; // Promenljivo!!!
            isprazniGrafickiObjekat();
        }
        else
        { bbp.rollbackTransation();
          poruka = "������ �� ���� �� ������ ��������."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}

@Override
public boolean promeniDomenskiObjekat(){
    bbp.makeConnection();
    boolean signal = bbp.updateRecord(ip);
    if (signal==true) 
        { bbp.commitTransation();
          poruka = "������ je �������� ��������."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
          isprazniGrafickiObjekat();
          poruka = "������ �� ���� �� ������� ��������."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}


@Override
public boolean nadjiDomenskiObjekat(){
    boolean signal;
    bbp.makeConnection();
    ip = (DKPorudzbina)bbp.findRecord(ip); // Promenljivo!!!
    if (ip != null) 
        { napuniGrafickiObjekatIzDomenskogObjekta(ip);
          poruka = "������ je ����� ��������."; // Promenljivo!!!
          signal = true;
        }
        else
        { isprazniGrafickiObjekat();
          poruka ="������ �� ���� �� ���� ��������."; // Promenljivo!!!
          signal = false;
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}

   
}


// Osluskivaci su kod primera za proxy patern klijenti.
class OsluskivacZapamti implements ActionListener
{   Kontroler1 kon;
 
    OsluskivacZapamti(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.zapamtiDomenskiObjekat();
        
    }
}

class OsluskivacKreiraj implements ActionListener
{   Kontroler kon;
 
    OsluskivacKreiraj(Kontroler kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.kreirajDomenskiObjekat();
         
        
    }
}

class OsluskivacObrisi implements ActionListener
{   Kontroler kon;
 
    OsluskivacObrisi(Kontroler kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.obrisiDomenskiObjekat();
        
    }
}

class OsluskivacPromeni implements ActionListener
{   Kontroler kon;
 
    OsluskivacPromeni(Kontroler kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.promeniDomenskiObjekat();
        
    }
}

class OsluskivacNadji implements ActionListener
{   Kontroler kon;
 
    OsluskivacNadji(Kontroler kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.nadjiDomenskiObjekat();
        
    }
}

class OsluskivacNadji1 implements FocusListener
{   Kontroler kon;
 
    OsluskivacNadji1(Kontroler kon1) {kon = kon1;}
    

    @Override
    public void focusLost(java.awt.event.FocusEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.nadjiDomenskiObjekat();
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }
}

