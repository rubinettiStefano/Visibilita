package package2;

/**
 * è una classe pensata per lavorare solo con numeri positivi
 */
public class Matematica 
{

    //proprietà sempre private
    //getter e setter sempre public
    //metodi sempre public
    //a meno che non siano di UTILITÀ
    //metodi pensati solo per essere utilizzati all'interno di altri metodi della classe
    //in quel caso private




    //VISIBILITÀ PRIVATA delle proprietà

    //QUESTA È ROBA MIA, tu non sai nemmeno che esiste
    //e non te ne devi preoccupare
    private double num1;
    private double num2;

    //ACCESSO CONTROLLATO ALLE PROPRIETÀ
    //Invece di lasciare che gli altri programmi facciano assegnamento DIRETTO delle proprietà
    //utilizzeranno METODI ACCESSORI
    //GETTER E SETTER
    //IL GETTER è un metodo che restituisce il valore di una proprietà
    //IL SETTER è un metodo che imposta il valore di una proprietà

    public double getNum1()
    {
        return num1;
    }

    /**
     * Il metodo impostare il VALORE ASSOLUTO
     * del parametro passato come valore di num1
     */
    public void setNum1(double nuovoValore)
    {
        if(nuovoValore<0)
        {
            this.num1 = nuovoValore*-1;
        }
        else
            this.num1 = nuovoValore;
    }

    public double somma()
    {
        return num1+num2;
    }

    public double radiceQuadrataNum1()
    {
        return Math.sqrt(num1);
    }
}
