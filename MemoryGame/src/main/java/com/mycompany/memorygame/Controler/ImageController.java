package com.mycompany.memorygame.Controler;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImageController {
    private List<Integer> imageIndices;
    private List<ImageIcon> images;
    private int currentIndex;

    public ImageController() {
        
        imageIndices = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            imageIndices.add(i);
            imageIndices.add(i); 
        }

        Collections.shuffle(imageIndices);

        images = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            images.add(new ImageIcon("PBO/proyek/MemoryGame/src/main/java/com/mycompany/memorygame/Dataset/0" + imageIndices.get(i) + ".png"));
        }

        currentIndex = 0;
    }   

    public void setStartImage(List<JButton> buttons) {
        ImageIcon startImage = new ImageIcon("PBO/proyek/MemoryGame/src/main/java/com/mycompany/memorygame/Controler/StartImage.png");
    
        for (JButton button : buttons) {
            button.setIcon(startImage);
            button.setEnabled(true); 
            button.addActionListener(e -> handleButtonClick(button)); 
        }
    }
    

    public void setImages(List<JButton> buttons) {
        for (JButton button : buttons) {
            setNextImage(button);
        }
    }

    private void setNextImage(JButton button) {
        button.setIcon(images.get(currentIndex));
        currentIndex++;
    }

    private void handleButtonClick(JButton button) {
        setNextImage(button);
    }
    
}
