package com.uk.jobfinder;


import com.uk.jobfinder.model.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class JobApi {

    JobProvider jobProvider;

    public JobApi(JobProvider jobProvider) {
        this.jobProvider = jobProvider;
    }

    @GetMapping("api/jobs")
    public List<Result> getJobApi(@RequestParam String city,
                                  @RequestParam String keywords,
                                  @RequestParam(value = "date", required = false) String date){
        List<Result> jobs = jobProvider.getJobs(keywords, city);
        if (date == null) {
            return jobs;
        }else {
            List<Result> collect = jobs.stream().filter(e -> e.getDate().equals(date)).collect(Collectors.toList());
            return collect;
        }
    }
}
