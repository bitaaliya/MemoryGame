/*
 * Untuk mengubah header lisensi, pilih Header Lisensi di Properti Proyek.
 * Untuk mengubah file template ini, pilih Alat | Templat
 * dan buka templat di editor.
 */
package com.mycompany.memorygame.Controler;

import javax.swing.JButton;

/**
 *
 * Penulis: MSBENAVIDES
 */
public class MatchController  extends match  {

    private int numberBtn;
    private JButton btn;
    private int valueMatch;

    public MatchController() {


    }

    public MatchController(int numberBtn, JButton btn, int valueMatch) {

        this.numberBtn = numberBtn;
        this.btn = btn;
        this.valueMatch = valueMatch;

    }


    @Override    
    public int getNumberBtn() {
        return numberBtn;
    }

    @Override
    public void setNumberBtn(int numberBtn) {
        this.numberBtn = numberBtn;
    }

    @Override
    public JButton getBtn() {
        return btn;
    }

    @Override
    public void setBtn(JButton btn) {
        this.btn = btn;
    }
    @Override
    public int getValueMatch() {
        return valueMatch;
    }

    @Override
    public void setValueMatch(int valueMatch) {
        this.valueMatch = valueMatch;
    }

  


}
