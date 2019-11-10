package com.uk.jobfinder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String encodedId;
    private String email;
    private String city;
    private String jobPosition;
    private boolean checkboxAgreement;
    private boolean checkboxOffers;

    public Email(String email, String city, String jobPosition, boolean checkboxAgreement, boolean checkboxOffers) {
        this.email = email;
        this.city = city;
        this.jobPosition = jobPosition;
        this.checkboxAgreement = checkboxAgreement;
        this.checkboxOffers = checkboxOffers;
    }

    public Email() {
    }

    public String getEncodedId() {
        return encodedId;
    }

    public String setEncodedId(String encodedId) {
        this.encodedId = encodedId;
        return encodedId;
    }

    public boolean isCheckboxAgreement() {
        return checkboxAgreement;
    }

    public void setCheckboxAgreement(boolean checkboxAgreement) {
        this.checkboxAgreement = checkboxAgreement;
    }

    public boolean isCheckboxOffers() {
        return checkboxOffers;
    }

    public void setCheckboxOffers(boolean checkboxOffers) {
        this.checkboxOffers = checkboxOffers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Boolean getCheckboxAgreement() {return  checkboxAgreement; }

    public void setCheckboxAgreement() { this.checkboxOffers = checkboxAgreement; }

    public Boolean getCheckboxOffers() {return  checkboxOffers; }

    public void setCheckboxOffers() { this.checkboxAgreement = checkboxOffers; }


}