package com.mycompany.memorygame.Controler;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.mycompany.memorygame.GameFrame;

public class ImageController {
    GameFrame gameFrame ;
    // private String[] dataset; // Array untuk menyimpan lokasi gambar di dataset

    private List<Match> match = new ArrayList<>();
    private List<Match> ok = new ArrayList<>();

    // METODE DI MANA NOMOR DIACAK PADA BARIS
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

    // METODE UNTUK MEMASUKKAN DUA BARIS
    public static List<Integer> rowsTableAll() {
        List<Integer> all = new ArrayList<>();
        all.addAll(rowsTable());
        all.addAll(rowsTable());
        return all;
    }

    // public ImageController(String[] dataset) {
    //     this.dataset = dataset;
    // }

    // public int getDatasetLength() {
    //     // System.out.println(dataset.length);
    //     return dataset.length;
    // }

    public void paintImage(JButton btn, int value) {
        try {
            btn.setIcon(new ImageIcon(getClass().getResource("/Images/0" + value + ".png")));
            btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            btn.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    // METODE YANG MEMULAI GAMBAR DI ?
    public void imgStart() {
        paintImage(GameFrame.btn01, 9);
        paintImage(GameFrame.btn02, 9);
        paintImage(GameFrame.btn03, 9);
        paintImage(GameFrame.btn04, 9);
        paintImage(GameFrame.btn05, 9);
        paintImage(GameFrame.btn06, 9);
        paintImage(GameFrame.btn07, 9);
        paintImage(GameFrame.btn08, 9);
        paintImage(GameFrame.btn09, 9);
    }

    // Fungsi untuk mengatur gambar pada button
    // public void setStartButtonImage(JButton button, int index) {
    //     // Pastikan index berada dalam rentang dataset
    //     if (index >= 0 && index < dataset.length) {
    //         String imagePath = dataset[index];
    //         ImageIcon icon = new ImageIcon(imagePath);
    //         button.setIcon(icon);
    //     }
    // }

    //  private void createGameButtons() {
    //     // Ganti dengan logika pembuatan button sesuai dengan jumlah yang diperlukan
    //     for (int i = 0; i < getDatasetLength() ; i++) {
    //         JButton button = new JButton();
    //         int index = i % getDatasetLength(); // Jika dataset kurang dari jumlah button
    //         setButtonImage(button, index);

    //         // Tambahkan button ke panel atau tempat yang sesuai di tampilan
    //         // Contoh: matchPanel.add(button);
    //     }
    // }

    public void paintMatch() {
        System.out.println(getMatch().size());
        if (getMatch().size() == 1) {
            paintImage(getMatch().get(0).getBtn(), getMatch().get(0).getValueMatch());
        } else if(getMatch().size() == 2) {
            paintImage(getMatch().get(1).getBtn(), getMatch().get(1).getValueMatch());
        }
    }
    
    // METODE DI MANA GAMBAR SUDAH MEMBUAT MATCH
    public void imgStartMatch() {
        if (ok.size() == 8) {
            JOptionPane.showMessageDialog(null, "Pemenang Pemain");

            for (int i = 0; i < ok.size(); i++) {
                paintImage(ok.get(i).getBtn(), ok.get(i).getValueMatch());
                ok.get(i).getBtn().setEnabled(true);
            }
            ok.clear();
            imgStart();
        }
        for (int i = 0; i < ok.size(); i++) {
            System.out.println(ok.get(i).getNumberBtn() + "_" + ok.get(i).getValueMatch());
            paintImage(ok.get(i).getBtn(), ok.get(i).getValueMatch());
            ok.get(i).getBtn().setEnabled(false);
        }
    }

    // METODE YANG MENGONTROL EKSEKUSI
    public void reset() {
        rowsTableAll();
        imgStart();
        imgStartMatch();
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

    public List<Match> getMatch() {
        return match;
    }

    public void setMatch(List<Match> match) {
        this.match = match;
    }
}
