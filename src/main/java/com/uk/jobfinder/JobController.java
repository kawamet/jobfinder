package com.uk.jobfinder;

import com.uk.jobfinder.model.Result;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;


@Route("show-all")
public class JobController extends VerticalLayout {

    JobProvider jobProvider;
    Grid<Result> grid;
    List<Result> jobs;
    Dialog dialogJobDescription;
    Anchor anchor;
    ComboBox<String> comboBoxCity;
    ComboBox<String> comboBoxJob;
    Button buttonSubmit;
    Button buttonSubscribe;
    Label labelSubscribe;

    @Autowired
    public JobController(JobProvider jobProvider) {
        this.jobProvider = jobProvider;


        //jobProvider.getAllJobs().stream().map(e -> e.getMinimumSalary()).forEach(System.out:: println);

        comboBoxCity = new ComboBox<String>("City");
        comboBoxCity.setItems("London", "Birmingham", "Manchester", "Glasgow", "Newcastle", "Sheffield", "Liverpool", "Leeds");

        comboBoxJob = new ComboBox<String>("Find");
        comboBoxJob.setItems("Java", "Junior Java", "Senior Java");

        buttonSubmit = new Button("Submit", new Icon(VaadinIcon.SELECT));
        buttonSubmit.setIconAfterText(true);

        buttonSubscribe = new Button("Subscribe!");
        labelSubscribe = new Label("add email");

        buttonSubscribe.addClickListener(click -> {
            //todo add to database

        });

        final int[] count = {0};
        buttonSubmit.addClickListener(click -> {
            removeIfGridAlreadyCreated(count);

            jobs = jobProvider.getJobs(comboBoxJob.getValue(), comboBoxCity.getValue());
            grid = new Grid<>(Result.class);
            grid.setItems(jobs);
            grid.setColumns("employerName", "jobTitle", "minimumSalary",
                    "maximumSalary", "currency", "applications");

            grid.addColumn(new ComponentRenderer<>(x -> {
                anchor = new Anchor(x.getJobUrl(), "apply");
                return anchor;
            })).setHeader("Details");

            showDialogWithJobDescription();


            add(grid);

        });


        add(comboBoxCity, comboBoxJob, buttonSubmit);

    }

    private void showDialogWithJobDescription() {
        dialogJobDescription = new Dialog();
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid.addItemClickListener(event -> {
            Set<Result> selectedItems = grid.getSelectedItems();
            for (Result selectedItem : selectedItems) {
                dialogJobDescription.add(new Label(selectedItem.getJobDescription()));
                add(dialogJobDescription);
                dialogJobDescription.open();
            }
        });
    }

    private void removeIfGridAlreadyCreated(int[] count) {
        if (count[0] > 0) {
            remove(grid);
        } else {
            count[0]++;
        }
    }

}
