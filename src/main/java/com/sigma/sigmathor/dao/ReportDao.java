package com.sigma.sigmathor.dao;

import com.sigma.sigmathor.domain.Goal;
import com.sigma.sigmathor.domain.User;
import com.sigma.sigmathor.mapper.GoalMapper;
import com.sigma.sigmathor.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReportDao {
    private final JdbcTemplate template;

    public List<User> listUsers(String todayDate, String initialDate, String finalDate) {
        String statement = "select usr.codusur user_code, usr.nome user_name, usr.cidade user_city, " +
                "sup.codsupervisor team_code, sup.nome team_name, " +

                "(select mtr.vlvendaprev from pcmetarca mtr where mtr.codusur = usr.codusur and " +
                "mtr.data = to_date(?, 'dd/MM/yyyy')) goal_today, " +

                "(select sum(mtr.vlvendaprev) " +
                "from pcmetarca mtr where mtr.codusur = usr.codusur " +
                "and mtr.data between to_date(?, 'dd/MM/yyyy') and to_date(?, 'dd/MM/yyyy')) goal_month, " +

                "(select sum(ped.vlatend) from pcpedc ped where ped.codusur = usr.codusur and " +
                "ped.data = to_date(?, 'dd/MM/yyyy')) sold_today, " +

                "(select sum(ped.vlatend) from pcpedc ped where ped.codusur = usr.codusur and " +
                "ped.data between to_date(?, 'dd/MM/yyyy') and to_date(?, 'dd/MM/yyyy')) sold_month, " +

                "(select * from ( " +
                "select lr.vllimcred from pclogrca lr where lr.codusur = usr.codusur and " +
                "lr.data between to_date(?, 'dd/MM/yyyy') and to_date(?, 'dd/MM/yyyy') " +
                "order by lr.data desc" +
                ") where rownum = 1) balance_limit, " +

                "(select * from ( " +
                "select lr.vlcorrente from pclogrca lr where lr.codusur = usr.codusur and " +
                "lr.data between to_date(?, 'dd/MM/yyyy') and to_date(?, 'dd/MM/yyyy') " +
                "order by lr.data desc" +
                ") where rownum = 1) balance_last " +

                "from pcusuari usr " +
                "join pcsuperv sup on sup.codsupervisor = usr.codsupervisor " +
                "where usr.dttermino is null and " +
                "usr.bloqueio = 'N' " +
                "group by usr.codusur, usr.nome, usr.cidade, sup.codsupervisor, sup.nome " +
                "order by usr.codusur desc";


        return template.query(statement, new UserMapper(), todayDate,
                initialDate, finalDate,
                todayDate,
                initialDate, finalDate,
                initialDate, finalDate,
                initialDate, finalDate
        );
    }


}
