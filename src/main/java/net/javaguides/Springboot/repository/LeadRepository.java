package net.javaguides.Springboot.repository;

import net.javaguides.Springboot.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
    @Query("select u from Lead u where u.leadId = :leadId")
    Lead findbyLeadId(long leadId);

    @Query(value = "select * from employee u where u.mobileNumber=:mobileNumber", nativeQuery = true)
    List<Lead> findbyMobileNumber(String mobileNumber);







}
