package company.dao.impl;

import company.dao.inter.AbstractDAO;
import company.dao.inter.CountryDaoInter;
import company.dao.inter.SkillDaoInter;
import company.entity.Country;
import company.entity.Skill;

import java.sql.SQLException;
import java.util.List;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {
    @Override
    public List<Skill> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
