package com.omarcs.tramify.repository;

import com.omarcs.tramify.entity.VehicleDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VehicleDocumentRepository extends JpaRepository<VehicleDocument, Long> {

    @Query("SELECT vd FROM VehicleDocument vd JOIN FETCH vd.vehicle v JOIN FETCH v.person WHERE vd.expiryDate BETWEEN :start AND :end")
    List<VehicleDocument> findExpiringWithVehicleAndPerson(@Param("start") LocalDate start, @Param("end") LocalDate end);
}
