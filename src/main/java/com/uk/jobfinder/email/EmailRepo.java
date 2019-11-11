package com.uk.jobfinder.email;

import com.uk.jobfinder.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepo extends JpaRepository<Email, Long> {

    public Email findFirstById(Long id);


}
