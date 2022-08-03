package com.sigma.sigmathor.controller;

import com.sigma.sigmathor.domain.User;
import com.sigma.sigmathor.request.ListUsersRequest;
import com.sigma.sigmathor.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("reports")
public class ReportController {
    private final ReportService reportService;

    @PostMapping("users")
    public ResponseEntity<List<User>> listUsers(@RequestBody ListUsersRequest request) {
        return ResponseEntity.ok(reportService.listUsers(request));
    }
}
