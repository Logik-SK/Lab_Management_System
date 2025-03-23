package com.sks.HospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sks.HospitalManagement.model.Billing;

public interface IbillingRepository extends JpaRepository<Billing, Long>  {

}
