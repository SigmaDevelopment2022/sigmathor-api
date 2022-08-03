package com.sigma.sigmathor.service;

import com.sigma.sigmathor.domain.User;
import com.sigma.sigmathor.repository.ReportRepository;
import com.sigma.sigmathor.request.ListUsersRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;

    public List<User> listUsers(ListUsersRequest request) {
        return reportRepository.listUsers(request.getTodayDate(), request.getInitialDate(), request.getFinalDate());
    }
}
