package com.uk.jobfinder;


import com.uk.jobfinder.model.Result;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.uk.jobfinder.model.Job;

import java.util.List;

@RestController
public class JobProvider {

    //String URL = "https://www.reed.co.uk/api/1.0/search?keywords=accountant&location=london&distancefromlocation=1&jobId=39080480&employerId=485927";
    //private static final String URL ="https://www.reed.co.uk/api/1.0/search?keywords=java&location=london&distancefromlocation=5";


    //    @EventListener(ApplicationReadyEvent.class)
    public List<Result> getJobs(String keywords, String location) {

        String URL = "https://www.reed.co.uk/api/1.0/search?keywords=" +
                keywords +
                "&distancefromlocation=5&locationname=" +
                location;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Basic ZGY0YjE0ZjktNmQ2Yy00MzBiLWI3MGUtOGEwZjdiY2Q5YmI0Og==");
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<Job> exchange = restTemplate.exchange(URL, HttpMethod.GET, httpEntity, Job.class);

        return exchange.getBody().getResults();

    }

}
