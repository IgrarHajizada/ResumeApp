package company.dao.impl;

import company.entity.Country;
import company.entity.Skill;
import company.entity.User;
import company.entity.UserSkill;
import company.dao.inter.AbstractDAO;
import company.dao.inter.UserDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {


    private User getUser(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        String phone = resultSet.getString("phone");
        String email = resultSet.getString("email");
        int nationalityId = resultSet.getInt("nationality_id");
        int birthplaceId = resultSet.getInt("birthplace_id");
        String nationalityStr = resultSet.getString("nationality");
        String birthplaceStr = resultSet.getString("birthplace");
        Date birthdate = resultSet.getDate("birthdate");

        Country country = new Country(nationalityId, null, nationalityStr);
        Country birthplace = new Country(birthplaceId, birthplaceStr, null);


        return new User(id, name, surname, phone, email, birthdate, country, birthplace);
    }


    @Override
    public List<User> getAll() throws SQLException, ClassNotFoundException {

        List<User> result = new ArrayList<>();
        try (Connection connection = connection()) {
            Statement statement = connection.createStatement();
            statement.execute("select u.*, n.nationality nationality, c.name birthplace " +
                    "from user u left join country n on u.nationality_id = n.id " +
                    "left join country c on u.birthplace_id = c.id");
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                User u = getUser(resultSet);
                result.add(u);
            }
            return result;
        }
    }


    @Override
    public User getById(int userId) throws SQLException, ClassNotFoundException {

        User result = new User();
        try (Connection connection = connection()) {
            Statement statement = connection.createStatement();
            statement.execute("select u.*, n.nationality nationality, c.name birthplace " +
                    "from user u left join country n on u.nationality_id = n.id " +
                    " left join country c on u.birthplace_id = c.id where u.id=" + userId);
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                result = getUser(resultSet);
            }
            return result;
        }
    }


    @Override
    public boolean updateUser(User user) throws SQLException, ClassNotFoundException {
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement =
                    connection().prepareStatement("update user set name=?, surname=?, email=?, phone=? where id=?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setInt(5, user.getId());
            return preparedStatement.execute();
        }
    }


    @Override
    public boolean addUser(User user) throws SQLException, ClassNotFoundException {
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection().prepareStatement("insert into " +
                    "user(name,surname,email,phone) values (?,?,?,?) ");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            return preparedStatement.execute();
        }
    }


    @Override
    public boolean deleteUser(int id) throws SQLException, ClassNotFoundException {
        try (Connection connection = connection()) {
            Statement statement = connection().createStatement();
            return statement.execute("delete from user where id=" + id);
        }
    }

}
