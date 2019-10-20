package com.uk.jobfinder;

import com.uk.jobfinder.model.Result;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@Route("show-all")
public class JobController extends HorizontalLayout {

    JobProvider jobProvider;

    @Autowired
    public JobController(JobProvider jobProvider) {
        this.jobProvider = jobProvider;
    }

    public void showMoviesPage() {
        List<Result> jobs = jobProvider.getJobs();



    }


}
