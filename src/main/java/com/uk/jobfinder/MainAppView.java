package com.uk.jobfinder;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@StyleSheet("/css/style.css")
@Route("app-main-view")
@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
@PWA(name = "JavaJobFinder", shortName = "OurApp")
class MainAppView extends AppLayout {

    public MainAppView() {
        Image img = new Image("https://i.imgur.com/maqwQwL.jpg", "JavaJobFinder");
        img.setHeight("400px");

        Label label = new Label("\n JavaJobFinder is the ultimate tool that will help you land your dream job as java developer " +
                "on any level you want. \n" +
                "We use best job search available and we promise to deliver the most suitable job offers directly to your inbox. So \n" +
                "do not hesitate and subscribe to our newsletter today. ");

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(img, label);
        addToNavbar(new DrawerToggle(), img, label);
        Tabs tabs = new Tabs(new Tab("Job Search"), new Tab("Subscribe"), new Tab("Unsubscribe"));
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        addToDrawer(tabs);
    }
}

