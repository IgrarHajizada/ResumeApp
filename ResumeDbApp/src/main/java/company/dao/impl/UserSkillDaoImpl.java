package company.dao.impl;

import company.dao.inter.AbstractDAO;
import company.dao.inter.UserSkillDaoInter;
import company.entity.Country;
import company.entity.Skill;
import company.entity.User;
import company.entity.UserSkill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    private UserSkill getUserSkill(ResultSet resultSet) throws SQLException, ClassNotFoundException {
        int userId = resultSet.getInt("id");
        int skillId = resultSet.getInt("skill_id");
        String skillName = resultSet.getString("skill_name");
        int power = resultSet.getInt("power");
        return new UserSkill(null, new User(userId), new Skill(skillId, skillName), power);
    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) throws SQLException, ClassNotFoundException {
        List<UserSkill> result = new ArrayList<>();
        try (Connection connection = connection()) {
            PreparedStatement statement = connection.prepareStatement("select u.*, us.skill_id, s.name skill_name," +
                    " us.power from user_skill us " +
                    "left join user u on us.user_id = u.id left join skill s on us.skill_id = s.id" +
                    " where us.user_id = ?;");
            statement.setInt(1, userId);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                UserSkill u = getUserSkill(resultSet);
                result.add(u);
            }
            return result;
        }
    }


}
