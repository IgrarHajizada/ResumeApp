package company.dao.impl;

import company.dao.inter.AbstractDAO;
import company.dao.inter.CountryDaoInter;
import company.entity.Country;

import java.sql.SQLException;
import java.util.List;

public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {
    @Override
    public List<Country> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
