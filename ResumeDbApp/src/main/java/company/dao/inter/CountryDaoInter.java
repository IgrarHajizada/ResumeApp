package company.dao.inter;

import company.entity.Country;
import company.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface CountryDaoInter {

    public List<Country> getAll() throws SQLException, ClassNotFoundException;

    public Country getById(int id) throws SQLException, ClassNotFoundException;

    public boolean updateCountry(Country country) throws SQLException, ClassNotFoundException;

    public boolean addCountry(Country country) throws SQLException, ClassNotFoundException;

    public boolean deleteCountry(int id) throws SQLException, ClassNotFoundException;


}
