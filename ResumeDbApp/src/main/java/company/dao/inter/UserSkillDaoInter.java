package company.dao.inter;

import company.entity.UserSkill;

import java.sql.SQLException;
import java.util.List;

public interface UserSkillDaoInter {
    public List<UserSkill> getAllSkillByUserId(int userId) throws SQLException, ClassNotFoundException;

    public boolean insertUserSkill(UserSkill userSkill) throws SQLException, ClassNotFoundException;

    public boolean updateUserSkill(UserSkill userSkill) throws SQLException, ClassNotFoundException;

    public boolean deleteUserSkill(int id) throws SQLException, ClassNotFoundException;


}
