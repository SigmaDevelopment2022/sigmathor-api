package com.sigma.sigmathor.mapper;

import com.sigma.sigmathor.domain.Goal;
import com.sigma.sigmathor.util.CurrencyUtil;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GoalMapper implements RowMapper<Goal> {
    @Override
    public Goal mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Goal(CurrencyUtil.format(rs.getBigDecimal("goal")));
    }
}
