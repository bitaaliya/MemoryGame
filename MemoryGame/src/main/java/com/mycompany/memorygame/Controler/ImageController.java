package com.mycompany.memorygame.Controler;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.mycompany.memorygame.MatchGame;

public class ImageController implements Runnable {

    private MatchGame matchGame;

    private List<MatchController> match = new ArrayList<>();
    protected List<MatchController> ok = new ArrayList<>();
    
    private int score;
    protected int round;
    private volatile boolean isRunning = true;


    @Override
    public void run() {
        while (isRunning) {


            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SwingUtilities.invokeLater(() -> {
                MatchGame.Timer.hitungScore();

            });
        }
    }

    public void stopRunning() {
        isRunning = false;
    }

    public void setMatchGame(MatchGame matchGame) {
        this.matchGame = matchGame;
        
    }

    public static List<Integer> rowsTable() {
        List<Integer> list = new ArrayList<>();
        Random r = new Random();
        int aument = 1;
        for (int i = 0; i < aument; i++) {
            if (list.size() != 4) {
                aument++;
            }
            int value = r.nextInt(5);
            if (!list.contains(value) && list.size() != 5 && value != 0) {
                list.add(value);
            }
        }
        return list;
    }

    public static List<Integer> rowsTableAll() {
        List<Integer> all = new ArrayList<>();
        List<Integer> firstSet = rowsTable();
        List<Integer> secondSet = rowsTable();

        all.addAll(firstSet);
        all.addAll(secondSet);

        // Shuffle the combined list
        Collections.shuffle(all);

        return all;
    }

    public void setStartImage() {

        MatchGame.btn01.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        MatchGame.btn02.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        MatchGame.btn03.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        MatchGame.btn04.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        MatchGame.btn05.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        MatchGame.btn06.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        MatchGame.btn07.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        MatchGame.btn08.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));

    }

    public void setImages(JButton buttons, int value) {

        try {

            buttons.setIcon(
                    new ImageIcon(getClass().getResource("/com/mycompany/memorygame/Dataset/0" + value + ".png")));

            buttons.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            buttons.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void paintMatch() {
        System.out.println(getMatch().size());
        if (getMatch().size() == 1) {
            setImages(getMatch().get(0).getBtn(), getMatch().get(0).getValueMatch());
        } else if (getMatch().size() == 2) {
            setImages(getMatch().get(1).getBtn(), getMatch().get(1).getValueMatch());
        }
    }

    // METODE DI MANA GAMBAR SUDAH MEMBUAT MATCH
    public void setStartImageMatch() {
        round = 0;
        // this.timer.start();
        if (ok.size() == 8) {
            MatchGame.Timer.hitungScore();
            MatchGame.Timer.getScore();
            score = MatchGame.Timer.getScore();
            System.out.println("Skor Anda: " + score);
            matchGame.setShowScore(score);
            matchGame.setHighScore(score);
            matchGame.resetGame();
            MatchGame.Timer.reset(); 
            round++;
            System.out.println("Round: " + round);
            matchGame.setRound(round);
            
            // Menampilkan notifikasi "Win Player" bersamaan dengan skor
            JOptionPane.showMessageDialog(null, "Win Player\nSkor Anda: " + MatchGame.Timer.getScore());
            
            for (int i = 0; i < ok.size(); i++) {
                setImages(ok.get(i).getBtn(), ok.get(i).getValueMatch());
                ok.get(i).getBtn().setEnabled(true);
            }
            ok.clear();
            setStartImage(); // set start();
        }
        for (int i = 0; i < ok.size(); i++) {
            System.out.println(ok.get(i).getNumberBtn() + "_" + ok.get(i).getValueMatch());
            setImages(ok.get(i).getBtn(), ok.get(i).getValueMatch());
            ok.get(i).getBtn().setEnabled(false);
        }
    }

    // METODE YANG MENGONTROL EKSEKUSI
    public void filpBack() {
        rowsTableAll();
        setStartImage();
        setStartImageMatch();
    }

    public void reset() {
        getMatch().clear();
        this.score = 0;
        matchGame.shuffleValues();
        for (int i = 0; i < ok.size(); i++) {
            setImages(ok.get(i).getBtn(), ok.get(i).getValueMatch());
            ok.get(i).getBtn().setEnabled(true);
        }
        ok.clear();
        setStartImage();

        for (int i = 0; i < ok.size(); i++) {
            System.out.println(ok.get(i).getNumberBtn() + "_" + ok.get(i).getValueMatch());
            setImages(ok.get(i).getBtn(), ok.get(i).getValueMatch());
            ok.get(i).getBtn().setEnabled(false);
        }
        
        setStartImageMatch();

    }

    // METODE PEMADAN
    public void match() {
        if (getMatch().size() == 2) {
            if (getMatch().get(0).getNumberBtn() != 0 && getMatch().get(1).getNumberBtn() != 0) {
                if (getMatch().get(0).getValueMatch() == getMatch().get(1).getValueMatch()) {
                    ok.add(getMatch().get(0));
                    ok.add(getMatch().get(1));
                    getMatch().clear();
                    filpBack();
                } else {
                    Runnable mx = new Runnable() {
                        @Override
                        public void run() {
                            getMatch().clear();
                            filpBack();
                        }
                    };
                    setTimeout(mx, 2000);
                }
            }
        }
    }

    public void setTimeout(Runnable runnable, int delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            } catch (Exception e) {
                System.err.println(e);
            }
        }).start();
    }

    public List<MatchController> getMatch() {
        return match;

    }

    public void setMatch(List<MatchController> match) {
        this.match = match;
    }

}