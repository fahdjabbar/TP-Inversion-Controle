package pres;

import dao.DaoImpl;
import ext.DaoImplV2;
import metier.MetierImpl;

public class PresentationV1 {
    public static void main(String[] args) {
        /*
        Injection des depandances par instanciation statique
         */
        DaoImplV2 d = new DaoImplV2();
        MetierImpl metier = new MetierImpl(d);//Injection des depandances via les constructeurs
        //metier.setDao(d); //Injection via setter
        System.out.println("RES ="+ metier.calcul());
    }
}
