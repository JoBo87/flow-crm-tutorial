package com.example.application.views.list;

import com.example.application.data.entity.Company;
import com.example.application.data.entity.Status;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.EmailField;
import com.example.application.data.entity.Contact;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;

import java.awt.*;
import java.util.List;

public class ContactForm extends FormLayout {
    TextField firstName = new TextField("first name");
    TextField lastName = new TextField("last name");
    EmailField email = new EmailField("Email");
    ComboBox<Status> status = new ComboBox<>("Company");
    ComboBox<Company> company = new ComboBox<>("company");


    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button cancel = new Button("Cancel");


    public ContactForm(List<Company> companies, List<Status> statuses) {
        addClassName("contact-form");

        company.setItems(companies);
        company.setItemLabelGenerator(Company::getName);

        add(
                firstName,
                lastName,
                email,
                company,
                status,
                createButtonLayout()
        );

    }

    private Component createButtonLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        cancel.addClickShortcut(Key.ESCAPE);
        return null;
    }


}
