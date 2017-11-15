/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboras3daigri.lab2grigaliauskas;

import java.util.*;
import laborai.studijosktu.*;

/**
 *
 * @author Laptopas
 */
public class Lab2Grigaliauskas {

    final static int sampleSize = 10;
    private ValueGenerator gen = new ValueGenerator();
    Random rndInt = new Random();
    ListKTUx<kazkas> testList = new ListKTUx<>(new kazkas());
    List<kazkas> halfList = new LinkedList<>();

    void test() {
        generate();
        //testAdd();
        //testAddFirst();
    }

    void generate() {
        for (int i = 0; i < sampleSize / 2; i++) {
            kazkas obj = randomObject();
            testList.add(obj);
            if (i % 2 == 0) {
                halfList.add(obj);
            }
        }
        for (int i = 0; i < sampleSize / 2; i++) {
            String dataString = Double.toString(ValueGenerator.randomPrice()) + " " + ValueGenerator.randomDate().toString() + " " + ValueGenerator.generateString() + " " + Integer.toString(ValueGenerator.randomSerialNumber());
            testList.add(dataString);
            if (i % 2 == 0) {
                kazkas tObj = new kazkas();
                tObj.create(dataString);
                halfList.add(tObj);
            }
        }
    }

    void testAdd() {
        ListKTUx<kazkas> temporaryList = testList.clone();
        temporaryList.println("Stock list %n");
        System.out.println("add(int index, E e) %n");
        for (int i = 0; i < 4; i++) {
            kazkas tempObj = randomObject();
            int index = rndInt.nextInt(sampleSize);
            System.out.println(" index = " + index + " " + tempObj.toString());
            temporaryList.add(index, tempObj);
        }
        temporaryList.println("New list ");
    }

    void testAddFirst() {
        ListKTUx<kazkas> temporaryList = testList.clone();
        temporaryList.println("Stock list %n");
        System.out.println("addFirst(E e) %n");
        for (int i = 0; i < 4; i++) {
            kazkas tempObj = randomObject();
            System.out.println(tempObj.toString());
            temporaryList.addFirst(tempObj);
        }
        temporaryList.println("New list ");
    }

    void testRemove() {
        ListKTUx<kazkas> temporaryList = testList.clone();
        temporaryList.println("Stock list ");
        System.out.println("remove(int index) ");
        for (int i = 0; i < 4; i++) {
            int index = rndInt.nextInt(sampleSize);
            kazkas tempObj = temporaryList.remove(index);
            System.out.println(" index = " + index + " " + tempObj.toString());
        }
        temporaryList.println("New list ");
    }

    void testSet() {
        ListKTUx<kazkas> temporaryList = testList.clone();
        temporaryList.println("Stock list ");
        System.out.println("set(int index,E e) ");
        for (int i = 0; i < 4; i++) {
            kazkas tempObj = randomObject();
            int index = rndInt.nextInt(sampleSize);
            kazkas oldObj = temporaryList.set(index, tempObj);
            System.out.println(" index = " + index + " old object " + oldObj.toString() + "new objext " + tempObj.toString());
        }
        temporaryList.println("New list ");
    }

    void testLastIndexOf() {
        ListKTUx<kazkas> temporaryList = testList.clone();
        temporaryList.println("Stock list ");
        int objectIndexInTheList = rndInt.nextInt(temporaryList.size());
        kazkas tempObj = temporaryList.get(objectIndexInTheList);
        System.out.println("index that needs to be found :" + objectIndexInTheList);
        System.out.println("last index" + temporaryList.lastIndexOf(tempObj));
        tempObj = randomObject();
        System.out.println("index should not be found :" + objectIndexInTheList);
        System.out.println("last index" + temporaryList.lastIndexOf(tempObj));
    }

    void testRetainAll() {
        ListKTUx<kazkas> temporaryList = testList.clone();
        temporaryList.println("Stock list ");
        boolean worked = temporaryList.retainAll(halfList);
        System.out.println("Retain all worked: " + worked);
        temporaryList.println("New list ");
    }

    void testSort() {
        ListKTUx<kazkas> temporaryList = testList.clone();
        temporaryList.println("Stock list");
        temporaryList.sortBuble(kazkas.byManufacturingDate);
        temporaryList.println("Sorted by manifacturing date");
        temporaryList.sortBuble(kazkas.byPrice);
        temporaryList.println("Sorted by price");
    }

    kazkas randomObject() {
        return new kazkas(ValueGenerator.randomPrice(), ValueGenerator.randomDate(), ValueGenerator.generateString(), ValueGenerator.randomSerialNumber());
    }

    public static void main(String[] args) {
        new Lab2Grigaliauskas().test();
    }

}
