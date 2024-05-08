package utility;

/**
 * Una Data è un giorno nel calendario, definito dal giorno del mese, mese e anno
 * FORMATO EU       : dd/MM/yyyy          27/08/1995
 * FORMATO US       : MM/dd/yyyy          08/27/1995
 * FORMATO DB       : yyyy-MM-dd          1995-08-27
 * FORMATO DB-US    : yyyy-dd-MM          1995-27-08 
 */
public class Data 
{

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

        return  (giorno<10 ? "0"+giorno : giorno+"") + "/" + (mese<10 ? "0"+mese : mese+"") + "/" + anno;
    }
}
