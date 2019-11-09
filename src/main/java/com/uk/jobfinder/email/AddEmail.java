package com.uk.jobfinder.email;

import com.uk.jobfinder.model.Email;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.time.LocalDate;

@Route("add-email")
@StyleSheet("/css/style.css")
public class AddEmail extends VerticalLayout {

    private EmailRepo emailRepo;
    private ComboBox<String> comboBoxCity;
    private ComboBox<String> comboBoxJobPosition;
    private DatePicker startDatePicker;
    private DatePicker endDatePicker;
    private TextComponent message;

    @Autowired
    public AddEmail(EmailRepo emailRepo) {
        this.emailRepo = emailRepo;

        //add(new Image("https://media.giphy.com/media/qgWV7ZjRbL1h6/giphy.gif", "SORRY, image is not available :-("));
        TextField textFieldEmail = new TextField("Enter your email address");

        comboBoxCity = new ComboBox<>("Select a city");
        comboBoxCity.setItems("London", "Birmingham", "Manchester", "Glasgow", "Newcastle", "Sheffield", "Liverpool", "Leeds", "Wimbledon");

        comboBoxJobPosition = new ComboBox<>("Select job position");
        comboBoxJobPosition.setItems("Senior Java", "Java", "Junior Java", "Graduate Java", "Academy Java");

//        DatePicker startDatePicker = new DatePicker();
//        startDatePicker.setLabel("Start");
//        startDatePicker.setValue(LocalDate.now());
//        DatePicker endDatePicker = new DatePicker();
//        endDatePicker.setLabel("End");
//        endDatePicker.setValue(LocalDate.now());
//
//        startDatePicker.addValueChangeListener(event -> {
//            LocalDate selectedDate = event.getValue();
//            LocalDate endDate = endDatePicker.getValue();
//            if (selectedDate != null) {
//                endDatePicker.setMin(selectedDate.plusDays(1));
//                if (endDate == null) {
//                    endDatePicker.setOpened(true);
//                    message.setText("Select the ending date");
//                } else {
//                    message.setText(
//                            "Selected period:\nFrom " + selectedDate.toString()
//                                    + " to " + endDate.toString());
//                }
//            } else {
//                endDatePicker.setMin(null);
//                message.setText("Select the starting date");
//            }
//        });
//
//        endDatePicker.addValueChangeListener(event -> {
//            LocalDate selectedDate = event.getValue();
//            LocalDate startDate = startDatePicker.getValue();
//            if (selectedDate != null) {
//                startDatePicker.setMax(selectedDate.minusDays(1));
//                if (startDate != null) {
//                    message.setText(
//                            "Selected period:\nFrom " + startDate.toString()
//                                    + " to " + selectedDate.toString());
//                } else {
//                    message.setText("Select the starting date");
//                }
//            } else {
//                startDatePicker.setMax(null);
//                if (startDate != null) {
//                    message.setText("Select the ending date");
//                } else {
//                    message.setText("No date is selected");
//                }
//            }
//        });

        Button button = new Button("Save!");

        button.addClickListener(buttonClickEvent -> {
            Email email = new Email(textFieldEmail.getValue(), comboBoxCity.getValue(), comboBoxJobPosition.getValue(),
                    startDatePicker.getValue(), endDatePicker.getValue());
            emailRepo.save(email);
            add("Your email has been saved to our database. We will contact you as soon as we get new offers.");
        });

        add(textFieldEmail, comboBoxCity, comboBoxJobPosition, startDatePicker, endDatePicker, button);
    }
}
