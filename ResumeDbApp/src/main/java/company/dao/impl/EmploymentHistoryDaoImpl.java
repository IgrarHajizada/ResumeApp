package company.dao.impl;

import company.dao.inter.AbstractDAO;
import company.dao.inter.EmploymentHistoryDaoInter;
import company.dao.inter.UserSkillDaoInter;
import company.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {


    private EmploymentHistory getEmploymentHistory(ResultSet resultSet) throws SQLException, ClassNotFoundException {
        String header = resultSet.getString("header");
        String jobDescription = resultSet.getString("job_description");
        Date beginDate = resultSet.getDate("begin_date");
        Date endDate = resultSet.getDate("end_date");
        int userId = resultSet.getInt("user_id");
        EmploymentHistory emp = new EmploymentHistory(null, header, beginDate, endDate, jobDescription, new User(userId));
        return emp;

    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) throws SQLException, ClassNotFoundException {
        List<EmploymentHistory> result = new ArrayList<>();
        try (Connection connection = connection()) {
            PreparedStatement statement = connection.prepareStatement("select * from " +
                    "employment_history where user_id =?");
            statement.setInt(1, userId);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                EmploymentHistory emp = getEmploymentHistory(resultSet);
                result.add(emp);
            }
            return result;
        }
    }


}
