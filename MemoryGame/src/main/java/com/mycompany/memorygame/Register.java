/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.memorygame;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Register extends javax.swing.JFrame {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/modul4";
    static final String USER = "root";
    static final String PASS = "";

    /**
     * Creates new form Register1
     */
    public Register() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        passLabel = new javax.swing.JLabel();
        enterPass = new javax.swing.JTextField();
        confrmPassLabel = new javax.swing.JLabel();
        confermPass = new javax.swing.JTextField();
        RegisterBtn1 = new javax.swing.JButton();
        registerLable = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        LoginBtn1 = new javax.swing.JButton();
        plsEnterDtlLable = new javax.swing.JLabel();
        UserLabel = new javax.swing.JLabel();
        enterUser = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        passLabel.setText("Password");

        enterPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterPassActionPerformed(evt);
            }
        });

        confrmPassLabel.setText("Confirm Password");

        confermPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermPassActionPerformed(evt);
            }
        });

        RegisterBtn1.setBackground(new java.awt.Color(0, 102, 255));
        RegisterBtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RegisterBtn1.setForeground(new java.awt.Color(255, 255, 255));
        RegisterBtn1.setText("Register");
        RegisterBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterBtn1ActionPerformed(evt);
            }
        });

        registerLable.setText("already have an account?");

        loginLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        loginLabel.setForeground(new java.awt.Color(0, 102, 255));
        loginLabel.setText("Register");
        loginLabel.setMaximumSize(new java.awt.Dimension(50, 36));
        loginLabel.setMinimumSize(new java.awt.Dimension(50, 36));
        loginLabel.setPreferredSize(new java.awt.Dimension(50, 36));

        LoginBtn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LoginBtn1.setForeground(new java.awt.Color(0, 102, 255));
        LoginBtn1.setText("login here");
        LoginBtn1.setBorder(null);
        LoginBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtn1ActionPerformed(evt);
            }
        });

        plsEnterDtlLable.setText("Please. enter your detail");

        UserLabel.setText("Username");

        enterUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confrmPassLabel)
                    .addComponent(confermPass, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegisterBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passLabel)
                    .addComponent(enterPass, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserLabel)
                    .addComponent(plsEnterDtlLable)
                    .addComponent(enterUser, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(registerLable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LoginBtn1))
                    .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plsEnterDtlLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confrmPassLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confermPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RegisterBtn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerLable)
                    .addComponent(LoginBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enterPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterPassActionPerformed

    private void confermPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confermPassActionPerformed

    private void LoginBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtn1ActionPerformed
        new Login().setVisible(true);
    }//GEN-LAST:event_LoginBtn1ActionPerformed

    private void enterUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterUserActionPerformed

    private void RegisterBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterBtn1ActionPerformed
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO userid(username, pass, score, round) VALUES (?, ?, 0, 0)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, enterUser.getText());
            statement.setString(2, enterPass.getText());
    
            if (enterUser.getText().isEmpty() && enterPass.getText().isEmpty() && confermPass.getText().isEmpty()) {
                JOptionPane.showMessageDialog(new JFrame(), "Username dan Password harus diisi", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (!confermPass.getText().equals(enterPass.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Password tidak sesuai", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                // The following two conditions seem unnecessary. If you still need them, modify accordingly.
                if (enterUser.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(), "Username tidak terdaftar", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (enterPass.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(), "Password tidak terdaftar", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
    
                JOptionPane.showMessageDialog(new JFrame(), "Register Berhasil", "Success", JOptionPane.INFORMATION_MESSAGE);
                statement.executeUpdate();
                new Login().setVisible(true);
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }//GEN-LAST:event_RegisterBtn1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Register1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Register1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Register1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Register1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Register1().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginBtn1;
    private javax.swing.JButton RegisterBtn1;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JTextField confermPass;
    private javax.swing.JLabel confrmPassLabel;
    private javax.swing.JTextField enterPass;
    private javax.swing.JTextField enterUser;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JLabel plsEnterDtlLable;
    private javax.swing.JLabel registerLable;
    // End of variables declaration//GEN-END:variables
}