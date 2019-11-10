package com.uk.jobfinder.email;

import com.uk.jobfinder.JobProvider;
import com.uk.jobfinder.model.Email;
import com.uk.jobfinder.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MailApi {

    @Value("${APLICATION_URL_UNSUBSCRIBE}")
    private String SUBSCRIBE_URL;
    private MailService mailService;
    private EmailRepo emailRepo;
    private JobProvider jobProvider;

    @Autowired
    public MailApi(MailService mailService, EmailRepo emailRepo, JobProvider jobProvider, EmailRepo emailRepo1,
                   JobProvider jobProvider1) {
        this.mailService = mailService;
        this.emailRepo = emailRepo1;
        this.jobProvider = jobProvider1;
    }

    @GetMapping("/sendMail")
    public String sendEmailTest() throws MessagingException {
        List<Email> emailList = emailRepo.findAll();

        for (Email email : emailList) {
            Long id = email.getId();
            String email1 = email.getEmail();
            String city = email.getCity();
            String keywords = email.getJobPosition();

            List<Result> jobs = jobProvider.getJobs(keywords, city);

            LocalDate today = LocalDate.now();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String format = formatter.format(today);

            List<Result> collect = jobs.stream().filter(e -> e.getDate().equals(format.toString())).collect(Collectors.toList());

            //todo add link with jobs
            mailService.sendMail(email1, "New today's job offers", "New offers: " + collect.size() + SUBSCRIBE_URL + id,
                    true);
        }

        return null;
    }

    @GetMapping("/unsubscribe")
    @ResponseBody
    public String unsubscribe(@RequestParam Long id) {
        emailRepo.deleteById(id);
        return "unsubscribed";
    }

}
