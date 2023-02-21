package company.dao.inter;

import company.entity.Country;
import company.entity.Skill;

import java.sql.SQLException;
import java.util.List;

public interface SkillDaoInter {

    public List<Skill> getAll() throws SQLException, ClassNotFoundException;




}
