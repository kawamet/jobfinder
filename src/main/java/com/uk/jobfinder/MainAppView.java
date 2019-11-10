package com.uk.jobfinder;

import com.uk.jobfinder.email.AddEmail;
import com.uk.jobfinder.email.EmailRepo;
import com.uk.jobfinder.model.Result;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

@StyleSheet("/css/style.css")
@Route("app-main-view")
@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
@PWA(name = "JavaJobFinder", shortName = "OurApp")
class MainAppView extends AppLayout {
    JobProvider jobProvider;
    AddEmail addEmail;
    JobController jobController;
    Image img;
    HorizontalLayout horizontalLayout;

    @Autowired
    public MainAppView(JobProvider jobProvider, EmailRepo emailRepo) {
        img = new Image("https://i.imgur.com/maqwQwL.jpg", "JavaJobFinder");
        img.setMaxHeight("400px");
        this.jobProvider = jobProvider;

        Label label = new Label("\n JavaJobFinder is the ultimate tool that will help you land your dream job as java developer " +
                "on any level you want. \n" +
                "We use best job search available and we promise to deliver the most suitable job offers directly to your inbox. So \n" +
                "do not hesitate and subscribe to our newsletter today. ");


        horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(img, label);
        addToNavbar(new DrawerToggle(), img, label);
        jobController = new JobController(jobProvider);
        addEmail = new AddEmail(emailRepo);

        Tabs tabs = new Tabs(new Tab("Main"), new Tab("Find Job"), new Tab("Subscribe"), new Tab("API documentation"));
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.addSelectedChangeListener(event -> {
            final Tab selectedTab = event.getSelectedTab();
            String label1 = selectedTab.getLabel();
            if (label1.equals("Find Job")) {
                remove(img, label, jobController, addEmail);
                addToNavbar(jobController);
            }
            if (label1.equals("Subscribe")) {
                remove(img, label, jobController, addEmail);
                addToNavbar(addEmail);
            }
            if (label1.equals("Main")) {
                remove(img, label, jobController, addEmail);
                addToNavbar(img, label);
            }
        });

        addToDrawer(tabs);
    }
}

