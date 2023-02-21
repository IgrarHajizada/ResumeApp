package company.dao.inter;

import company.entity.User;
import company.entity.UserSkill;

import java.sql.SQLException;
import java.util.List;

public interface UserDaoInter {

    public List<User> getAll() throws SQLException, ClassNotFoundException;

    public User getById(int id) throws SQLException, ClassNotFoundException;

    public boolean updateUser(User user) throws SQLException, ClassNotFoundException;

    public boolean addUser(User user) throws SQLException, ClassNotFoundException;


    public boolean deleteUser(int id) throws SQLException, ClassNotFoundException;



}
