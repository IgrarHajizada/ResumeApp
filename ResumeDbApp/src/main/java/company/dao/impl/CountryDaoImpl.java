package company.dao.impl;

import company.dao.inter.AbstractDAO;
import company.dao.inter.CountryDaoInter;
import company.entity.Country;
import company.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {

    public Country getCountry(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String nationality = resultSet.getString("nationality");
        return new Country(id, name, nationality);
    }

    @Override
    public List<Country> getAll() throws SQLException, ClassNotFoundException {
        List<Country> result = new ArrayList<>();
        try (Connection connection = connection()) {
            Statement statement = connection.createStatement();
            statement.execute("select * from country");
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                Country country = getCountry(resultSet);
                result.add(country);
            }
            return result;
        }
    }

    @Override
    public Country getById(int userId) throws SQLException, ClassNotFoundException {
        Country country = null;
        try (Connection connection = connection()) {
            PreparedStatement statement = connection.prepareStatement("select * from country where id= ?");
            statement.setInt(1, userId);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                country = getCountry(resultSet);
            }
            return country;
        }
    }

    @Override
    public boolean updateCountry(Country country) throws SQLException, ClassNotFoundException {
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement =
                    connection().prepareStatement("update country set name=?, " +
                            "nationality=? where id=?");
            preparedStatement.setString(1, country.getName());
            preparedStatement.setString(2, country.getNationality());
            preparedStatement.setString(3, String.valueOf(country.getId()));

            return preparedStatement.execute();
        }
    }

    @Override
    public boolean addCountry(Country country) throws SQLException, ClassNotFoundException {
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection().prepareStatement("insert into " +
                    "country(name,nationality) values (?,?) ");
            preparedStatement.setString(1, country.getName());
            preparedStatement.setString(2, country.getNationality());
            return preparedStatement.execute();
        }
    }

    @Override
    public boolean deleteCountry(int id) throws SQLException, ClassNotFoundException {
        try (Connection connection = connection()) {
            PreparedStatement statement = connection().prepareStatement("delete  from country where id=?");
            statement.setInt(1, id);
            return statement.execute();
        }
    }
}
