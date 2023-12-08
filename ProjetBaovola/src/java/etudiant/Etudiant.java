/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.DBConnection;

/**
 *
 * @author itu
 */
public class Etudiant {
    int idEtudiant;
    String nom;
    String prenom;

    Etudiant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public void save(Connection connection) throws ClassNotFoundException, SQLException {
        boolean wasConnected = true;
        if(connection == null) {
            connection = DBConnection.getConnection();
            wasConnected = false;
        }
        String sql = "INSERT INTO \"public\".etudiant( id_etudiant, nom, prenom) VALUES ( default, ?, ? )";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, this.getNom());
            stmt.setString(2, this.getPrenom());
            stmt.executeUpdate();
        }
        if (!wasConnected) {
            connection.close();
        }
    }
    
     
    
}
