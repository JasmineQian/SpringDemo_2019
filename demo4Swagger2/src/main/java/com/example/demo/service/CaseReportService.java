package com.example.demo.service;

import com.example.demo.entity.CaseReport;

import java.util.List;

public interface CaseReportService {

    List<CaseReport> findByCondtion(int pid, String name, String description);
}
