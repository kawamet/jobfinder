package com.uk.jobfinder.email;

import com.uk.jobfinder.JobProvider;
import com.uk.jobfinder.model.Email;
import com.uk.jobfinder.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MailApi {

    @Value("${APLICATION_URL_UNSUBSCRIBE}")
    private String SUBSCRIBE_URL;
    @Value("${APLICATION_URL}")
    private String APLICATION_URL;
    private MailService mailService;
    private EmailRepo emailRepo;
    private JobProvider jobProvider;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public MailApi(MailService mailService, EmailRepo emailRepo, JobProvider jobProvider, EmailRepo emailRepo1,
                   JobProvider jobProvider1, PasswordEncoder passwordEncoder) {
        this.mailService = mailService;
        this.emailRepo = emailRepo1;
        this.jobProvider = jobProvider1;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sendMail")
    public void sendEmailTest() throws MessagingException {
        List<Email> emailList = emailRepo.findAll();

        for (Email email : emailList) {
            String encodedId = email.getEncodedId();
            String email1 = email.getEmail();
            String city = email.getCity();
            String keywords = email.getJobPosition();

            List<Result> jobs = jobProvider.getJobs(keywords, city);

            Date today = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String format = formatter.format(today);

            List<Result> collect = jobs.stream().filter(e -> e.getDate().equals(format.toString())).collect(Collectors.toList());


            String emialText1 = "New offers: " + collect.size() + "<br>" + SUBSCRIBE_URL + encodedId + "<br>";
            String emialText2 = "Visit website: " + APLICATION_URL;
            //todo add link with jobs
            mailService.sendMail(email1, "New today's job offers", emialText1 + emialText2, true);
        }
    }

    @GetMapping("/unsubscribe")
    @ResponseBody
    public String unsubscribe(@RequestParam String encodedId) {
        Email email = emailRepo.findAll().stream().filter(e -> e.getEncodedId().equals(encodedId)).collect(Collectors.toList()).get(0);
        emailRepo.deleteById(email.getId());
        return "unsubscribed";
    }

}
