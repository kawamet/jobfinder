
package com.uk.jobfinder.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "results",
    "ambiguousLocations",
    "totalResults"
})
public class Job {

    @JsonProperty("results")
    private List<Result> results = null;
    @JsonProperty("ambiguousLocations")
    private List<Object> ambiguousLocations = null;
    @JsonProperty("totalResults")
    private Integer totalResults;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

    @JsonProperty("ambiguousLocations")
    public List<Object> getAmbiguousLocations() {
        return ambiguousLocations;
    }

    @JsonProperty("ambiguousLocations")
    public void setAmbiguousLocations(List<Object> ambiguousLocations) {
        this.ambiguousLocations = ambiguousLocations;
    }

    @JsonProperty("totalResults")
    public Integer getTotalResults() {
        return totalResults;
    }

    @JsonProperty("totalResults")
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
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
        return "Job{" +
                "results=" + results +
                ", ambiguousLocations=" + ambiguousLocations +
                ", totalResults=" + totalResults +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
