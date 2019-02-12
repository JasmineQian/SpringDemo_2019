package com.example.demo.service;

import com.example.demo.bean.Empoly;

import java.util.List;

public interface EmpolyService {

    List<Empoly> findTester();

    List<Empoly> findDeveloper();
}
