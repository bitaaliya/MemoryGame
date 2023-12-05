package com.mycompany.memorygame.Controler;

import com.mycompany.memorygame.MatchGame;

public class CountDown extends Thread {
    private int time;
    private boolean isruning = true;       
    private Match matchControler;
    private MatchGame gameFrame;

    public CountDown(int time, Match matchControler, MatchGame gameFrame) {
        this.time = time;
        this.matchControler = matchControler;
        this.gameFrame = gameFrame;
    
    }

    public void run(){
        

        while (isruning && time > 0) {
           
            try {
                CountDown.sleep(1000);
                time--;
                gameFrame.setShowTime(String.format("%02d:%02d",0, time));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        if (time == 0) {
            matchControler.end();
            gameFrame.setShowTime("00:00");

            
        }
        else if (time<0) {
            gameFrame.setShowTime("01:00");

        }
    }

    public void interrupt(){
        isruning = false;
        time=0;
        gameFrame.setShowTime("01:00");
        
    }
}
