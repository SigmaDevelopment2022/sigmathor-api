package com.sigma.sigmathor.repository;

import com.sigma.sigmathor.dao.ReportDao;
import com.sigma.sigmathor.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReportRepository {
    private final ReportDao reportDao;

    public List<User> listUsers(String todayDate, String initialDate, String finalDate) {
        return reportDao.listUsers(todayDate, initialDate, finalDate);
    }
}
