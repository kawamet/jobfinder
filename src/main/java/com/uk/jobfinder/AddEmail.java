package com.uk.jobfinder;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("add-email")
public class AddEmail extends VerticalLayout {

    private EmailRepo emailRepo;

    @Autowired
    public AddEmail(EmailRepo emailRepo) {
        this.emailRepo = emailRepo;

        TextField textFieldName = new TextField();

        Button button = new Button("Save");

        button.addClickListener(buttonClickEvent -> {
            Email email = new Email(textFieldName.getValue());
            emailRepo.save(email);
        });

        add(textFieldName, button);

    }
}
