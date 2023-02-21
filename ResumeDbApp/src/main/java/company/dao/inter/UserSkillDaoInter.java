package company.dao.inter;

import company.entity.UserSkill;

import java.sql.SQLException;
import java.util.List;

public interface UserSkillDaoInter {
    public List<UserSkill> getAllSkillByUserId(int userId) throws SQLException, ClassNotFoundException;
}
