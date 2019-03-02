package com.java.test.app.dao.impl;

import com.java.test.app.dao.UserDao;
import com.java.test.app.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void insert(User cus) {
        String sql = "INSERT INTO application.users (id, firstName, lastName) VALUES (?, ?, ?)" ;
        getJdbcTemplate().update(sql, new Object[]{
            cus.getId(), cus.getFirstName(), cus.getLastName()
        });
    }

    @Override
    public User get(long Id) {
        String sql = "SELECT * FROM application.users WHERE id = ?";
        
        // Obligé de faire un try catch pour ne pas rentrer dans une erreur si l'utilisateur n'existe pas
        // https://www.mkyong.com/spring/queryforobject-throws-emptyresultdataaccessexception-when-record-not-found/

        try {
            return (User)getJdbcTemplate().queryForObject(sql, new Object[]{ Id }, new RowMapper<User>(){
                @Override
                public User mapRow(ResultSet rs, int rwNumber) throws SQLException {
                    User user = new User(
                        rs.getLong("Id"),
                        rs.getString("firstName"),
                        rs.getString("lastName")
                    );
                    return user;
                }
            });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}