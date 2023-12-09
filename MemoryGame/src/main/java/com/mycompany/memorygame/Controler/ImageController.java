package com.mycompany.memorygame.Controler;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.mycompany.memorygame.MatchGame;
import com.mycompany.memorygame.Controler.MatchController;

public class ImageController {
    private List<Integer> imageIndices;
    private List<ImageIcon> images;
    // private int currentIndex;

    List<JButton> buttons = Arrays.asList(
            MatchGame.btn01, MatchGame.btn02, MatchGame.btn03, MatchGame.btn04,
            MatchGame.btn05, MatchGame.btn06, MatchGame.btn07, MatchGame.btn08,
            MatchGame.btn09, MatchGame.btn10, MatchGame.btn11, MatchGame.btn12);

    private List<MatchController> match = new ArrayList<>();
    private List<MatchController> ok = new ArrayList<>();

    public ImageController() {
        imageIndices = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            imageIndices.add(i);
            imageIndices.add(i);
        }

        Collections.shuffle(imageIndices);

        images = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            images.add(
                    new ImageIcon("src/main/java/com/mycompany/memorygame/Dataset/0" + imageIndices.get(i) + ".png"));
        }

    }

    public static List<Integer> rowsTable() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        int aument = 1;
        for (int i = 0; i < aument; i++) {
            if (list.size() != 4) {
                aument++;
            }
            int value = random.nextInt(6);
            if (!list.contains(value) && list.size() != 5 && value != 0) {
                list.add(value);
            }
        }
        return list;
    }

    public static List<Integer> rowsTableAll() {
        List<Integer> all = new ArrayList<>();
        all.addAll(rowsTable());
        all.addAll(rowsTable());
        return all;
    }

    public void setStartImage(List<JButton> buttons) {

        // ImageIcon startImage = new
        // ImageIcon("PBO/proyek/MemoryGame/src/main/java/com/mycompany/memorygame/Controler/StartImage.png");

        // for (JButton button : buttons) {
        // button.setIcon(startImage);
        // button.setEnabled(true);

        // }
        MatchGame.btn01.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        MatchGame.btn02.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        MatchGame.btn03.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        MatchGame.btn04.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        MatchGame.btn05.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        MatchGame.btn06.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        MatchGame.btn07.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        MatchGame.btn08.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        MatchGame.btn09.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        MatchGame.btn10.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        MatchGame.btn11.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        MatchGame.btn12.setIcon(new ImageIcon(getClass().getResource("StartImage.png")));
        // setImages(MatchGame.btn01, 9);
        // setImages(MatchGame.btn02, 9);
        // setImages(MatchGame.btn03, 9);
        // setImages(MatchGame.btn04, 9);
        // setImages(MatchGame.btn05, 9);
        // setImages(MatchGame.btn06, 9);
        // setImages(MatchGame.btn07, 9);
        // setImages(MatchGame.btn08, 9);
        // setImages(MatchGame.btn09, 9);
        // setImages(MatchGame.btn10, 9);
        // setImages(MatchGame.btn11, 9);
        // setImages(MatchGame.btn12, 9);

    }

    public void setImages(JButton buttons, int value) {
        try {
            buttons.setIcon(
                    new ImageIcon(getClass().getResource("src/main/java/com/mycompany/memorygame/Dataset/01.png")));
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
        if (ok.size() == 12) {
            JOptionPane.showMessageDialog(null, "Pemenang Pemain");

            for (int i = 0; i < ok.size(); i++) {
                setImages(ok.get(i).getBtn(), ok.get(i).getValueMatch());
                ok.get(i).getBtn().setEnabled(true);
            }
            ok.clear();
            setStartImage(buttons);
        }
        for (int i = 0; i < ok.size(); i++) {
            System.out.println(ok.get(i).getNumberBtn() + "_" + ok.get(i).getValueMatch());
            setImages(ok.get(i).getBtn(), ok.get(i).getValueMatch());
            ok.get(i).getBtn().setEnabled(false);
        }
    }

    // METODE YANG MENGONTROL EKSEKUSI
    public void reset() {
        rowsTableAll();
        setStartImage(buttons);
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
                    reset();
                } else {
                    Runnable mx = new Runnable() {
                        @Override
                        public void run() {
                            getMatch().clear();
                            reset();
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