package company.dao.impl;

import company.dao.inter.AbstractDAO;
import company.dao.inter.CountryDaoInter;
import company.dao.inter.SkillDaoInter;
import company.entity.Country;
import company.entity.Skill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {


    public Skill getByName(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        return new Skill(id, name);
    }


    @Override
    public List<Skill> getAll() throws SQLException, ClassNotFoundException {
        List<Skill> result = new ArrayList<>();
        try (Connection connection = connection()) {
            Statement statement = connection.createStatement();
            statement.execute("select * from country");
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                Skill skill = getByName(resultSet);
                result.add(skill);
            }
            return result;
        }
    }

    @Override
    public Skill getById(int id) throws SQLException, ClassNotFoundException {
        Skill skill = null;
        try (Connection connection = connection()) {
            PreparedStatement statement = connection.prepareStatement("select * from skill where id= ?");
            statement.setInt(1, id);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                skill = new Skill(resultSet.getInt("id"), resultSet.getString("name"));
            }
            return skill;
        }
    }

    @Override
    public boolean updateSkill(Skill skill) throws SQLException, ClassNotFoundException {
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement =
                    connection().prepareStatement("update skill set name=? where id=?");
            preparedStatement.setString(1, skill.getName());
            preparedStatement.setString(2, String.valueOf(skill.getId()));

            return preparedStatement.execute();
        }
    }

    @Override
    public boolean addSkill(Skill skill) throws SQLException, ClassNotFoundException {
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection().prepareStatement("insert into " +
                    "skill(name) values (?) ", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, skill.getName());

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                skill.setId(generatedKeys.getInt(1));
            }
            return preparedStatement.execute();
        }
    }


    @Override
    public boolean deleteSkill(int id) throws SQLException, ClassNotFoundException {
        try (Connection connection = connection()) {
            PreparedStatement statement = connection().prepareStatement("delete  from country where id=?");
            statement.setInt(1, id);
            return statement.execute();
        }
    }
}
