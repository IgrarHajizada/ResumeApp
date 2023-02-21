package company.dao.inter;

import company.entity.Country;
import company.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface CountryDaoInter {

    public List<Country> getAll() throws SQLException, ClassNotFoundException;




}
