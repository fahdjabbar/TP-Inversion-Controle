package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component("daoV2")
public class DaoImplV2 implements IDao {

    @Override
    public double getData() {
        System.out.println("version Web services");
        double t =11;
        return t;
    }
}
