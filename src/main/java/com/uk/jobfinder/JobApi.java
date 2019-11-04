package com.uk.jobfinder;


import com.uk.jobfinder.model.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class JobApi {

    JobProvider jobProvider;

    public JobApi(JobProvider jobProvider) {
        this.jobProvider = jobProvider;
    }

    @GetMapping("api/jobs")
    public List<Result> getJobApi(@RequestParam String city,
                                  @RequestParam String keywords,
                                  @RequestParam(value = "date", required = false) String date) {
        List<Result> jobs = jobProvider.getJobs(keywords, city);
        if (date == null) {
            return jobs;
        } else {
            List<Result> collect = jobs.stream().filter(e -> e.getDate().equals(date)).collect(Collectors.toList());

            return collect;
        }
    }

    @GetMapping("api/techsum")
    public Map<String, Long> getJobApiCount(@RequestParam String city,
                                            @RequestParam String keywords) {
        List<Result> jobs = jobProvider.getJobs(keywords, city);
        List<String> technologies = Arrays.asList("spring", "sql", "microservices", "mongodb", "aws", "react", "hibernate", "mysql", "apis", "git", "mokito", "junit", "tdd", "html", "css", "javascript", "bootstrap", "docker", "jenkins", "ci/cd", "design paterns", "jsp", "servlets", "tomcat");
        Map<String, Long> countTech = new HashMap<>();

        for (String technology : technologies) {
            Long count = jobs.stream().filter(e -> e.getJobDescription().toLowerCase().contains(technology)).count();
            countTech.put(technology, count);
        }
        Map<String, Long> collect = countTech.entrySet().stream().filter(e -> e.getValue() > 0).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        return collect;
    }


}
