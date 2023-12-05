package com.mycompany.memorygame.Controler;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.util.List;

public class MatchController {
    private ImageIcon hiddenImage; // The image used when the card is face-down
    private JButton firstButton; // The first button clicked
    private JButton secondButton; // The second button clicked

    public MatchController() {
        // Set the image for the face-down cards (you can customize this)
        hiddenImage = new ImageIcon("PBO/proyek/MemoryGame/src/main/java/com/mycompany/memorygame/Controler/HiddenImage.png");
        reset();
    }

    public void reset() {
        firstButton = null;
        secondButton = null;
    }

    public boolean isMatch(JButton button1, JButton button2) {
        ImageIcon icon1 = (ImageIcon) button1.getIcon();
        ImageIcon icon2 = (ImageIcon) button2.getIcon();

        // Implement your logic to check if the images match
        // For example, you might compare file paths or image indices

        return icon1.getDescription().equals(icon2.getDescription());
    }

    public void revealImage(JButton button) {
        button.setIcon(hiddenImage);
    }

    public void hideImage(JButton button) {
        button.setIcon(null);
    }

    public JButton getFirstButton() {
        return firstButton;
    }

    public JButton getSecondButton() {
        return secondButton;
    }

    public void setFirstButton(JButton button) {
        firstButton = button;
    }

    public void setSecondButton(JButton button) {
        secondButton = button;
    }

    public void end() {
    }
}
