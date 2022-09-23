/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainClasses;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Korisnik
 */
public class DKSto implements Serializable, GeneralDObject{
    private int SifraStola;
    private String NazivStola;

    public DKSto() {
        SifraStola = 0;
        NazivStola = "";
    }

    public DKSto(int SifraStola, String NazivStola) {
        this.SifraStola = SifraStola;
        this.NazivStola = NazivStola;
    }
     public DKSto(int SifraStola)  	
    {   this.SifraStola = SifraStola;
    }

    public String getNazivStola() {
        return NazivStola;
    }

    public int getSifraStola() {
        return SifraStola;
    }

    public void setNazivStola(String NazivStola) {
        this.NazivStola = NazivStola;
    }

    public void setSifraStola(int SifraStola) {
        this.SifraStola = SifraStola;
    }
     
    @Override
    public String getNameByColumn(int column)
        { String names[] = {"SifraStola","NazivStola"}; 
          return names[column];
        }		
 
    @Override
    public GeneralDObject getNewRecord(ResultSet rs)  throws SQLException
    {return new DKSto(rs.getInt("SifraStola"),rs.getString("NazivStola"));} 
    @Override
    public String getAtrValue() {return SifraStola + ", " + (NazivStola == null ? null : "'" + NazivStola + "'");}
    @Override
    public String setAtrValue(){return "SifraStola = " + SifraStola + ", " + "NazivStola=" + (NazivStola == null ? null : "'" + NazivStola + "'");}
    @Override
    public String getClassName(){return "DKSto";}
    @Override
    public String getWhereCondition(){return "SifraStola = " + SifraStola;}
    
}
