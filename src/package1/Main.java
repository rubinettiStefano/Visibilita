package package1;

import java.util.Scanner;

import package2.Matematica;

public class Main 
{
    public static void main(String[] args) 
    {
        //COSTRUTTORE IMPLICITO
        //QUELLO CHE HO SE NON SCRIVO COSTRUTTORI
        //È PUBLIC
        Matematica m = new Matematica();

        //m.num1 = -10;
        m.setNum1(-81);

        //m.num2 = 10;

        //UNA PROPRIETÀ PUBLIC è una proprietà
        //a cui il resto del programma ha libero accesso
        //può impostare il valore a suo piacimento

        System.out.println(m.radiceQuadrataNum1());
    }
}
