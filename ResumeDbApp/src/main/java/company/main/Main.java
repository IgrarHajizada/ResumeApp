package company.main;

import company.dao.inter.EmploymentHistoryDaoInter;
import company.dao.inter.UserDaoInter;
import company.dao.inter.UserSkillDaoInter;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        EmploymentHistoryDaoInter dao = Context.instanceEmploymentHistoryDao();
        System.out.println(dao.getAllEmploymentHistoryByUserId(1));

    }


}
