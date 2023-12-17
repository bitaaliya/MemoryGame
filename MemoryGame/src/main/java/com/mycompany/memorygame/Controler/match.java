package com.mycompany.memorygame.Controler;

import javax.swing.JButton;

public abstract class match {

    public match() {
        
    }


    public abstract void setNumberBtn(int numberBtn);

    public abstract int getNumberBtn();

    public abstract void setBtn(JButton btn);

    public abstract JButton getBtn();

    public abstract void setValueMatch(int valueMatch);

    public abstract int getValueMatch();



}
