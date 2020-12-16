
package bdc_kemia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Bende Attila
 */
public class Bdc_kemia {
    
    //lista
    static ArrayList<Elemek> elemLista = new ArrayList<>();
    
    public static void main(String[] args) {
        // beolvasás
        try 
        {
            FileReader fajl = new FileReader("felfedezesek.csv");
            BufferedReader br = new BufferedReader(fajl);
            String sor = br.readLine(); // az első sor beolvasása
            while ((sor = br.readLine()) != null)
            {                
                String[] d = sor.split(";");
                int evszam = 0;
                if(!d[0].equals("Ókor"))
                {
                    evszam = Integer.parseInt(d[0]);
                }
                Elemek e = new Elemek(evszam,d[1],d[2],d[3],d[4]);
                elemLista.add(e);
            }
            br.close();
            fajl.close();
            System.out.println("Beolvasva :)");
            
        } 
        catch (Exception e) 
        {
            System.out.println("Hiba: " + e);
        }
        
        System.out.println("3. feladat");
        System.out.println("Kémiai elemek száma: " + elemLista.size());
        
        System.out.println("4. feladat");
        int dbOkor = 0;
        for (Elemek elem : elemLista) {
            if(elem.getEv() == 0)
            {
                dbOkor++;
            }
        }
        System.out.println("Az ókorban felfedezett elemek száma: " + dbOkor);
        
        System.out.println("5. feladat");
        Scanner be = new Scanner(System.in);
        String vegyjel = "";
        boolean jo = false;
        do
        {
            System.out.println("Kérek egy vegyjelet!");
            vegyjel = be.next();
            if(vegyjel.matches("[a-zA-Z]{2}"))
                jo = true;
        }while(jo == false);
        
        boolean megvan = false;
        int index = 0;
        while(megvan == false && index < elemLista.size()) {
           if(vegyjel.equals(elemLista.get(index).getVegyjel()))
           {
               megvan = true;
               System.out.println(elemLista.get(index).getNev());
               System.out.println(elemLista.get(index).getEv());
               //többi adat lekérése
           }
           index++;
        }
        if(megvan == false)
            System.out.println("Nincs ilyen elem!");
        
        System.out.println("7. feladat");
        int maxEvKul = 0;
        for (int i = 1; i < elemLista.size(); i++) {
            if(elemLista.get(i-1).getEv() != 0)
            {
                int kulonbseg = elemLista.get(i).getEv() - elemLista.get(i-1).getEv();
                if(kulonbseg > maxEvKul)
                    maxEvKul = kulonbseg;
            }
        }
        System.out.println("A legnagyobb különbség: " + maxEvKul);
        
        System.out.println("8. feladat");
        ArrayList<Integer> evszamok = new ArrayList<>();
        ArrayList<Integer> evDarab = new ArrayList<>();
        //az évszámok kigyűjtése
        for (Elemek elem : elemLista) {
            if(!evszamok.contains(elem.getEv()) && elem.getEv() != 0)
            {
                evszamok.add(elem.getEv());
            }
        }
        System.out.println(evszamok);
        for (int i = 0; i < evszamok.size(); i++) {
            int db = 0;
            for (int j = 0; j < elemLista.size(); j++) {
                if(evszamok.get(i) == elemLista.get(j).getEv())
                    db++;
            }
            evDarab.add(db);
        }
        System.out.println(evDarab);
        for (int i = 0; i < evDarab.size(); i++) {
            if(evDarab.get(i) > 3)
            {
                System.out.println(evszamok.get(i) + ": " + evDarab.get(i));
            }
        }
    }
    
}
