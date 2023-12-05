/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.memorygame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.mycompany.memorygame.Controler.ImageController;
import com.mycompany.memorygame.Controler.Match;

/**
 *
 * @author HP
 */
public class MatchGame extends javax.swing.JFrame {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/modul4";
    static final String USER = "root";
    static final String PASS = "";
    protected String user;
    public static String tempUser = "asd";

  
    int clic =0;

    private ImageController imageController;

    

    public MatchGame(String user) {
        initComponents();
        this.setLocationRelativeTo(this);

        imageController = new ImageController();
        List<JButton> buttons = Arrays.asList(btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09, btn10, btn11, btn12);
        // imageController.setImages(buttons);
        imageController.setStartImage(buttons);
        
  
    }

    public void setShowTime(String text){
        this.ShowTime.setText(text);
    }

    
    public void setRound(int round){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "UPDATE userid SET round = round + ? WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, round);
            pstmt.setString(2, tempUser);
            
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setHighScore(int score) {
        try {
            
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
    
            
            String selectSql = "SELECT score FROM userid WHERE username = ?";
            try (PreparedStatement selectStmt = conn.prepareStatement(selectSql)) {
                
                selectStmt.setString(1, tempUser);
    
                ResultSet resultSet = selectStmt.executeQuery();
    
                if (resultSet.next()) {
                    int currentHighScore = resultSet.getInt("score");
    
                    if (score > currentHighScore) {
                        String updateSql = "UPDATE userid SET score = ? WHERE username = ?";
                        try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                            updateStmt.setInt(1, score);
                            updateStmt.setString(2, tempUser);
    
                            updateStmt.executeUpdate();
    
                            
                        }
                    } 
                } 
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void setShowScore(int score){
        String text = Integer.toString(score);
        this.ShowScore.setText(  text );
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ShowScore = new javax.swing.JLabel();
        ShowTime = new javax.swing.JLabel();
        MatchPanle = new javax.swing.JPanel();
        btn02 = new javax.swing.JButton();
        btn09 = new javax.swing.JButton();
        btn03 = new javax.swing.JButton();
        btn04 = new javax.swing.JButton();
        btn05 = new javax.swing.JButton();
        btn06 = new javax.swing.JButton();
        btn07 = new javax.swing.JButton();
        btn08 = new javax.swing.JButton();
        btn01 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        ScoreP = new javax.swing.JLabel();
        leaderBoardButton = new javax.swing.JButton();
        leaderBoardButton1 = new javax.swing.JButton();
        TimerL = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ShowScore.setBackground(new java.awt.Color(0, 0, 0));
        ShowScore.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ShowScore.setText("0 ");
        ShowScore.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ShowTime.setBackground(new java.awt.Color(0, 0, 0));
        ShowTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ShowTime.setText("01.00");
        ShowTime.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        MatchPanle.setBackground(new java.awt.Color(255, 255, 255));

        btn02.setForeground(new java.awt.Color(240, 240, 240));
        btn02.setMaximumSize(new java.awt.Dimension(64, 64));
        btn02.setMinimumSize(new java.awt.Dimension(64, 64));
        btn02.setPreferredSize(new java.awt.Dimension(64, 64));
        btn02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn02MouseClicked(evt);
            }
        });

        btn09.setForeground(new java.awt.Color(240, 240, 240));
        btn09.setMaximumSize(new java.awt.Dimension(64, 64));
        btn09.setMinimumSize(new java.awt.Dimension(64, 64));
        btn09.setPreferredSize(new java.awt.Dimension(64, 64));
        btn09.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn09MouseClicked(evt);
            }
        });

        btn03.setForeground(new java.awt.Color(240, 240, 240));
        btn03.setMaximumSize(new java.awt.Dimension(64, 64));
        btn03.setMinimumSize(new java.awt.Dimension(64, 64));
        btn03.setPreferredSize(new java.awt.Dimension(64, 64));
        btn03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn03MouseClicked(evt);
            }
        });
        btn03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn03ActionPerformed(evt);
            }
        });

        btn04.setForeground(new java.awt.Color(240, 240, 240));
        btn04.setMaximumSize(new java.awt.Dimension(64, 64));
        btn04.setMinimumSize(new java.awt.Dimension(64, 64));
        btn04.setPreferredSize(new java.awt.Dimension(64, 64));
        btn04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn04MouseClicked(evt);
            }
        });

        btn05.setForeground(new java.awt.Color(240, 240, 240));
        btn05.setMaximumSize(new java.awt.Dimension(64, 64));
        btn05.setMinimumSize(new java.awt.Dimension(64, 64));
        btn05.setPreferredSize(new java.awt.Dimension(64, 64));
        btn05.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn05MouseClicked(evt);
            }
        });

        btn06.setForeground(new java.awt.Color(240, 240, 240));
        btn06.setMaximumSize(new java.awt.Dimension(64, 64));
        btn06.setMinimumSize(new java.awt.Dimension(64, 64));
        btn06.setPreferredSize(new java.awt.Dimension(64, 64));
        btn06.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn06MouseClicked(evt);
            }
        });

        btn07.setForeground(new java.awt.Color(240, 240, 240));
        btn07.setMaximumSize(new java.awt.Dimension(64, 64));
        btn07.setMinimumSize(new java.awt.Dimension(64, 64));
        btn07.setPreferredSize(new java.awt.Dimension(64, 64));
        btn07.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn07MouseClicked(evt);
            }
        });

        btn08.setForeground(new java.awt.Color(240, 240, 240));
        btn08.setMaximumSize(new java.awt.Dimension(64, 64));
        btn08.setMinimumSize(new java.awt.Dimension(64, 64));
        btn08.setPreferredSize(new java.awt.Dimension(64, 64));
        btn08.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn08MouseClicked(evt);
            }
        });

        btn01.setForeground(new java.awt.Color(240, 240, 240));
        btn01.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn01.setMaximumSize(new java.awt.Dimension(64, 64));
        btn01.setMinimumSize(new java.awt.Dimension(64, 64));
        btn01.setPreferredSize(new java.awt.Dimension(64, 64));
        btn01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn01MouseClicked(evt);
            }
        });

        btn10.setForeground(new java.awt.Color(240, 240, 240));
        btn10.setMaximumSize(new java.awt.Dimension(64, 64));
        btn10.setMinimumSize(new java.awt.Dimension(64, 64));
        btn10.setPreferredSize(new java.awt.Dimension(64, 64));
        btn10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn10MouseClicked(evt);
            }
        });

        btn11.setForeground(new java.awt.Color(240, 240, 240));
        btn11.setMaximumSize(new java.awt.Dimension(64, 64));
        btn11.setMinimumSize(new java.awt.Dimension(64, 64));
        btn11.setPreferredSize(new java.awt.Dimension(64, 64));
        btn11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn11MouseClicked(evt);
            }
        });

        btn12.setForeground(new java.awt.Color(240, 240, 240));
        btn12.setMaximumSize(new java.awt.Dimension(64, 64));
        btn12.setMinimumSize(new java.awt.Dimension(64, 64));
        btn12.setPreferredSize(new java.awt.Dimension(64, 64));
        btn12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MatchPanleLayout = new javax.swing.GroupLayout(MatchPanle);
        MatchPanle.setLayout(MatchPanleLayout);
        MatchPanleLayout.setHorizontalGroup(
            MatchPanleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MatchPanleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MatchPanleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MatchPanleLayout.createSequentialGroup()
                        .addGroup(MatchPanleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn01, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn05, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(MatchPanleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MatchPanleLayout.createSequentialGroup()
                                .addComponent(btn02, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn03, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn04, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MatchPanleLayout.createSequentialGroup()
                                .addComponent(btn06, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn07, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn08, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(MatchPanleLayout.createSequentialGroup()
                        .addComponent(btn09, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MatchPanleLayout.setVerticalGroup(
            MatchPanleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MatchPanleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MatchPanleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MatchPanleLayout.createSequentialGroup()
                        .addGroup(MatchPanleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn02, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn03, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn04, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(MatchPanleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn05, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn06, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn07, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn08, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn01, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(MatchPanleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn09, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        ScoreP.setBackground(new java.awt.Color(0, 0, 0));
        ScoreP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ScoreP.setText("Score:");
        ScoreP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        leaderBoardButton.setBackground(new java.awt.Color(51, 102, 255));
        leaderBoardButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        leaderBoardButton.setForeground(new java.awt.Color(255, 255, 255));
        leaderBoardButton.setText("Profile");
        leaderBoardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderBoardButtonActionPerformed(evt);
            }
        });

        leaderBoardButton1.setBackground(new java.awt.Color(51, 102, 255));
        leaderBoardButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        leaderBoardButton1.setForeground(new java.awt.Color(255, 255, 255));
        leaderBoardButton1.setText("Leader Board");
        leaderBoardButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderBoardButton1ActionPerformed(evt);
            }
        });

        TimerL.setBackground(new java.awt.Color(0, 0, 0));
        TimerL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TimerL.setText("Timer:");
        TimerL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Cari Gambar Yang Sama");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MatchPanle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ScoreP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ShowScore, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TimerL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ShowTime, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(leaderBoardButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(leaderBoardButton)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TimerL)
                            .addComponent(ShowTime)
                            .addComponent(leaderBoardButton)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ScoreP)
                            .addComponent(ShowScore)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(leaderBoardButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MatchPanle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void leaderBoardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderBoardButtonActionPerformed
        // new LeaderBoard().setVisible(true);
    }//GEN-LAST:event_leaderBoardButtonActionPerformed

    private void leaderBoardButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderBoardButton1ActionPerformed
        // new Profile().setVisible(true);
    }//GEN-LAST:event_leaderBoardButton1ActionPerformed

    private void btn01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn01MouseClicked
        
        // Match match = new Match();
        // match.setBtn(btn01);
        // match.setNumberBtn(1);
        // match.setValueMatch(next.get(0));
        // imageController.getMatch().add(match);
        // imageController.paintMatch();
        // imageController.match();
    }//GEN-LAST:event_btn01MouseClicked

    private void btn08MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn08MouseClicked
        
        // Match match = new Match();
        // match.setBtn(btn08);
        // match.setNumberBtn(1);
        // match.setValueMatch(next.get(0));
        // imageController.getMatch().add(match);
        // imageController.paintMatch();
        // imageController.match();
    }//GEN-LAST:event_btn08MouseClicked

    private void btn07MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn07MouseClicked
        
        // Match match = new Match();
        // match.setBtn(btn07);
        // match.setNumberBtn(1);
        // match.setValueMatch(next.get(0));
        // imageController.getMatch().add(match);
        // imageController.paintMatch();
        // imageController.match();
    }//GEN-LAST:event_btn07MouseClicked

    private void btn06MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn06MouseClicked
        // Match match = new Match();
        // match.setBtn(btn06);
        // match.setNumberBtn(6);
        // match.setValueMatch(next.get(5));
        // imageController.getMatch().add(match);
        // imageController.paintMatch();
        // imageController.match();
    }//GEN-LAST:event_btn06MouseClicked

    private void btn05MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn05MouseClicked
        // Match match = new Match();
        // match.setBtn(btn05);
        // match.setNumberBtn(5);
        // match.setValueMatch(next.get(4));
        // imageController.getMatch().add(match);
        // imageController.paintMatch();
        // imageController.match();
    }//GEN-LAST:event_btn05MouseClicked

    private void btn04MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn04MouseClicked
        // Match match = new Match();
        // match.setBtn(btn04);
        // match.setNumberBtn(4);
        // match.setValueMatch(next.get(3));
        // imageController.getMatch().add(match);
        // imageController.paintMatch();
        // imageController.match();
    }//GEN-LAST:event_btn04MouseClicked

    private void btn03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn03MouseClicked
        // TODO add your handling code here:
        // Match match = new Match();
        // match.setBtn(btn03);
        // match.setNumberBtn(3);
        // match.setValueMatch(next.get(2));
        // imageController.getMatch().add(match);
        // imageController.paintMatch();
        // imageController.match();
    }//GEN-LAST:event_btn03MouseClicked

    private void btn09MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn09MouseClicked
        
        // Match match = new Match();
        // match.setBtn(btn09);
        // match.setNumberBtn(1);
        // match.setValueMatch(next.get(0));
        // imageController.getMatch().add(match);
        // imageController.paintMatch();
        // imageController.match();
    }//GEN-LAST:event_btn09MouseClicked

    private void btn02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn02MouseClicked
        
        // Match match = new Match();
        // match.setBtn(btn02);
        // match.setNumberBtn(2);
        // match.setValueMatch(next.get(1));
        // imageController.getMatch().add(match);
        // imageController.paintMatch();
        // imageController.match();
    }//GEN-LAST:event_btn02MouseClicked

    private void btn03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn03ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn03ActionPerformed

    private void btn10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn10MouseClicked

    private void btn11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn11MouseClicked

    private void btn12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn12MouseClicked

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MatchGame(tempUser).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MatchPanle;
    private javax.swing.JLabel ScoreP;
    private javax.swing.JLabel ShowScore;
    private javax.swing.JLabel ShowTime;
    private javax.swing.JLabel TimerL;
    public static javax.swing.JButton btn01;
    public static javax.swing.JButton btn02;
    public static javax.swing.JButton btn03;
    public static javax.swing.JButton btn04;
    public static javax.swing.JButton btn05;
    public static javax.swing.JButton btn06;
    public static javax.swing.JButton btn07;
    public static javax.swing.JButton btn08;
    public static javax.swing.JButton btn09;
    public static javax.swing.JButton btn10;
    public static javax.swing.JButton btn11;
    public static javax.swing.JButton btn12;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton leaderBoardButton;
    private javax.swing.JButton leaderBoardButton1;
    // End of variables declaration//GEN-END:variables
}