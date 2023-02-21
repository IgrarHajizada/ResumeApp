package company.dao.inter;

import company.entity.EmploymentHistory;

import java.sql.SQLException;
import java.util.List;

public interface EmploymentHistoryDaoInter {
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) throws SQLException, ClassNotFoundException;
}
