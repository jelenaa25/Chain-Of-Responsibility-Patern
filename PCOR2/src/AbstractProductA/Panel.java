/* Panel.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */


package AbstractProductA;



import java.awt.event.KeyEvent;
import java.util.Date;

// Promenljivo!!!
public abstract class Panel extends javax.swing.JPanel{
       
       public abstract String getSifraPorudzbine(); // Promenljivo!!!
       public abstract String getSifraStola();
       public abstract javax.swing.JTextField getSifraPorudzbine1(); // Promenljivo!!!
       public abstract String getPalacinka(); // Promenljivo!!!
       public abstract String getPreliv(); // Promenljivo!!!
       public abstract String getVoce(); // Promenljivo!!!
      // public abstract Date getDatum(); // Promenljivo!!!
       
       public abstract void setSifraPorudzbine(String sifraPorudzbine); // Promenljivo!!!
       public abstract void setSifraStola(String sifraStola);
       public abstract void setPalacinka(String Palacinka); // Promenljivo!!!
       public abstract void setPreliv(String Preliv); // Promenljivo!!!
       public abstract void setVoce(String Voce); // Promenljivo!!!
       
       public abstract void setPoruka(String Poruka);
       
       public abstract javax.swing.JButton getKreiraj(); 
       public abstract javax.swing.JButton getPromeni(); 
       public abstract javax.swing.JButton getObrisi(); 
       public abstract javax.swing.JButton getNadji();
       
       
       
}
