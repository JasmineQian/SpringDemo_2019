package com.example.demo.controller;

import com.example.demo.bean.*;
import com.example.demo.service.*;
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
    private EmployService employService;

    @Autowired
    private TestTypeService testTypeService;

    @Autowired
    private CRService crService;

    @Autowired
    private BugStatusService bugStatusService;

    @RequestMapping("/insert")
    public String insert(Model model) {
        logger.info("转页面");
        List<Project> projects = projectService.findAll();
        List<Employ> testers = employService.findTester();
        List<Employ> developers = employService.findDeveloper();
        List<TestType> testType = testTypeService.findTestType();
        List<CR> crtype = crService.findCRType();
        List<BugStatus> bugStatuses = bugStatusService.findBugStatus();
        model.addAttribute("projects", projects);
        model.addAttribute("testers", testers);
        model.addAttribute("developers", developers);
        model.addAttribute("testType", testType);
        model.addAttribute("crtype", crtype);
        model.addAttribute("bugStatus", bugStatuses);
        return "insert";
    }
}
