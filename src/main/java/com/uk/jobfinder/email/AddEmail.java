package com.uk.jobfinder.email;

import com.uk.jobfinder.model.Email;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Route("add-email")
@StyleSheet("/css/style.css")
public class AddEmail extends VerticalLayout {

    private EmailRepo emailRepo;
    private ComboBox<String> comboBoxCity;
    private ComboBox<String> comboBoxJobPosition;
    private Dialog dialogEmpty;
    private Checkbox checkboxAgreement;
    private Checkbox checkboxOffers;
    private PasswordEncoder passwordEncoder;
    private Email saveId;



    @Autowired
    public AddEmail(EmailRepo emailRepo) {
        this.emailRepo = emailRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();

        EmailField textFieldEmail = new EmailField("Enter your email address");
        textFieldEmail.setClearButtonVisible(true);
        textFieldEmail.setErrorMessage("Please enter a valid email address");
        checkboxAgreement = new Checkbox();
        checkboxAgreement.setLabel("I declare that I have read and understood JavaJobFinder privacy policy.");
        checkboxOffers = new Checkbox();
        checkboxOffers.setLabel(" I consent to receive promotional offers from JavaJobFinder.");

        comboBoxCity = new ComboBox<>("Select a city");
        comboBoxCity.setItems("London", "Birmingham", "Manchester", "Glasgow", "Newcastle", "Sheffield", "Liverpool", "Leeds");

        comboBoxJobPosition = new ComboBox<>("Select job position");
        comboBoxJobPosition.setItems("Senior Java", "Java", "Junior Java", "Graduate Java");

        Button button = new Button("Save");
        checkboxOffers.setValue(true);
        checkboxAgreement.setValue(true);


        button.addClickListener(buttonClickEvent -> {

            if (textFieldEmail.isEmpty() || comboBoxCity.isEmpty() || comboBoxJobPosition.isEmpty() || checkboxAgreement.getValue() != true) {
                dialogEmpty = new Dialog();
                dialogEmpty.add(new Label("Field/s cannot be empty!!!"));
                dialogEmpty.open();
                add(dialogEmpty);
            } else {
                Email email = new Email( textFieldEmail.getValue(), comboBoxCity.getValue(), comboBoxJobPosition.getValue(),
                        checkboxAgreement.getValue(), checkboxOffers.getValue());
                saveId = emailRepo.save(email);

                Dialog dialog = new Dialog();
                dialog.add(new Label("Your email has been saved to our database. We will contact you as soon as we " +
                        "get new offers."));
                dialog.setWidth("250px");
                dialog.setHeight("150px");

                Button confirmButton = new Button("Ok", event -> dialog.close());
                dialog.add(confirmButton);
                dialog.open();

            }

            encodeId(emailRepo, passwordEncoder);
        });
        add(textFieldEmail, comboBoxCity, comboBoxJobPosition, checkboxAgreement, checkboxOffers, button);
    }

    private void encodeId(EmailRepo emailRepo, PasswordEncoder passwordEncoder) {
        Email firstById = this.emailRepo.findFirstById(saveId.getId());

        String encode = passwordEncoder.encode(saveId.getId().toString());
        firstById.setEncodedId(encode);
        emailRepo.save(firstById);
    }
}
