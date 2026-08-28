package com.omarcs.tramify.repository;

import com.omarcs.tramify.entity.PersonalDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PersonalDocumentRepository extends JpaRepository<PersonalDocument, Long> {

    @Query("SELECT pd FROM PersonalDocument pd JOIN FETCH pd.person WHERE pd.expiryDate BETWEEN :start AND :end")
    List<PersonalDocument> findExpiringWithPerson(@Param("start") LocalDate start, @Param("end") LocalDate end);
}
