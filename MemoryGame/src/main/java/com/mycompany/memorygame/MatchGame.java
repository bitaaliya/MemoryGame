/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.memorygame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.text.Utilities;
import com.mycompany.memorygame.Controler.Timer;
import com.mycompany.memorygame.Controler.ImageController;
import com.mycompany.memorygame.Controler.MatchController;

/**
 *
 * @author MSBENAVIDES
 */
public class MatchGame extends javax.swing.JFrame {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/memorygame";
    static final String USER = "root";
    static final String PASS = "";
    protected String user;
    // public static String tempUser = "asd";

    int clic = 0;

    private ImageController imageController;

    List<Integer> shuffledIndices = ImageController.rowsTableAll();

    List<Integer> next = ImageController.rowsTableAll();

    int valB1 = 0, valB2 = 1, valB3 = 2, valB4 = 3, valB5 = 4, valB6 = 5, valB7 = 6, valB8 = 7;

    boolean run = true;

    public MatchGame(String user) {
        initComponents();

        this.setLocationRelativeTo(this);
        this.user = user;
        imageController = new ImageController();
        imageController.setMatchGame(this);
        shuffleValues();
        imageController.setStartImage();

    }

    public void resetGame() {
        run = true;
        imageController.reset();
        Timer.reset();
    }

    public void shuffleValues() {

        List<String> variableList = new ArrayList<>();
        variableList.add("variabel1");
        variableList.add("variabel2");
        variableList.add("variabel3");
        variableList.add("variabel4");
        variableList.add("variabel5");
        variableList.add("variabel6");
        variableList.add("variabel7");
        variableList.add("variabel8");

        List<Integer> shuffledIndices = new ArrayList<>();
        for (int i = 0; i < variableList.size(); i++) {
            shuffledIndices.add(i);
        }
        Collections.shuffle(shuffledIndices);

        Map<String, Integer> variableValues = new HashMap<>();

        valB1 = getValue(variableList.get(0), shuffledIndices, variableValues);
        valB2 = getValue(variableList.get(1), shuffledIndices, variableValues);
        valB3 = getValue(variableList.get(2), shuffledIndices, variableValues);
        valB4 = getValue(variableList.get(3), shuffledIndices, variableValues);
        valB5 = getValue(variableList.get(4), shuffledIndices, variableValues);
        valB6 = getValue(variableList.get(5), shuffledIndices, variableValues);
        valB7 = getValue(variableList.get(6), shuffledIndices, variableValues);
        valB8 = getValue(variableList.get(7), shuffledIndices, variableValues);

        System.out.println("valB1: " + valB1);
        System.out.println("valB2: " + valB2);
        System.out.println("valB3: " + valB3);
        System.out.println("valB4: " + valB4);
        System.out.println("valB5: " + valB5);
        System.out.println("valB6: " + valB6);
        System.out.println("valB7: " + valB7);
        System.out.println("valB8: " + valB8);

    }

    private static int getValue(String variable, List<Integer> shuffledIndices, Map<String, Integer> variableValues) {
        int index;
        do {
            index = shuffledIndices.remove(0);
        } while (variableValues.containsValue(index));

        variableValues.put(variable, index);
        return index;
    }

    private void handleButtonClick(JButton button, int numberBtn, int valueMatch) {
        if (run == true){
            Timer.start();
        }
        // Check if the button has already been matched
        for (MatchController matchedController : imageController.getMatch()) {
            if (matchedController.getBtn() == button) {
                return; // Ignore the click if the button has already been matched
            }
        }
        run = false;
        MatchController matchController = new MatchController();
        matchController.setBtn(button);
        matchController.setNumberBtn(numberBtn);
        matchController.setValueMatch(valueMatch);
        imageController.getMatch().add(matchController);
        imageController.paintMatch();
        imageController.match();
    }

    public void setShowTime(String text) {
        this.timerLabel.setText(text);
    }

    public void setRound(int round) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "UPDATE userid SET round = round + ? WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, round);
            pstmt.setString(2, user);

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

                selectStmt.setString(1, user);

                ResultSet resultSet = selectStmt.executeQuery();

                if (resultSet.next()) {
                    int currentHighScore = resultSet.getInt("score");

                    if (score > currentHighScore) {
                        String updateSql = "UPDATE userid SET score = ? WHERE username = ?";
                        try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                            updateStmt.setInt(1, score);
                            updateStmt.setString(2, user);

                            updateStmt.executeUpdate();

                        }
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setShowScore() {
        int skor = MatchGame.Timer.getScore();
        System.out.println("Skor Anda: " + skor);
    }

    public void setShowScore(int score) {
        String text = Integer.toString(score);
        this.ShowScore.setText(text);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        MatchPanle = new javax.swing.JPanel();
        btn02 = new javax.swing.JButton();
        btn03 = new javax.swing.JButton();
        btn04 = new javax.swing.JButton();
        btn05 = new javax.swing.JButton();
        btn06 = new javax.swing.JButton();
        btn07 = new javax.swing.JButton();
        btn08 = new javax.swing.JButton();
        btn01 = new javax.swing.JButton();
        Timer = new Timer();
        timerLabel = new javax.swing.JLabel();
        ScoreP = new javax.swing.JLabel();
        ShowScore = new javax.swing.JLabel();
        leaderBoardButton1 = new javax.swing.JButton();
        ProfileButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();

        jButton3.setText("jButton1");

        jButton4.setText("jButton1");

        jButton5.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        btn01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MatchPanleLayout = new javax.swing.GroupLayout(MatchPanle);
        MatchPanle.setLayout(MatchPanleLayout);
        MatchPanleLayout.setHorizontalGroup(
                MatchPanleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MatchPanleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        MatchPanleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btn01, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btn05, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(
                                        MatchPanleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(MatchPanleLayout.createSequentialGroup()
                                                        .addComponent(btn02, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(btn03, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(btn04, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(MatchPanleLayout.createSequentialGroup()
                                                        .addComponent(btn06, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(btn07, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(btn08, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        MatchPanleLayout.setVerticalGroup(
                MatchPanleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MatchPanleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(MatchPanleLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MatchPanleLayout
                                                .createSequentialGroup()
                                                .addGroup(MatchPanleLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btn02, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btn03, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btn04, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(MatchPanleLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btn05, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btn06, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btn07, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btn08, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(btn01, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));


        timerLabel.setBackground(new java.awt.Color(0, 0, 0));
        timerLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        timerLabel.setText("Timer :");
        timerLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Timer.setBackground(new java.awt.Color(0, 0, 0));
        Timer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Timer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
                                
                                
        ScoreP.setBackground(new java.awt.Color(0, 0, 0));
        ScoreP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ScoreP.setText("Score:");
        ScoreP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ShowScore.setBackground(new java.awt.Color(0, 0, 0));
        ShowScore.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ShowScore.setText("0 ");
        ShowScore.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        leaderBoardButton1.setBackground(new java.awt.Color(255, 51, 51));
        leaderBoardButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        leaderBoardButton1.setForeground(new java.awt.Color(255, 255, 255));
        leaderBoardButton1.setText("Leader Board");
        leaderBoardButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderBoardButton1ActionPerformed(evt);
            }
        });

        ProfileButton.setBackground(new java.awt.Color(0, 255, 51));
        ProfileButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ProfileButton.setForeground(new java.awt.Color(255, 255, 255));
        ProfileButton.setText("Profile");
        ProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileButtonActionPerformed(evt);
            }
        });

        ResetButton.setBackground(new java.awt.Color(255, 204, 0));
        ResetButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ResetButton.setForeground(new java.awt.Color(255, 255, 255));
        ResetButton.setText("Reset");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(15, Short.MAX_VALUE)
                                .addComponent(MatchPanle, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                        .createSequentialGroup()
                                                        .addComponent(ScoreP, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(ShowScore, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Timer, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                ))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(29, 29, 29)
                                                        .addComponent(ProfileButton)
                                                        .addGap(28, 28, 28)
                                                        .addComponent(ResetButton))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(60, 60, 60)
                                                        .addComponent(leaderBoardButton1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 104,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap(56, Short.MAX_VALUE))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(111, Short.MAX_VALUE)
                                .addComponent(MatchPanle, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(timerLabel)
                                                .addComponent(Timer)
                                                .addComponent(leaderBoardButton1))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(17, 17, 17)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(ScoreP)
                                                                .addComponent(ShowScore)))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                        .createSequentialGroup()
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(ResetButton)
                                                                .addComponent(ProfileButton))))
                                        .addContainerGap(260, Short.MAX_VALUE))));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn02MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn02MouseClicked
        Collections.shuffle(shuffledIndices);

        handleButtonClick(btn02, 2, next.get(valB2));
        System.out.println("valB  " + valB2);

    }// GEN-LAST:event_btn02MouseClicked

    private void btn03MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn03MouseClicked
        handleButtonClick(btn03, 3, next.get(valB3));
        System.out.println("valB3  " + valB3);
    }// GEN-LAST:event_btn03MouseClicked

    private void btn03ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn03ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn03ActionPerformed

    private void btn04MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn04MouseClicked
        handleButtonClick(btn04, 4, next.get(valB4));
        System.out.println("valB4  " + valB4);
    }// GEN-LAST:event_btn04MouseClicked

    private void btn05MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn05MouseClicked
        handleButtonClick(btn05, 5, next.get(valB5));
        System.out.println("valB5  " + valB5);
    }// GEN-LAST:event_btn05MouseClicked

    private void btn06MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn06MouseClicked
        handleButtonClick(btn06, 6, next.get(valB6));
        System.out.println("valB6  " + valB6);
    }// GEN-LAST:event_btn06MouseClicked

    private void btn07MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn07MouseClicked
        handleButtonClick(btn07, 7, next.get(valB7));
        System.out.println("valB7  " + valB7);
    }// GEN-LAST:event_btn07MouseClicked

    private void btn08MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn08MouseClicked
        handleButtonClick(btn08, 8, next.get(valB8));
        System.out.println("valB8  " + valB8);
    }// GEN-LAST:event_btn08MouseClicked

    private void btn01MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn01MouseClicked
        handleButtonClick(btn01, 1, next.get(valB1));
        System.out.println("valB1  " + valB1);
    }// GEN-LAST:event_btn01MouseClicked

    private void leaderBoardButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_leaderBoardButton1ActionPerformed
        new LeaderBoard().setVisible(true);
    }// GEN-LAST:event_leaderBoardButton1ActionPerformed

    private void ProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ProfileButtonActionPerformed
        new Profile(user).setVisible(true);
        
    }// GEN-LAST:event_ProfileButtonActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ResetButtonActionPerformed
        resetGame();
    }// GEN-LAST:event_ResetButtonActionPerformed

    private void btn01ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn01ActionPerformed
        
    }// GEN-LAST:event_btn01ActionPerformed

    /**
     * @param args the command line arguments
     */
    // public static void main(String args[]) {

    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new MatchGame(tempUser).setVisible(true);
    //         }
    //     });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MatchPanle;
    private javax.swing.JButton ProfileButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JLabel ScoreP;
    private javax.swing.JLabel ShowScore;
    private javax.swing.JLabel timerLabel;
    public static Timer Timer;
    public static javax.swing.JButton btn01;
    public static javax.swing.JButton btn02;
    public static javax.swing.JButton btn03;
    public static javax.swing.JButton btn04;
    public static javax.swing.JButton btn05;
    public static javax.swing.JButton btn06;
    public static javax.swing.JButton btn07;
    public static javax.swing.JButton btn08;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton leaderBoardButton1;
    // End of variables declaration//GEN-END:variables
}
