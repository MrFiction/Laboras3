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
public class Test {

    final static int sampleSize = 10;
    private ValueGenerator gen = new ValueGenerator();
    Random rndInt = new Random();
    //ListKTUx<kazkas> testList = new ListKTUx<>(new kazkas());
    List<kazkas> halfList = new LinkedList<>();

    static kazkas[] set;
    static SortedSetADTx<kazkas> aSerija = new BstSetKTUx(new kazkas(), kazkas.byPrice);

     static SortedSetADTx<kazkas> generuotiAibe(int kiekis, int generN) {
        set = new kazkas[generN];
        for (int i = 0; i < generN; i++) {
            set[i] = ValueGenerator.randomObject();
        }
        Collections.shuffle(Arrays.asList(set));
        aSerija.clear();
        for (int i = 0; i < kiekis; i++) {
            aSerija.add(set[i]);
        }
        return aSerija;
    }
   
    
    public static void Testing() throws CloneNotSupportedException{
        kazkas item1 = new kazkas(1000.2, ValueGenerator.randomDate(), "1st57275", 20714410);
        kazkas item2 = ValueGenerator.randomObject();
        kazkas item3 = ValueGenerator.randomObject();
        kazkas item4 = ValueGenerator.randomObject();
        kazkas item5 = ValueGenerator.randomObject();
        kazkas item6 = ValueGenerator.randomObject();
        
        kazkas[] itemArray = {item1, item2, item3, item4, item5, item6};
        
        Ks.oun("Įrašų Aibė:");
        BstSetKTUx<kazkas> Set = new BstSetKTUx(new kazkas());
        
        Collections.shuffle(Arrays.asList(itemArray));

        for (kazkas a : itemArray) {
            Set.add(a);
            Ks.oun("Aibė papildoma: " + a + ". Jos dydis: " + Set.size());
        }
        kazkas record8 = ValueGenerator.randomObject();
        Set.add(record8);
        Ks.oun(Set.toVisualizedString(""));
            SortedSetADTx<kazkas> autoAibeKopija
                = (SortedSetADTx<kazkas>) Set.clone();
        Ks.oun("Kopija: ");
        Ks.oun(autoAibeKopija);
        item5.setPrice(66.66);
        Ks.oun(autoAibeKopija);
        Ks.oun(Set);
     //
        BstSetKTUx<kazkas> test = new BstSetKTUx(new kazkas());
        test.add(item1);
        test.add(item5);
        test.add(ValueGenerator.randomObject());
        
        Ks.oun(Set.toVisualizedString(""));
        Ks.oun(item4);


        Ks.oun("floor test: ");
        Ks.oun(Set.floor(item4));
        Ks.oun("----------------");
        Ks.oun(test);
        Ks.oun(Set);

        Ks.oun("containsAll test: ");
        Ks.oun(test.containsAll(Set));
        Ks.oun("----------------");

        Ks.oun(Set.toVisualizedString(""));
        Ks.oun(item5);
        Ks.oun("----------------");
        
        Ks.oun("headset test: ");
        Ks.oun(Set.headSet(item3, true));
        
        Ks.oun("higher test: ");
        Ks.oun(test.higher(item3));
        Ks.oun("----------------");
        
        Ks.oun("pollLast test: ");
        Ks.oun(test.pollLast());
        Ks.oun("----------------");

    }
    
  

     public static void main(String[] args) throws CloneNotSupportedException{
        Locale.setDefault(Locale.US);
        Testing();
        
    }

}
