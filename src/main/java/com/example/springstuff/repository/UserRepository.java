package com.example.springstuff.repository;

import com.example.springstuff.data.DataClass;
import com.example.springstuff.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRepository {
    private Connection connection;

    @Autowired
    public UserRepository(DataClass dataClass) {
        this.connection = dataClass.getConnection();
    }


    //CREATE
    public void createUser(User user) {
        String sql = "insert into users (name) values (?)";

        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //READ
    public User getUserById(Long id) {
        String sql = "select *, name from users where id = ?";

        User user = null;

        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getLong("id"), rs.getString("name"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(Long id, String name) {
        String sql = "update users set name = ? where id = ?";

        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setLong(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //DELETE
    public void deleteUser(User user) {
        String sql = "delete from users where id = ?";

        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
