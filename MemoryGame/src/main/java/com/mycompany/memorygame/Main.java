
// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  */

package com.mycompany.memorygame;

// /**
//  *
//  * @author HP
//  */
// public class Main {

//     public static void main(String[] args) {
//         new Login().setVisible(true);
//     }
// }
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> variableList = new ArrayList<>();
        variableList.add("variabel1");
        variableList.add("variabel2");
        variableList.add("variabel3");
        variableList.add("variabel4");
        variableList.add("variabel5");
        variableList.add("variabel6");
        variableList.add("variabel7");
        variableList.add("variabel8");

        List<Integer> shuffledIndices = new ArrayList<>();
        for (int i = 0; i < variableList.size(); i++) {
            shuffledIndices.add(i);
        }
        Collections.shuffle(shuffledIndices);

        Map<String, Integer> variableValues = new HashMap<>();

        int valB1 = getValue(variableList.get(0), shuffledIndices, variableValues);
        int valB2 = getValue(variableList.get(1), shuffledIndices, variableValues);
        int valB3 = getValue(variableList.get(2), shuffledIndices, variableValues);
        int valB4 = getValue(variableList.get(3), shuffledIndices, variableValues);
        int valB5 = getValue(variableList.get(4), shuffledIndices, variableValues);
        int valB6 = getValue(variableList.get(5), shuffledIndices, variableValues);
        int valB7 = getValue(variableList.get(6), shuffledIndices, variableValues);
        int valB8 = getValue(variableList.get(7), shuffledIndices, variableValues);

        System.out.println("valB1: " + valB1);
        System.out.println("valB2: " + valB2);
        System.out.println("valB3: " + valB3);
        System.out.println("valB4: " + valB4);
        System.out.println("valB5: " + valB5);
        System.out.println("valB6: " + valB6);
        System.out.println("valB7: " + valB7);
        System.out.println("valB8: " + valB8);
    }

    private static int getValue(String variable, List<Integer> shuffledIndices, Map<String, Integer> variableValues) {
        int index;
        do {
            index = shuffledIndices.remove(0);
        } while (variableValues.containsValue(index));

        variableValues.put(variable, index);
        return index;
    }
}
