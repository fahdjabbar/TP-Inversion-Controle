package dao;

public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("version de base de donnes ");
        double temp =23;
        return temp;
    }
}
