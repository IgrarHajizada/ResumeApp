package company.main;

import company.dao.impl.EmploymentHistoryDaoImpl;
import company.dao.impl.UserDaoImpl;
import company.dao.impl.UserSkillDaoImpl;
import company.dao.inter.EmploymentHistoryDaoInter;
import company.dao.inter.UserDaoInter;
import company.dao.inter.UserSkillDaoInter;
import company.entity.EmploymentHistory;

public class Context {
    public static UserDaoInter instanceUserDao() {
        return new UserDaoImpl();
    }

    public static UserSkillDaoInter instanceUserSkillDao() {
        return new UserSkillDaoImpl();
    }

    public static EmploymentHistoryDaoInter instanceEmploymentHistoryDao() {
        return new EmploymentHistoryDaoImpl();
    }
}
