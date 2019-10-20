package com.uk.jobfinder;

import com.uk.jobfinder.model.Result;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Route("show-all")
public class JobController extends VerticalLayout {

    JobProvider jobProvider;
    Grid<Result> grid;
    List<Result> jobs;

    @Autowired
    public JobController(JobProvider jobProvider) {
        this.jobProvider = jobProvider;

        ComboBox<String> comboBoxCity = new ComboBox<String>("City");
        comboBoxCity.setItems("London", "Birmingham", "Manchester", "Glasgow", "Newcastle", "Sheffield", "Liverpool", "Leeds");

        ComboBox<String> comboBoxJob = new ComboBox<String>("Find");
        comboBoxJob.setItems("Java", "Junior Java", "Senior Java");

        Button buttonSubmit = new Button("Submit", new Icon(VaadinIcon.SELECT));
        buttonSubmit.setIconAfterText(true);

        buttonSubmit.addClickListener(click -> {

            jobs = jobProvider.getJobs(comboBoxJob.getValue(), comboBoxCity.getValue());
            grid = new Grid<>(Result.class);
            grid.setItems(jobs);
            grid.setColumns("employerName", "jobTitle", "locationName", "minimumSalary",
                    "maximumSalary", "currency", "jobDescription", "applications", "jobUrl");

            add(grid);


        });


        add(comboBoxCity, comboBoxJob, buttonSubmit);

    }

}
