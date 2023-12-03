package com.mycompany.memorygame.Controler;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageController {
    private String[] dataset; // Array untuk menyimpan lokasi gambar di dataset

    public ImageController(String[] dataset) {
        this.dataset = dataset;
    }

    public int getDatasetLength() {
        // System.out.println(dataset.length);
        return dataset.length;
    }

    // Fungsi untuk mengatur gambar pada button
    public void setStartButtonImage(JButton button, int index) {
        // Pastikan index berada dalam rentang dataset
        if (index >= 0 && index < dataset.length) {
            String imagePath = dataset[index];
            ImageIcon icon = new ImageIcon(imagePath);
            button.setIcon(icon);
        }
    }

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
}
