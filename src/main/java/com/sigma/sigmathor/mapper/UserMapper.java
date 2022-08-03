package com.sigma.sigmathor.mapper;

import com.sigma.sigmathor.domain.*;
import com.sigma.sigmathor.util.CurrencyUtil;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
                .code(rs.getLong("user_code"))
                .name(rs.getString("user_name"))
                .city(rs.getString("user_city"))
                .team(Team.builder()
                        .code(rs.getLong("team_code"))
                        .name(rs.getString("team_name"))
                        .build())
                .goalToday(new Goal(CurrencyUtil.format(Optional.ofNullable(rs.getBigDecimal("goal_today")).orElse(new BigDecimal(0)))))
                .goalMonth(new Goal(CurrencyUtil.format(Optional.ofNullable(rs.getBigDecimal("goal_month")).orElse(new BigDecimal(0)))))
                .soldToday(new Sell(CurrencyUtil.format(Optional.ofNullable(rs.getBigDecimal("sold_today")).orElse(new BigDecimal(0)))))
                .soldMonth(new Sell(CurrencyUtil.format(Optional.ofNullable(rs.getBigDecimal("sold_month")).orElse(new BigDecimal(0)))))
                .creditLimit(new Balance(CurrencyUtil.format(Optional.ofNullable(rs.getBigDecimal("balance_limit")).orElse(new BigDecimal(0)))))
                .creditLast(new Balance(CurrencyUtil.format(Optional.ofNullable(rs.getBigDecimal("balance_last")).orElse(new BigDecimal(0)))))
                .build();
    }
}
