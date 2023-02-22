package company.dao.inter;

import company.entity.Country;
import company.entity.Skill;

import java.sql.SQLException;
import java.util.List;

public interface SkillDaoInter {

    public List<Skill> getAll() throws SQLException, ClassNotFoundException;

    public Skill getById(int id) throws SQLException, ClassNotFoundException;

    public boolean updateSkill(Skill skill) throws SQLException, ClassNotFoundException;

    public boolean addSkill(Skill skill) throws SQLException, ClassNotFoundException;

    public boolean deleteSkill(int id) throws SQLException, ClassNotFoundException;


}
