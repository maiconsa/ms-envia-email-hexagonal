package com.ms.adapters.outbound.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.adapters.outbound.persistence.entities.EmailEntity;
@Repository
public interface SpringDataEmailRepository extends  JpaRepository<EmailEntity, UUID> {

}
