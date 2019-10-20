package com.uk.jobfinder;

import com.uk.jobfinder.model.Result;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController extends HorizontalLayout {

    JobProvider jobProvider;

    @Autowired
    public JobController(JobProvider jobProvider) {
        this.jobProvider = jobProvider;
    }

    @GetMapping
    @RequestMapping("/showJobs")
    public String showMoviesPage(Model model) {
        List<Result> jobs = jobProvider.getJobs();
        model.addAttribute("jobs", jobs);


        return "showJobs";
    }


}
