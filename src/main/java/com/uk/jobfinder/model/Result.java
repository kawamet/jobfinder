
package com.uk.jobfinder.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "jobId",
    "employerId",
    "employerName",
    "employerProfileId",
    "employerProfileName",
    "jobTitle",
    "locationName",
    "minimumSalary",
    "maximumSalary",
    "currency",
    "expirationDate",
    "date",
    "jobDescription",
    "applications",
    "jobUrl"
})
public class Result {

    @JsonProperty("jobId")
    private Integer jobId;
    @JsonProperty("employerId")
    private Integer employerId;
    @JsonProperty("employerName")
    private String employerName;
    @JsonProperty("employerProfileId")
    private Object employerProfileId;
    @JsonProperty("employerProfileName")
    private Object employerProfileName;
    @JsonProperty("jobTitle")
    private String jobTitle;
    @JsonProperty("locationName")
    private String locationName;
    @JsonProperty("minimumSalary")
    private Double minimumSalary;
    @JsonProperty("maximumSalary")
    private Double maximumSalary;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("expirationDate")
    private String expirationDate;
    @JsonProperty("date")
    private String date;
    @JsonProperty("jobDescription")
    private String jobDescription;
    @JsonProperty("applications")
    private Integer applications;
    @JsonProperty("jobUrl")
    private String jobUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("jobId")
    public Integer getJobId() {
        return jobId;
    }

    @JsonProperty("jobId")
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    @JsonProperty("employerId")
    public Integer getEmployerId() {
        return employerId;
    }

    @JsonProperty("employerId")
    public void setEmployerId(Integer employerId) {
        this.employerId = employerId;
    }

    @JsonProperty("employerName")
    public String getEmployerName() {
        return employerName;
    }

    @JsonProperty("employerName")
    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    @JsonProperty("employerProfileId")
    public Object getEmployerProfileId() {
        return employerProfileId;
    }

    @JsonProperty("employerProfileId")
    public void setEmployerProfileId(Object employerProfileId) {
        this.employerProfileId = employerProfileId;
    }

    @JsonProperty("employerProfileName")
    public Object getEmployerProfileName() {
        return employerProfileName;
    }

    @JsonProperty("employerProfileName")
    public void setEmployerProfileName(Object employerProfileName) {
        this.employerProfileName = employerProfileName;
    }

    @JsonProperty("jobTitle")
    public String getJobTitle() {
        return jobTitle;
    }

    @JsonProperty("jobTitle")
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @JsonProperty("locationName")
    public String getLocationName() {
        return locationName;
    }

    @JsonProperty("locationName")
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @JsonProperty("minimumSalary")
    public Double getMinimumSalary() {
        return minimumSalary;
    }

    @JsonProperty("minimumSalary")
    public void setMinimumSalary(Double minimumSalary) {
        this.minimumSalary = minimumSalary;
    }

    @JsonProperty("maximumSalary")
    public Double getMaximumSalary() {
        return maximumSalary;
    }

    @JsonProperty("maximumSalary")
    public void setMaximumSalary(Double maximumSalary) {
        this.maximumSalary = maximumSalary;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("expirationDate")
    public String getExpirationDate() {
        return expirationDate;
    }

    @JsonProperty("expirationDate")
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("jobDescription")
    public String getJobDescription() {
        return jobDescription;
    }

    @JsonProperty("jobDescription")
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    @JsonProperty("applications")
    public Integer getApplications() {
        return applications;
    }

    @JsonProperty("applications")
    public void setApplications(Integer applications) {
        this.applications = applications;
    }

    @JsonProperty("jobUrl")
    public String getJobUrl() {
        return jobUrl;
    }

    @JsonProperty("jobUrl")
    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Result{" +
                "jobId=" + jobId +
                ", employerId=" + employerId +
                ", employerName='" + employerName + '\'' +
                ", employerProfileId=" + employerProfileId +
                ", employerProfileName=" + employerProfileName +
                ", jobTitle='" + jobTitle + '\'' +
                ", locationName='" + locationName + '\'' +
                ", minimumSalary=" + minimumSalary +
                ", maximumSalary=" + maximumSalary +
                ", currency='" + currency + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", date='" + date + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", applications=" + applications +
                ", jobUrl='" + jobUrl + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
