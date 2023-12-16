/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.memorygame;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Profile extends javax.swing.JFrame {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/memorygame";
    static final String USER = "root";
    static final String PASS = "";
    private String loggedInUsername;
    // public static String tempUser = "asd";

    /**
     * Creates new form Profile
     */
    public Profile(String loggedInUsername) {
        initComponents();

        this.setLocationRelativeTo(this);
        this.loggedInUsername = loggedInUsername;
        updateProfile();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ProfileLabel = new javax.swing.JLabel();
        ProfileName = new javax.swing.JLabel();
        ProfileScore = new javax.swing.JLabel();
        ProfileRound = new javax.swing.JLabel();

        ProfileLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ProfileLabel.setText("Profile");

        ProfileName.setText("Nama: ");

        ProfileScore.setText("Highscore: ");

        ProfileRound.setText("Jumlah Tes: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ProfileRound, javax.swing.GroupLayout.PREFERRED_SIZE, 127,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ProfileScore, javax.swing.GroupLayout.PREFERRED_SIZE, 127,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ProfileLabel)
                                        .addComponent(ProfileName, javax.swing.GroupLayout.PREFERRED_SIZE, 127,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(38, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(ProfileLabel)
                                .addGap(18, 18, 18)
                                .addComponent(ProfileName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ProfileScore)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ProfileRound)
                                .addContainerGap(54, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    private void updateProfile() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "SELECT username, score, round FROM userid WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, loggedInUsername);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String playerName = rs.getString("username");
                int playerScore = rs.getInt("score");
                int playerRound = rs.getInt("round");

                ProfileName.setText("Nama: " + playerName);
                ProfileScore.setText("Highscore: " + playerScore);
                ProfileRound.setText("Jumlah Tes: " + playerRound);
            }

            rs.close();
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    // public static void main(String args[]) {
    // java.awt.EventQueue.invokeLater(new Runnable() {
    // public void run() {
    // new Profile().setVisible(true);
    // }
    // });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ProfileLabel;
    private javax.swing.JLabel ProfileName;
    private javax.swing.JLabel ProfileRound;
    private javax.swing.JLabel ProfileScore;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
