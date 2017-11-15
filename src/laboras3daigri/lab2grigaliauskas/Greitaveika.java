/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboras3daigri.lab2grigaliauskas;

import java.util.*;
import laborai.studijosktu.Ks;

/**
 *
 * @author Laptopas
 */
public class Greitaveika {

    static int[] sampleSize = {50, 1000, 5000};

    void goThroughArrayWithSqrt(double[] x, int numberOfElements) {
        for (int i = 0; i < numberOfElements; i++) {
            Math.pow(x[i], 1.0 / 3);
        }
    }

    void goThroughArrayWithHypot(double[] x, int numberOfElements) {
        for (int i = 0; i < numberOfElements; i++) {
            Math.cbrt(x[i]);
        }
    }

    void powVsCbrt(int numberOfElements) {

        long t0 = System.nanoTime();
        double x[] = generateDoubles(numberOfElements);
        long t1 = System.nanoTime();
        System.gc();
        System.gc();
        System.gc();
        long t2 = System.nanoTime();
        goThroughArrayWithSqrt(x, numberOfElements);
        long t3 = System.nanoTime();
        goThroughArrayWithHypot(x, numberOfElements);
        long t4 = System.nanoTime();

        Ks.ouf("%7d %7.4f %7.4f %7.4f %7.4f \n", numberOfElements,
                (t1 - t0) / 1e9, (t2 - t1) / 1e9, (t3 - t2) / 1e9,
                (t4 - t3) / 1e9);
    }

    double[] generateDoubles(int numberOfElements) {
        double[] temp = new double[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            temp[i] = ValueGenerator.randomPrice();
        }
        return temp;
    }
    
     int[] generateIntegeres(int numberOfElements) {
        int[] temp = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            temp[i] = ValueGenerator.randomSerialNumber();
        }
        return temp;
    }

    ArrayList<Double> generateIntegeresToArrayList(int numberOfElements, double numbers[]) {
        ArrayList<Double> arrayList = new ArrayList<Double>();
        for (int i = 0; i < numberOfElements; i++) {
            arrayList.add(numbers[i]);
        }
        return arrayList;
    }

    LinkedList<Double> generateIntegeresToLinkedList(int numberOfElements, double numbers[]) {
        LinkedList<Double> linkedList = new LinkedList<Double>();
        for (int i = 0; i < numberOfElements; i++) {
            linkedList.add(numbers[i]);
        }
        return linkedList;
    }

    void astuntosUzduotiesTyrimas(int numberOfElements) {

        long t0 = System.nanoTime();
        double numbers[] = generateDoubles(numberOfElements);
        long t1 = System.nanoTime();
        ArrayList<Double> arrayList = generateIntegeresToArrayList(numberOfElements, numbers);
        long t2 = System.nanoTime();
        LinkedList<Double> linkedList = generateIntegeresToLinkedList(numberOfElements, numbers);
        long t3 = System.nanoTime();
        System.gc();
        System.gc();
        System.gc();
        long t4 = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            arrayList.containsAll(linkedList);
        }
        long t5 = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            linkedList.containsAll(arrayList);
        }
        long t6 = System.nanoTime();
        Ks.ouf("%7d %7.4f %7.4f %7.4f %7.4f %7.4f %7.4f \n", numberOfElements,
                (t1 - t0) / 1e9, (t2 - t1) / 1e9, (t3 - t2) / 1e9,
                (t4 - t3) / 1e9, (t5 - t4) / 1e9, (t6 - t5) / 1e9);
    }

    void analysis() {
        Ks.ouf("");
        Ks.oun("1 - Generuojami duomenys");
        Ks.oun("2 - Pasiruošimas tyrimui - šiukšlių surinkimas");
        Ks.oun("3 - Prabegame pro duomenis su sqrt");
        Ks.oun("4 - Prabegame pro duomenis su cbrt");
        for (int n : sampleSize) {
            powVsCbrt(n);
        }
        Ks.ouf("");
        Ks.oun("1 - Generuojami duomenys");
        Ks.oun("2 - duomenis sudedame i arraylista");
        Ks.oun("3 - duomenis sudedame i linkedlista");
        Ks.oun("4 - Pasiruošimas tyrimui - šiukšlių surinkimas");
        Ks.oun("5 - tiriam greiti arrayliste");
        Ks.oun("6 - tiriam greiti linkedliste");
        for (int n : sampleSize) {
            astuntosUzduotiesTyrimas(n);
        }
    }

    public static void main(String[] args) {
        // suvienodiname skaičių formatus pagal LT lokalę (10-ainis kablelis)
        Locale.setDefault(new Locale("LT"));
        new Greitaveika().analysis();
    }
}
