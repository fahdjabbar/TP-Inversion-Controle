package metier;

import dao.IDao;

 public class MetierImpl implements IMetier {
     //couplage faible
     private IDao dao;
     public MetierImpl() {}
     public MetierImpl(IDao dao) {
         this.dao = dao;
     }

     @Override
     public double calcul() {
         double t = dao.getData();
         double res = t * 23;
         return res;
     }
    /**
    * pour Injecter dans la variable
     * un objet de la classe qui implemente l'interface IDao
    */
       public void setDao(IDao dao) {
           this.dao = dao;
       }
 }
