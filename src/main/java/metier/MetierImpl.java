package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
 public class MetierImpl implements IMetier {
     //couplage faible
     private IDao dao;
     public MetierImpl(@Qualifier("dao1") IDao dao) {
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
       public void setDao( IDao dao) {
           this.dao = dao;
       }
 }
