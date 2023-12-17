package com.mycompany.memorygame.Controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

import com.mycompany.memorygame.MatchGame;

public class Timer extends JLabel implements Runnable,utility {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/memorygame";
    static final String USER = "root";
    static final String PASS = "";

    private int seconds;
    private int minutes;

    public static boolean isTimesUp = false;

    public static int secondCounter = 0;
    private Thread t = new Thread(this);
    private MatchGame matchGame;
    private ImageController imageController;

    private int score = 0; // Menambahkan variabel score
    private static final int WAKTU_AWAL = 60;
    private static final int SCORE_PER_GAME = 8;

    public Timer(MatchGame matchGame) {
        super("01:00");
        this.matchGame = matchGame;
    }

    public void start() {
        isTimesUp = false;
        secondCounter = 0;
        score = 0; // Reset score saat timer dimulai
        t.start();
    }

    @Override
    public void run() {
        seconds = 60;
        while (true) {
            try {
                Thread.sleep(1000);
                seconds--;
                secondCounter++;
                // System.out.println(secondCounter+" detik");
                minutes = seconds / 60;
                String time = String.format("%02d:%02d", getMinutes(), getSeconds() % 60);
                setText(time);
                if (seconds == 0) {
                    hitungScore(); // Hitung skor saat waktu habis
                    reset();
                    this.matchGame.resetGame();
                    // imageController.setStartImage();
                    isTimesUp = true;
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Time out!!!");
                break;
            }
        }
    }

    void hitungScore() {
        // Hitung skor berdasarkan rumus yang telah dibahas sebelumnya
        score = SCORE_PER_GAME * seconds;
        System.out.println("Skor Anda: " + score);
    }

    void simpanScore(String username) {
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/memorygame", "root", "");

        String sql = "INSERT INTO player(username, pass, score, round) VALUES (?, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, PASS);
        pstmt.setInt(3, score);
        pstmt.setInt(4, 0);
        pstmt.executeUpdate();

    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
    @Override
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }
    public int getScore() {
        return score;
    }    

    public void reset() {
        
        t.interrupt();
        
        isTimesUp = false;
        t = new Thread(this);
        seconds = 60;
        setText("01:00");
        // matchGame.resetGame();
    }

 
}
