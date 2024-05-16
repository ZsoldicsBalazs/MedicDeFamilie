package Repository;

import Domain.Pacient;

import java.util.ArrayList;
import java.util.List;

public class PacientListRepo implements PacientRepoInterface{
    List <Pacient> pacientList = new ArrayList<>();
    @Override
    public List findAll() {
        return pacientList;
    }

    @Override
    public boolean save(Object entity) {
        return false;
    }

    @Override
    public boolean update(Object entity) {
        return false;
    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int entityId) {
        return false;
    }
}
