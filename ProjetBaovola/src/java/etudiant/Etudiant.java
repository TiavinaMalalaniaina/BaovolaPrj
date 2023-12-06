/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author itu
 */
public class Etudiant {
    int idEtudiant;
    String nom;
    String prenom;

    public Etudiant() {
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
     public static List<Etudiant> find(Connection connection) throws ClassNotFoundException, SQLException {
        List<Etudiant> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            connection = DBConnection.getConnection();
            wasConnected = false;
        }
        String sql = "SELECT * FROM Etudiant";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
         
      
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Etudiant model = new Etudiant();
                model.setNom(rs.getString("nom"));
                model.setPrenom(rs.getString("prenom"));
                 model.setIdEtudiant(rs.getInt("Id_Etudiant"));
                models.add(model);
            }
        }
        if (!wasConnected) {
            connection.close();
        }
        return models;
    }
    
     
    
}
