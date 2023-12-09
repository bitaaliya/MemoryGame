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
import javax.swing.text.Utilities;

import com.mycompany.memorygame.Controler.ImageController;
import com.mycompany.memorygame.Controler.MatchController;

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
    
    private ImageController imageController = new ImageController();;

    List<Integer> next = ImageController.rowsTableAll();

    public MatchGame(String user) {
        initComponents();
        List<JButton> buttons = Arrays.asList(btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09, btn10, btn11, btn12);
        // imageController.setStartImage(buttons);
        this.setLocationRelativeTo(this);
        imageController.setStartImage(buttons);

    }

    public void setShowTime(String text) {
        this.ShowTime.setText(text);
    }

    public void setRound(int round) {
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

    public void setShowScore(int score) {
        String text = Integer.toString(score);
        this.ShowScore.setText(text);

    }
    @SuppressWarnings("unchecked")
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
        ProfileButton = new javax.swing.JButton();
        leaderBoardButton1 = new javax.swing.JButton();
        TimerL = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ResetButton = new javax.swing.JButton();

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
                                .addGroup(MatchPanleLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MatchPanleLayout.createSequentialGroup()
                                                .addGroup(MatchPanleLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btn01, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btn05, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(MatchPanleLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(MatchPanleLayout.createSequentialGroup()
                                                                .addComponent(btn02,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btn03,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btn04,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(MatchPanleLayout.createSequentialGroup()
                                                                .addComponent(btn06,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btn07,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btn08,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(MatchPanleLayout.createSequentialGroup()
                                                .addComponent(btn09, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12,
                                        Short.MAX_VALUE)
                                .addGroup(
                                        MatchPanleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btn09, javax.swing.GroupLayout.Alignment.TRAILING,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 99,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btn10, javax.swing.GroupLayout.Alignment.TRAILING,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 99,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btn11, javax.swing.GroupLayout.Alignment.TRAILING,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 99,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btn12, javax.swing.GroupLayout.Alignment.TRAILING,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 99,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap()));

        ScoreP.setBackground(new java.awt.Color(0, 0, 0));
        ScoreP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ScoreP.setText("Score:");
        ScoreP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ProfileButton.setBackground(new java.awt.Color(0, 255, 51));
        ProfileButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ProfileButton.setForeground(new java.awt.Color(255, 255, 255));
        ProfileButton.setText("Profile");
        ProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileButtonActionPerformed(evt);
            }
        });

        leaderBoardButton1.setBackground(new java.awt.Color(255, 51, 51));
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
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(MatchPanle, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(ScoreP,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(ShowScore,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(TimerL,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(ShowTime,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(29, 29, 29)
                                                                .addComponent(ProfileButton)
                                                                .addGap(28, 28, 28)
                                                                .addComponent(ResetButton))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(62, 62, 62)
                                                                .addComponent(leaderBoardButton1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 104,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TimerL)
                                        .addComponent(ShowTime)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(leaderBoardButton1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(ScoreP)
                                                        .addComponent(ShowScore)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(ResetButton)
                                                        .addComponent(ProfileButton))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MatchPanle, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(12, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ProfileButtonActionPerformed
        // new LeaderBoard().setVisible(true);
        
    }// GEN-LAST:event_ProfileButtonActionPerformed

    private void leaderBoardButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_leaderBoardButton1ActionPerformed
        // new Profile().setVisible(true);
    }// GEN-LAST:event_leaderBoardButton1ActionPerformed

    private void btn01MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn01MouseClicked
        MatchController matchController = new MatchController();
        matchController.setBtn(btn01);
        matchController.setNumberBtn(1);
        matchController.setValueMatch(next.get(0));
        imageController.getMatch().add(matchController);
        imageController.paintMatch();
        imageController.match();
    }// GEN-LAST:event_btn01MouseClicked

    private void btn08MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn08MouseClicked
        
        MatchController matchController = new MatchController();
        matchController.setBtn(btn08);
        matchController.setNumberBtn(8);
        matchController.setValueMatch(next.get(7));
        imageController.getMatch().add(matchController);
        imageController.paintMatch();
        imageController.match();

    }// GEN-LAST:event_btn08MouseClicked

    private void btn07MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn07MouseClicked
        MatchController matchController = new MatchController();
        matchController.setBtn(btn07);
        matchController.setNumberBtn(7);
        matchController.setValueMatch(next.get(6));
        imageController.getMatch().add(matchController);
        imageController.paintMatch();
        imageController.match();

    }// GEN-LAST:event_btn07MouseClicked

    private void btn06MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn06MouseClicked
        MatchController matchController = new MatchController();
        matchController.setBtn(btn06);
        matchController.setNumberBtn(6);
        matchController.setValueMatch(next.get(5));
        imageController.getMatch().add(matchController);
        imageController.paintMatch();
        imageController.match();

    }// GEN-LAST:event_btn06MouseClicked

    private void btn05MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn05MouseClicked
        MatchController matchController = new MatchController();
        matchController.setBtn(btn05);
        matchController.setNumberBtn(5);
        matchController.setValueMatch(next.get(4));
        imageController.getMatch().add(matchController);
        imageController.paintMatch();
        imageController.match();

    }// GEN-LAST:event_btn05MouseClicked

    private void btn04MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn04MouseClicked
        MatchController matchController = new MatchController();
        matchController.setBtn(btn04);
        matchController.setNumberBtn(4);
        matchController.setValueMatch(next.get(3));
        imageController.getMatch().add(matchController);
        imageController.paintMatch();
        imageController.match();

    }// GEN-LAST:event_btn04MouseClicked

    private void btn03MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn03MouseClicked
        MatchController matchController = new MatchController();
        matchController.setBtn(btn03);
        matchController.setNumberBtn(3);
        matchController.setValueMatch(next.get(2));
        imageController.getMatch().add(matchController);
        imageController.paintMatch();
        imageController.match();

    }// GEN-LAST:event_btn03MouseClicked

    private void btn09MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn09MouseClicked
        MatchController matchController = new MatchController();
        matchController.setBtn(btn09);
        matchController.setNumberBtn(9);
        matchController.setValueMatch(next.get(8));
        imageController.getMatch().add(matchController);
        imageController.paintMatch();
        imageController.match();


    }// GEN-LAST:event_btn09MouseClicked

    private void btn02MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn02MouseClicked
        MatchController matchController = new MatchController();
        matchController.setBtn(btn02);
        matchController.setNumberBtn(2);
        matchController.setValueMatch(next.get(1));
        imageController.getMatch().add(matchController);
        imageController.paintMatch();
        imageController.match();


    }// GEN-LAST:event_btn02MouseClicked

    private void btn10MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn10MouseClicked
        MatchController matchController = new MatchController();
        matchController.setBtn(btn10);
        matchController.setNumberBtn(10);
        matchController.setValueMatch(next.get(9));
        imageController.getMatch().add(matchController);
        imageController.paintMatch();
        imageController.match();
    }// GEN-LAST:event_btn10MouseClicked

    private void btn11MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn11MouseClicked
        MatchController matchController = new MatchController();
        matchController.setBtn(btn11);
        matchController.setNumberBtn(11);
        matchController.setValueMatch(next.get(10));
        imageController.getMatch().add(matchController);
        imageController.paintMatch();
        imageController.match();

    }// GEN-LAST:event_btn11MouseClicked

    private void btn12MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn12MouseClicked
        MatchController matchController = new MatchController();
        matchController.setBtn(btn12);
        matchController.setNumberBtn(12);
        matchController.setValueMatch(next.get(11));
        imageController.getMatch().add(matchController);
        imageController.paintMatch();
        imageController.match();
    }// GEN-LAST:event_btn12MouseClicked

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ResetButtonActionPerformed

    }

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
    private javax.swing.JButton ProfileButton;
    private javax.swing.JButton ResetButton;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton leaderBoardButton1;
    // End of variables declaration//GEN-END:variables
}
