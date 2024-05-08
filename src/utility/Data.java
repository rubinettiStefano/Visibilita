package utility;

import java.util.ArrayList;

/**
 * Una Data è un giorno nel calendario, definito dal giorno del mese, mese e anno
 * FORMATO EU       : dd/MM/yyyy          27/08/1995
 * FORMATO US       : MM/dd/yyyy          08/27/1995
 * FORMATO DB       : yyyy-MM-dd          1995-08-27
 * FORMATO DB-US    : yyyy-dd-MM          1995-27-08 
 */
public class Data 
{
    //L'OGGETTO CONOSCE LA CLASSE
    //LA CLASSE NON CONOSCE I SUOI OGGETTI

    //CON SCOPE DEFINIAMO l'APPARTENZA DI UN MEMBRO DELLA CLASSE

    //SCOPE DI CLASSE  (STATIC)
    //Proprietà e Metodi che sono DELLA CLASSE, non dei suoi OGGETTI
    //è uguale per tutti gli oggetti della classe
    private final static  int[] GIORNIPERMESE = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
    //final davanti ad una proprietà (static o no), indica che è una COSTANTE, che non può essere modificata


    //metodo static
    //metodo che non deve lavorare con l'oggetto

    /**
     * Entra una String che rappresenta una Data e una String che rappresenta il suo formato
     * Esce una LISTA con 3 numeri, il primo è il giorno, il secondo il mese, il terzo l'anno
     * Se il formato non è uno tra EU,US,DB,DB-US restituisco una lista con 3 -1
     */
    public static ArrayList<Integer> estraiValoriSingoli(String dataTestuale,String formatoDiQuellaData)
    {

        ArrayList<Integer> res = new ArrayList<>();
        switch (formatoDiQuellaData.toUpperCase()) 
        {
            case "EU": //dd/MM/yyyy
                res = splittaEu(dataTestuale);
            break;
            case "US"://MM/dd/yyyy
            {
                String[] parti = dataTestuale.split("/");
                res.add(Integer.parseInt(parti[1]));//giorno 
                res.add(Integer.parseInt(parti[0]));//mese
                res.add(Integer.parseInt(parti[2]));//anno 
            }
            break;
            case "DB":
            {
                String[] parti = dataTestuale.split("-");
                res.add(Integer.parseInt(parti[2]));//giorno 
                res.add(Integer.parseInt(parti[1]));//mese
                res.add(Integer.parseInt(parti[0]));//anno 
            }
            break;
            case "DB-US":
            {
                String[] parti = dataTestuale.split("-");
                res.add(Integer.parseInt(parti[1]));//giorno 
                res.add(Integer.parseInt(parti[2]));//mese
                res.add(Integer.parseInt(parti[0]));//anno 
            }    
            break;
            default: //NON HA SENSO, gli do un risultato che possa farglielo capire
                res.add(-1);
                res.add(-1);
                res.add(-1);
        }

        return res;
    }

    private static ArrayList<Integer> splittaEu(String data)
    {
        ArrayList<Integer> res = new ArrayList<>();
        String[] parti = data.split("/");
        res.add(Integer.parseInt(parti[0]));//giorno 
        res.add(Integer.parseInt(parti[1]));//mese
        res.add(Integer.parseInt(parti[2]));//anno 

        return res;
    }

    //SCOPE DI OGGETTO
    //Proprietà e Metodi che sono degli oggetti (delle istanze) di quella classe

    //PROPRIETÀ OGGETTO Data
    private Integer giorno,mese,anno;
    private String formato;

    //COSTRUTTORI
    //POSSONO ANCHE DEFINIRE MANIERE OBBLIGATORIE PER CREARE UN NUOVO OGGETTO
    //Se non scriviamo nessun costruttore abbiamo il costruttore implicito
    //che è un costruttore public Data(){}
    //Nel momento in cui DICHIARO un costruttore esplicito quello implicito viene DISABILITATO
    public Data(int giorno,int mese,int anno)
    {
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
        this.formato = "EU";
        //NON È DEFINITIVO, solo una soluzione temporanea
        if(!this.isValid())
        {
            System.out.println("La data non è valida, dato che sono una persona tranquilla faccio distruggere il programma");
            System.exit(-1);//TERMINA FORZATAMENTE IL PROGRAMMA
        }
    }

    public Data(int giorno,int mese,int anno,String formato)
    {
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
        this.formato = formato.toUpperCase();
        //NON È DEFINITIVO, solo una soluzione temporanea
        if(!this.isValid())
        {
            System.out.println("La data non è valida, dato che sono una persona tranquilla faccio distruggere il programma");
            System.exit(-1);//TERMINA FORZATAMENTE IL PROGRAMMA
        }
    }

    public boolean isValid()
    {
        return annoValido() && meseValido() && giornoValido() && formatoValido();
    }

    /**
     * Un anno è valido se compreso tra 0 e 2100
     */
    private boolean annoValido()
    {
        return anno>=0 && anno<=2100;
    }

    private boolean meseValido()
    {
        return mese>=1 && mese<=12;
    }

    private boolean giornoValido()
    {
        int igiorniDiGennaio = GIORNIPERMESE[1];

        return giorno>=1 && giorno<=31;
    }

    private boolean formatoValido()
    {
        switch (formato) 
        {
            case "EU","US","DB":
                return true;
            case "DB-US":    //è qui solo per esempio    
                return true;
            default:
                return false;
        }
    }

    public String toString()
    {
        // String res = "";

        // if(giorno<10)
        //     res+="0"+giorno;
        // else
        //     res+=giorno;
        
        // res+="/";

        // if(mese<10)
        //     res+="0"+mese;
        // else
        //     res+=mese;
        
        // res+="/"+anno;

        // return res;

        //OPERATORE TERNARIO
        //è una forma di SELEZIONE che permette di scegliere tra 2 valori

        
        //           condizione      ?      valoreVero          :       valoreFalso
        // String res = giorno<10       ?      "0"+giorno          :       giorno+""  ;

        // res+="/";
        
        // res+= mese<10       ?      "0"+mese          :       mese+""  ;
        
        // res+="/"+anno;

        // return res;

        // return  (giorno<10 ? "0"+giorno : giorno+"") + "/" + (mese<10 ? "0"+mese : mese+"") + "/" + anno;
        String giornoBonificato = giorno<10       ?      "0"+giorno          :       giorno+""  ;
        String meseBonificato = mese<10       ?      "0"+mese          :       mese+""  ;

        return  formato.equals("US")                            ? 
                    meseBonificato+"/"+giornoBonificato+"/"+anno         :
                formato.equals("DB")                            ?
                    anno+"-"+meseBonificato+"-"+giornoBonificato         :
                formato.equals("DB-US")                         ?
                    anno+"-"+giornoBonificato+"-"+meseBonificato         :
                giornoBonificato +"/"+meseBonificato+"/"+anno            ;
    }
}
