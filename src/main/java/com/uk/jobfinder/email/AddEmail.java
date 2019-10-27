package com.uk.jobfinder.email;

import com.uk.jobfinder.model.Email;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("add-email")
public class AddEmail extends VerticalLayout {

    private EmailRepo emailRepo;
    private ComboBox<String> comboBoxCity;
    private ComboBox<String> comboBoxJobPosition;

    @Autowired
    public AddEmail(EmailRepo emailRepo) {
        this.emailRepo = emailRepo;

        TextField textFieldEmail = new TextField("Enter your email address");
        comboBoxCity = new ComboBox<>("Select a city");
        comboBoxCity.setItems("London", "Birmingham", "Manchester", "Glasgow", "Newcastle", "Sheffield", "Liverpool", "Leeds", "Wimbledon");
        comboBoxJobPosition = new ComboBox<>("Select job position");
        comboBoxJobPosition.setItems("Senior Java", "Java", "Junior Java", "Graduate Java", "Academy Java");

        Button button = new Button("Save!");

        button.addClickListener(buttonClickEvent -> {
            Email email = new Email(textFieldEmail.getValue(), comboBoxCity.getValue(), comboBoxJobPosition.getValue());
            emailRepo.save(email);
        });

        add(textFieldEmail, comboBoxCity, comboBoxJobPosition, button);

    }
}
