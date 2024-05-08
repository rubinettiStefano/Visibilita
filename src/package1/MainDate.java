package package1;

import java.util.ArrayList;
import java.util.Scanner;

import utility.Data;

public class MainDate
{

    public static void main(String[] args) 
    {

        // Data d1 = new Data(12,8,2024);    
        // System.out.println(d1);
        Scanner term = new Scanner(System.in);
        System.out.println("Inserisci la data per intero");
        String dataTest = term.nextLine();
        System.out.println("Inserisci il formato della data che hai inserito");
        String format = term.nextLine();
        ArrayList<Integer> valori = Data.estraiValoriSingoli(dataTest, format);

        System.out.println("Inserisci il formato che vuoi ottenere");
        String formatUscita = term.nextLine();

        Data conv = new Data(valori.get(0), valori.get(1), valori.get(2),formatUscita);



        System.out.println(conv);
    }
}
