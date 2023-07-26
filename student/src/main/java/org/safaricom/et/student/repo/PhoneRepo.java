package org.safaricom.et.student.repo;

import org.safaricom.et.student.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.ws.rs.QueryParam;
import java.util.List;

@Repository
public interface PhoneRepo extends JpaRepository<Phone, Long> {
    @Query(value = "select p from Phone p where p.address.id = :id")
    List<Phone> findByAddressId(@QueryParam("id") Long id);
}
