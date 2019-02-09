package com.example.demo.controller;

import com.example.demo.bean.CR;
import com.example.demo.bean.Empoly;
import com.example.demo.bean.Project;
import com.example.demo.bean.TestType;
import com.example.demo.service.CRService;
import com.example.demo.service.EmpolyService;
import com.example.demo.service.ProjectService;
import com.example.demo.service.TestTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProjectController {

    Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmpolyService empolyService;

    @Autowired
    private TestTypeService testTypeService;

    @Autowired
    private CRService crService;

    @RequestMapping("/insert")
    public String insert(Model model) {
        logger.info("转页面");
        List<Project> projects = projectService.findAll();
        List<Empoly> testers = empolyService.findTester();
        List<Empoly> developers = empolyService.findDeveloper();
        List<TestType> testType = testTypeService.findTestType();
        List<CR> crtype = crService.findCRType();
        model.addAttribute("projects", projects);
        model.addAttribute("testers", testers);
        model.addAttribute("developers", developers);
        model.addAttribute("testType", testType);
        model.addAttribute("crtype", crtype);
        return "insert";
    }
}
