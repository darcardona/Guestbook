package com.habuma.guestbook;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcGuestRepository implements GuestRepository {

    private final JdbcTemplate jdbcTemplate;

    @Inject
    public JdbcGuestRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public void addGuest(Guest guest) {
        jdbcTemplate.update(
                "INSERT INTO Guest (NAME, email, dateOfVisit) VALUES (?, ?, ?)",
                guest.getName(), guest.getEmail(), guest.getDateOfVisit());
    }

    @Override
    public List<Guest> getAllGuests() {
        return jdbcTemplate.query("SELECT NAME, email, dateOfVisit FROM Guest ORDER BY dateOfVisit", new RowMapper<Guest>() {
            @Override
            public Guest mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Guest(rs.getString("name"), rs.getString("email"), rs.getTimestamp("dateOfVisit"));
            }
        });
    }

}
