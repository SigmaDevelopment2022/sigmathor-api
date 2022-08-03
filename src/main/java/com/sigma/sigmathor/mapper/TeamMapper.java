package com.sigma.sigmathor.mapper;

import com.sigma.sigmathor.domain.Team;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamMapper implements RowMapper<Team> {
    @Override
    public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Team.builder()
                .code(rs.getLong("team_code"))
                .name(rs.getString("team_name"))
                .build();
    }
}
