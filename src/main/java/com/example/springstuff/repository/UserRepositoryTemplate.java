package com.example.springstuff.repository;

import com.example.springstuff.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryTemplate implements CrudRepository<User, UUID> {
    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public void save(User user) {

        String sql = "insert into users(id, name) values(:id, :name)";

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", user.getId())
                .addValue("name", user.getName());

        jdbc.update(sql, params);
    }

    @Override
    public Optional<User> getById(UUID uuid) {

        String sql = "select * from users where id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", uuid);

        List<User> users = jdbc.query(sql, params, userMapper);

        if (users.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(users.get(0));
    }

    @Override
    public List<User> getAll() {

        String sql = "select * from users";

        return jdbc.query(sql, userMapper);
    }

    @Override
    public void update(User user) {

        String sql = "update users set name = :name where id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", user.getId())
                .addValue("name", user.getName());

        jdbc.update(sql, params);
    }

    @Override
    public boolean deleteById(UUID uuid) {

        String sql = "delete from users where id= :id";

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", uuid);

        int rows = jdbc.update(sql, params);

        return rows > 0;
    }

    @Override
    public void deleteAll() {

        String sql = "delete from users";

        jdbc.update(sql, new MapSqlParameterSource());
    }

    private final RowMapper<User> userMapper = (rs, rowNum) ->
            new User(
                    UUID.fromString(rs.getString("id")),
                    rs.getString("name")
            );
}
